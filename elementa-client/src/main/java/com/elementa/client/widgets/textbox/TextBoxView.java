package com.elementa.client.widgets.textbox;

import javax.inject.Inject;

import com.elementa.client.resources.AppResources;
import com.google.gwt.user.client.ui.TextBox;

public class TextBoxView extends AbstractTextBoxView implements TextBoxPresenter.MyView {

	@Inject
	TextBoxView(AppResources res) {
		super(res, new TextBox());
	}

}
