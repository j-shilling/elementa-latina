package com.elementa.client.application.accounts.manageaccounts;

import com.google.gwt.event.shared.EventHandler;

@FunctionalInterface
public interface UserSelectedHandler extends EventHandler {
	public void onUserSelected(UserSelectedEvent event);
}
