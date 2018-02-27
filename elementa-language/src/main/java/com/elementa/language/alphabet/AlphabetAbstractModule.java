package com.elementa.language.alphabet;

import com.google.inject.AbstractModule;

/**
 * A GUICE Module used to bind the implementations of 
 * {@link ElementSet} and, optionally, {@link Letterifier}.
 * 
 * @author Jake Shilling
 * @see ElementSet
 * @see Letterifier
 */
public abstract class AlphabetAbstractModule extends AbstractModule {

	/** @return a class implementing {@link ElementSet} */
	protected abstract Class<? extends ElementSet> elements();
	
	/** @return a class implementing {@link ElementSet} */
	protected Class<? extends Letterifier> letterifier() {
		return LetterifierImpl.class;
	}
	
	/** {@inheritDoc} */
	@Override
	final protected void configure() {
		this.bind(Alphabet.class);
		this.bind(CharSet.class);
		this.bind(PhonemeSet.class);
		this.bind(LetterFactory.class);
		this.bind(LettersFactory.class);
	
		this.bind(ElementSet.class).to(this.elements());
		this.bind(Letterifier.class).to(this.letterifier());
	}

}
