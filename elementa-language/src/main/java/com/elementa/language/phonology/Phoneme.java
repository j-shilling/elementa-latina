package com.elementa.language.phonology;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.Nonnull;

/**
 * Represents the sound signified by a given letter or
 * sequence of letters.
 * 
 * @author Jake Shilling
 *
 */
public class Phoneme implements HasPhonemes, Serializable {
	
	private static final long serialVersionUID = -8747503682519462216L;

	@Nonnull private final String id;
	
	private final boolean longVowel;
	private final boolean shortVowel;

	private final boolean dublex;
	private final boolean consonant;
	
	protected Phoneme (String id, boolean isVowel, boolean isLongOrDouble) {
		this.id = id;
		
		if (isVowel) {
			this.longVowel = isLongOrDouble;
			this.shortVowel = !isLongOrDouble;
			this.dublex = false;
			this.consonant = false;
		} else {
			this.longVowel = false;
			this.shortVowel = false;
			this.dublex = isLongOrDouble;
			this.consonant = true;
		}
	}
	
	protected Phoneme (String id, boolean isVowel, boolean isConsonant, boolean isLongOrDouble) {
		this.id = id;
		
		if (isVowel) {
			this.longVowel = isLongOrDouble;
			this.shortVowel = !isLongOrDouble;
			this.dublex = false;
			this.consonant = isConsonant;
		} else {
			this.longVowel = false;
			this.shortVowel = false;
			this.dublex = isLongOrDouble;
			this.consonant = isConsonant;
		}
	}
	
	public boolean isLongVowel() {
		return longVowel;
	}

	public boolean isShortVowel() {
		return shortVowel;
	}
	
	public boolean isVowel() {
		return this.isLongVowel() || this.isShortVowel();
	}
	
	public boolean isConsonant() {
		return this.consonant;
	}
	
	public boolean isDouble() {
		return dublex;
	}
	
	@Override
	public String toString() {
		return this.id;
	}
	
	@Override
	public boolean equals (Object o) {
		if (o instanceof Phoneme) {
			Phoneme that = (Phoneme) o;
			
			return this.id == that.id
					&& this.longVowel == that.longVowel
					&& this.shortVowel == that.shortVowel
					&& this.dublex == that.dublex;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.longVowel, this.shortVowel, this.dublex);
	}

	@Override
	public PhonemeString toPhonemeString() {
		return new PhonemeString (this);
	}

}
