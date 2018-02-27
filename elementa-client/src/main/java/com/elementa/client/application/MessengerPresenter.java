package com.elementa.client.application;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class MessengerPresenter extends PresenterWidget<MessengerPresenter.MyView> {

	public interface MyView extends View {
		void fine (String text);
		void error (String text);
	}
	
	@Inject
	public MessengerPresenter(EventBus eventBus, MyView view) {
		super(eventBus, view);
	}
	
	public void fine (String text) {
		this.getView().fine(text);
	}
	
	public void error (String text) {
		this.getView().error(text);
	}

}
