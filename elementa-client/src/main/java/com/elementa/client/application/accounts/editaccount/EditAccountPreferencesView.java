package com.elementa.client.application.accounts.editaccount;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class EditAccountPreferencesView 
		extends ViewImpl 
		implements EditAccountPreferencesPresenter.MyView {

	interface Binder extends UiBinder<Widget, EditAccountPreferencesView> {
	}

	@Inject
	public EditAccountPreferencesView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
