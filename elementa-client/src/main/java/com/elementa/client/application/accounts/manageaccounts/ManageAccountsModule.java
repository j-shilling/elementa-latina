package com.elementa.client.application.accounts.manageaccounts;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ManageAccountsModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
    	install (new UserDataTableModule());
        bindPresenter(ManageAccountsPresenter.class, ManageAccountsPresenter.MyView.class, ManageAccountsView.class, ManageAccountsPresenter.MyProxy.class);
    }
}