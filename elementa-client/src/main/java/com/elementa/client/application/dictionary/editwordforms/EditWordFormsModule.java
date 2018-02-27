package com.elementa.client.application.dictionary.editwordforms;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class EditWordFormsModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		this.bindPresenter(EditWordFormsPresenter.class, 
				EditWordFormsPresenter.MyView.class, 
				EditWordFormsView.class,
				EditWordFormsPresenter.MyProxy.class);
	}

}
