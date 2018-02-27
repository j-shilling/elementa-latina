package com.elementa.client.application.accounts;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class AccountInformationModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		bindPresenterWidget (AccountInformationPresenter.class,
				AccountInformationPresenter.MyView.class,
				AccountInformationView.class);
	}

}
