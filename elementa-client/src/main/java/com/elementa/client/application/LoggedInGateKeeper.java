package com.elementa.client.application;

import javax.inject.Inject;

import com.elementa.client.CurrentUser;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;

public class LoggedInGateKeeper implements Gatekeeper {
	
	private final CurrentUser currentUser;
	
	@Inject
	public LoggedInGateKeeper(CurrentUser currentUser) {
		this.currentUser = currentUser;
	}

	@Override
	public boolean canReveal() {
		return this.currentUser.isLoggedIn();
	}

}
