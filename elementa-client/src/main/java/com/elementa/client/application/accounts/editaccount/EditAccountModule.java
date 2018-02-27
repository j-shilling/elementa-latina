package com.elementa.client.application.accounts.editaccount;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class EditAccountModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install (new EditAccountPreferencesModule());
		
		 bindPresenter(EditAccountPresenter.class, 
				 EditAccountPresenter.MyView.class, 
				 EditAccountView.class, 
				 EditAccountPresenter.MyProxy.class);
	}

}
