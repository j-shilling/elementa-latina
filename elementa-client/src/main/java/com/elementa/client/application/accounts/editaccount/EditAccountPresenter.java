package com.elementa.client.application.accounts.editaccount;

import java.util.logging.Level;

import com.elementa.client.CurrentUser;
import com.elementa.client.Logger;
import com.elementa.client.StringConstants;
import com.elementa.client.application.ApplicationPresenter;
import com.elementa.client.application.LoginEvent;
import com.elementa.client.application.MessengerPresenter;
import com.elementa.client.application.accounts.AccountInformationPresenter;
import com.elementa.client.callbacks.BooleanCallback;
import com.elementa.client.callbacks.OptionalCallback;
import com.elementa.client.place.HasTitle;
import com.elementa.client.place.NameTokens;
import com.elementa.client.place.ParameterTokens;
import com.elementa.client.widgets.ValidityChangeHandler;
import com.elementa.client.widgets.actionbutton.ActionButtonPresenter;
import com.elementa.client.widgets.authenticator.AuthenticatorPresenter;
import com.elementa.client.widgets.textbox.PasswordTextBoxPresenter;
import com.elementa.shared.api.UsersResource;
import com.elementa.shared.dto.AccountType;
import com.elementa.shared.dto.User;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.GatekeeperWithParams;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class EditAccountPresenter 
		extends Presenter<EditAccountPresenter.MyView, EditAccountPresenter.MyProxy> 
		implements HasTitle, EditAccountUiHandlers {

	interface MyView extends View, HasUiHandlers<EditAccountUiHandlers>  {
		void hidePasswordContainer();
		void showPasswordContainer();
	}
	
	@NameToken(NameTokens.EDIT_ACCOUNT)
	@ProxyStandard
	interface MyProxy extends ProxyPlace<EditAccountPresenter> {
	}
	
	public static final PermanentSlot<AccountInformationPresenter> ACCOUNT_INFO = new PermanentSlot<>();
	public static final PermanentSlot<EditAccountPreferencesPresenter> ACCOUNT_PREFS = new PermanentSlot<>();
	
	public static final PermanentSlot<PasswordTextBoxPresenter> NEW_PASSWORD = new PermanentSlot<>();
	public static final PermanentSlot<PasswordTextBoxPresenter> CONFIRM_PASSWORD = new PermanentSlot<>();
	
	public static final PermanentSlot<ActionButtonPresenter> SAVE = new PermanentSlot<>();
	public static final PermanentSlot<ActionButtonPresenter> DELETE = new PermanentSlot<>();
	
	private User user;
	
	private final Logger logger;
	private final MessengerPresenter messenger;
	private final StringConstants constants;
	private final CurrentUser currentUser;
	private final ResourceDelegate<UsersResource> users;
	private final PlaceManager placeManager;
	
	private final GatekeeperWithParams gatekeeper;
	
	private final AccountInformationPresenter accountInfo;
	
	private final PasswordTextBoxPresenter newPassword;
	private final PasswordTextBoxPresenter confirmPassword;
	
	private final ActionButtonPresenter save;
	private final ActionButtonPresenter delete;
	
	private final EditAccountPreferencesPresenter prefs;
	private final AuthenticatorPresenter auth;
	private final EventBus eventBus;
	
	private void saveUser () {
		
		/*First Check if the password is being changed */
		
		if (!newPassword.getText().isEmpty()) {
			auth.setCallback(new BooleanCallback(logger) {

				@Override
				public void onTrue() {
					
					/* If user is verified then change the password */
					
					users.withCallback(new BooleanCallback (logger) {

						@Override
						public void onTrue() {
							saveUserDetails();
						}

						@Override
						public void onFalse() {
							messenger.error("Failed to update password");
						}
						
					}).update(currentUser.getAuthorization(), newPassword.getText());
				}

				@Override
				public void onFalse() {
					messenger.error("Authentication failed.");
				}
				 
			});
			addToPopupSlot(auth);
			
		} else {
			saveUserDetails();
		}
	}
	
	private void saveUserDetails() {
		Optional<User> result = accountInfo.buildUser();
		if (!result.isPresent()) {
			messenger.error("Cannot create a valid user with the information below.");
			return;
		}
		User newUser = result.get()
				.toBuilder()
				.setUid(user.getUid())
				.setPreferences(prefs.getPreferences())
				.build();
		
		users.withCallback(new OptionalCallback<User> (logger) {

			@Override
			public void onFound(User result) {
				if (result.getUid() == currentUser.getUser().get().getUid()) {
					eventBus.fireEvent(new LoginEvent (result));
				}
				
				user = newUser;
				onReveal();
				messenger.fine("User updated.");
			}

			@Override
			public void onNotFound() {
				messenger.error("Could not update user");
			}
			
		}).update(currentUser.getAuthorization(), user.getUid(), newUser);
	}
	
	private void deleteUser() {
		users.withCallback(new BooleanCallback (logger) {

			@Override
			public void onTrue() {
				placeManager.navigateBack();
				messenger.fine("User deleted successfully");
			}

			@Override
			public void onFalse() {
				messenger.error("Could not delete user");
			}
			
		}).delete(currentUser.getAuthorization(), user.getUid());
	}
	
	@Inject
	EditAccountPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,
            Logger logger,
            MessengerPresenter messenger,
            StringConstants constants,
            PlaceManager placeManager,
            ResourceDelegate<UsersResource> users,
            CurrentUser currentUser,
            EditAccountGatekeeper gatekeeper,
            AccountInformationPresenter accountInfo,
            PasswordTextBoxPresenter newPassword,
            PasswordTextBoxPresenter confirmPassword,
            ActionButtonPresenter save,
            ActionButtonPresenter delete,
            EditAccountPreferencesPresenter prefs,
            AuthenticatorPresenter auth) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        this.getView().setUiHandlers(this);
        
        this.logger = logger;
        this.messenger = messenger;
        this.constants = constants;
        this.eventBus = eventBus;
        this.users = users;
        this.currentUser = currentUser;
        this.placeManager = placeManager;
        this.auth = auth;
        
        this.gatekeeper = gatekeeper;
        
        this.setInSlot(ACCOUNT_INFO, accountInfo);
        this.setInSlot(NEW_PASSWORD, newPassword);
        this.setInSlot(CONFIRM_PASSWORD, confirmPassword);
        this.setInSlot(SAVE, save);
        this.setInSlot(DELETE, delete);
        this.setInSlot(ACCOUNT_PREFS, prefs);
        
        this.accountInfo = accountInfo;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
        
        this.save = save;
        this.delete = delete;
        
        this.prefs = prefs;
		
        newPassword.setValidityChecker(obj -> {
        	if (newPassword.getText().isEmpty())
        		obj.setNeutral();
        	else
        		obj.setValid();
        });
		confirmPassword.setValidityChecker(o -> {
			
			if (newPassword.getText().isEmpty()) {
				if (confirmPassword.getText().isEmpty())
					confirmPassword.setNeutral();
				else
					confirmPassword.setInvalid();
			} else {
				confirmPassword.setValid(confirmPassword
						.getText()
						.equals(newPassword.getText()));
			}
			
		});
		newPassword.addTextBoxChangeHandler(event -> { confirmPassword.check(); });
        
        ValidityChangeHandler handler = event -> { onChange(); };
        this.newPassword.addValidityChangeHandler(handler);
        this.confirmPassword.addValidityChangeHandler(handler);
        this.accountInfo.addValidityChangeHandler(handler);
        
        save.setText(constants.save());
        save.setAction(() -> saveUser());
        delete.setText(constants.delete());
        delete.setAction(() -> deleteUser());
	}
	
	@Override
	public void onChange() {
		if (accountInfo.isValid()
				&& !newPassword.isInvalid() 
				&& !confirmPassword.isInvalid()) {
			
			this.save.enable();
			
		} else {
			
			this.save.disable();
			
		}
	}
	
	@Override
	public String getTitle() {
		return this.constants.editAccount();
	}
	
	@Override
	public void onReveal() {
		this.accountInfo.setUser(this.user);
		
		this.newPassword.setText("");
		this.confirmPassword.setText("");
		
		this.onChange();
		
		AccountType type = this.currentUser.getUser().get().getType();
		if (!type.isAdmin())
			this.accountInfo.disableRoles();
		
		if (!(type.isAdmin() || type.isTeacher()))
			this.delete.disable();
		
		if (this.currentUser.getUser().get().getUid() != this.user.getUid())
			this.getView().hidePasswordContainer();
		else
			this.getView().showPasswordContainer();
	}
	
	@Override
	public boolean useManualReveal() {
		return true;
	}
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		String uid = request.getParameter(ParameterTokens.UID, "0");
		
		this.gatekeeper.withParams(new String[] { uid });
		if (this.gatekeeper.canReveal()) {
			
			if (this.currentUser.getUser().get().getUid() == Integer.parseInt(uid)) {
				EditAccountPresenter.this.user = this.currentUser.getUser().get();
				EditAccountPresenter.this
					.getProxy()
					.manualReveal(EditAccountPresenter.this);
			} else {
			
				this.users.withCallback(new OptionalCallback<User>(this.logger) {
	
					@Override
					public void onFound(User result) {
						EditAccountPresenter.this.user = result;
						EditAccountPresenter.this
							.getProxy()
							.manualReveal(EditAccountPresenter.this);
					}
	
					@Override
					public void onNotFound() {
						EditAccountPresenter.this
							.logger.log(Level.WARNING,
									"Either user " + uid 
									+ " does not exist or we do not have permission to see it.");
						
						EditAccountPresenter.this
							.getProxy()
							.manualRevealFailed();
					}
					
				}).get(this.currentUser.getAuthorization(), Integer.parseInt(uid));
			}
			
		}
		
		this
			.getProxy()
			.manualRevealFailed();
	}

	@Override
	public void onEnter() {
		this.save.click();
	}

}
