package com.elementa.server.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elementa.server.ConfigurationProperties;
import com.elementa.server.dao.UserRelationshipsDAO;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MySqlUserRelationshipsDAO 
		extends MySqlDAO<MySqlUserRelationshipsDAO.Relationship> 
		implements UserRelationshipsDAO {
	
	private static final Logger logger = LogManager.getLogger(MySqlUserDAO.class);

	protected class Relationship {
		public final int parent;
		public final int child;
		
		public final int id;
		
		protected Relationship (int parent, int child, int id) {
			this.parent = parent;
			this.child = child;
			this.id = id;
		}
		
		public int getParent() { return this.parent; }
		public int getChild() { return this.child; }
		public int getId() { return this.id; }
	}
	
	@Inject
	protected MySqlUserRelationshipsDAO(ConfigurationProperties config) {
		super(config);
	}
	
	@Override
	protected String getTable() {
		return this.config().getUserRelationshipsTable();
	}

	@Override
	protected String getIdCol() {
		return this.config().getUserRelationshipsId();
	}

	@Override
	protected String createTableStatement() {
		String ret = "CREATE TABLE " + this.config().getUserRelationshipsTable() + "("
				+ this.config().getUserRelationshipsId() + 		" INT NOT NULL AUTO_INCREMENT UNIQUE, "
				+ this.config().getUserRelationshipsParent() + 	" INT NOT NULL, "
				+ this.config().getUserRelationshipsChild() + 	" INT NOT NULL, "
				
				+ "PRIMARY KEY (" + this.config().getUserRelationshipsId() + "), "
				+ "FOREIGN KEY (" + this.config().getUserRelationshipsParent() + ") REFERENCES "
						+ this.config().getUsersTable() + "(" + this.config().getUsersUID() + "), "
				+ "FOREIGN KEY (" + this.config().getUserRelationshipsChild() + ") REFERENCES "
						+ this.config().getUsersTable() + "(" + this.config().getUsersUID() + ")"
				+ ");";
		return ret;
	}

	@Override
	protected boolean initializeTable() {
		return true; // Nothing to initialize
	}

	@Override
	protected Optional<Relationship> fromResultSet(ResultSet rs) {
		if (rs == null) {
			return Optional.empty();
		}
		
		try {
			return Optional.of(
					new Relationship (rs.getInt(this.config().getUserRelationshipsParent()),
							rs.getInt(this.config().getUserRelationshipsChild()),
							rs.getInt(this.config().getUserRelationshipsId()))
				);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return Optional.empty();
		}
	}

	@Override
	protected PreparedStatement toPreparedStatement(Connection con, Relationship arg) throws Exception {
		String stmt = "INSERT INTO " + this.config().getUserRelationshipsTable()
		+ "("  + this.config().getUserRelationshipsParent() 
		+ ", " + this.config().getUserRelationshipsChild()
		+ ") VALUES"
		+ "(?, ?)";
		
		PreparedStatement pst = con.prepareStatement(stmt);
		pst.setInt(1, arg.getParent());
		pst.setInt(2, arg.getChild());
		
		return pst;
	}

	@Override
	public boolean delUser(int user) {
		Collection<Relationship> c = this.get(this.config().getUserRelationshipsParent(), user);
		
		boolean ret = true;
		
		for (Relationship r : c)
			ret = ret && this.deleteRow(r.getId());
		
		c = this.get(this.config().getUserRelationshipsChild(), user);
		
		for (Relationship r : c)
			ret = ret && this.deleteRow(r.getId());
		
		return ret;
	}

	@Override
	public Set<Integer> getParents(int child) {
		Collection<Relationship> c = this.get(this.config().getUserRelationshipsChild(), child);
		Set<Integer> ret = new HashSet<>();
		
		for (Relationship r : c)
			ret.add(r.getParent());
		
		return ret;
	}

	@Override
	public Set<Integer> getChildren(int parent) {
		Collection<Relationship> c = this.get(this.config().getUserRelationshipsParent(), parent);
		Set<Integer> ret = new HashSet<>();
		
		for (Relationship r : c)
			ret.add(r.getChild());
		
		return ret;
	}

	@Override
	public boolean isParent(int child, int uid) {
		return this.getParents(child).contains(uid);
	}

	@Override
	public boolean isChild(int parent, int uid) {
		return this.getChildren(parent).contains(uid);
	}

	@Override
	public boolean addRelationship(int parent, int child) {
		return this.insertColumn(new Relationship (parent, child, -1));
	}

	@Override
	public boolean delRelationship(int parent, int child) {
		Collection<Relationship> c = this.get(this.config().getUserRelationshipsParent(), parent);
		
		boolean ret = true;
		
		for (Relationship r : c)
			if (r.getChild() == child)
				ret = ret && this.deleteRow(r.getId());
		
		return ret;
	}

}
