package com.elementa.server.dao.sql;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

import com.elementa.server.ConfigurationProperties;
import com.elementa.server.dao.UserDAO;
import com.elementa.server.dao.UserRelationshipsDAO;
import com.elementa.server.security.Passwords;
import com.elementa.shared.dto.AccountRole;
import com.elementa.shared.dto.User;
import com.elementa.shared.dto.UserPreferences;
import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Represents a singleton which provides a MySQL implementation of {@link UserDAO}
 * 
 * @author Jake Shilling
 * @version 0.1
 * @since 2016-06-10
 *
 */
@Singleton
public class MySqlUserDAO extends MySqlDAO<User> implements UserDAO {
	
	private static final Logger logger = LogManager.getLogger(MySqlUserDAO.class);
	
	private final Passwords passwords;
	private final UserRelationshipsDAO userRel;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getTable() {
		return this.config().getUsersTable();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getIdCol() {
		return this.config().getUsersUID();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String createTableStatement() {
		return "CREATE TABLE " + this.config().getUsersTable() + "("
				+ this.config().getUsersUID() + 			" INT 			NOT NULL AUTO_INCREMENT, "
				+ this.config().getUsersCreator() + 		" INT 			NOT NULL, "
				+ this.config().getUsersUsername() + 		" VARCHAR(25), "
				+ this.config().getUsersPassword() + 		" VARCHAR(300) 	NOT NULL, "
				+ this.config().getUsersCredentials() + 	" VARCHAR(300)	NOT NULL, "
				+ this.config().getUsersAccountType() + 	" TINYINT 		NOT NULL, "
				+ this.config().getUsersFirstName() + 		" VARCHAR(25), "
				+ this.config().getUsersLastName() + 		" VARCHAR(25), "
				+ this.config().getUsersEmail() + 			" VARCHAR(25),"
				+ this.config().getUsersPreferences() + 	" BLOB			NOT NULL,"
				
				+ "PRIMARY KEY (" + this.config().getUsersUID() + ")"
				+ ");";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean initializeTable() {
		/* Create initial admin account */
		User first_admin = new User.UserBuilder()
				.setUsername("admin")
				.setType(AccountRole.ADMIN)
				.setUid(1)
				.build();

		this.addUser(first_admin);
		
		boolean ret = this.getUser(first_admin.getUid()).isPresent();
		MySqlUserDAO.logger.traceExit("Initial admin created: {}", Boolean.toString(ret));
		return ret;
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected Optional<User> fromResultSet(ResultSet rs) {
		if (rs == null) {
			return Optional.empty();
		}
		
		try {
			InputStream is = rs.getBinaryStream(this.config().getUsersPreferences());
			ObjectInputStream ois = new ObjectInputStream(is);
			
			User ret = new User.UserBuilder()
				.setUid(rs.getInt(this.config().getUsersUID()))
				.setUsername(rs.getString(this.config().getUsersUsername()))
				.setType(rs.getInt(this.config().getUsersAccountType()))
				.setFirstName(rs.getString(this.config().getUsersFirstName()))
				.setLastName(rs.getString(this.config().getUsersLastName()))
				.setEmail(rs.getString(this.config().getUsersEmail()))
				.setCreator(rs.getInt(this.config().getUsersCreator()))
				.setCredential(rs.getString(this.config().getUsersCredentials()))
				.setPreferences((UserPreferences) ois.readObject())
				.build();
				
			return Optional.of(ret);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return Optional.empty();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected PreparedStatement toPreparedStatement (Connection con, User arg) throws Exception {
		String stm = "INSERT INTO " + this.config().getUsersTable()
			+ "("  + this.config().getUsersUsername() 
			+ ", " + this.config().getUsersFirstName()
			+ ", " + this.config().getUsersLastName() 
			+ ", " + this.config().getUsersEmail() 
			+ ", " + this.config().getUsersAccountType() 
			+ ", " + this.config().getUsersCreator() 
			+ ", " + this.config().getUsersPreferences() 
			+ ", " + this.config().getUsersPassword()
			+ ", " + this.config().getUsersCredentials()
			+ ") VALUES"
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement pst = con.prepareStatement(stm);
			pst.setString(1, arg.getUsername());
			pst.setString(2, arg.getFirstName());
			pst.setString(3, arg.getLastName());
			pst.setString(4, arg.getEmail());
			pst.setInt(5, arg.getType().toInt());
			pst.setInt(6, arg.getCreator());
			
			Blob blob = con.createBlob();
			ObjectOutputStream oos = new ObjectOutputStream(blob.setBinaryStream(1));
			oos.writeObject(arg.getPreferences());
			oos.close();
			
			pst.setBlob(7, blob);
			
			pst.setString(8, this.passwords.hash(arg.getUsername()));
			pst.setString(9, this.passwords.hash(Integer.toString(arg.getUid())));
			
			return pst;
		} catch (SQLException | IOException e) {
			throw e;
		}
	}

	/*
	 * PRIVATE CONSTRUCTOR
	 */
	@Inject
	private MySqlUserDAO(
			ConfigurationProperties config,
			Passwords passwords,
			UserRelationshipsDAO userRel) {
		
		super(config);
		
		this.passwords = passwords;
		this.userRel = userRel;
	}
	
	/*
	 * PUBLIC METHODS
	 */
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addUser(User user) {
		MySqlUserDAO.logger.traceEntry();
		
		try {
			
			Preconditions.checkNotNull(user, "Cannot add a null user");
			Preconditions.checkArgument(!user.getUsername().isEmpty(), 
					"Cannot add a user without a username.");
			Preconditions.checkArgument(!this.getUser(user.getUsername()).isPresent(),
					user.getUsername() + " already esists as a username");
			
			MySqlUserDAO.logger.trace("Trying to create new user {}", user.getUsername());
			
			return super.insertColumn(user);
			
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			MySqlUserDAO.logger.traceExit("Returning false for failure");
			return false;
			
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean editUser(User user) {
		MySqlUserDAO.logger.traceEntry();
		Preconditions.checkNotNull(user, "Cannot update a user with a null value.");
		Preconditions.checkArgument(this.getUser(user.getUid()).isPresent(),
				"Cannot update a user that does not exist.");
		
		boolean ret = true;
		
		ret = ret && super.updateColumn(user.getUid(), this.config().getUsersFirstName(), user.getFirstName());
		ret = ret && super.updateColumn(user.getUid(), this.config().getUsersLastName(), user.getLastName());
		ret = ret && super.updateColumn(user.getUid(), this.config().getUsersUsername(), user.getUsername());
		ret = ret && super.updateColumn(user.getUid(), this.config().getUsersEmail(), user.getEmail());
		ret = ret && super.updateColumn(user.getUid(), this.config().getUsersAccountType(), user.getType().toInt());
		ret = ret && super.updateColumn(user.getUid(), this.config().getUsersPreferences(), user.getPreferences());
		
		MySqlUserDAO.logger.traceExit("Operation successful: {}", Boolean.toString(ret));
		return ret;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<User> getUser(int uid) {
		MySqlUserDAO.logger.traceEntry();
		return super.get(uid);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<User> getUser(String username) {
		MySqlUserDAO.logger.traceEntry();
		
		Collection<User> result = super.get(this.config().getUsersUsername(), username);
		if (result.isEmpty())
			return Optional.empty();
		else
			return Optional.of(result.toArray(new User[0])[0]);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setUserPassword(int uid, String pwd) {
		MySqlUserDAO.logger.traceEntry();
		boolean ret = updateColumn(uid, this.config().getUsersPassword(), this.passwords.hash(pwd));
		MySqlUserDAO.logger.traceExit("Operation successful: {}", Boolean.toString(ret));
		return ret;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setUserPassword(String username, String pwd) {
		MySqlUserDAO.logger.traceEntry();
		Optional<User> user = getUser(username);
		
		if (!user.isPresent()) {
			MySqlUserDAO.logger.warn("No user {} found", username);
			return false;
		}
		
		boolean ret = setUserPassword(getUser(username).get().getUid(), pwd);
		MySqlUserDAO.logger.traceExit("Operation successful: {}", Boolean.toString(ret));
		return ret;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<String> getSavedPassword(int uid) {
		logger.traceEntry("Looking up password for account {}", uid);
		
		try {
			String ret;
			ret = super.getString(uid, this.config().getUsersPassword());
			logger.traceExit();
			return Optional.of(ret);
		} catch (NoSuchElementException | SQLException e) {
			logger.error(e.getMessage(), e);
			logger.traceExit();
			return Optional.empty();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<String> getSavedPassword(String username) {
		MySqlUserDAO.logger.traceEntry();
		Optional<User> user = getUser(username);
		
		if (!user.isPresent()) {
			logger.warn("No user found with username = \"{}\"", username);
			return Optional.empty();
		}
		
		MySqlUserDAO.logger.traceExit();
		return getSavedPassword(user.get().getUid());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<String> getSavedCredentials(int uid) {
		logger.traceEntry("Looking up credentials for account {}", uid);
		
		try {
			String ret;
			ret = super.getString(uid, this.config().getUsersCredentials());
			logger.traceExit();
			return Optional.of(ret);
		} catch (NoSuchElementException | SQLException e) {
			logger.error(e.getMessage(), e);
			logger.traceExit();
			return Optional.empty();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<String> getSavedCredentials(String username) {
		MySqlUserDAO.logger.traceEntry();
		Optional<User> user = getUser(username);
		
		if (!user.isPresent()) {
			logger.warn("No user found with username = \"{}\"", username);
			return Optional.empty();
		}
		
		MySqlUserDAO.logger.traceExit();
		return getSavedCredentials(user.get().getUid());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getUserCount() {
		return super.size();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<User> getChildAccounts (int uid) {
		logger.traceEntry("Getting children of account {}", uid);
		
		Collection<User> result = super.get(this.config().getUsersCreator(), uid);
		logger.traceExit();
		return new HashSet<User>(result);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<User> searchUsers(String term) {
		MySqlUserDAO.logger.traceEntry();
		
		if (term == null)
			term = new String("");
		
		Set<User> ret = new HashSet<User>();
		
		if (term.isEmpty()) {
			logger.trace("Empty search term given; returning all users");
			ret.addAll(super.get());
			logger.traceExit();
			return ret;
		} else {
			logger.trace("Search term is not empty; searching for \"{}\"", term);
			ret.addAll(super.search(this.config().getUsersUID(), term));
			ret.addAll(super.search(this.config().getUsersUsername(), term));
			ret.addAll(super.search(this.config().getUsersFirstName(), term));
			ret.addAll(super.search(this.config().getUsersLastName(), term));
			ret.addAll(super.search(this.config().getUsersEmail(), term));
		}
		
		MySqlUserDAO.logger.traceExit();
		return ret;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<User> searchUsers(int creator, String term) {
		MySqlUserDAO.logger.traceEntry();
		
		if (term == null)
			term = new String("");
		
		Set<User> ret = new HashSet<User>();
		
		if (term.isEmpty()) {
			logger.trace("Empty search term given; returning all users");
			ret.addAll(super.get());
			logger.traceExit();
			return ret;
		} else {
			logger.trace("Search term is not empty; searching for \"{}\"", term);
			ret.addAll(super.searchWhere(this.config().getUsersUID(), term, this.config().getUsersCreator(), creator));
			ret.addAll(super.searchWhere(this.config().getUsersUsername(), term, this.config().getUsersCreator(), creator));
			ret.addAll(super.searchWhere(this.config().getUsersFirstName(), term, this.config().getUsersCreator(), creator));
			ret.addAll(super.searchWhere(this.config().getUsersLastName(), term, this.config().getUsersCreator(), creator));
			ret.addAll(super.searchWhere(this.config().getUsersEmail(), term, this.config().getUsersCreator(), creator));
		}
		
		MySqlUserDAO.logger.traceExit();
		return ret;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteUser(int uid) {
		MySqlUserDAO.logger.traceEntry();
		
		if (!this.getUser(uid).isPresent()) {
			logger.warn("Someone is trying to delete a user which does not exist. UID=\'" + uid + "\'");
			return false;
		}
		
		boolean ret = super.deleteRow(uid);
		MySqlUserDAO.logger.traceExit("Operation successful: {}", Boolean.toString(ret));
		return ret;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<User> getFromCredential(String credential) {
		MySqlUserDAO.logger.traceEntry();
		
		Collection<User> result = super.get(this.config().getUsersCredentials(), credential);
		
		if (result.isEmpty()) {
			logger.warn("There is no user with the given credential");
			logger.traceExit("No user found");
			return Optional.empty();
		}
		
		if (result.size() > 1) {
			logger.warn("More than one user has the same credential");
			logger.traceExit("No user found");
			return Optional.empty();
		}
		
		User ret = result.toArray(new User[0])[0];
		logger.traceExit("User found");
		return Optional.of(ret);
	}

	
}
