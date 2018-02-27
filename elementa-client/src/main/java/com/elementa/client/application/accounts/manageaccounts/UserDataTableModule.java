package com.elementa.client.application.accounts.manageaccounts;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class UserDataTableModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		bindPresenterWidget (UserDataTablePresenter.class,
				UserDataTablePresenter.MyView.class,
				UserDataTableView.class);
	}

}
