package com.elementa.client.application.accounts.editaccount;

import javax.inject.Inject;

import com.elementa.client.StringConstants;
import com.elementa.client.resources.AppResources;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class EditAccountView 
		extends ViewWithUiHandlers<EditAccountUiHandlers>  
		implements EditAccountPresenter.MyView {

	interface Binder extends UiBinder<Widget, EditAccountView> {
	}
	
	
	@UiField
	FocusPanel focus;
	@UiField
	SimplePanel accountInformation;
	@UiField
	Label newPasswordLbl;
	@UiField
	SimplePanel newPasswordTxtBox;
	@UiField
	Label confirmPasswordLbl;
	@UiField
	SimplePanel confirmPasswordTxtBox;
	
	@UiField
	SimplePanel prefContainer;
	
	@UiField
	SimplePanel saveBtnContainer;
	@UiField
	SimplePanel deleteBtnContainer;
	
	@UiField
	HTMLPanel passwords;
	
	private final AppResources res;
	
	@Inject
	public EditAccountView(
			Binder uiBinder,
			StringConstants constants,
			AppResources res) {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.res = res;
		
		this.newPasswordLbl.setText(constants.newPassword());
		this.confirmPasswordLbl.setText(constants.confirmPassword());
		
		this.bindSlot(EditAccountPresenter.ACCOUNT_INFO, accountInformation);
		
		this.bindSlot(EditAccountPresenter.NEW_PASSWORD, this.newPasswordTxtBox);
		this.bindSlot(EditAccountPresenter.CONFIRM_PASSWORD, this.confirmPasswordTxtBox);
		
		this.bindSlot(EditAccountPresenter.SAVE, this.saveBtnContainer);
		this.bindSlot(EditAccountPresenter.DELETE, this.deleteBtnContainer);
		
		this.bindSlot(EditAccountPresenter.ACCOUNT_PREFS, prefContainer);
		
		this.focus.addKeyDownHandler(event -> {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER)
				this.getUiHandlers().onEnter();
		});
	}

	@Override
	public void hidePasswordContainer() {
		this.passwords.setStyleName(this.res.w3().Hide());
	}

	@Override
	public void showPasswordContainer() {
		this.passwords.setStyleName(this.res.w3().Container());
	}

}
