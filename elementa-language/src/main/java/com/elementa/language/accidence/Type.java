package com.elementa.language.accidence;

import java.io.Serializable;

/**
 * A Type is used to group related {@link Value}s together. That is
 * to say that if we think of a word's form as a collection of values (e.g.
 * 1st person, present, active, singular) these different values should
 * each have a corresponding type (e.g. present is a tense, active is a voice, etc)
 * 
 * @author Jake Shilling
 * @see Types
 *
 */
public interface Type extends Serializable, Comparable<Type> {
	/** @return an array of all {@link Value}s with this type */
	public Value[] values();
	
	/**
	 * @param value		
	 * @return			<tt>true</tt> if value is of this type
	 */
	public boolean equals (Value value);
}
