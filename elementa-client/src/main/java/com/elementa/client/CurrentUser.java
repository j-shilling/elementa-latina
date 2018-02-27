package com.elementa.client;

import java.util.Optional;

import javax.inject.Inject;

import com.elementa.client.application.LoginEvent;
import com.elementa.client.application.LoginHandler;
import com.elementa.client.application.LogoutEvent;
import com.elementa.client.application.LogoutHandler;
import com.elementa.shared.dto.User;
import com.google.common.io.BaseEncoding;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Stores information about the currently logged in user.
 * 
 * @author Jake Shilling
 * @since 0.1
 */
@Singleton
public class CurrentUser {
	
	private final EventBus eventBus;
	
	private User user = null;
	
	/**
	 * Injects dependencies and registers event handlers.
	 * 
	 * @param eventBus		Provides access to the site-wide event bus.
	 */
	@Inject
	public CurrentUser (
			EventBus eventBus) {
		this.eventBus = eventBus;
		this.eventBus.addHandler(LoginEvent.TYPE, new LoginHandler() {

			@Override
			public void onLogin(LoginEvent loginEvent) {
				CurrentUser.this.user = loginEvent.getUser();
			}
			
		});
		this.eventBus.addHandler(LogoutEvent.TYPE, new LogoutHandler() {

			@Override
			public void onLogout(LogoutEvent e) {
				CurrentUser.this.user = null;
			}
			
		});
	}
	
	/**
	 * Checks whether a user is logged in.
	 * 
	 * @return <tt>true</tt> if a user is logged in
	 */
	public boolean isLoggedIn() {
		return this.user != null;
	}
	
	/**
	 * Gets the currently logged in user.
	 * 
	 * @return The currently logged in user wrapped in a {@link java.util.Optional}
	 */
	public Optional<User> getUser() {
		return Optional.ofNullable(this.user);
	}
	
	/**
	 * Generates the authorization string passed in HTTP requests.
	 * 
	 * @return The HTTP Basic authorization string
	 */
	public String getAuthorization() {
		String name = this.user == null ? "" : this.user.getUsername();
		String pwd = this.user == null ? "" : this.user.getCredential();
		String auth = name + ":" + pwd;
		
		return "Basic " + BaseEncoding.base64().encode(auth.getBytes());
	}

}
