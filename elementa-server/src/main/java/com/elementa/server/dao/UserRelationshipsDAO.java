package com.elementa.server.dao;

import java.util.Set;

/**
 * Defines the behavior of objects interacting with the user relationships DB.
 * 
 * @author Jake Shilling
 *
 */
public interface UserRelationshipsDAO {
	public boolean addRelationship (int parent, int child);
	public boolean delRelationship (int parent, int child);
	public boolean delUser (int user);
	
	public Set<Integer> getParents (int child);
	public Set<Integer> getChildren (int parent);
	
	public boolean isParent (int child, int uid);
	public boolean isChild (int parent, int uid);
}
