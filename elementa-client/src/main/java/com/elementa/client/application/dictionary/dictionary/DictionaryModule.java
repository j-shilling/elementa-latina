package com.elementa.client.application.dictionary.dictionary;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class DictionaryModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(DictionaryPresenter.class, DictionaryPresenter.MyView.class, DictionaryView.class,
                DictionaryPresenter.MyProxy.class);
    }
}
