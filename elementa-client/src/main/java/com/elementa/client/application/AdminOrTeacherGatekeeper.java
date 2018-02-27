package com.elementa.client.application;

import javax.inject.Inject;

import com.elementa.client.CurrentUser;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;

public class AdminOrTeacherGatekeeper implements Gatekeeper {

	private final CurrentUser currentUser;
	
	@Inject
	public AdminOrTeacherGatekeeper(CurrentUser currentUser) {
		this.currentUser = currentUser;
	}

	@Override
	public boolean canReveal() {
		if (!this.currentUser.isLoggedIn())
			return false;
		else
			return this.currentUser.getUser().get().isAdmin()
					|| this.currentUser.getUser().get().isTeacher();
	}

}
