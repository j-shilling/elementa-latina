package com.elementa.language.form;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import com.elementa.language.accidence.Types;
import com.elementa.language.accidence.Values;
import com.google.inject.Singleton;

@Singleton
public class FormModules {
	
	@Nonnull private final Types types;
	@Nonnull private final Values values;
	
	@Inject
	private FormModules (Types types, Values values) {
		this.types = types;
		this.values = values;
	}
	
	public FormModule noun() {
		return new FormModule() {

			@Override
			protected void configure() {
				this.requires(values.noun());
				this.requires(types.Number(), types.Gender(), types.Case());
			}
			
		};
	}
	
	public FormModule adjective() {
		return new FormModule() {

			@Override
			protected void configure() {
				this.requires(values.adjective());
				this.requires(types.Number(), types.Gender(), types.Case(), types.Degree());
			}
			
		};
	}
	
	public FormModule pronoun() {
		return new FormModule() {

			@Override
			protected void configure() {
				this.requires(values.pronoun());
				this.requires(types.Number(), types.Gender(), types.Case(), types.Person());
			}
			
		};
	}
	
	public FormModule adverb() {
		return new FormModule() {

			@Override
			protected void configure() {
				this.requires(values.adverb());
				this.requires(types.Degree());
			}
			
		};
	}
	
	public FormModule verb() {
		return new FormModule() {

			@Override
			protected void configure() {
				this.requires(values.verb());
				this.requires(types.Mood());
				
				this.value(values.indicative()).requires(types.Person(), types.Number(), types.Voice(), types.Tense());
				
				this.value(values.subjunctive()).requires(types.Person(), types.Number(), types.Voice(), types.Tense());
				this.value(values.subjunctive()).forbids(values.future(), values.futurePerfect());
				
				this.value(values.imperative()).requires(types.Person(), types.Number(), types.Voice(), types.Tense());
				this.value(values.imperative()).forbids(values.firstPerson(), values.imperfect(), values.perfect(),
						values.pluperfect(), values.futurePerfect());
				
				this.value(values.infinitive()).requires(types.Voice(), types.Tense());
				this.value(values.infinitive()).forbids(values.futurePerfect(), values.imperfect(), values.pluperfect());
				
				this.value(values.participle()).requires(types.Voice(), types.Tense(), types.Number(), types.Gender(), types.Case());
				this.value(values.participle()).forbids(values.futurePerfect(), values.imperfect(), values.pluperfect());
				
				this.value(values.gerund()).requires(types.Case());
				this.value(values.gerund()).requires(values.neuter(), values.singular());
				this.value(values.gerund()).forbids(values.nominative(), values.vocative(), values.locative());
				
				this.value(values.supine()).requires(types.Case());
				this.value(values.supine()).forbids(values.nominative(), values.genitive(), values.dative(), 
						values.locative(), values.vocative());
			}
			
		};
	}
	
	public FormModule conjunction() {
		return new FormModule() {

			@Override
			protected void configure() {
				this.requires(values.conjunction());
			}
			
		};
	}
	
	public FormModule preposition() {
		return new FormModule() {

			@Override
			protected void configure() {
				this.requires(values.preposition());
			}
			
		};
	}
		
	public FormModule interjection() {
		return new FormModule() {

			@Override
			protected void configure() {
				this.requires(values.interjection());
			}
			
		};
	}

}
