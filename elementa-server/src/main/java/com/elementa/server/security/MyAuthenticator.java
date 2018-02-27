package com.elementa.server.security;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Optional;

import javax.inject.Inject;

import com.elementa.server.dao.UserDAO;
import com.elementa.shared.dto.User;
import com.google.common.base.Preconditions;
import com.google.inject.Singleton;

@Singleton
public class MyAuthenticator implements Authenticator {
	
	private final UserDAO users;
	
	@Inject
	public MyAuthenticator (UserDAO users) {
		this.users = users;
	}
	
	public Optional<User> getUser (String auth) {
		Preconditions.checkNotNull(auth);
		Preconditions.checkArgument(auth.startsWith("Basic"));
		
		String base64Credentials = auth.substring("Basic".length()).trim();
		String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                Charset.forName("UTF-8"));
		final String[] values = credentials.split(":",2);
		
		Optional<User> ret = this.users.getUser(values[0]);
		if (ret.isPresent()) {
			if (ret.get().getCredential().equals(values[1])) {
				return ret;
			}
		}
		
		return Optional.empty();
	}
	

}
