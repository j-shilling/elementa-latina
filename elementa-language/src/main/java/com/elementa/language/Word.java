package com.elementa.language;

import java.io.Serializable;

import com.elementa.language.form.Form;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.Phoneme;
import com.elementa.language.phonology.Syllable;

/**
 * Represents a specific word by associated a string of
 * {@link com.elementa.language.phonology.Phonemes} with
 * a specific {@link com.elementa.language.form.Form}.
 * 
 * @author Jake Shilling
 * @see com.elementa.language.WordFactory
 *
 */
public interface Word extends Serializable, HasPhonemes {
	/** @return An instance of {@link com.elementa.language.form.Form} representing
	 * 			the form of this word.
	 */
	public Form getForm();
	
	/** @return A representation of this word as an array of 
	 * 			{@link com.elementa.language.phonology.Syllable}s.
	 */
	public Syllable[] asSyllables();
	
	/** @return A representation of this word as an array of 
	 * 			{@link com.elementa.language.phonology.Phoneme}s.
	 */
	public Phoneme[] asPhonemes();
}
