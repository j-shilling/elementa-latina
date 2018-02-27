package com.elementa.client.application.navigation;

import com.gwtplatform.mvp.client.UiHandlers;

public interface NavUiHandlers extends UiHandlers {

	void onCloseClick();

	void onAccountClick();

	void onLoginClick();

	void onDictionaryClick();

	void onManageDictionaryClick();

	void onManageAccountsClick();

	void onLogoutClick();

}
