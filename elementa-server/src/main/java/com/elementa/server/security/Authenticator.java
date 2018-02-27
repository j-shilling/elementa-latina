package com.elementa.server.security;

import java.util.Optional;

import com.elementa.shared.dto.User;

public interface Authenticator {
	
	Optional<User> getUser (String auth);
	
	default public boolean isLoggedIn(String auth) {
		return this.getUser(auth).isPresent();
	}
	
	default public boolean isAdmin(String auth) {
		Optional<User> result = this.getUser(auth);
		
		if (result.isPresent())
			if (result.get().isAdmin())
				return true;
		
		return false;
	}
	
	default public boolean isTeacher(String auth) {
		Optional<User> result = this.getUser(auth);
		
		if (result.isPresent())
			if (result.get().isTeacher())
				return true;
		
		return false;
	}
	
	default public boolean isStudent(String auth) {
		Optional<User> result = this.getUser(auth);
		
		if (result.isPresent())
			if (result.get().isStudent())
				return true;
		
		return false;
	}
}
