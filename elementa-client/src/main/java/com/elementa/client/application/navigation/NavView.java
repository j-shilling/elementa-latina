package com.elementa.client.application.navigation;

import javax.inject.Inject;

import com.elementa.client.StringConstants;
import com.elementa.client.application.navigation.NavPresenter.MyView;
import com.elementa.client.resources.AppResources;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
import com.gwtplatform.mvp.client.view.PopupPositioner;

public class NavView extends PopupViewWithUiHandlers<NavUiHandlers> implements MyView {
	
	interface Binder extends UiBinder<PopupPanel, NavView> {
    }
	
	private final AppResources res;
	
	@UiField
	FlowPanel accountHider;
	@UiField
	FlowPanel loginHider;
	@UiField
	FlowPanel logoutHider;
	@UiField
	FlowPanel adminLinks;
	@UiField
	FlowPanel adminOrTeacherLinks;
	@UiField
	FlowPanel teacherLinks;
	@UiField
	FlowPanel teacherOrStudentLinks;
	@UiField
	FlowPanel studentLinks;
	
	@UiField
	Label closeNav;
	@UiField
	Label account;
	@UiField
	Label login;
	@UiField
	Label logout;
	@UiField
	Label dictionary;
	@UiField
	Label manageDictionary;
	@UiField
	Label manageAccounts;

	@Inject
	protected NavView(
			Binder uiBinder, 
			EventBus eventBus, 
			PopupPositioner positioner, 
			AppResources res,
			StringConstants constants) {
		
		super(eventBus, positioner);
		initWidget(uiBinder.createAndBindUi(this));
		
		this.res = res;
		
		this.closeNav.setText(constants.close());
		this.account.setText(constants.account());
		this.login.setText(constants.login());
		this.logout.setText(constants.logout());
		this.dictionary.setText(constants.dictionary());
		this.manageDictionary.setText(constants.manageDictionary());
		this.manageAccounts.setText(constants.manageAccounts());
	}

	@Override
	public void showAccountInfoLink(String text) {
		this.accountHider.setStyleName(res.w3().Show());
		this.account.setText(text);
	}

	@Override
	public void showAdminLinks() {
		this.adminLinks.setStyleName(res.w3().Show());
		this.adminOrTeacherLinks.setStyleName(res.w3().Show());
	}

	@Override
	public void showTeacherLinks() {
		this.teacherLinks.setStyleName(res.w3().Show());
		this.teacherOrStudentLinks.setStyleName(res.w3().Show());
		this.adminOrTeacherLinks.setStyleName(res.w3().Show());
	}

	@Override
	public void showStudentLinks() {
		this.studentLinks.setStyleName(res.w3().Show());
		this.teacherOrStudentLinks.setStyleName(res.w3().Show());
	}

	@Override
	public void showLogoutLink() {
		this.logoutHider.setStyleName(res.w3().Show());
	}

	@Override
	public void hideLoginLink() {
		this.loginHider.setStyleName(res.w3().Hide());		
	}
	
	@Override
	public void showLoginLink() {
		this.loginHider.setStyleName(res.w3().Show());
	}

	@Override
	public void hideAccountInfoLink() {
		this.accountHider.setStyleName(res.w3().Hide());
	}

	@Override
	public void hideLoggedInLinks() {
		this.adminLinks.setStyleName(res.w3().Hide());
		this.adminOrTeacherLinks.setStyleName(res.w3().Hide());
		this.teacherLinks.setStyleName(res.w3().Hide());
		this.teacherOrStudentLinks.setStyleName(res.w3().Hide());
		this.studentLinks.setStyleName(res.w3().Hide());
	}

	@Override
	public void hideLogoutLink() {
		this.logoutHider.setStyleName(res.w3().Hide());
	}
	
	@UiHandler ("closeNav")
	void closeNav (ClickEvent event) {
		this.getUiHandlers().onCloseClick();
	}
	@UiHandler ("account")
	void account (ClickEvent event) {
		this.getUiHandlers().onAccountClick();
	}
	@UiHandler ("login")
	void login (ClickEvent event) {
		this.getUiHandlers().onLoginClick();
	}
	@UiHandler ("logout")
	void logout (ClickEvent event) {
		this.getUiHandlers().onLogoutClick();
	}
	@UiHandler ("dictionary")
	void dictionary (ClickEvent event) {
		this.getUiHandlers().onDictionaryClick();
	}
	@UiHandler ("manageDictionary")
	void manageDictionary (ClickEvent event) {
		this.getUiHandlers().onManageDictionaryClick();
	}
	@UiHandler ("manageAccounts")
	void manageAccounts (ClickEvent event) {
		this.getUiHandlers().onManageAccountsClick();
	}

	

}
