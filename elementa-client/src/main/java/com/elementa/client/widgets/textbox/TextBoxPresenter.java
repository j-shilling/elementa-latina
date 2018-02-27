package com.elementa.client.widgets.textbox;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;

public class TextBoxPresenter extends AbstractTextBoxPresenter {
	
	interface MyView extends AbstractTextBoxPresenter.MyView {
	}

	@Inject
	TextBoxPresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);
	}

}
