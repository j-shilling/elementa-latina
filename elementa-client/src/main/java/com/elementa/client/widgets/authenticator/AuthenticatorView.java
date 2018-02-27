package com.elementa.client.widgets.authenticator;

import javax.inject.Inject;

import com.elementa.client.StringConstants;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
import com.gwtplatform.mvp.client.view.CenterPopupPositioner;

public class AuthenticatorView 
		extends PopupViewWithUiHandlers<AuthenticatorUiHandlers> 
		implements AuthenticatorPresenter.MyView {

	interface Binder extends UiBinder<Widget, AuthenticatorView> {
	}
	
	@UiField
	FocusPanel focus;
	@UiField
	Label header;
	
	@UiField
	SimplePanel username;
	@UiField
	Label usernameLbl;
	
	@UiField
	SimplePanel password;
	@UiField
	Label passwordLbl;
	
	@UiField
	SimplePanel ActionBtnPanel;

	@Inject
	public AuthenticatorView(Binder uiBinder,
			EventBus eventBus,
			CenterPopupPositioner positioner,
			StringConstants constants) {
		super (eventBus, positioner);
		
		initWidget(uiBinder.createAndBindUi(this));
		
		this.usernameLbl.setText(constants.username());
		this.passwordLbl.setText(constants.password());
		this.header.setText(constants.pleaseVerifyYourIdentity());
		
		this.bindSlot(AuthenticatorPresenter.VALIDATE, this.ActionBtnPanel);
		this.bindSlot(AuthenticatorPresenter.USERNAME, this.username);
		this.bindSlot(AuthenticatorPresenter.PASSWORD, this.password);
		
		this.focus.addKeyDownHandler(event -> {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER)
				this.getUiHandlers().onEnter();
		});
	}

}
