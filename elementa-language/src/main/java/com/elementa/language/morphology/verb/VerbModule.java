package com.elementa.language.morphology.verb;

import com.google.inject.AbstractModule;

public class VerbModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(VerbAnalyzer.class);
		this.bind(VerbEndings.class);
		this.bind(VerbForms.class);
		this.bind(VerbStems.class);
		
		this.bind(VerbFirstConjugationEndings.class);
		this.bind(VerbSecondConjugationEndings.class);
		this.bind(VerbThirdConjugationEndings.class);
		this.bind(VerbIOConjugationEndings.class);
		this.bind(VerbFourthConjugationEndings.class);
	}

}
