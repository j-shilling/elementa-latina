package com.elementa.client.widgets.paradigm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

class TwoColumnTable extends Composite implements ParadigmTabComponent {

	private static TwoColumnTableUiBinder uiBinder = GWT.create(TwoColumnTableUiBinder.class);

	interface TwoColumnTableUiBinder extends UiBinder<Widget, TwoColumnTable> {
	}

	@UiField
	FlowPanel left;
	@UiField
	FlowPanel right;
	
	private String text = new String();
	
	public TwoColumnTable() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void addLeft(ParadigmCell cell) {
		this.left.add(cell);
	}
	
	public void addRight(ParadigmCell cell) {
		this.right.add(cell);
	}

	@Override
	public String getLabelText() {
		return this.text;
	}

	@Override
	public void setLabelText(String text) {
		this.text = text;
	}

}
