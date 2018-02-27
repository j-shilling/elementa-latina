package com.elementa.client.application;

import javax.inject.Inject;

import com.elementa.client.resources.AppResources;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class MessengerView extends ViewImpl implements MessengerPresenter.MyView {

	interface Binder extends UiBinder<Widget, MessengerView> {
	}
	
	@UiField
	Label label;
	
	private final AppResources res;

	@Inject
	public MessengerView(Binder uiBinder, AppResources res) {
		initWidget(uiBinder.createAndBindUi(this));
		this.res = res;
	}

	@Override
	public void fine(String text) {
		this.label.setText(text);
		this.label.setStyleName(this.res.w3().TextBlue());
	}

	@Override
	public void error(String text) {
		this.label.setText(text);
		this.label.setStyleName(this.res.w3().TextRed());
	}

}
