package com.elementa.server.security;

import org.mindrot.jbcrypt.BCrypt;

import com.google.inject.Singleton;

@Singleton
public class MyPasswords implements Passwords {

	@Override
	public String hash(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	@Override
	public boolean matches(String check, String hash) {
		return BCrypt.checkpw(check, hash);
	}

}
