package com.elementa.client.widgets.accidentlistbox;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class AccidentListBoxModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		this.bindPresenterWidget(AccidentListBoxPresenter.class,
				AccidentListBoxPresenter.MyView.class,
				AccidentListBoxView.class);
	}

}
