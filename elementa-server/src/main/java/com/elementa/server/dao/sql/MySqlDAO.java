package com.elementa.server.dao.sql;

import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elementa.server.ConfigurationProperties;

/**
 * An abstract, generic base class to handle all behavior common to all SQL
 * implementations of DAOs.
 * 
 * @author Jake Shilling
 * @since 0.1
 */
abstract class MySqlDAO<T> {
	private final Logger logger;
	private final ConfigurationProperties config;

	/**
	 * Get a new connection to the database.
	 * 
	 * @return The resulting connection or <tt>null</tt> on error.
	 */
	private Optional<Connection> getConnection() {
		this.logger.traceEntry("Getting SQL connection...");

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(this.config().getDBUrl(),
					this.config().getDBUser(), this.config().getDBPwd());
			this.logger.traceExit("Connection received.");
			return Optional.of(con);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {

			this.logger.error("Exception while getting connection\n", e);
			return Optional.empty();

		}

	}

	/**
	 * Construct a new instance of the base class which stores the information
	 * necessary to access the SQL database.
	 * 
	 * @param url
	 *            URL of the SQL server
	 * @param user
	 *            User to access the SQL server
	 * @param pwd
	 *            Password of the user
	 */
	protected MySqlDAO(ConfigurationProperties config) {
		this.logger = LogManager.getLogger(MySqlDAO.class);
		this.logger.traceEntry("Building a SQL DAO");

		this.config = config;

		try {
			this.logger.trace("Checking whether the table " + this.getTable() + " exists");
			/* Create table if it does not exist */
			Optional<Connection> ret = this.getConnection();
			if (ret.isPresent()) {
				Connection con = this.getConnection().get();
				DatabaseMetaData meta = con.getMetaData();
				ResultSet res = meta.getTables(null, null, this.getTable(), new String[] { "TABLE" });

				if (!res.next()) {
					this.logger.info("Creating table {}", this.getTable());
					PreparedStatement pst = con.prepareStatement(this.createTableStatement());
					pst.executeUpdate();

					this.logger.info("Table created.");

					this.logger.info("Table initialized successfully: {}", Boolean.toString(this.initializeTable()));
				}

				con.close();
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Get the name of the table this object is used to access.
	 * 
	 * @return The table name
	 */
	abstract protected String getTable();

	/**
	 * Get the column in the table used as a unique identifier for each entry.
	 * 
	 * @return The name of the column
	 */
	abstract protected String getIdCol();

	/**
	 * Set the SQL command used to create the table
	 * 
	 * @return The SQL command
	 */
	abstract protected String createTableStatement();

	/**
	 * Perform any necessary tasks after the table is created
	 * 
	 * @return <tt>true</tt> if everything was successful.
	 */
	abstract protected boolean initializeTable();

	/**
	 * Convert a result from a SQL query into an instance of the desired object.
	 * 
	 * @param rs
	 *            ResultSet returned by query command
	 * @return Result wrapped in an {@link java.util.Optional}
	 */
	abstract protected Optional<T> fromResultSet(ResultSet rs);

	/**
	 * Create a PreparedStatement to insert the given object into the database.
	 * 
	 * @param con
	 *            An open connection to the SQL server
	 * @param arg
	 *            The object to save
	 * @return A finished PreparedStatement
	 */
	abstract protected PreparedStatement toPreparedStatement(Connection con, T arg) throws Exception;
	
	/**
	 * Access the server configuration for this object.
	 * 
	 * @return
	 */
	protected ConfigurationProperties config() {
		return this.config;
	}

	/**
	 * Get the object stored in a particular row.
	 * 
	 * @param id
	 *            Id of the row
	 * @return The result wrapped in an {@link java.util.Optional}
	 */
	protected Optional<T> get(int id) {
		this.logger.traceEntry("Getting row {}", Integer.toString(id));

		try {
			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				PreparedStatement pst = con
						.prepareStatement("SELECT * FROM " + this.getTable() + " WHERE " + this.getIdCol() + "=?");
				pst.setInt(1, id);

				ResultSet rs = pst.executeQuery();

				Optional<T> ret = null;
				if (rs.next())
					ret = this.fromResultSet(rs);
				else
					ret = Optional.empty();

				con.close();

				this.logger.traceExit();
				return ret;
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
				return Optional.empty();
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			return Optional.empty();
		}
	}

	/**
	 * Gets all objects which hold a matching value in the given column.
	 * 
	 * @param col
	 *            The name of the column to check
	 * @param val
	 *            The value to search for
	 * @return A {@link java.util.Collection} of results. This may be empty, but
	 *         may not be null;
	 */
	protected Collection<T> get(String col, String val) {
		this.logger.trace("Getting all rows where col {} equals {}", col, val);

		Set<T> ret = new HashSet<>();

		try {
			Optional<Connection> c = this.getConnection();

			if (c.isPresent()) {
				Connection con = c.get();
				PreparedStatement pst = con
						.prepareStatement("SELECT * FROM " + this.getTable() + " WHERE " + col + "=?");
				pst.setString(1, val);
				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					Optional<T> o = this.fromResultSet(rs);
					if (o.isPresent())
						ret.add(o.get());
				}

				con.close();
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
			}

			return ret;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			return ret;
		}
	}

	/**
	 * Gets all objects which hold a matching value in the given column.
	 * 
	 * @param col
	 *            The name of the column to check
	 * @param val
	 *            The value to search for
	 * @return A {@link java.util.Collection} of results. This may be empty, but
	 *         may not be null;
	 */
	protected Collection<T> get(String col, int val) {
		this.logger.traceEntry("Getting all rows where col {} equals {}", col, val);

		Set<T> ret = new HashSet<>();

		try {
			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				PreparedStatement pst = con
						.prepareStatement("SELECT * FROM " + this.getTable() + " WHERE " + col + "=?");
				pst.setInt(1, val);
				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					Optional<T> o = this.fromResultSet(rs);
					if (o.isPresent())
						ret.add(o.get());
				}

				con.close();
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
			}
			return ret;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			return ret;
		}
	}

