package com.elementa.client.widgets.paradigm;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ParadigmModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		this.bindPresenterWidget(ParadigmPresenter.class,
				ParadigmPresenter.MyView.class,
				ParadigmView.class);

	}

}
