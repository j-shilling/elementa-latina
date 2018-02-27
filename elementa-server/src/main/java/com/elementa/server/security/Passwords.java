package com.elementa.server.security;

public interface Passwords {
	public String hash (String password);
	public boolean matches (String check, String hash);
}
