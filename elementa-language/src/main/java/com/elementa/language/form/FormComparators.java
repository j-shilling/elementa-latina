package com.elementa.language.form;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import com.elementa.language.accidence.Types;
import com.google.inject.Singleton;

@Singleton
public class FormComparators {

	@Nonnull private final FormComparator noun;
	@Nonnull private final FormComparator adjective;
	@Nonnull private final FormComparator pronoun;
	@Nonnull private final FormComparator adverb;
	@Nonnull private final FormComparator verb;
	@Nonnull private final FormComparator conjunction;
	@Nonnull private final FormComparator preposition;
	@Nonnull private final FormComparator interjection;
	
	@Inject
	private FormComparators (Types types) {
		
		this.noun = new FormComparator (types.Gender(), types.Case(), types.Number());
		this.adjective = new FormComparator (types.Degree(), types.Gender(), types.Case(), types.Number());
		this.pronoun = new FormComparator (types.Person(), types.Gender(), types.Case(), types.Number());
		this.adverb = new FormComparator (types.Degree());
		this.verb = new FormComparator (types.Mood(), types.Voice(), types.Tense(), types.Person(), types.Number(),
				types.Gender(), types.Case(), types.Number());
		
		FormComparator indeclinable = new FormComparator (types.PartOfSpeech());
		
		this.conjunction = indeclinable;
		this.preposition = indeclinable;
		this.interjection = indeclinable;
	}
	
	public FormComparator noun() {
		return this.noun;
	}
	
	public FormComparator adjective() {
		return this.adjective;
	}
	
	public FormComparator pronoun() {
		return this.pronoun;
	}
	
	public FormComparator adverb() {
		return this.adverb;
	}
	
	public FormComparator verb() {
		return this.verb;
	}
	
	public FormComparator conjunction() {
		return this.conjunction;
	}
	
	public FormComparator preposition() {
		return this.preposition;
	}
	
	public FormComparator interjection() {
		return this.interjection;
	}
}
