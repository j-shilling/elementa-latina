package com.elementa.language.morphology;

import com.elementa.language.morphology.adjectives.AdjectiveModule;
import com.elementa.language.morphology.adverb.AdverbModule;
import com.elementa.language.morphology.indeclinable.IndeclinableModule;
import com.elementa.language.morphology.noun.NounModule;
import com.elementa.language.morphology.verb.VerbModule;
import com.google.inject.AbstractModule;

public class MorphologyModule extends AbstractModule {

	@Override
	protected void configure() {
		this.install(new IndeclinableModule());
		this.install(new NounModule());
		this.install(new AdjectiveModule());
		this.install(new AdverbModule());
		this.install(new VerbModule());
	}

}
