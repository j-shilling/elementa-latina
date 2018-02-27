package com.elementa.client.widgets.actionbutton;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ActionButtonModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindPresenterWidget(ActionButtonPresenter.class,
            		ActionButtonPresenter.MyView.class, 
            		ActionButtonView.class);
    }
}