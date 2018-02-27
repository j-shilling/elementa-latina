package com.elementa.client.application.accounts.manageaccounts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import com.elementa.client.CurrentUser;
import com.elementa.client.Logger;
import com.elementa.client.StringConstants;
import com.elementa.client.callbacks.CallBack;
import com.elementa.shared.api.UsersResource;
import com.elementa.shared.dto.User;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.cellview.client.AbstractPager;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.view.client.ListDataProvider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class UserDataTablePresenter extends PresenterWidget<UserDataTablePresenter.MyView> implements HasHandlers {
	
	interface MyView extends View {
		public void addDataTable (CellTable<?> table, AbstractPager pager);
	}
	
	private final StringConstants constants;
	private final Logger logger;
	private final CurrentUser user;
	private final ResourceDelegate<UsersResource> users;
	private final ListDataProvider<User> dataProvider;
	private final HandlerManager manager;
	
	@Inject
	public UserDataTablePresenter(
			EventBus eventBus, 
			MyView view,
			StringConstants constants,
			Logger logger,
			CurrentUser user,
			ResourceDelegate<UsersResource> users) {
		super(eventBus, view);
		
		this.constants = constants;
		this.logger = logger;
		this.user = user;
		this.users = users;
		
		this.manager = new HandlerManager(this);
		
		CellTable<User> table = new CellTable<User>();

		TextColumn<User> uidCol = new TextColumn<User>() {

			@Override
			public String getValue(User object) {
				return Integer.toString(object.getUid());
			}

		};
		table.addColumn(uidCol, this.constants.uid());

		TextColumn<User> firstNameCol = new TextColumn<User>() {

			@Override
			public String getValue(User object) {
				return object.getFirstName();
			}

		};
		table.addColumn(firstNameCol, this.constants.firstName());

		TextColumn<User> lastNameCol = new TextColumn<User>() {

			@Override
			public String getValue(User object) {
				return object.getLastName();
			}

		};
		table.addColumn(lastNameCol, this.constants.lastName());

		TextColumn<User> roleCol = new TextColumn<User>() {

			@Override
			public String getValue(User object) {
				return object.getType().toString();
			}

		};
		table.addColumn(roleCol, this.constants.role());

		TextColumn<User> usernameCol = new TextColumn<User>() {

			@Override
			public String getValue(User object) {
				return object.getUsername();
			}

		};
		table.addColumn(usernameCol, this.constants.username());

		TextColumn<User> emailCol = new TextColumn<User>() {

			@Override
			public String getValue(User object) {
				return object.getEmail();
			}

		};
		table.addColumn(emailCol, this.constants.email());

		SimplePager pager = new SimplePager();
		pager.setDisplay(table);
		pager.setPageSize(10);

		dataProvider = new ListDataProvider<User>();
		dataProvider.addDataDisplay(table);

		ListHandler<User> columnSortHandler = new ListHandler<User>(dataProvider.getList());
		columnSortHandler.setComparator(uidCol, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return o1.getUid() - o2.getUid();
			}

		});
		uidCol.setSortable(true);

		columnSortHandler.setComparator(firstNameCol, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}

		});
		firstNameCol.setSortable(true);

		columnSortHandler.setComparator(lastNameCol, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}

		});
		lastNameCol.setSortable(true);

		columnSortHandler.setComparator(usernameCol, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return o1.getUsername().compareTo(o2.getUsername());
			}

		});
		usernameCol.setSortable(true);

		columnSortHandler.setComparator(emailCol, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return o1.getEmail().compareTo(o2.getEmail());
			}

		});
		emailCol.setSortable(true);

		columnSortHandler.setComparator(roleCol, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return o1.getType().toInt() - o2.getType().toInt();
			}

		});
		roleCol.setSortable(true);

		table.addColumnSortHandler(columnSortHandler);

		table.addDomHandler(new DoubleClickHandler() {

			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				User user = dataProvider.getList().get(table.getKeyboardSelectedRow() + pager.getPageStart());
				UserDataTablePresenter.this.fireEvent(new UserSelectedEvent (user));
			}

		}, DoubleClickEvent.getType());

		this.getView().addDataTable(table, pager);
	}
	
	public void populate(final String search) {
		CallBack<Set<User>> callback = new CallBack<Set<User>>(this.logger) {

			@Override
			public void onSuccess(Set<User> result) {
				List<User> list = UserDataTablePresenter.this.dataProvider.getList();
				list.clear();

				list.addAll(result);

				UserDataTablePresenter.this.dataProvider.refresh();
			}
			
		};
		
		if (search.isEmpty())
			users.withCallback(callback).get(this.user.getAuthorization());
		else
			users.withCallback(callback).get(this.user.getAuthorization(), search);
	}
	
	public HandlerRegistration addUserSelectedHandler (UserSelectedHandler handler) {
		return this.manager.addHandler(UserSelectedEvent.TYPE, handler);
	}
	
	@Override
	public void fireEvent (GwtEvent<?> event) {
		this.manager.fireEvent(event);
	}

}
