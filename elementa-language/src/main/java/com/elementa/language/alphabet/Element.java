package com.elementa.language.alphabet;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a basic element of the alphabet. All the different
 * representations of a letter are stored here. Elements are identified
 * by an integer representing their position in the alphabet.
 * 
 * @author Jake Shilling
 * @see ElementSet
 *
 */
public class Element implements Serializable, Comparable<Element> {
	
	private static final long serialVersionUID = 6559195374689543304L;
	
	/* Symbols used for all letters */
	@Nonnull private final Character LOWER_CASE;
	@Nonnull private final Character UPPER_CASE;
	
	/* Only used for vowels */
	@Nullable private final Character LOWER_CASE_WITH_MACRON;
	@Nullable private final Character UPPER_CASE_WITH_MACRON;
	@Nullable private final Character LOWER_CASE_WITH_DIAERESIS;
	@Nullable private final Character UPPER_CASE_WITH_DIAERESIS;
	
	private final int position;
	
	public Element (
			int position,
			char lowerCase,
			char upperCase,
			char lowerMacron,
			char upperMacron,
			char lowerDiaeresis,
			char upperDiaeresis) {
		
		this.position = position;
		
		this.LOWER_CASE = lowerCase;
		this.UPPER_CASE = upperCase;
		this.LOWER_CASE_WITH_MACRON = lowerMacron;
		this.UPPER_CASE_WITH_MACRON = upperMacron;
		this.LOWER_CASE_WITH_DIAERESIS = lowerDiaeresis;
		this.UPPER_CASE_WITH_DIAERESIS = upperDiaeresis;
	}
	
	public Element (
			int position,
			char lowerCase,
			char upperCase) {
		
		this.position = position;
		
		this.LOWER_CASE = lowerCase;
		this.UPPER_CASE = upperCase;
		this.LOWER_CASE_WITH_MACRON = null;
		this.UPPER_CASE_WITH_MACRON = null;
		this.LOWER_CASE_WITH_DIAERESIS = null;
		this.UPPER_CASE_WITH_DIAERESIS = null;
	}
	
	/** @return		this element's position in the alphabet */
	protected int getId() {
		return this.position;
	}
	
	/** @return		this element represented by a lower case character */
	protected char lowercase() {
		return this.LOWER_CASE;
	}
	
	/** @return		this element represented by an upper case character */
	protected char uppercase() {
		return this.UPPER_CASE;
	}
	
	/**
	 * @return		this element represented by a lower case character
	 * 				with a macron and wrapped in an {@link java.util.Optional} 
	 * 				or an empty {@link java.util.Optional}.
	 */
	protected Optional<Character> lowerCaseWithMacron() {
		return Optional.ofNullable(this.LOWER_CASE_WITH_MACRON);
	}
	
	/**
	 * @return		this element represented by an upper case character
	 * 				with a macron and wrapped in an {@link java.util.Optional} 
	 * 				or an empty {@link java.util.Optional}.
	 */
	protected Optional<Character> upperCaseWithMacron() {
		return Optional.ofNullable(this.UPPER_CASE_WITH_MACRON);
	}
	
	/**
	 * @return		this element represented by a lower case character
	 * 				with a diaeresis and wrapped in an {@link java.util.Optional} 
	 * 				or an empty {@link java.util.Optional}.
	 */
	protected Optional<Character> lowerCaseWithDiaeresis() {
		return Optional.ofNullable(this.LOWER_CASE_WITH_DIAERESIS);
	}
	
	/**
	 * @return		this element represented by an upper case character
	 * 				with a diaeresis and wrapped in an {@link java.util.Optional} 
	 * 				or an empty {@link java.util.Optional}.
	 */
	protected Optional<Character> upperCaseWithDiaeresis() {
		return Optional.ofNullable(this.UPPER_CASE_WITH_DIAERESIS);
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return new String (this.uppercase() + " " + this.lowercase());
	}
	
	/**
	 * Two elements are considered equal if they have the same
	 * position in the alphabet. That is, if x.getId() == y.getId().
	 * 
	 * @param obj		The {@link java.lang.Object} to compare.
	 * @return			<code>this.getId() == (Element) obj).getId()</code>
	 */
	@Override
	public boolean equals (Object obj) {
		if (obj instanceof Element) {
			return this.position == ((Element) obj).position;
		}
		
		return false;
	}
	
	/** {@inheritDoc} */
	@Override
	public int hashCode () {
		return Objects.hash(this.position);
	}

	/** {@inheritDoc} */
	@Override
	public int compareTo(Element that) {
		return Integer.compare(this.position, that.position);
	}
	
}
