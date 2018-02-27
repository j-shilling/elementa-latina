package com.elementa.client.application.navigation;

import javax.inject.Inject;

import com.elementa.client.CurrentUser;
import com.elementa.client.application.LoginEvent;
import com.elementa.client.application.LoginHandler;
import com.elementa.client.application.LogoutEvent;
import com.elementa.client.application.LogoutHandler;
import com.elementa.client.place.NameTokens;
import com.elementa.client.place.ParameterTokens;
import com.elementa.shared.dto.User;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class NavPresenter extends PresenterWidget<NavPresenter.MyView> implements NavUiHandlers {
	
	class Handler implements LoginHandler, LogoutHandler {
		
		@Override
		public void onLogin(LoginEvent loginEvent) {
			User user = loginEvent.getUser();
			MyView view = NavPresenter.this.getView();
			
			view.showAccountInfoLink(user.getUsername());
			
			if (user.isAdmin())
				view.showAdminLinks();
			if (user.isTeacher())
				view.showTeacherLinks();
			if (user.isStudent())
				view.showStudentLinks();
			
			view.showLogoutLink();
			view.hideLoginLink();
		}
		
		@Override
		public void onLogout(LogoutEvent e) {
			MyView view = NavPresenter.this.getView();
			
			view.hideLogoutLink();
			view.showLoginLink();
			view.hideAccountInfoLink();
			view.hideLoggedInLinks();
		}
		
	}
	
	interface MyView extends PopupView, HasUiHandlers<NavUiHandlers> {
		void showAccountInfoLink (String text);
		void showAdminLinks();
		void showTeacherLinks();
		void showStudentLinks();
		void showLogoutLink();
		void showLoginLink();
		void hideLoginLink();
		void hideAccountInfoLink ();
		void hideLoggedInLinks();
		void hideLogoutLink();
	}
	
	private final PlaceManager placeManager;
	private final Handler handler;
	private final CurrentUser user;
	
	@Inject
	public NavPresenter(
			EventBus eventBus, 
			MyView view,
			PlaceManager placeManager,
			CurrentUser user) {
		super(eventBus, view);
		this.getView().setUiHandlers(this);
		
		this.placeManager = placeManager;
		this.handler = new Handler();
		this.user = user;
		
		this.getEventBus().addHandler(LoginEvent.TYPE, this.handler);
		this.getEventBus().addHandler(LogoutEvent.TYPE, this.handler);
		
		if (user.isLoggedIn()) {
			this.handler.onLogin(new LoginEvent(user.getUser().get()));
		} else {
			this.handler.onLogout(new LogoutEvent());
		}
	}

	@Override
	public void onCloseClick() {
		this.getView().hide();
	}

	@Override
	public void onAccountClick() {
		if (this.user.isLoggedIn()) {
			int uid = user.getUser().get().getUid();
			this.placeManager.revealPlace(new PlaceRequest.Builder()
					.nameToken(NameTokens.EDIT_ACCOUNT)
					.with(ParameterTokens.UID, Integer.toString(uid))
					.build());
		}
		
		this.getView().hide();
	}

	@Override
	public void onLoginClick() {
		this.placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.LOGIN).build());
		this.getView().hide();
	}

	@Override
	public void onDictionaryClick() {
		this.placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.DICTIONARY).build());
		this.getView().hide();
	}

	@Override
	public void onManageDictionaryClick() {
		this.placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.MANAGE_DICTIONARY).build());
		this.getView().hide();
	}

	@Override
	public void onManageAccountsClick() {
		this.placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.MANAGE_ACCOUNTS).build());
		this.getView().hide();
	}

	@Override
	public void onLogoutClick() {
		this.getEventBus().fireEvent(new LogoutEvent());
		this.placeManager.revealDefaultPlace();
		this.getView().hide();
	}

}
