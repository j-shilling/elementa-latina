package com.elementa.language.phonology;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Nonnull;

import com.elementa.language.util.ImmutableArray;

public class Syllable extends ImmutableArray<Phoneme> implements Serializable, HasPhonemes {

	private static final long serialVersionUID = 7497494834425846049L;
	
	@Nonnull private final Phoneme[] phonemes;
	@Nonnull private final Phoneme vowel;
	
	public Syllable (Phoneme...phonemes) {
		Phoneme vowel = null;
		
		for (Phoneme p : phonemes) {
			if (p.isVowel()) {
				if (vowel == null) {
					vowel = p;
				} else {
					throw new IllegalArgumentException ("Syllables can only have one vowel: " + phonemes);
				}
			}
		}
		
		if (vowel == null) {
			throw new IllegalArgumentException ("Syllables must have a vowel: " + phonemes);
		}
		
		this.vowel = vowel;
		this.phonemes = phonemes;
	}
	
	public Phoneme getVowel() {
		return this.vowel;
	}

	@Override
	public Phoneme[] getArray() {
		return this.phonemes;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Phoneme x : this.phonemes)
			sb.append(x.toString());
		
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Syllable) {
			Syllable that = (Syllable) o;
			
			if (this.phonemes.length != that.phonemes.length)
				return false;
			
			for (int i = 0; i < this.phonemes.length; i++) {
				if (!this.phonemes[i].equals(that.phonemes[i]))
					return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(this.phonemes);
	}

	@Override
	public PhonemeString toPhonemeString() {
		return new PhonemeString (this.phonemes);
	}

}
