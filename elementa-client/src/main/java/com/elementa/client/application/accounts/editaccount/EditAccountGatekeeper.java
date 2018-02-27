package com.elementa.client.application.accounts.editaccount;

import javax.inject.Inject;

import com.elementa.client.CurrentUser;
import com.google.common.base.Preconditions;
import com.gwtplatform.mvp.client.proxy.GatekeeperWithParams;

public class EditAccountGatekeeper implements GatekeeperWithParams {
	
	private final CurrentUser currentUser;
	private int uid;
	
	@Inject
	public EditAccountGatekeeper(CurrentUser currentUser) {
		this.currentUser = currentUser;
	}

	@Override
	public GatekeeperWithParams withParams(String[] params) {
		Preconditions.checkNotNull(params, 
				"EditAccountGatekeeper requires non null parameters");
		Preconditions.checkArgument(params.length == 1,
				"EditAccountGatekeeper should take exactly one argument");
		
		try {
			this.uid = Integer.parseInt(params[0]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException (
					"EditAccountGatekeeper could not parse the argument " + params[0]);
		}
		
		return this;
	}

	@Override
	public boolean canReveal() {
		if (!this.currentUser.isLoggedIn())
			return false;
		
		if (this.currentUser.getUser().get().getUid() == this.uid)
			return true;
		
		if (this.currentUser.getUser().get().isAdmin()
				|| this.currentUser.getUser().get().isTeacher())
			return true;
		
		return false;
	}

}
