package com.elementa.language;

import com.elementa.language.accidence.Value;

/**
 * Defines the behavior of the factory class used
 * to create instances of a {@link Lexeme}.
 * 
 * @author Jake Shilling
 * 
 * @see com.elementa.language.Lexeme
 *
 */
public interface LexemeFactory {
	
	/** @return a noun lexeme from the given principle parts */
	public Lexeme noun (Word...words);
	/** @return an adjective lexeme from the given principle parts */
	public Lexeme adjective (Word...words);
	/** @return a pronoun lexeme from the given principle parts */
	public Lexeme pronoun (Word...words);
	/** @return an adverb lexeme from the given principle parts */
	public Lexeme adverb (Word...words);
	/** @return a verb lexeme from the given principle parts */
	public Lexeme verb (Word...words);
	/** @return a conjunction lexeme from the given principle parts */
	public Lexeme conjunction (Word...words);
	/** @return a preposition lexeme from the given principle parts */
	public Lexeme preposition (Word...words);
	/** @return an interjection lexeme from the given principle parts */
	public Lexeme interjection (Word...words);
	
	/**
	 * Create a new instance of {@link Lexeme} by parsing a string
	 * given by the user. Throws an IllegalArgumentException if the
	 * user input is not formatted correctly.
	 * 
	 * @param partOfSpeech		The part of speech to interpret this
	 * 							string as.
	 * @param input				The string to parse. This should be
	 * 							formatted in the standard way the
	 * 							word would be represented in the dictionary.
	 * @return					The created {@link Lexeme}
	 */
	public Lexeme create (Value partOfSpeech, String input)
		throws IllegalArgumentException;
}
