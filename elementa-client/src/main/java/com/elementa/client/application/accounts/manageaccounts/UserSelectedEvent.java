package com.elementa.client.application.accounts.manageaccounts;

import com.elementa.shared.dto.User;
import com.google.gwt.event.shared.GwtEvent;

public class UserSelectedEvent extends GwtEvent<UserSelectedHandler> {
	
	public static final Type<UserSelectedHandler> TYPE = new Type<>();
	
	private final User user;
	
	public UserSelectedEvent (User user) {
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<UserSelectedHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UserSelectedHandler handler) {
		handler.onUserSelected(this);
	}

}
