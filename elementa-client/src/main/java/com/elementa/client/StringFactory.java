package com.elementa.client;

import javax.inject.Inject;

import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.accidence.AccidentType;
import com.google.inject.Singleton;

/**
 * Used to add internationalization in situations where {@link StringConstants} will
 * not work. Primarily, this class can be used in place of Object.toString() to find
 * the correct way to convert an object to a String.
 * 
 * @author Jake Shilling
 * @since 0.1
 */
@Singleton
public class StringFactory {
	
	private final StringConstants constants;
	
	/**
	 * Injects dependencies.
	 * 
	 * @param constants		Provides access to pre-defined string constants
	 */
	@Inject
	public StringFactory(StringConstants constants) {
		this.constants = constants;
	}
	
	public String toString(Accident val) {
		
		switch (val) {
		case ABLATIVE: 		return this.constants.ablative();
		case ACCUSATIVE:	return this.constants.accusative();
		case ACTIVE:		return this.constants.active();
		case ADJECTIVE:		return this.constants.adjective();
		case ADVERB:		return this.constants.adverb();
		case COMMON:		return this.constants.masculineOrFeminine();
		case COMPARATIVE:	return this.constants.comparative();
		case CONJUNCTION:	return this.constants.conjunstion();
		case DATIVE:		return this.constants.dative();
		case FEMININE:		return this.constants.feminine();
		case FIRST_PERSON:	return this.constants.firstPerson();
		case FUTURE:		return this.constants.future();
		case FUTURE_PERFECT:return this.constants.futurePerfect();
		case GENITIVE:		return this.constants.genitive();
		case GERUND:		return this.constants.gerund();
		case IMPERATIVE:	return this.constants.imperative();
		case IMPERFECT:		return this.constants.imperfect();
		case INDICATIVE:	return this.constants.indicative();
		case INFINITIVE:	return this.constants.infinitive();
		case INTERJECTION:	return this.constants.interjection();
		case LOCATIVE:		return this.constants.locative();
		case MASCULINE:		return this.constants.masculine();
		case NEUTER:		return this.constants.neuter();
		case NOMINATIVE:	return this.constants.nominative();
		case NOUN:			return this.constants.noun();
		case OMNIUM:		return this.constants.masculineFeminineOrNeuter();
		case PARTICIPLE:	return this.constants.participle();
		case PASSIVE:		return this.constants.passive();
		case PERFECT:		return this.constants.perfect();
		case PLUPERFECT:	return this.constants.pluperfect();
		case PLURAL:		return this.constants.plural();
		case POSITIVE:		return this.constants.positive();
		case PREPOSITION:	return this.constants.preposition();
		case PRESENT:		return this.constants.present();
		case PRONOUN:		return this.constants.pronoun();
		case SECOND_PERSON:	return this.constants.secondPerson();
		case SINGULAR:		return this.constants.singular();
		case SUBJUNCTIVE:	return this.constants.subjunctive();
		case SUPERLATIVE:	return this.constants.superlative();
		case SUPINE:		return this.constants.supine();
		case THIRD_PERSON:	return this.constants.thirdPerson();
		case VERB:			return this.constants.verb();
		case VOCATIVE:		return this.constants.vocative();
		default:			return "";
		}
	}
	
	String toString(AccidentType val)
	{
		switch (val) {
		case CASE:				return this.constants.Case();
		case DEGREE:			return this.constants.degree();
		case GENDER:			return this.constants.gender();
		case MOOD:				return this.constants.mood();
		case NUMBER:			return this.constants.number();
		case PART_OF_SPEECH:	return this.constants.partOfSpeech();
		case PERSON:			return this.constants.person();
		case TENSE:				return this.constants.tense();
		case VOICE:				return this.constants.voice();
		default:				return "";
		}
	}
}
