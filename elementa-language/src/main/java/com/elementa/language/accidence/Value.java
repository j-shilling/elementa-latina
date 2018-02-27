package com.elementa.language.accidence;

import java.io.Serializable;

/**
 * A Value is used to represent a particular property that a 
 * word's form can have. All values are group by having a corresponding
 * {@link Type}. A {@link com.elementa.language.form.Form} can only hold
 * one value of a given {@link Type}.
 * 
 * @author Jake Shilling
 * @see Values
 */
public interface Value extends Serializable, Comparable<Value> {
	/** @return The {@link Type} associated with this value */
	public Type getType();
	
	/**
	 * @param type		
	 * @return			<tt>true</tt> if this value is of the given type
	 */
	public boolean equals (Type type);
}
