package com.elementa.shared.dto.form;

import com.google.gwt.core.shared.GwtIncompatible;
import com.google.inject.AbstractModule;

@GwtIncompatible
public class FormDtoGuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(FormDtoComparators.class);
		this.bind(FormDtoFactory.class);
		this.bind(FormDtoModules.class);
	}

}
