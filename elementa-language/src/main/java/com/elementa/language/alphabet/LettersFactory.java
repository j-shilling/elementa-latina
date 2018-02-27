package com.elementa.language.alphabet;

import java.util.Collection;

import com.elementa.language.phonology.HasPhonemes;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * A factory class used to get instances of {@link Letters}
 * 
 * @author Jake Shilling
 *
 */
@Singleton
public class LettersFactory {
	
	private final Provider<Letterifier> letterifier;
	
	@Inject
	private LettersFactory(
			Provider<Letterifier> letterifier) {
		this.letterifier = letterifier;
	}
	
	/** Create an empty {@link Letters} */
	public Letters create () {
		return new LettersImpl (this);
	}
	
	/** Create a {@link Letters} from every {@link Letter} in a collection */
	public Letters create (Collection<Letter> c) {
		return new LettersImpl (this, c);
	}
	
	/** Create a {@link Letters} from a single {@link Letter} */
	public Letters create (Letter letter) {
		return new LettersImpl (this, letter);
	}
	
	/** Create a {@link Letters} from many objects which can
	 *  be converted into {@link Letters}.
	 */
	public Letters create (HasLetters...hasLetters) {
		return new LettersImpl (this, hasLetters);
	}
	
	/** Create a {@link Letters} from many objects which can
	 *  be converted into {@link com.elementa.language.phonology.PhonemeString}.
	 */
	public Letters create (HasPhonemes...hasPhonemes) {
		return this.letterifier.get().letterify(hasPhonemes);
	}
	
	/** Create a {@link Letters} from a {@link java.lang.String} */
	public Letters create (String string) {
		return this.letterifier.get().letterify(string);
	}
}
