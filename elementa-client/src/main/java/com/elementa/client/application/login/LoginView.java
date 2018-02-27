package com.elementa.client.application.login;

import javax.inject.Inject;

import com.elementa.client.StringConstants;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class LoginView 
		extends ViewWithUiHandlers<LoginUiHandlers> 
		implements LoginPresenter.MyView {
	
	interface Binder extends UiBinder<Widget, LoginView> {
    }
	
	class InputChange implements KeyUpHandler {
		
		@Override
		public void onKeyUp(KeyUpEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				LoginView.this.getUiHandlers().onEnterPressed();
			} else {
				LoginView.this.getUiHandlers().onInputChange();
			}
		}
		
	}
	
	@UiField
	SimplePanel ActionBtnPanel;
	@UiField
	TextBox username;
	@UiField
	TextBox password;
	@UiField
	CheckBox remember;
	
	 @Inject
	    LoginView(
	            Binder uiBinder,
	            StringConstants constants) {
	        initWidget(uiBinder.createAndBindUi(this));
	        
	        this.bindSlot(LoginPresenter.SLOT, ActionBtnPanel);
	        
	        this.username.addKeyUpHandler(new InputChange());
	        this.password.addKeyUpHandler(new InputChange());
	        
	        this.remember.setText(" " + constants.stayLoggedIn());
	        
	    }

	@Override
	public String getUserNameText() {
		return this.username.getText();
	}

	@Override
	public String getPasswordText() {
		return this.password.getText();
	}

	@Override
	public boolean remember() {
		return this.remember.getValue();
	}
	
	@Override
	public void clearText() {
		this.username.setText("");
		this.password.setText("");
	}
	
}
