package com.elementa.client.widgets.paradigm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class OneColumnTable extends Composite implements ParadigmTabComponent {

	private static OneColumnTableUiBinder uiBinder = GWT.create(OneColumnTableUiBinder.class);

	interface OneColumnTableUiBinder extends UiBinder<Widget, OneColumnTable> {
	}
	
	@UiField
	FlowPanel panel;
	
	private String text = new String();

	public OneColumnTable() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void add (ParadigmCell cell) {
		this.panel.add(cell);
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
