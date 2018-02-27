package com.elementa.language.morphology.noun;

import com.google.inject.AbstractModule;

public class NounModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(NounEndings.class);
		this.bind(NounAnalyzer.class);
		this.bind(NounStem.class);
		this.bind(NounForms.class);
	}

}