	/**
	 * Get a Collection of all rows in the table.
	 * 
	 * @return A collection of results. May be empty, but may not be null.
	 */
	protected Collection<T> get() {
		this.logger.traceEntry("Getting all rows");

		Set<T> ret = new HashSet<>();

		try {
			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				PreparedStatement pst = con.prepareStatement("SELECT * FROM " + this.getTable());
				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					Optional<T> o = this.fromResultSet(rs);
					if (o.isPresent())
						ret.add(o.get());
				}

				con.close();
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
			}
			return ret;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			return ret;
		}
	}

	/**
	 * Gets an integer value stored in a given column.
	 * 
	 * @param id
	 *            The row id to look in
	 * @param col
	 *            The column to check
	 * @return The integer value found
	 * @throws NoSuchElementException
	 * @throws SQLException
	 */
	protected int getInt(int id, String col) throws NoSuchElementException, SQLException {
		this.logger.traceEntry("Getting the int value in column {} of row {}", col, id);

		try {
			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				PreparedStatement pst = con.prepareStatement(
						"SELECT " + col + " FROM " + this.getTable() + " WHERE " + this.getIdCol() + "=?");
				pst.setInt(1, id);

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					int ret = rs.getInt(col);
					this.logger.traceExit("Returning {}", ret);
					return ret;
				} else {
					throw new NoSuchElementException("Row " + id + " does not exist");
				}
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
				throw new SQLException();
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * Gets an String value stored in a given column.
	 * 
	 * @param id
	 *            The row id to look in
	 * @param col
	 *            The column to check
	 * @return The String value found
	 * @throws NoSuchElementException
	 * @throws SQLException
	 */
	protected String getString(int id, String col) throws NoSuchElementException, SQLException {
		this.logger.traceEntry("Getting the int value in column {} of row {}", col, id);

		try {
			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				PreparedStatement pst = con.prepareStatement(
						"SELECT " + col + " FROM " + this.getTable() + " WHERE " + this.getIdCol() + "=?");
				pst.setInt(1, id);

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					String ret = rs.getString(col);
					this.logger.traceExit("Returning {}", ret);
					return ret;
				} else {
					throw new NoSuchElementException("Row " + id + " does not exist");
				}
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
				throw new SQLException();
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	/**
	 * Gets the number of rows in the table. Returns a negative number if there
	 * was an error.
	 * 
	 * @return The result.
	 */
	protected int size() {
		this.logger.traceEntry("Counting entries");
		int ret = -1;

		try {
			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM " + this.getTable());
				ResultSet rs = pst.executeQuery();
				con.close();

				if (!rs.next()) {
					ret = 0;
				} else {
					ret = rs.getInt(1);
				}
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
			}

			return ret;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			return ret;
		}
	}

	/**
	 * Search for the given string in the specified column.
	 * 
	 * @param col
	 *            The column to search
	 * @param term
	 *            The string to look for
	 * @return A collection of results. May be empty, but may not be null.
	 */
	protected Collection<T> search(String col, String term) {
		this.logger.traceEntry("Searching {} for \"{}\"", col, term);
		Set<T> ret = new HashSet<>();

		try {
			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				PreparedStatement pst = con
						.prepareStatement("SELECT * FROM " + this.getTable() + " WHERE " + col + " LIKE ?");
				pst.setString(1, "%" + term + "%");

				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					Optional<T> o = this.fromResultSet(rs);
					if (o.isPresent())
						ret.add(o.get());
				}

				con.close();
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
			}

			return ret;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.traceExit();
			return ret;
		}
	}

	/**
	 * Search for the given string in the specified column in rows where the
	 * given conditional column holds the given conditional value.
	 * 
	 * @param col
	 *            The column to search
	 * @param term
	 *            The string to look for
	 * @param conditionalCol
	 *            The column of the conditional WHERE clause
	 * @param conditionalVal
	 *            The value of the conditional WHERE clause
	 * @return A Collection of results; may be empty, but not null.
	 */
	protected Collection<T> searchWhere(String col, String term, String conditionalCol, int conditionalVal) {
		this.logger.traceEntry("Searching {} for \"{}\" where {}={}", col, term, conditionalCol, conditionalVal);
		Set<T> ret = new HashSet<>();

		try {
			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				PreparedStatement pst = con.prepareStatement("SELECT * FROM " + this.getTable() + " WHERE " + col
						+ " LIKE ?" + " AND " + conditionalCol + "=?");
				pst.setString(1, "%" + term + "%");
				pst.setInt(2, conditionalVal);

				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					Optional<T> o = this.fromResultSet(rs);
					if (o.isPresent())
						ret.add(o.get());
				}

				con.close();
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
			}

			return ret;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.traceExit();
			return ret;
		}
	}

	/**
	 * Search for the given string in the specified column in rows where the
	 * given conditional column holds the given conditional value.
	 * 
	 * @param col
	 *            The column to search
	 * @param term
	 *            The string to look for
	 * @param conditionalCol
	 *            The column of the conditional WHERE clause
	 * @param conditionalVal
	 *            The value of the conditional WHERE clause
	 * @return A Collection of results; may be empty, but not null.
	 */
	protected Collection<T> searchWhere(String col, String term, String conditionalCol, String conditionalVal) {
		this.logger.traceEntry("Searching {} for \"{}\" where {}={}", col, term, conditionalCol, conditionalVal);
		Set<T> ret = new HashSet<>();

		try {
			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				PreparedStatement pst = con.prepareStatement("SELECT * FROM " + this.getTable() + " WHERE " + col
						+ " LIKE ?" + " AND " + conditionalCol + "=?");
				pst.setString(1, "%" + term + "%");
				pst.setString(2, conditionalVal);

				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					Optional<T> o = this.fromResultSet(rs);
					if (o.isPresent())
						ret.add(o.get());
				}

				con.close();
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
			}

			return ret;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.traceExit();
			return ret;
		}
	}

	/**
	 * Create a new row to store the given object.
	 * 
	 * @param o
	 *            The Object to be stored
	 * @return <tt>true</tt> if the operation was successful.
	 */
	protected boolean insertColumn(T o) {
		this.logger.traceEntry();

		try {
			this.logger.trace("Trying to insert new row");

			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				PreparedStatement pst = this.toPreparedStatement(con, o);

				this.logger.trace("Executing \"{}\"", pst.toString());
				pst.executeUpdate();
				con.close();

				this.logger.traceExit("Returning true for success");
				return true;
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + "table.");
				return false;
			}

		} catch (Exception e) {
			this.logger.error("SQL Exception while creating new row!\n", e);
			this.logger.traceExit("Returning false for failure");
			return false;
		}

	}

	/**
	 * Updates a given column of the table with a blob of the given Object.
	 * 
	 * @param id
	 *            The value stored in {@link MySqlDAO#getIdCol()}
	 * @param col
	 *            The name of the column to update
	 * @param o
	 *            The object to be saved as a blob
	 * @return <tt>true</tt> if the update was successful.
	 */
	protected boolean updateColumn(int id, String col, Object o) {
		this.logger.traceEntry();

		/*
		 * If this Object should not be saved as a BLOB call another method.
		 */
		if (o instanceof String)
			return this.updateColumn(id, col, (String) o);
		if (o instanceof Integer)
			return this.updateColumn(id, col, ((Integer) o).intValue());

		try {
			this.logger.trace("Trying to save {} in column {} of row {}", o, col, Integer.toString(id));

			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				// Create the Blob
				Blob blob = con.createBlob();
				ObjectOutputStream oos = new ObjectOutputStream(blob.setBinaryStream(1));
				oos.writeObject(o);
				oos.close();

				// Prepare the SQL statement
				String stm = "UPDATE " + this.getTable() + " SET " + col + "=? WHERE " + this.getIdCol() + "=?";
				PreparedStatement pst = con.prepareStatement(stm);

				pst.setBlob(1, blob);
				pst.setInt(2, id);

				// Execute and close
				pst.executeUpdate();
				con.close();

				this.logger.traceExit("Returning true for success");
				return true;
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
				return false;
			}

		} catch (Exception e) {
			this.logger.error("Error while performing SQL update.\n", e);
			this.logger.traceExit("returning false for failure");
			return false;
		}

	}

	/**
	 * Updates a given column of the table with a String
	 * 
	 * @param id
	 *            The value stored in {@link MySqlDAO#getIdCol()}
	 * @param col
	 *            The name of the column to update
	 * @param val
	 *            The String to be saved
	 * @return <tt>true</tt> if the update was successful.
	 */
	protected boolean updateColumn(int id, String col, String val) {
		this.logger.traceEntry();

		try {
			this.logger.trace("Trying to save {} in column {} of row {}", val, col, Integer.toString(id));

			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				String stm = "UPDATE " + this.getTable() + " SET " + col + "=? WHERE " + this.getIdCol() + "=?";
				PreparedStatement pst = con.prepareStatement(stm);

				pst.setString(1, val);
				pst.setInt(2, id);

				pst.executeUpdate();
				con.close();

				this.logger.traceExit("Returning true for success");
				return true;
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
				return false;
			}
		} catch (SQLException e) {
			this.logger.error("Error while performing SQL update.\n", e);
			this.logger.traceExit("returning false for failure");
			return false;
		}
	}

	/**
	 * Updates a given column of the table with an integer
	 * 
	 * @param id
	 *            The value stored in {@link MySqlDAO#getIdCol()}
	 * @param col
	 *            The name of the column to update
	 * @param val
	 *            The integer to be saved
	 * @return <tt>true</tt> if the update was successful.
	 */
	protected boolean updateColumn(int id, String col, int val) {
		this.logger.traceEntry();

		try {
			this.logger.trace("Trying to save {} in column {} of row {}", Integer.toString(val), col,
					Integer.toString(id));

			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				String stm = "UPDATE " + this.getTable() + " SET " + col + "=? WHERE " + this.getIdCol() + "=?";
				PreparedStatement pst = con.prepareStatement(stm);

				pst.setInt(1, val);
				pst.setInt(2, id);

				pst.executeUpdate();
				con.close();

				this.logger.traceExit("Returning true for success");
				return true;
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
				return false;
			}
		} catch (SQLException e) {
			this.logger.error("Error while performing SQL update.\n", e);
			this.logger.traceExit("returning false for failure");
			return false;
		}
	}

	/**
	 * Checks whether a row exists which has the given value in
	 * {@link MySqlDAO#getIdCol()}
	 * 
	 * @param id
	 *            The value to search for
	 * @return <tt>true</tt> if the row was found.
	 * @throws SQLException
	 */
	protected boolean isRow(int id) throws SQLException {
		this.logger.traceEntry();

		try {
			this.logger.trace("Searching for a row {}", Integer.toString(id));

			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				PreparedStatement pst = con
						.prepareStatement("SELECT * FROM " + this.getTable() + " WHERE " + this.getIdCol() + "=?");
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				con.close();

				if (rs.next()) {
					this.logger.traceExit("Row was found");
					return true;
				} else {
					this.logger.traceExit("row was not found");
					return false;
				}
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
				return false;
			}
		} catch (SQLException e) {
			this.logger.error("Exception caught while searching.\n", e);
			throw e;
		}
	}

	/**
	 * Delete the row with the given id value in {@link MySqlDAO#getIdCol()}
	 * 
	 * @param id
	 *            The value of the row to delete
	 * @return <tt>true</tt> if the operation was successful.
	 */
	protected boolean deleteRow(int id) {
		this.logger.traceEntry();

		try {
			this.logger.trace("Trying to deleted row {}", Integer.toString(id));

			Optional<Connection> c = this.getConnection();
			if (c.isPresent()) {
				Connection con = c.get();
				PreparedStatement pst = con
						.prepareStatement("DELETE FROM " + this.getTable() + "WHERE " + this.getIdCol() + " =?");
				pst.setInt(1, id);

				pst.executeUpdate();
				con.close();

				this.logger.traceExit("Returning true for success");
				return true;
			} else {
				this.logger.error("Could not connect to the " + this.getTable() + " table.");
				return false;
			}
		} catch (SQLException e) {
			this.logger.error("Error while performing SQL update.\n", e);
			this.logger.traceExit("returning false for failure");
			return false;
		}
	}
}
