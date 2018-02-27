package com.elementa.server.language;

import static com.elementa.shared.dto.accidence.AccidentType.*;

import com.elementa.language.accidence.Type;
import com.elementa.language.accidence.Types;
import com.google.inject.Singleton;

/**
 * Server implementation of {@link com.elementa.language.accidence.Types}
 * 
 * @author Jake Shilling
 * @see TypeImpl
 */
@Singleton
public class TypesImpl implements Types {
	
	/** {@inheritDoc} */
	@Override
	public Type PartOfSpeech() {
		return new TypeImpl (PART_OF_SPEECH);
	}

	/** {@inheritDoc} */
	@Override
	public Type Person() {
		return new TypeImpl (PERSON);
	}

	/** {@inheritDoc} */
	@Override
	public Type Number() {
		return new TypeImpl (NUMBER);
	}

	/** {@inheritDoc} */
	@Override
	public Type Gender() {
		return new TypeImpl (GENDER);
	}

	/** {@inheritDoc} */
	@Override
	public Type Case() {
		return new TypeImpl (CASE);
	}

	/** {@inheritDoc} */
	@Override
	public Type Degree() {
		return new TypeImpl (DEGREE);
	}

	/** {@inheritDoc} */
	@Override
	public Type Voice() {
		return new TypeImpl (VOICE);
	}

	/** {@inheritDoc} */
	@Override
	public Type Tense() {
		return new TypeImpl (TENSE);
	}

	/** {@inheritDoc} */
	@Override
	public Type Mood() {
		return new TypeImpl (MOOD);
	}

}
