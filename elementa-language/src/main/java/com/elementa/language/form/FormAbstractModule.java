package com.elementa.language.form;

import com.google.inject.AbstractModule;

public abstract class FormAbstractModule extends AbstractModule {
	
	protected abstract Class<? extends FormFactory> factory();

	@Override
	protected void configure() {
		this.bind(FormComparators.class);
		this.bind(FormModules.class);
		
		this.bind(FormFactory.class).to(this.factory());
	}

}
