package com.elementa.language.alphabet;

/**
 * This interface defines the behavior of any
 * object which can be turned into an instance of
 * {@link Letters}.
 * 
 * @author Jake Shilling
 *
 */
public interface HasLetters {
	
	/** @return this object represented by an instance of {@link Letters} */
	public Letters toLetters ();
	
	/** 
	 * Checks whether this object, as an instance of {@link Letters}, ends
	 * with the provided sequence of letters.
	 * 
	 * @param those		Objects to be converted to {@link Letters} and then
	 * 					check
	 */
	default public boolean endsWith (HasLetters...those) {
		return this.toLetters().endsWith(those);
	}
	
	/**
	 * Concatenates the given parameters to this object, an instance of {@link Letters}
	 * 
	 * @param those		Letters to be concatenated.
	 * @return			A new instance of {@link Letters}
	 */
	default public Letters concat (HasLetters...those) {
		return this.toLetters().concat(those);
	}
}
