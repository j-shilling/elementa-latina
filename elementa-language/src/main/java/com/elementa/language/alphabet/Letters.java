package com.elementa.language.alphabet;

import com.elementa.language.util.ImmutableCollection;

/**
 * Defines the behavior of an immutable collection of {@link Letter}s.
 * 
 * @author Jake Shilling
 *
 */
public interface Letters extends ImmutableCollection<Letter>, Comparable<Letters>, HasLetters{
	/** @return the {@link Letter} held at the given index */
	public Letter get (int index);
	
	/** @return a new instance of Letters composed of all 
	 * 			the {@link Letter}s help from index start to
	 * 			index end;
	 */
	public Letters substring (int start, int end);
}
