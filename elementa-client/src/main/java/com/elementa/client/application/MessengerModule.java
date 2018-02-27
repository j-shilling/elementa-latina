package com.elementa.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class MessengerModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		bindSingletonPresenterWidget(MessengerPresenter.class, MessengerPresenter.MyView.class,
				MessengerView.class);
	}

}
