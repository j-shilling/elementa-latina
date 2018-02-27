package com.elementa.client.application.accounts.editaccount;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class EditAccountPreferencesModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		this.bindSingletonPresenterWidget(EditAccountPreferencesPresenter.class,
				EditAccountPreferencesPresenter.MyView.class,
				EditAccountPreferencesView.class);
	}

}
