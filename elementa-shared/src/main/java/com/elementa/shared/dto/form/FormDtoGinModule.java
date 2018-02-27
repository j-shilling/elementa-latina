package com.elementa.shared.dto.form;

import com.google.gwt.inject.client.AbstractGinModule;

public class FormDtoGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		this.bind(FormDtoComparators.class);
		this.bind(FormDtoFactory.class);
		this.bind(FormDtoModules.class);
	}

}
