package com.elementa.server.dao;

import java.util.Optional;
import java.util.Set;

import com.elementa.shared.dto.User;

/**
 * Defines the behavior of any classes interacting with the User database.
 * 
 * @author Jake Shilling
 * @version 0.1
 * @since 2016-11-25
 *
 */
public interface UserDAO {

	/**
	 * Adds a new user to the database. Username is used as the password for
	 * the new account.
	 * 
	 * @param user	new user to add to the database
	 * @return 		<tt>true</tt> if user was created successfully.
	 */
	public boolean addUser(User user);
	
	/**
	 * Updates the information for an existing user account
	 * 
	 * @param user	User holding the new information for the user.
	 * @return 		<tt>true</tt> if the edit was successful.
	 */
	public boolean editUser(User user);
	
	/**
	 * Returns the user with a specified UID
	 * 
	 * @param uid	UID of the desired user account
	 * @return		User object holding account information wrapped in an {@link java.util.Optional}
	 */
	public Optional<User> getUser(int uid);
	
	/**
	 * Returns the user with a specified username
	 * 
	 * @param username	username of the desired user account
	 * @return			User object holding account information wrapped in an {@link java.util.Optional}
	 */
	public Optional<User> getUser(String username);
	
	/**
	 * Sets or updates the password for user with a particular UID
	 * 
	 * @param uid		UID of user to update
	 * @param pwd		new password
	 * @return 			<tt>true</tt> if the password was set successfully.
	 */
	public boolean setUserPassword(int uid, String pwd);
	
	/**
	 * Sets or updates the password for the user with a particular username
	 * 
	 * @param username		username of user account to update
	 * @param pwd			new password
	 * @return 				<tt>true</tt> if the password was set successfully.
	 */
	public boolean setUserPassword(String username, String pwd);
	
	/**
	 * Finds the password hash associated with a given user
	 * @param username		User account in question
	 * @return				The saved password hash wrapped in an {@link java.util.Optional}
	 */
	public Optional<String> getSavedPassword(String username);
	
	/**
	 * Finds the password hash associated with a given user
	 * @param uid		User account in question
	 * @return				The saved password hash wrapped in an {@link java.util.Optional}
	 */
	public Optional<String> getSavedPassword(int uid);

	/**
	 * Counts the number of users in the database
	 * 
	 * @return	current number of user accounts or -1 if there was an error.
	 */
	public int getUserCount();
	
	/**
	 * Gets a list of all accounts created by a specified UID
	 * 
	 * @param uid		UID of parent account
	 * @return			set of child accounts.
	 */
	public Set<User> getChildAccounts (int uid);
	
	/**
	 * Searches through table for any user with a row matching, or partially matching,
	 * the search term. Returns a list of all accounts if search term is empty.
	 * 
	 * @param term		String to search for
	 * @return			set of matching accounts
	 */
	public Set<User> searchUsers(String term);
	
	/**
	 * Searches through table for any user with a row matching, or partially matching,
	 * the search term. Returns a list of all accounts if search term is empty.
	 * 
	 * @param creator	Creator uid to filter by
	 * @param term		String to search for
	 * @return			set of matching accounts 
	 */
	public Set<User> searchUsers(int creator, String term);

	/**
	 * Deletes a particular user and any child accounts of that user.
	 * 
	 * @param uid		UID of the account to be deleted.
	 * @return			<tt>true</tt> if the account was deleted successfully
	 */
	public boolean deleteUser(int uid);

	/**
	 * Gets the credential string associated with a given UID.
	 * 
	 * @param uid		Account number to look up
	 * @return			Result wrapped in an {@link java.util.Optional}
	 */
	public Optional<String> getSavedCredentials(int uid);
	
	/**
	 * Gets the credential string associated with a given username.
	 * 
	 * @param username	Username to look up
	 * @return			Result wrapped in an {@link java.util.Optional}
	 */
	public Optional<String> getSavedCredentials(String username);

	/**
	 * Gets the user associated with a given credential string.
	 * 
	 * @param credential	Credentials to look up
	 * @return				Result wrapped in an {@link java.util.Optional}
	 */
	public Optional<User> getFromCredential(String credential);
}