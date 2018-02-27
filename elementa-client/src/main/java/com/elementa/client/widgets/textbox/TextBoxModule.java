package com.elementa.client.widgets.textbox;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TextBoxModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
    	bindPresenterWidget(TextBoxPresenter.class, 
            	TextBoxPresenter.MyView.class, 
            	TextBoxView.class);
    }
}