package com.elementa.client.application.dictionary.editwordforms;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class EditWordFormsView extends ViewImpl implements EditWordFormsPresenter.MyView {

	interface Binder extends UiBinder<Widget, EditWordFormsView> {
	}
	
	@UiField
	FlowPanel panel;
	@UiField
	SimplePanel paradigmPanel;

	@Inject
	public EditWordFormsView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.bindSlot(EditWordFormsPresenter.SLOT, paradigmPanel);
	}

	@Override
	public void print(String text) {
		this.panel.add(new Label(text));
	}

	@Override
	public void clear() {
		this.panel.clear();
	}

}
