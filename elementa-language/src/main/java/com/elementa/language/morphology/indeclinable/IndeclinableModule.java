package com.elementa.language.morphology.indeclinable;

import com.google.inject.AbstractModule;

public class IndeclinableModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(IndeclinableAnalyzer.class);
		this.bind(IndeclinableEndings.class);
		this.bind(IndeclinableForms.class);
		this.bind(IndeclinableStems.class);
	}

}
