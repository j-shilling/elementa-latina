package com.elementa.client.application.accounts.manageaccounts;

import javax.inject.Inject;

import com.elementa.client.StringConstants;
import com.elementa.client.resources.AppResources;
import com.elementa.client.widgets.SelfStylingWidget;
import com.elementa.client.widgets.WidgetStyler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class ManageAccountsView 
		extends ViewWithUiHandlers<ManageAccountsUiHandlers> 
		implements ManageAccountsPresenter.MyView {
	
    interface Binder extends UiBinder<Widget, ManageAccountsView> {
    }
    
    class Handler implements KeyUpHandler {
    	
    	@Override
		public void onKeyUp(KeyUpEvent event) {
    		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER)
    			ManageAccountsView.this.getUiHandlers().onEnter();
    		else
    			ManageAccountsView.this.getUiHandlers().onSearchTextChange();
    		
    		event.preventDefault();
		}
    	
    }


    @UiField
    SimplePanel tableContainer;
    @UiField
    SimplePanel addBtnPanel;
    @UiField
    SimplePanel saveBtnPanel;
    @UiField
    Label searchLbl;
    @UiField
    TextBox searchTxtBox;
    @UiField
    SimplePanel addUserContainer;
    
    @UiField
    FocusPanel focusPanel;
    
    private WidgetStyler addBtnStyler;
    private WidgetStyler saveBtnStyler;
    private final AppResources res;
    
    @Inject
    ManageAccountsView(
    		Binder uiBinder,
    		AppResources res,
    		StringConstants constants) {
        initWidget(uiBinder.createAndBindUi(this));
        
        this.res = res;
        
        this.searchLbl.setText(constants.search());
        
        this.bindSlot(ManageAccountsPresenter.ADD, addBtnPanel);
        this.bindSlot(ManageAccountsPresenter.SAVE, saveBtnPanel);
        this.bindSlot(ManageAccountsPresenter.TABLE, tableContainer);
        this.bindSlot(ManageAccountsPresenter.ACCOUNT_INFO, addUserContainer);
        
        Handler handler = new Handler();
        
        this.searchTxtBox.addKeyUpHandler(handler);
        
        this.focusPanel.addKeyUpHandler(handler);
        
        this.searchTxtBox.setFocus(true);
    }

	@Override
	public String getSearchText() {
		return this.searchTxtBox.getText();
	}

	@Override
	public void reset() {
		this.searchTxtBox.setText("");
		ManageAccountsUiHandlers handler = this.getUiHandlers();
		handler.onSearchTextChange();
		
		this.addUserContainer.setStyleName(res.w3().Hide());
		this.addBtnStyler.delStyle(res.w3().Hide());
		this.saveBtnStyler.addStyle(res.w3().Hide());
		this.addBtnStyler.setStyles();
		this.saveBtnStyler.setStyles();
		
		this.searchTxtBox.setFocus(true);
	}

	@Override
	public void setAddBtnStyler(WidgetStyler styler) {
		this.addBtnStyler = styler;
		
		this.addBtnStyler.addStyle(
				res.w3().Btn(),
				res.w3().Xlarge(),
				res.w3().RoundXlarge(),
				res.w3().Right(),
				res.w3().Margin(),
				res.theme().Light2());
		this.addBtnStyler.setStyles();
	}

	@Override
	public void setSaveBtnStyler(WidgetStyler styler) {
		this.saveBtnStyler = styler;
		
		this.saveBtnStyler.addStyle(
				res.w3().Btn(),
				res.w3().Xlarge(),
				res.w3().RoundXlarge(),
				res.w3().Right(),
				res.w3().Margin(),
				res.theme().Light2(),
				res.w3().Hide());
		this.saveBtnStyler.setStyles();
	}

	@Override
	public void showAddUser() {
		this.addUserContainer.setStyleName(res.w3().Show());
		this.addBtnStyler.addStyle(res.w3().Hide());
		this.saveBtnStyler.delStyle(res.w3().Hide());
		
		this.addBtnStyler.setStyles();
		this.saveBtnStyler.setStyles();
	}

	@Override
	public void styleTextBox(SelfStylingWidget widget) {
		widget.addStyle(
				res.w3().Input(),
				res.w3().Border(),
				res.theme().Light5());
		
	}
}