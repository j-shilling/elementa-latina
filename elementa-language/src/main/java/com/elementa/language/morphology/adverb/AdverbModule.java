package com.elementa.language.morphology.adverb;

import com.google.inject.AbstractModule;

public class AdverbModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(AdverbAnalyzer.class);
		this.bind(AdverbEndings.class);
		this.bind(AdverbStems.class);
	}

}
