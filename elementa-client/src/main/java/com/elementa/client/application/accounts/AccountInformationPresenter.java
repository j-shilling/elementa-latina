package com.elementa.client.application.accounts;

import javax.inject.Inject;

import com.elementa.client.CurrentUser;
import com.elementa.client.Logger;
import com.elementa.client.callbacks.BooleanCallback;
import com.elementa.client.widgets.HasValidity;
import com.elementa.client.widgets.ValidityChangeHandler;
import com.elementa.client.widgets.ValidityChecker;
import com.elementa.client.widgets.textbox.TextBoxPresenter;
import com.elementa.shared.api.UsersResource;
import com.elementa.shared.dto.AccountRole;
import com.elementa.shared.dto.AccountType;
import com.elementa.shared.dto.User;
import com.google.common.base.Optional;
import com.google.gwt.event.shared.HandlerManager;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;

public class AccountInformationPresenter 
		extends PresenterWidget<AccountInformationPresenter.MyView>
		implements AccountInformationUiHandlers, HasValidity {

	interface MyView extends View, HasUiHandlers<AccountInformationUiHandlers> {
		void setAdmin (boolean val);
		void setTeacher (boolean val);
		void setStudent (boolean val);
		
		void setAdminEnabled (boolean val);
		void setTeacherEnabled (boolean val);
		void setStudentEnabled (boolean val);
		
		boolean isAdmin();
		boolean isTeacher();
		boolean isStudent();
		
		void disableCheckBoxes();
	}
	
	public static final PermanentSlot<TextBoxPresenter> NAME = new PermanentSlot<>();
	public static final PermanentSlot<TextBoxPresenter> USERNAME = new PermanentSlot<>();
	public static final PermanentSlot<TextBoxPresenter> EMAIL = new PermanentSlot<>();
	
	private final TextBoxPresenter name;
	private final TextBoxPresenter username;
	private final TextBoxPresenter email;
	
	private final HandlerManager hm;
	
	private Optional<User> user;
	private Optional<Boolean> valid;
	private Optional<ValidityChecker> checker;
	
	@Inject
	public AccountInformationPresenter(
			EventBus eventBus, 
			MyView view,
			Logger logger,
			CurrentUser currentUser,
			ResourceDelegate<UsersResource> users,
			TextBoxPresenter name,
			TextBoxPresenter username,
			TextBoxPresenter email) {
		
		super(eventBus, view);
		
		this.getView().setUiHandlers(this);
		
		this.setInSlot(NAME, name);
		this.setInSlot(USERNAME, username);
		this.setInSlot(EMAIL, email);
		
		this.user = Optional.absent();
		this.hm = new HandlerManager(this);
		this.valid = Optional.absent();
		this.checker = Optional.absent();
		
		this.name = name;
		this.username = username;
		this.email = email;
		
		this.username.setRequired(true);
		
		this.name.setRegex("^[a-zA-Z ]+$");
		this.email.setRegex("^(.+)@(.+)$");
		this.username.setValidityChecker(o -> {
			
			if (username.getText().isEmpty()) {
				o.setInvalid();
				return;
			}
			
			if (user.isPresent()) {

				if (user.get().getUsername().equals(username.getText())) {
					o.setValid();
					return;
				}

			}

			users.withCallback(new BooleanCallback(logger) {

				@Override
				public void onTrue() {
					o.setValid();
				}

				@Override
				public void onFalse() {
					o.setInvalid();
				}

			}).checkUsername(currentUser.getAuthorization(), username.getText());

		});

		ValidityChangeHandler handler = event -> {
			onChange();
		};
		this.name.addValidityChangeHandler(handler);
		this.username.addValidityChangeHandler(handler);
		this.email.addValidityChangeHandler(handler);
		
		this.setValidityChecker(obj -> {
			
			obj.setValid(
						!name.isInvalid()
						&& username.isValid()
						&& !email.isInvalid()
						&& (getView().isAdmin()
							|| getView().isTeacher()
							|| getView().isStudent())
					);
			
		});
		
		this.getView().setStudent(true);
	}
	
	public void setUser(User user) {
		this.user = Optional.fromNullable(user);
		if (!this.user.isPresent())
			return;
		
		this.name.setText((user.getFirstName() + " " + user.getLastName()).trim());
		this.username.setText(user.getUsername());
		this.email.setText(user.getEmail());
		
		this.getView().setAdmin(user.isAdmin());
		this.getView().setTeacher(user.isTeacher());
		this.getView().setStudent(user.isStudent());
		
		this.check();
	}
	
	public Optional<User> buildUser() {
		
		if (! this.isValid() )
			return Optional.absent();
		
		AccountType type;
		String usrname = "";
		String firstName = "";
		String lastName = "";
		String eml = "";

		usrname = username.getText().trim();
		eml = email.getText().trim();

		String[] names = name.getText().trim().split(" ");
		if (names.length == 1) {
			firstName = names[0];
		} else if (names.length > 1) {
			lastName = names[names.length - 1];
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < (names.length - 1); i++) {
				sb.append(names[i]);
			}
			firstName = sb.toString();
		}

		type = new AccountType();
		if (getView().isAdmin())
			type.addRole(AccountRole.ADMIN);
		if (getView().isTeacher())
			type.addRole(AccountRole.TEACHER);
		if (getView().isStudent())
			type.addRole(AccountRole.STUDENT);

		return Optional.of(new User.UserBuilder()
					.setUsername(usrname)
					.setFirstName(firstName)
					.setLastName(lastName)
					.setEmail(eml)
					.setType(type)
					.build());
	}

	@Override
	public void onChange() {
		this.check();
	}

	@Override
	public void setValidityValue(Optional<Boolean> val) {
		this.valid = val;
	}

	@Override
	public HandlerManager getHandlerManager() {
		return this.hm;
	}

	@Override
	public void setValidityChecker(ValidityChecker checker) {
		this.checker = Optional.fromNullable(checker);
	}

	@Override
	public Optional<ValidityChecker> getValidityChecker() {
		return this.checker;
	}

	@Override
	public Optional<Boolean> getValidityValue() {
		return this.valid;
	}
	
	public TextBoxPresenter getNameTextBox() {
		return this.name;
	}
	
	public TextBoxPresenter getUsernameTextBox() {
		return this.username;
	}
	
	public TextBoxPresenter getEmailTextBox() {
		return this.email;
	}
	
	public void setFocus(boolean val) {
		this.name.setFocus(val);
	}
	
	public void reset() {
		this.name.setText("");
		this.username.setText("");
		this.email.setText("");
		
		this.getView().setAdmin(false);
		this.getView().setTeacher(false);
		this.getView().setStudent(true);
	}
	
	public void disableRoles() {
		this.getView().disableCheckBoxes();
	}

}
