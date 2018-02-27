package com.elementa.client.callbacks;

import com.elementa.client.Logger;

public abstract class BooleanCallback extends CallBack<Boolean> {
	
	public abstract void onTrue();
	public abstract void onFalse();

	protected BooleanCallback(Logger logger) {
		super(logger);
	}

	@Override
	public void onSuccess(Boolean result) {
		if (result.booleanValue())
			this.onTrue();
		else
			this.onFalse();
	}

}
