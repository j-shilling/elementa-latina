package com.elementa.server.security;

import com.google.inject.AbstractModule;

public class SecurityModule extends AbstractModule {

	@Override
	protected void configure() {
		bind (Authenticator.class).to(MyAuthenticator.class);
		bind (Passwords.class).to(MyPasswords.class);
	}
}
