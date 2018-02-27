package com.elementa.client.widgets.authenticator;

import javax.inject.Inject;

import com.elementa.client.CurrentUser;
import com.elementa.client.Logger;
import com.elementa.client.StringConstants;
import com.elementa.client.callbacks.BooleanCallback;
import com.elementa.client.widgets.ValidityChangeHandler;
import com.elementa.client.widgets.actionbutton.ActionButtonPresenter;
import com.elementa.client.widgets.textbox.AbstractTextBoxPresenter;
import com.elementa.client.widgets.textbox.PasswordTextBoxPresenter;
import com.elementa.client.widgets.textbox.TextBoxPresenter;
import com.elementa.shared.api.UsersResource;
import com.google.common.base.Optional;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;

public class AuthenticatorPresenter extends PresenterWidget<AuthenticatorPresenter.MyView> implements AuthenticatorUiHandlers {

	interface MyView extends PopupView, HasUiHandlers<AuthenticatorUiHandlers> {
	}
	
	public static final PermanentSlot<ActionButtonPresenter> VALIDATE = new PermanentSlot<>();
	public static final PermanentSlot<AbstractTextBoxPresenter> USERNAME = new PermanentSlot<>();
	public static final PermanentSlot<AbstractTextBoxPresenter> PASSWORD = new PermanentSlot<>();
	
	private final AbstractTextBoxPresenter username;
	private final AbstractTextBoxPresenter password;
	private final ActionButtonPresenter validate;
	
	public Optional<BooleanCallback> callback;
	
	@Inject
	public AuthenticatorPresenter(EventBus eventBus,
			MyView view,
			ResourceDelegate<UsersResource> users,
			Logger logger,
			CurrentUser currentUser,
			StringConstants constants,
			ActionButtonPresenter validate,
			TextBoxPresenter username,
			PasswordTextBoxPresenter password) {
		super(eventBus, view);
		
		this.getView().setUiHandlers(this);
		
		this.setInSlot(VALIDATE, validate);
		this.setInSlot(USERNAME, username);
		this.setInSlot(PASSWORD, password);
		
		this.username = username;
		this.password = password;
		this.validate = validate;
		
		username.setValidityChecker(obj -> {
			obj.setValid(!username.getText().isEmpty());
		});
		password.setValidityChecker(obj -> {
			obj.setValid(!password.getText().isEmpty());
		});
		
		ValidityChangeHandler handler = event -> {
			validate.setEnabled(username.isValid() && password.isValid());
		};
		username.addValidityChangeHandler(handler);
		password.addValidityChangeHandler(handler);
		
		this.callback = Optional.absent();
		
		validate.setAction(() -> {
			users.withCallback(new BooleanCallback(logger) {

				@Override
				public void onTrue() {
					if (callback.isPresent())
						callback.get().onTrue();
					
					getView().hide();
				}

				@Override
				public void onFalse() {
					if (callback.isPresent())
						callback.get().onFalse();
					
					getView().hide();
				}
				
			}).validate(currentUser.getAuthorization(), username.getText(), password.getText());
		});
		validate.setText(constants.validate());
	}
	
	public void setCallback (BooleanCallback callback) {
		this.callback = Optional.fromNullable(callback);
	}
	
	@Override
	public void onReveal() {
		username.setText("");
		password.setText("");
		
		username.setFocus(true);
	}

	@Override
	public void onEnter() {
		validate.click();
	}

}
