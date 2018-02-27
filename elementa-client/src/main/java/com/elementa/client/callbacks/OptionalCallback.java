package com.elementa.client.callbacks;

import javax.inject.Inject;

import com.elementa.client.Logger;

public abstract class OptionalCallback<T> extends CallBack<T> {
	
	@Inject
	protected OptionalCallback(Logger logger) {
		super(logger);
	}
	
	public abstract void onFound(T result);
	public abstract void onNotFound();

	@Override
	public void onSuccess(T result) {
		if (result != null) {
			this.onFound(result);
		} else {
			this.onNotFound();
		}
	}

}
