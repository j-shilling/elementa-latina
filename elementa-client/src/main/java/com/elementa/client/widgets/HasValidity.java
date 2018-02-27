package com.elementa.client.widgets;

import com.google.common.base.Optional;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;

public interface HasValidity {
	
	public Optional<Boolean> getValidityValue();
	public void setValidityValue (Optional<Boolean> val);
	public HandlerManager getHandlerManager();
	public void setValidityChecker (ValidityChecker checker);
	public Optional<ValidityChecker> getValidityChecker();
	
	default void setValidityValue (Boolean val) {
		this.setValidityValue(Optional.fromNullable(val));
	}
	default void setValidityValue (boolean val) {
		this.setValidityValue(new Boolean (val));
	}
	

	default public boolean isValid() {
		if (this.getValidityValue().isPresent()) {
			return this.getValidityValue().get().booleanValue();
		}
		
		return false;
	}
	default public boolean isInvalid() {
		if (this.getValidityValue().isPresent()) {
			return !this.getValidityValue().get().booleanValue();
		}
		
		return false;
	}
	default public boolean isNeutral() {
		return !this.getValidityValue().isPresent();
	}
	
	default public void setValid(Optional<Boolean> val) {
		if (this.getValidityValue().equals(val))
			return;
		
		this.setValidityValue(val);
		this.getHandlerManager().fireEvent(new ValidityChangeEvent(val));
	}
	default public void setValid(Boolean val) {
		this.setValid(Optional.fromNullable(val));
	}
	default public void setValid(boolean val) {
		this.setValid(new Boolean(val));
	}
	
	default public void setValid() {
		this.setValid(true);
	}
	default public void setInvalid() {
		this.setValid(false);
	}
	default public void setNeutral() {
		this.setValid(Optional.absent());
	}
	
	default public boolean check() {
		Optional<ValidityChecker> checker = this.getValidityChecker();
		
		if (checker.isPresent())
			checker.get().checkValidity(this);
		
		return this.isValid();
	}
	
	default HandlerRegistration addValidityChangeHandler(ValidityChangeHandler handler) {
		return this.getHandlerManager().addHandler(ValidityChangeEvent.TYPE, handler);
	}
	

}
