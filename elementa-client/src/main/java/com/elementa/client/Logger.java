package com.elementa.client;

import java.util.logging.Level;

import javax.inject.Inject;

import com.elementa.shared.api.LogsResource;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;

/**
 * Client side logger which can log to the server.
 * 
 * @author Jake Shilling
 * @since 0.1
 */
public class Logger {
	
	private final Level level = Level.ALL;
	private final CurrentUser user;
	private final ResourceDelegate<LogsResource> logs;
	
	/**
	 * Injects dependencies
	 * 
	 * @param user		Provides information about the current user.
	 * @param logs		Provides remote access to the server log.
	 */
	@Inject
	public Logger (
			CurrentUser user,
			ResourceDelegate<LogsResource> logs) {
		this.user = user;
		this.logs = logs;
	}
	
	/**
	 * Logs a message on the server if the level is greater than
	 * or equal to the level of this object.
	 * 
	 * @param level		The priority level of this message
	 * @param msg		The string to log
	 */
	public void log (Level level, String msg) {
		if (level.intValue() < this.level.intValue()) {
			return;
		}
		
		int uid = 0;
		if (this.user.isLoggedIn()) {
			uid = this.user.getUser().get().getUid();
		}
		
		logs.withoutCallback().log(uid, msg);
	}

}
