package com.elementa.client.callbacks;

import java.util.logging.Level;

import javax.inject.Inject;

import com.elementa.client.Logger;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class CallBack<T> implements AsyncCallback<T> {
	
	private final Logger logger;
	
	@Inject
	protected CallBack (Logger logger) {
		this.logger = logger;
	}
	
	@Override
	public void onFailure(Throwable caught) {
		this.logger.log(Level.SEVERE,
				"Caught exception during server call: " + caught.getMessage());
	}

}
