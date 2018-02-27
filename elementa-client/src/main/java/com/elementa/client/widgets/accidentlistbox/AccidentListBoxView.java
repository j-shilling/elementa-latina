package com.elementa.client.widgets.accidentlistbox;

import javax.inject.Inject;

import com.elementa.client.widgets.WidgetStyler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class AccidentListBoxView extends ViewImpl implements AccidentListBoxPresenter.MyView {

	interface Binder extends UiBinder<Widget, AccidentListBoxView> {
	}
	
	@UiField
	ListBox listBox;
	
	private final WidgetStyler styler;

	@Inject
	public AccidentListBoxView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.styler = new WidgetStyler (this.listBox);
	}

	@Override
	public WidgetStyler getStyler() {
		return this.styler;
	}

	@Override
	public void addItem(String item, String value) {
		this.listBox.addItem(item, value);
	}

	@Override
	public void clear() {
		this.listBox.clear();
	}

	@Override
	public int getItemCount() {
		return this.listBox.getItemCount();
	}

	@Override
	public String getValue(int index) {
		return this.listBox.getValue(index);
	}

	@Override
	public void setSelectedIndex(int index) {
		this.listBox.setSelectedIndex(index);
	}

	@Override
	public String getSelectedValue() {
		return this.listBox.getSelectedValue();
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return this.listBox.addClickHandler(handler);
	}

}
