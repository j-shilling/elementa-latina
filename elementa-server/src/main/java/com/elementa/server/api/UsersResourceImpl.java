package com.elementa.server.api;

import java.util.Optional;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elementa.server.dao.UserDAO;
import com.elementa.server.security.Authenticator;
import com.elementa.server.security.Passwords;
import com.elementa.shared.api.UsersResource;
import com.elementa.shared.dto.User;
import com.google.inject.Singleton;

import java.util.Set;

@Singleton
public class UsersResourceImpl implements UsersResource {
	
	private final Logger logger = LogManager.getLogger(UsersResourceImpl.class);
	
	private final UserDAO users;
	private final Authenticator authenticator;
	private final Passwords passwords;
	
	@Inject
	private UsersResourceImpl (
			UserDAO users,
			Authenticator authenticator,
			Passwords passwords) {
		this.users = users;
		this.authenticator = authenticator;
		this.passwords = passwords;
	}

	@Override
	public User login(String username, String password) {
		this.logger.traceEntry("Authenticating \"{}\"", username);
		
		Optional<User> user = this.users.getUser(username);
		if (!user.isPresent()) {
			this.logger.traceExit("No user found with the username \"{}\"", username);
			return null;
		}
		
		Optional<String> saved = this.users.getSavedPassword(user.get().getUid());
		
		if (!saved.isPresent()) {
			this.logger.error("No password exists for user \'{}\'", username);
			this.logger.traceExit();
			return null;
		}
		
		if (this.passwords.matches(password, saved.get())) {
			this.logger.traceExit("User \'{}\' authenticated", username);
			return user.get();
		} else {
			this.logger.traceExit("Incorrect password; user \'{}\' not authenticated", username);
			return null;
		}
	}

	@Override
	public User login(String credential) {
		this.logger.traceEntry("Trying to find user from saved credential string");
		
		Optional<User> user = this.users.getFromCredential(credential);
		
		if (user.isPresent()) {
			this.logger.traceExit("Found user \'{}\'", user.get().getUsername());
			return user.get();
		} else {
			this.logger.traceExit("No matching user found");
			return null;
		}
	}

	@Override
	public Set<User> get (String auth, String text) {
		this.logger.traceEntry("Searching user database for \"{}\"", text);
		return this.users.searchUsers(text);
	}

	@Override
	public Set<User> get(String auth) {
		this.logger.traceEntry();
		User cur = this.authenticator.getUser(auth).get();
		
		this.logger.trace("Searching for all users available to \"{}\"", cur.getUsername());
		
		if (cur.isAdmin()) {
			this.logger.traceExit();
			return this.users.searchUsers("");
		} else {
			this.logger.traceExit();
			return this.users.searchUsers(cur.getUid(), "");
		}
	}

	@Override
	public Boolean checkUsername(String auth, String username) {
		this.logger.traceEntry("Checking whether the username \"{}\" is available", username);
		Optional<User> user = this.users.getUser(username);
		
		boolean ret = !user.isPresent();
		this.logger.traceExit("returning {}", Boolean.toString(ret));
		return ret;
	}

	@Override
	public Boolean create(String auth, User user) {
		this.logger.traceEntry("Creating new user \"{}\"", user.getUsername());
		
		boolean ret =  this.users.addUser(user);
		this.logger.traceExit("returning {}", Boolean.toString(ret));
		return ret;
	}

	@Override
	public User get (String auth, int uid) {
		this.logger.traceEntry("Getting user where uid = {}", uid);
		
		User currentUser = this.authenticator.getUser(auth).get();
		
		if (currentUser.isAdmin() || currentUser.isTeacher() || (uid == currentUser.getUid())) {
			Optional<User> user = this.users.getUser(uid);
			
			if (user.isPresent()) {
				if (currentUser.isAdmin() 
						|| (uid == currentUser.getUid() 
						|| (currentUser.getUid() == user.get().getCreator()))) {
					this.logger.traceExit();
					return user.get();
				}
				
				this.logger.warn("User \"{}\" does not have permission to view accound {}", 
						currentUser.getUsername(), uid);
			}
			
			this.logger.warn("There is no account {}", uid);
		}
		
		this.logger.traceExit();
		return null;
	}

	@Override
	public User update(String auth, int uid, User user) {
		this.logger.traceEntry ("Editing account {}", uid);
		
		User currentUser = this.authenticator.getUser(auth).get();
		
		if (currentUser.isAdmin() 
				|| (currentUser.getUid() == user.getUid())
				|| (currentUser.isTeacher() && (currentUser.getUid() == user.getCreator()))) {
			if (!users.editUser(user)) {
				this.logger.traceExit("Something went wrong");
				return null;
			}
			
			Optional<User> result = users.getUser(uid);
			if (result.isPresent()) {
				this.logger.traceExit();
				return result.get();
			} else {
				this.logger.traceExit();
				return null;
			}
		}
		
		this.logger.warn("User \"{}\" does not have permission to view accound {}", 
				currentUser.getUsername(), uid);
		this.logger.traceExit();
		return null;
	}

	@Override
	public Boolean delete(String auth, int uid) {
		this.logger.traceEntry("Deleting account {}", uid);
		
		User currentUser = this.authenticator.getUser(auth).get();
		Optional<User> result = users.getUser(uid);
		
		if (!result.isPresent()) {
			this.logger.warn("There is no account {}", uid);
			this.logger.traceExit();
			return false;
		}
		
		User user = result.get();
		
		if (currentUser.isAdmin() 
				|| (currentUser.getUid() == user.getUid())
				|| (currentUser.isTeacher() 
						&& (currentUser.getUid() == user.getCreator()))) {
			boolean ret = users.deleteUser(uid);
			
			this.logger.traceExit("Returning {}", Boolean.toString(ret));
			return ret;
		}
		
		this.logger.warn("User \"{}\" does not have permission to view accound {}", 
				currentUser.getUsername(), uid);
		this.logger.traceExit();
		return false;
	}

	@Override
	public Boolean validate(String auth, String username, String password) {
		this.logger.traceEntry("Validating user \"{}\"", username);
		
		Optional<User> user = this.users.getUser(username);
		if (!user.isPresent()) {
			this.logger.warn("There is no user \"{}\"", username);
			return false;
		}
		
		Optional<String> saved = this.users.getSavedPassword(user.get().getUid());
		
		if (!saved.isPresent()) {
			this.logger.error("No password exists for user \'{}\'", username);
			this.logger.traceExit();
		}
		
		boolean ret = this.passwords.matches(password, saved.get());
		this.logger.traceExit("Returning {}", Boolean.toString(ret));
		return ret;
	}

	@Override
	public Boolean update(String auth, String password) {
		this.logger.traceEntry();
		
		User currentUser = this.authenticator.getUser(auth).get();
		this.logger.trace("Changing password for account {}", currentUser.getUid());
		
		boolean ret = users.setUserPassword(currentUser.getUid(), password);
		this.logger.traceExit("Returning {}", Boolean.toString(ret));
		return ret;
	}

}
