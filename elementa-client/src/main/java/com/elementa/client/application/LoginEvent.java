package com.elementa.client.application;

import com.elementa.shared.dto.User;
import com.google.gwt.event.shared.GwtEvent;

public class LoginEvent extends GwtEvent<LoginHandler> {
	public static Type<LoginHandler> TYPE = new Type<LoginHandler>();
	
	private final User user;
	
	public LoginEvent (User user) {
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}

	@Override
	public Type<LoginHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LoginHandler handler) {
		handler.onLogin(this);
	}

}
