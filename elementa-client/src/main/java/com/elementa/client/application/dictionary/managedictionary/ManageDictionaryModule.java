package com.elementa.client.application.dictionary.managedictionary;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ManageDictionaryModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ManageDictionaryPresenter.class, 
        		ManageDictionaryPresenter.MyView.class, 
        		ManageDictionaryView.class, 
        		ManageDictionaryPresenter.MyProxy.class);
    }
}