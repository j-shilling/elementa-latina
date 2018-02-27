package com.elementa.client.application;

import com.google.gwt.event.shared.GwtEvent;

public class LogoutEvent extends GwtEvent<LogoutHandler> {
	public static Type<LogoutHandler> TYPE = new Type<LogoutHandler>();

	@Override
	public Type<LogoutHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LogoutHandler handler) {
		handler.onLogout(this);
	}

}
