package com.elementa.language;

import com.elementa.language.accidence.AccidentAbstractModule;
import com.elementa.language.alphabet.AlphabetAbstractModule;
import com.elementa.language.form.FormAbstractModule;
import com.elementa.language.morphology.MorphologyModule;
import com.elementa.language.phonology.PhonologyModule;
import com.google.inject.AbstractModule;

/**
 * An implementation of a GUICE module which binds most classes
 * for the library. The user must provide their own implementation
 * of the accident and alphabet classes.
 * 
 * @author Jake Shilling
 * 
 * @see com.elementa.language.accidence.Values
 * @see com.elementa.language.accidence.Types
 * @see com.elementa.language.alphabet.ElementSet
 *
 */
public abstract class LanguageModule extends AbstractModule {
	
	/**
	 * @return An {@link com.elementa.language.accidence.AccidentAbstractModule} 
	 * 		defining the implementationsof {@link com.elementa.language.accidence.Values}
	 * 		and {@link com.elementa.language.accidence.Types}.
	 */
	protected abstract AccidentAbstractModule accidentModule();
	
	/**
	 * @return An {@link com.elementa.language.form.FormAbstractModule} defining the
	 * 		implementations of {@link com.elementa.language.form.FormFactory}
	 */
	protected abstract FormAbstractModule formModule();
	
	/**
	 * @return An {@link com.elementa.language.alphabet.AlphabetAbstractModule} defining 
	 * 		the implementations of {@link com.elementa.language.alphabet.ElementSet} and 
	 * 		{@link com.elementa.language.alphabet.Letterifier}
	 */
	protected abstract AlphabetAbstractModule alphabetModule();

	/**
	 * {@inheritDoc}
	 */
	@Override
	final protected void configure() {
		this.install(new MorphologyModule());
		this.install(new PhonologyModule());
		
		this.install(this.accidentModule());
		this.install(this.formModule());
		this.install(this.alphabetModule());
		
		this.bind(WordFactory.class).to(WordFactoryImpl.class);
		this.bind(LexemeFactory.class).to(LexemeFactoryImpl.class);
	}

}
