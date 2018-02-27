package com.elementa.language;

import com.elementa.language.alphabet.HasLetters;
import com.elementa.language.form.Form;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.Syllable;

/**
 * Defines a Factory used to create instances of {@link Word}s.
 * 
 * @author Jake Shilling
 * @see WordImpl
 * @see ParaphrasticWordImpl
 *
 */
public interface WordFactory {
	/**
	 * Create an instance of {@link WordImpl} by converting 
	 * {@link com.elementa.language.phonology.Phoneme}s into 
	 * {@link com.elementa.language.phonology.Syllable}s
	 * 
	 * @param form			The {@link com.elementa.language.form.Form} to give to the new Word.
	 * @param phonemes		The array of {@link com.elementa.language.phonology.Phoneme}s to convert.
	 * @return				A fresh instance of {@link WordImpl}.
	 */
	Word create (Form form, HasPhonemes...phonemes);
	
	/**
	 * Create an instance of {@link WordImpl} from the given
	 * {@link com.elementa.language.phonology.Syllable}s
	 * 
	 * @param form			The {@link com.elementa.language.form.Form} to give to the new Word.
	 * @param syllables		The array of {@link com.elementa.language.phonology.Syllable}s to use.
	 * @return				A fresh instance of {@link WordImpl}.
	 */
	Word create (Form form, Syllable...syllables);
	
	/**
	 * Create an instance of {@link WordImpl} by converting 
	 * {@link com.elementa.language.alphabet.HasLetters} into
	 * {@link com.elementa.language.phonology.Phoneme}s and then
	 * into {@link com.elementa.language.phonology.Syllable}s
	 * 
	 * @param form			The {@link com.elementa.language.form.Form} to give to the new Word.
	 * @param hasLetters	The array of {@link com.elementa.language.alphabet.HasLetters} to convert.
	 * @return				A fresh instance of {@link WordImpl}.
	 */
	Word create (Form form, HasLetters...hasLetters);
	
	/**
	 * Create an instance of {@link WordImpl} by converting a String
	 * into {@link com.elementa.language.alphabet.HasLetters}, then into
	 * {@link com.elementa.language.phonology.Phoneme}s and then
	 * into {@link com.elementa.language.phonology.Syllable}s
	 * 
	 * @param form			The {@link com.elementa.language.form.Form} to give to the new Word.
	 * @param string		The String to convert.
	 * @return				A fresh instance of {@link WordImpl}.
	 */
	Word create (Form form, String string);
	
	/**
	 * Create an instance of {@link ParaphrasticWordImpl} from the given
	 * Words.
	 * 
	 * @param form			The {@link com.elementa.language.form.Form} to give to the new Word.
	 * @param words			The {@link Word}s to use for the paraphrastic form.
	 * @return				A fresh instance of {@link ParaphrasticWordImpl}
	 */
	Word createParaphrastic (Form form, Word...words);
}
