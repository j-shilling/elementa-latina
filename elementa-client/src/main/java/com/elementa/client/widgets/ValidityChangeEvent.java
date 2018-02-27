package com.elementa.client.widgets;

import com.google.common.base.Optional;
import com.google.gwt.event.shared.GwtEvent;

public class ValidityChangeEvent extends GwtEvent<ValidityChangeHandler> {
	
	public static final Type<ValidityChangeHandler> TYPE = new Type<>();
	
	private final Optional<Boolean> valid;
	
	public ValidityChangeEvent (Optional<Boolean> valid) {
		this.valid = valid;
	}
	public ValidityChangeEvent (Boolean val) {
		this (Optional.fromNullable(val));
	}
	public ValidityChangeEvent (boolean val) {
		this (new Boolean (val));
	}
	
	public boolean isValid() {
		return this.valid.isPresent() && this.valid.get().booleanValue();
	}
	
	public boolean isInvalid() {
		return this.valid.isPresent() && !this.valid.get().booleanValue();
	}
	
	public boolean isNeutral() {
		return !this.valid.isPresent();
	}
	

	@Override
	public Type<ValidityChangeHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ValidityChangeHandler handler) {
		handler.onChange(this);
	}

}
