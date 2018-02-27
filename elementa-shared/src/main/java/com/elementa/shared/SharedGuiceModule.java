package com.elementa.shared;

import com.elementa.shared.dto.form.FormDtoGuiceModule;
import com.google.gwt.core.shared.GwtIncompatible;
import com.google.inject.AbstractModule;

@GwtIncompatible
public class SharedGuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		this.install(new FormDtoGuiceModule());
	}

}
