package com.elementa.client.application.accounts.manageaccounts;

import javax.inject.Inject;

import com.elementa.client.resources.AppResources;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.AbstractPager;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class UserDataTableView extends ViewImpl implements UserDataTablePresenter.MyView {

	interface Binder extends UiBinder<Widget, UserDataTableView> {
	}
	
	private final AppResources res;

	@Inject
	public UserDataTableView(Binder uiBinder, AppResources res) {
		initWidget(uiBinder.createAndBindUi(this));
		this.res = res;
	}

	@UiField
	FlowPanel panel;

	@Override
	public void addDataTable(CellTable<?> table, AbstractPager pager) {
		
		table.setStyleName(res.w3().CellRow());
		pager.setStyleName(res.w3().CellRow());
		
		this.panel.add(table);
		this.panel.add(pager);
	}

}
