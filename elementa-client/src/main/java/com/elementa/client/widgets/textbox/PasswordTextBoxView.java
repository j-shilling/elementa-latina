package com.elementa.client.widgets.textbox;

import javax.inject.Inject;

import com.elementa.client.resources.AppResources;
import com.google.gwt.user.client.ui.PasswordTextBox;

public class PasswordTextBoxView extends AbstractTextBoxView implements PasswordTextBoxPresenter.MyView {

	@Inject
	PasswordTextBoxView(AppResources res) {
		super(res, new PasswordTextBox());
	}

}
