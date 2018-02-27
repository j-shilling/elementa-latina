package com.elementa.client.widgets;

import com.google.common.base.Optional;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.junit.client.GWTTestCase;

public class HasValidityGwtTest extends GWTTestCase {
	
	public static class Validity implements HasValidity {
		
		Optional<Boolean> val = Optional.absent();
		HandlerManager hm = new HandlerManager(this);
		Optional<ValidityChecker> checker = Optional.absent();

		@Override
		public Optional<Boolean> getValidityValue() {
			return this.val;
		}

		@Override
		public void setValidityValue(Optional<Boolean> val) {
			this.val = val;
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
		
	}

	@Override
	public String getModuleName() {
		return "com.elementa.Elementa";
	}
	
	int i = 0;
	int j = 0;
	
	public void testValidityChangeHandler() {
		Validity obj = new Validity();
		obj.addValidityChangeHandler(event -> { i++; });
		obj.addValidityChangeHandler(event -> { j++; });
		
		obj.setValid();
		obj.setInvalid();
		obj.setNeutral();
		
		assertTrue (i == 3);
		assertTrue (j == 3);
		
		i = 0;
		j = 0;
		
		obj.setValidityChecker(o -> {
			if (o.isValid())
				o.setInvalid();
			else if (o.isInvalid())
				o.setNeutral();
			else
				o.setValid();
		});
		
		obj.check();
		obj.check();
		obj.check();
		
		assertTrue (i == 3);
		assertTrue (j == 3);
	}

}
