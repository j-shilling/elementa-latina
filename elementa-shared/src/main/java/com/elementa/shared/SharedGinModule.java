package com.elementa.shared;

import com.elementa.shared.dto.form.FormDtoGinModule;
import com.google.gwt.inject.client.AbstractGinModule;

public class SharedGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		this.install(new FormDtoGinModule());
	}

}
