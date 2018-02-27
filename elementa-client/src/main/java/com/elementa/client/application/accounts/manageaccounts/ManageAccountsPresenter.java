package com.elementa.client.application.accounts.manageaccounts;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.annotations.NameToken;

import java.util.logging.Level;

import com.elementa.client.CurrentUser;
import com.elementa.client.Logger;
import com.elementa.client.StringConstants;
import com.elementa.client.application.AdminOrTeacherGatekeeper;
import com.elementa.client.application.ApplicationPresenter;
import com.elementa.client.application.MessengerPresenter;
import com.elementa.client.application.accounts.AccountInformationPresenter;
import com.elementa.client.callbacks.BooleanCallback;
import com.elementa.client.place.HasTitle;
import com.elementa.client.place.NameTokens;
import com.elementa.client.place.ParameterTokens;
import com.elementa.client.widgets.SelfStylingWidget;
import com.elementa.client.widgets.WidgetStyler;
import com.elementa.client.widgets.actionbutton.ActionButtonPresenter;
import com.elementa.client.widgets.textbox.TextBoxPresenter;
import com.elementa.shared.api.UsersResource;
import com.elementa.shared.dto.User;

public class ManageAccountsPresenter extends Presenter<ManageAccountsPresenter.MyView, ManageAccountsPresenter.MyProxy>
		implements HasTitle, ManageAccountsUiHandlers {

	interface MyView extends View, HasUiHandlers<ManageAccountsUiHandlers> {
		void setAddBtnStyler(WidgetStyler styler);

		void setSaveBtnStyler(WidgetStyler styler);

		void showAddUser();

		String getSearchText();

		void reset();

		void styleTextBox(SelfStylingWidget widget);
	}

	@NameToken(NameTokens.MANAGE_ACCOUNTS)
	@ProxyStandard
	@UseGatekeeper(AdminOrTeacherGatekeeper.class)
	interface MyProxy extends ProxyPlace<ManageAccountsPresenter> {
	}

	public static final PermanentSlot<ActionButtonPresenter> ADD = new PermanentSlot<>();
	public static final PermanentSlot<ActionButtonPresenter> SAVE = new PermanentSlot<>();
	public static final PermanentSlot<UserDataTablePresenter> TABLE = new PermanentSlot<>();
	public static final PermanentSlot<AccountInformationPresenter> ACCOUNT_INFO = new PermanentSlot<>();

	private final StringConstants constants;
	private final CurrentUser user;
	private final Logger logger;
	private final ResourceDelegate<UsersResource> users;

	private final ActionButtonPresenter save;
	private final ActionButtonPresenter add;
	private final AccountInformationPresenter account;
	private final UserDataTablePresenter table;
	private final MessengerPresenter messenger;

	private void save() {

		save.disable();
		logger.log(Level.FINER, "Saving new user.");
		
		Optional<User> newUser = this.account.buildUser();
		if (!newUser.isPresent())
			return;

		users.withCallback(new BooleanCallback(logger) {

			@Override
			public void onTrue() {
				ManageAccountsPresenter.this.onReveal();
				messenger.fine("New user saved.");
			}

			@Override
			public void onFalse() {
				logger.log(Level.WARNING, "Could not create new user.");
				messenger.error("Could not save new user.");
			}

		}).create(user.getAuthorization(), newUser.get());
	}

	private boolean autoUsername;

	@Inject
	ManageAccountsPresenter(EventBus eventBus, MyView view, MyProxy proxy, Logger logger, StringConstants constants,
			CurrentUser user, PlaceManager placeManager, ResourceDelegate<UsersResource> users,
			ActionButtonPresenter addBtn, ActionButtonPresenter saveBtn, AccountInformationPresenter account, UserDataTablePresenter table,
			MessengerPresenter messenger) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
		this.getView().setUiHandlers(this);

		/*
		 * Set Final Fields
		 */
		this.constants = constants;
		this.user = user;
		this.logger = logger;
		this.messenger = messenger;
		this.users = users;
		this.save = saveBtn;
		this.add = addBtn;
		this.table = table;
		this.account = account;

		/*
		 * Attach PresenterWidgets to Slots
		 */

		this.setInSlot(ADD, addBtn);
		this.setInSlot(SAVE, saveBtn);
		this.setInSlot(TABLE, table);
		this.setInSlot(ACCOUNT_INFO, account);

		/*
		 * Configure the view
		 */
		this.getView().setAddBtnStyler(addBtn.getStyler());
		this.getView().setSaveBtnStyler(saveBtn.getStyler());

		this.account
			.getUsernameTextBox()
			.addTextBoxChangeHandler(event -> autoUsername &= !event.isManualChange());
		
		this.account
			.getNameTextBox()
			.addTextBoxChangeHandler(event -> {
				
				TextBoxPresenter name = this.account.getNameTextBox();
				TextBoxPresenter username = this.account.getUsernameTextBox();
			
				if (autoUsername && name.isValid() && !name.getText().isEmpty()) {
					String[] names = name.getText().split(" ");
					StringBuilder sb = new StringBuilder();
	
					if (names.length == 1) {
						sb.append(names[0]);
					} else {
						sb.append(names[0].charAt(0));
						sb.append(names[names.length - 1]);
					}
	
					if (!sb.toString().isEmpty())
						username.setText(sb.toString().toLowerCase());
				}
		});

		/*
		 * Setup buttons
		 */

		addBtn.setAction (() -> {
			ManageAccountsPresenter.this.getView().showAddUser();
			addBtn.disable();
			this.account.setFocus(true);
		});
		addBtn.setText("+");

		saveBtn.setAction(() -> {
			save();
		});
		saveBtn.setText(this.constants.save());
		
		this.account.addValidityChangeHandler(event -> {
			if (event.isValid())
				saveBtn.enable();
			else
				saveBtn.disable();
		});

		/*
		 * Handler event when a table row is clicked
		 */

		table.addUserSelectedHandler(event -> {
			String uid = Integer.toString(event.getUser().getUid());
			placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.EDIT_ACCOUNT)
					.with(ParameterTokens.UID, uid).build());
		});
	}

	/*
	 * Inherited Methods
	 */

	@Override
	public void onReveal() {
		this.getView().reset();
		this.autoUsername = true;
		this.add.enable();
		this.save.disable();

		this.account.reset();
	}

	@Override
	public String getTitle() {
		return this.constants.manageAccounts();
	}

	@Override
	public void onSearchTextChange() {
		table.populate(getView().getSearchText());
	}

	@Override
	public void onEnter() {

		if (add.isVisible() && add.isEnabled()) {
			add.click();
			return;
		}

		if (save.isVisible() && save.isEnabled()) {
			save();
			return;
		}
	}
}