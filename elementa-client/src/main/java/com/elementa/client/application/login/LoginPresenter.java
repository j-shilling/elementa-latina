package com.elementa.client.application.login;

import java.util.Date;

import javax.inject.Inject;

import com.elementa.client.Logger;
import com.elementa.client.StringConstants;
import com.elementa.client.application.ApplicationPresenter;
import com.elementa.client.application.LoginEvent;
import com.elementa.client.callbacks.OptionalCallback;
import com.elementa.client.place.HasTitle;
import com.elementa.client.place.NameTokens;
import com.elementa.client.resources.AppResources;
import com.elementa.client.widgets.actionbutton.Action;
import com.elementa.client.widgets.actionbutton.ActionButtonPresenter;
import com.elementa.shared.api.UsersResource;
import com.elementa.shared.dto.User;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class LoginPresenter 
	extends Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy> 
	implements LoginUiHandlers, HasTitle {
	
	public static final String COOKIE = "ElementaLatinaCookie";
	
	class onLoginPressed implements Action {

		@Override
		public void execute() {
			String username = getView().getUserNameText();
			String password = getView().getPasswordText();
			
			resource.withCallback(
					new OptionalCallback<User>(logger) {

						@Override
						public void onFound(User result) {
							if (LoginPresenter.this.getView().remember()) {
								final long DURATION = 1000 * 60 * 60 * 24 * 365;
								Date expires = new Date (System.currentTimeMillis() + DURATION);
								
								Cookies.setCookie(COOKIE, result.getCredential(), expires);
							}
							
							eventBus.fireEvent(new LoginEvent (result));
							placeManager.revealDefaultPlace();
						}

						@Override
						public void onNotFound() {
							Window.alert("Login failed!");
						}
				
			}).login(username, password);
		
		}
		
	}

	@ProxyStandard
    @NameToken(NameTokens.LOGIN)
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<LoginPresenter> {
    }
	
	interface MyView extends View, HasUiHandlers<LoginUiHandlers> {
		public String getUserNameText();
		public String getPasswordText();
		public boolean remember();
		public void clearText();
    }
	
	public static final PermanentSlot<ActionButtonPresenter> SLOT = new PermanentSlot<>();
	
	private final ActionButtonPresenter login;
	private final ResourceDelegate<UsersResource> resource;
	private final EventBus eventBus;
	private final PlaceManager placeManager;
	private final StringConstants constants;
	private final Logger logger;
	
	private void validateInput() {
		if (this.getView().getUserNameText().isEmpty() || this.getView().getPasswordText().isEmpty()) {
			this.login.disable();
		} else {
			this.login.enable();
		}
	}
	
	@Inject
    LoginPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            ActionButtonPresenter btn,
            AppResources res,
            ResourceDelegate<UsersResource> resource,
            PlaceManager placeManager,
            Logger logger,
            StringConstants constants) {
          
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);

        this.getView().setUiHandlers(this);
        this.setInSlot(SLOT, btn);
        
        this.resource = resource;
        this.eventBus = eventBus;
        this.placeManager = placeManager;
        this.constants = constants;
        this.logger = logger;
        
        this.login = btn;
        this.login.addStyle(
        		res.w3().Btn(),
        		res.w3().Right(),
        		res.w3().Margin(),
        		res.theme().Light2());
        this.login.setText("Login");
        this.login.setAction(new onLoginPressed());
        this.validateInput();
    }
	
	@Override
	public void onReveal() {
		this.getView().clearText();
	}

	@Override
	public String getTitle() {
		return this.constants.login();
	}

	@Override
	public void onInputChange() {
		this.validateInput();
	}

	@Override
	public void onEnterPressed() {
		this.login.click();
	}
}
