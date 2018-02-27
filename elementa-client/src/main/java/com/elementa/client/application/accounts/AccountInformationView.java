package com.elementa.client.application.accounts;

import javax.inject.Inject;

import com.elementa.client.StringConstants;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class AccountInformationView 
		extends ViewWithUiHandlers<AccountInformationUiHandlers>
		implements AccountInformationPresenter.MyView {

	interface Binder extends UiBinder<Widget, AccountInformationView> {
	}
	
	@UiField
	SimplePanel nameTxtBox;
	@UiField
	SimplePanel usernameTxtBox;
	@UiField
	SimplePanel emailTxtBox;
	
	@UiField
	Label nameLbl;
	@UiField
	Label usernameLbl;
	@UiField
	Label emailLbl;
	
	@UiField
	CheckBox adminchk;
	@UiField
	CheckBox teacherchk;
	@UiField
	CheckBox studentchk;

	@Inject
	public AccountInformationView(Binder uiBinder, StringConstants constants) {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.bindSlot(AccountInformationPresenter.NAME, nameTxtBox);
		this.bindSlot(AccountInformationPresenter.USERNAME, usernameTxtBox);
		this.bindSlot(AccountInformationPresenter.EMAIL, emailTxtBox);
		
		this.nameLbl.setText(constants.name());
		this.emailLbl.setText(constants.email());
		this.usernameLbl.setText(constants.username());
		
		this.adminchk.setText(" " + constants.admin());
		this.teacherchk.setText(" " + constants.teacher());
		this.studentchk.setText(" " + constants.student());
		
		ClickHandler handler = event -> { getUiHandlers().onChange(); };
		this.adminchk.addClickHandler(handler);
		this.teacherchk.addClickHandler(handler);
		this.studentchk.addClickHandler(handler);
	}
	
	@Override
	public void setAdmin(boolean val) {
		this.adminchk.setValue(val);
	}

	@Override
	public void setTeacher(boolean val) {
		this.teacherchk.setValue(val);
	}

	@Override
	public void setStudent(boolean val) {
		this.studentchk.setValue(val);
	}

	@Override
	public boolean isAdmin() {
		return this.adminchk.getValue();
	}

	@Override
	public boolean isTeacher() {
		return this.teacherchk.getValue();
	}

	@Override
	public boolean isStudent() {
		return this.studentchk.getValue();
	}

	@Override
	public void setAdminEnabled(boolean val) {
		this.adminchk.setEnabled(val);
	}

	@Override
	public void setTeacherEnabled(boolean val) {
		this.teacherchk.setEnabled(val);
	}

	@Override
	public void setStudentEnabled(boolean val) {
		this.teacherchk.setEnabled(val);
	}

	@Override
	public void disableCheckBoxes() {
		this.adminchk.setEnabled(false);
		this.teacherchk.setEnabled(false);
		this.studentchk.setEnabled(false);
	}

}
