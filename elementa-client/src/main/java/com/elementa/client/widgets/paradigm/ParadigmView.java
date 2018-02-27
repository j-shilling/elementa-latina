package com.elementa.client.widgets.paradigm;

import javax.inject.Inject;

import com.elementa.client.widgets.paradigm.ParadigmPresenter.Table;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class ParadigmView extends ViewImpl implements ParadigmPresenter.MyView {

	interface Binder extends UiBinder<Widget, ParadigmView> {
	}

	@UiField
	SimplePanel panel;
	
	@Inject
	public ParadigmView(Binder uiBinder) {
		this.initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void clear() {
		this.panel.clear();
	}

	@Override
	public void add(Table table) {
		this.panel.add(table);
	}

}
