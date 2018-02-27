package com.elementa.client.application.accounts.editaccount;

import javax.inject.Inject;

import com.elementa.shared.dto.UserPreferences;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class EditAccountPreferencesPresenter extends PresenterWidget<EditAccountPreferencesPresenter.MyView> {

	interface MyView extends View {
		
	}

	@Inject
	public EditAccountPreferencesPresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);
	}
	
	public UserPreferences getPreferences() {
		return new UserPreferences();
	}
}
