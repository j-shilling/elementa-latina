package com.elementa.language.morphology.adjectives;

import com.google.inject.AbstractModule;

public class AdjectiveModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(AdjectiveEndings.class);
		this.bind(AdjectiveAnalyzer.class);
		this.bind(AdjectiveStems.class);
		this.bind(AdjectiveForms.class);
	}

}
