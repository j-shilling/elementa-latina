package com.elementa.language.alphabet;

import com.elementa.language.phonology.HasPhonemes;

/**
 * Defines the behavior of an object which can take a string
 * or a set of {@link com.elementa.language.phonology.HasPhonemes}
 * and return an instance of {@link Letters}
 * 
 * @author Jake
 *
 */
public interface Letterifier {
	/**
	 * @param string		String to convert
	 * @return				resulting object
	 */
	public Letters letterify(String string);
	
	/**
	 * @param hasPhonemes	{@link com.elementa.language.phonology.HasPhonemes}
	 * 					 	to convert
	 * @return				resulting object
	 */
	public Letters letterify(HasPhonemes...hasPhonemes);
}
