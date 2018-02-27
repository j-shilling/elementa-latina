package com.elementa.client.widgets.textbox;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PasswordTextBoxModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
    	bindPresenterWidget(PasswordTextBoxPresenter.class, 
    			PasswordTextBoxPresenter.MyView.class, 
    			PasswordTextBoxView.class);
    }
}