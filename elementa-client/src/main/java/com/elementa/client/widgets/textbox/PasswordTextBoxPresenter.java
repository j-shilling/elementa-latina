package com.elementa.client.widgets.textbox;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.View;

public class PasswordTextBoxPresenter extends AbstractTextBoxPresenter {
	
	interface MyView extends View, AbstractTextBoxPresenter.MyView {
	}

	@Inject
	PasswordTextBoxPresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);
	}

}
