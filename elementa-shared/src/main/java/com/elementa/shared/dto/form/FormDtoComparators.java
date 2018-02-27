package com.elementa.shared.dto.form;

import static com.elementa.shared.dto.accidence.AccidentType.*;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import com.google.inject.Singleton;

@Singleton
public class FormDtoComparators {

	@Nonnull private final FormDtoComparator noun;
	@Nonnull private final FormDtoComparator adjective;
	@Nonnull private final FormDtoComparator pronoun;
	@Nonnull private final FormDtoComparator adverb;
	@Nonnull private final FormDtoComparator verb;
	@Nonnull private final FormDtoComparator conjunction;
	@Nonnull private final FormDtoComparator preposition;
	@Nonnull private final FormDtoComparator interjection;
	
	@Inject
	private FormDtoComparators () {
		
		this.noun = new FormDtoComparator (GENDER, CASE, NUMBER);
		this.adjective = new FormDtoComparator (DEGREE, GENDER, CASE, NUMBER);
		this.pronoun = new FormDtoComparator (PERSON, GENDER, CASE, NUMBER);
		this.adverb = new FormDtoComparator (DEGREE);
		this.verb = new FormDtoComparator (MOOD, VOICE, TENSE, PERSON, NUMBER,
				GENDER, CASE, NUMBER);
		
		FormDtoComparator indeclinable = new FormDtoComparator (PART_OF_SPEECH);
		
		this.conjunction = indeclinable;
		this.preposition = indeclinable;
		this.interjection = indeclinable;
	}
	
	public FormDtoComparator noun() {
		return this.noun;
	}
	
	public FormDtoComparator adjective() {
		return this.adjective;
	}
	
	public FormDtoComparator pronoun() {
		return this.pronoun;
	}
	
	public FormDtoComparator adverb() {
		return this.adverb;
	}
	
	public FormDtoComparator verb() {
		return this.verb;
	}
	
	public FormDtoComparator conjunction() {
		return this.conjunction;
	}
	
	public FormDtoComparator preposition() {
		return this.preposition;
	}
	
	public FormDtoComparator interjection() {
		return this.interjection;
	}
}
