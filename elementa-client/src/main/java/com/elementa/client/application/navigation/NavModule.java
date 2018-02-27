package com.elementa.client.application.navigation;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.view.PopupPositioner;

public class NavModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindSingletonPresenterWidget(NavPresenter.class, NavPresenter.MyView.class,
                NavView.class);
        bind(PopupPositioner.class).to(NavPositioner.class);
    }
}
