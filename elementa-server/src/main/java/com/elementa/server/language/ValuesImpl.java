package com.elementa.server.language;

import static com.elementa.shared.dto.accidence.Accident.*;

import com.elementa.language.accidence.Value;
import com.elementa.language.accidence.Values;
import com.google.inject.Singleton;

/**
 * Server implementation of {@link com.elementa.language.accidence.Values}
 * 
 * @author Jake Shilling
 * @see ValueImpl
 */
@Singleton
public class ValuesImpl implements Values {

	/** {@inheritDoc} */
	@Override
	public Value noun() {
		return new ValueImpl (NOUN);
	}

	/** {@inheritDoc} */
	@Override
	public Value pronoun() {
		return new ValueImpl (PRONOUN);
	}

	/** {@inheritDoc} */
	@Override
	public Value adjective() {
		return new ValueImpl (ADJECTIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value verb() {
		return new ValueImpl (VERB);
	}

	/** {@inheritDoc} */
	@Override
	public Value adverb() {
		return new ValueImpl (ADVERB);
	}

	/** {@inheritDoc} */
	@Override
	public Value preposition() {
		return new ValueImpl (PREPOSITION);
	}

	/** {@inheritDoc} */
	@Override
	public Value conjunction() {
		return new ValueImpl (CONJUNCTION);
	}

	/** {@inheritDoc} */
	@Override
	public Value interjection() {
		return new ValueImpl (INTERJECTION);
	}

	/** {@inheritDoc} */
	@Override
	public Value singular() {
		return new ValueImpl (SINGULAR);
	}

	/** {@inheritDoc} */
	@Override
	public Value plural() {
		return new ValueImpl (PLURAL);
	}

	/** {@inheritDoc} */
	@Override
	public Value masculine() {
		return new ValueImpl (MASCULINE);
	}

	/** {@inheritDoc} */
	@Override
	public Value feminine() {
		return new ValueImpl (FEMININE);
	}

	/** {@inheritDoc} */
	@Override
	public Value neuter() {
		return new ValueImpl (NEUTER);
	}

	/** {@inheritDoc} */
	@Override
	public Value common() {
		return new ValueImpl (COMMON);
	}

	/** {@inheritDoc} */
	@Override
	public Value omnium() {
		return new ValueImpl (OMNIUM);
	}

	/** {@inheritDoc} */
	@Override
	public Value nominative() {
		return new ValueImpl (NOMINATIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value genitive() {
		return new ValueImpl (GENITIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value dative() {
		return new ValueImpl (DATIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value accusative() {
		return new ValueImpl (ACCUSATIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value ablative() {
		return new ValueImpl (ABLATIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value locative() {
		return new ValueImpl (LOCATIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value vocative() {
		return new ValueImpl (VOCATIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value firstPerson() {
		return new ValueImpl (FIRST_PERSON);
	}

	/** {@inheritDoc} */
	@Override
	public Value secondPerson() {
		return new ValueImpl (SECOND_PERSON);
	}

	/** {@inheritDoc} */
	@Override
	public Value thirdPerson() {
		return new ValueImpl (THIRD_PERSON);
	}

	/** {@inheritDoc} */
	@Override
	public Value positive() {
		return new ValueImpl (POSITIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value comparative() {
		return new ValueImpl (COMPARATIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value superlative() {
		return new ValueImpl (SUPERLATIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value active() {
		return new ValueImpl (ACTIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value passive() {
		return new ValueImpl (PASSIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value present() {
		return new ValueImpl (PRESENT);
	}

	/** {@inheritDoc} */
	@Override
	public Value imperfect() {
		return new ValueImpl (IMPERFECT);
	}

	/** {@inheritDoc} */
	@Override
	public Value future() {
		return new ValueImpl (FUTURE);
	}

	/** {@inheritDoc} */
	@Override
	public Value perfect() {
		return new ValueImpl (PERFECT);
	}

	/** {@inheritDoc} */
	@Override
	public Value pluperfect() {
		return new ValueImpl (PLUPERFECT);
	}

	/** {@inheritDoc} */
	@Override
	public Value futurePerfect() {
		return new ValueImpl (FUTURE_PERFECT);
	}

	/** {@inheritDoc} */
	@Override
	public Value indicative() {
		return new ValueImpl (INDICATIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value imperative() {
		return new ValueImpl (IMPERATIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value subjunctive() {
		return new ValueImpl (SUBJUNCTIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value participle() {
		return new ValueImpl (PARTICIPLE);
	}

	/** {@inheritDoc} */
	@Override
	public Value infinitive() {
		return new ValueImpl (INFINITIVE);
	}

	/** {@inheritDoc} */
	@Override
	public Value supine() {
		return new ValueImpl (SUPINE);
	}

	/** {@inheritDoc} */
	@Override
	public Value gerund() {
		return new ValueImpl (GERUND);
	}

}
