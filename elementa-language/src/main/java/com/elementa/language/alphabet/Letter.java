package com.elementa.language.alphabet;

import java.util.Objects;
import java.util.Optional;

import javax.annotation.Nonnull;

/**
 * Represents a specific incarnation of an {@link Element}. While
 * the Element class stores all possible symbols, Letter stores
 * a particular symbol used.
 * 
 * @author Jake Shilling
 *
 */
public class Letter implements Comparable<Letter>, HasLetters {
	
	@Nonnull private final CharSet chars;
	@Nonnull private final LetterFactory factory;
	@Nonnull private final LettersFactory letters;
	
	private final int id;
	
	private final boolean uppercase;
	private final boolean macron;
	private final boolean diaeresis;
	
	protected Letter (CharSet chars, 
			LetterFactory factory,
			LettersFactory letters,
			int id, 
			boolean uppercase,
			boolean macron,
			boolean diaeresis) {
		
		this.chars = chars;
		this.factory = factory;
		this.letters = letters;
		
		this.id = id;
		this.uppercase = uppercase;
		this.macron = macron;
		this.diaeresis = diaeresis;
	}
	
	/**
	 * @return 	An integer used to identify the {@link Element} represented
	 * 			by this Letters.
	 * @see		Element#getId()
	 */
	protected int getId() {
		return this.id;
	}
	
	/** @return whether this is a lower case letter */
	public boolean isLowercase() {
		return !this.uppercase;
	}
	
	/** @return whether this is an upper case letter */
	public boolean isUppercase() {
		return this.uppercase;
	}
	
	/** @return whether this has a macron */
	public boolean hasMacron() {
		return this.macron;
	}
	
	/** @return whether this has a diaeresis */
	public boolean hasDiaeresis() {
		return this.diaeresis;
	}
	
	/** 
	 * @return		an instance of {@link Letter} representing the same
	 * 				{@link Element}, but with in a lower case.
	 */
	public Letter toLowercase() {
		
		return this.factory.get(this.id, false, this.hasMacron(), this.hasDiaeresis());
		
	}
	
	/** 
	 * @return		an instance of {@link Letter} representing the same
	 * 				{@link Element}, but with in an upper case.
	 */
	public Letter toUppercase() {
		
		return this.factory.get(this.id, true, this.hasMacron(), this.hasDiaeresis());
		
	}
	
	/** 
	 * Get a version of this letter with a macron. Throws an UnsupportedOperationException
	 * if such a letter does not exist (i.e. if this is not a vowel).
	 * 
	 * @return		an instance of {@link Letter} representing the same
	 * 				{@link Element}, but with a macron.
	 */
	public Letter withMacron() {
		
		if (!this.chars.get(this.id, this.isUppercase(), true, false).isPresent())
			throw new UnsupportedOperationException 
				("This letter cannot have a macron: " + this.toString());
		
		return this.factory.get(this.id, this.isUppercase(), true, false);
		
	}
	/**
	 * @return		an instance of {@link Letter} representing the same
	 * 				{@link Element}, but without a macron.
	 *
	 */
	public Letter withoutMacron() {
		
		return this.factory.get(this.id, this.isUppercase(), false, this.hasDiaeresis());
		
	}
	
	/** 
	 * Get a version of this letter with a diaeresis. Throws an UnsupportedOperationException
	 * if such a letter does not exist (i.e. if this is not a vowel).
	 * 
	 * @return		an instance of {@link Letter} representing the same
	 * 				{@link Element}, but with a diaeresis.
	 */
	public Letter withDiaeresis() {
		if (!this.chars.get(this.id, this.isUppercase(), false, true).isPresent())
			throw new UnsupportedOperationException 
				("This letter cannot have a diaeresis: " + this.toString());
		
		return this.factory.get(this.id, this.isUppercase(), false, true);
	}
	
	/**
	 * @return		an instance of {@link Letter} representing the same
	 * 				{@link Element}, but without a diaeresis.
	 *
	 */
	public Letter withoutDiaeresis() {
		
		return this.factory.get(this.id, this.isUppercase(), this.hasMacron(), false);
		
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		
		Optional<Character> ret = this.chars.get(this);
		
		return ret.isPresent() ? ret.get().toString() : "";
		
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals (Object obj) {
		if (obj instanceof Letter) {
			Letter that = (Letter) obj;
			
			return this.id == that.id
					&& this.isUppercase() == that.isUppercase()
					&& this.hasMacron() == that.hasMacron()
					&& this.hasDiaeresis() == that.hasDiaeresis();
		}
		
		return false;
	}
	
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.macron, this.diaeresis);
	}

	/** {@inheritDoc} */
	@Override
	public int compareTo(Letter that) {
		return this.toString().compareTo(that.toString());
	}

	/** {@inheritDoc} */
	@Override
	public Letters toLetters() {
		return letters.create (this);
	}

}
