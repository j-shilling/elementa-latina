package com.elementa.client;

import java.util.logging.Level;

import javax.inject.Inject;

import com.elementa.client.application.LoginEvent;
import com.elementa.client.application.login.LoginPresenter;
import com.elementa.client.callbacks.OptionalCallback;
import com.elementa.client.place.NameTokens;
import com.elementa.shared.api.UsersResource;
import com.elementa.shared.dto.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.event.shared.UmbrellaException;
import com.google.gwt.user.client.Cookies;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

/**
 * Class used by <a href="https://dev.arcbees.com/gwtp/index.html">GWTP</a>
 * to set up the application before it is displayed to the user. Set up code is
 * executed by {@link AppBootstrapper#onBootstrap()}.
 * 
 * @see <a href="https://dev.arcbees.com/gwtp/get-started/Bootstrap-Code.html">Hook in the Bootstrap Process</a>
 * 
 * @author Jake Shilling
 * @since 0.1
 */
@Singleton
public class AppBootstrapper implements Bootstrapper {
	
	private final ResourceDelegate<UsersResource> users;
	private final EventBus eventBus;
	private final PlaceManager placeManager;
	private final Logger logger;
	
	/**
	 * Creates an instance of AppBootstrapper by injecting its
	 * dependencies.
	 * 
	 * @param users				Provides remote access to the users database 
	 * 							via {@link com.elementa.shared.api.UsersResource}
	 * @param eventBus			Grants access to the site wide event bus
	 * @param logger			Used for remote logging
	 * @param placeManager		Needed to reveal different pages.
	 */
	@Inject
	public AppBootstrapper(
			ResourceDelegate<UsersResource> users,
			EventBus eventBus,
			Logger logger,
			PlaceManager placeManager) {
		this.users = users;
		this.eventBus = eventBus;
		this.placeManager = placeManager;
		this.logger = logger;
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onBootstrap() {
		
		// Catch and handle all Exceptions
        GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			private Throwable unwrap (Throwable e) {
				if (e instanceof UmbrellaException) {
					UmbrellaException ue = (UmbrellaException) e;
					if (ue.getCauses().size() == 1) {
						return unwrap(ue.getCauses().iterator().next());
					}
				}
				return e;
			}

			@Override
			public void onUncaughtException(Throwable arg0) {
				Throwable e = this.unwrap(arg0);
				logger.log(Level.SEVERE, "Caught Exception: " 
						+ e.toString() + "\n" 
						+ e.getMessage());
			}
			
		});
        
        // Handle automatic log in
		String credential = Cookies.getCookie(LoginPresenter.COOKIE);
		
        if (credential != null) {
        	this.logger.log(Level.FINE, "Found credential cookie. Trying to autologin.");
        	users.withCallback(new OptionalCallback<User> (this.logger) {

				@Override
				public void onFound(User result) {
					AppBootstrapper.this.logger
						.log(Level.FINE, "Successfully authenticated user " 
								+ result.getUsername());
					AppBootstrapper.this.eventBus
						.fireEvent(new LoginEvent (result));
					AppBootstrapper.this.placeManager
						.revealCurrentPlace();
				}

				@Override
				public void onNotFound() {
					AppBootstrapper.this.placeManager
						.revealPlace(new PlaceRequest.Builder()
								.nameToken(NameTokens.LOGIN)
								.build());
				}
        		
        	}).login(credential); 
        } else {
        	this.placeManager
        		.revealDefaultPlace();
        }
	}

}
