package com.elementa.client.widgets.authenticator;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class AuthenticatorModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		bindSingletonPresenterWidget (AuthenticatorPresenter.class,
				AuthenticatorPresenter.MyView.class,
				AuthenticatorView.class);
	}

}
