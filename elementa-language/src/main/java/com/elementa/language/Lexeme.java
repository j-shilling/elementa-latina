package com.elementa.language;

import java.util.Collection;
import com.elementa.language.form.Form;

/**
 * Defines the behavior of a given lexeme. An implementation will be
 * used to generate all of the words from this lexeme which correspond
 * to a given form.
 * 
 * @author Jake Shilling
 * 
 * @see com.elementa.language.Word
 * @see com.elementa.language.form.Form
 *
 */
public interface Lexeme {
	
	/**
	 * Generate the specified form of this lexeme, assuming that
	 * it is conjugated / declined regularly.
	 * 
	 * @param form		An object representing the desired word form.
	 * @return			A collection of words representing this lexeme in
	 * 					the specified form. This method should never
	 * 					return <tt>null</tt>. If no corresponding forms
	 * 					exist, the collection will be empty.
	 */
	public Collection<Word> get (Form form);
}
