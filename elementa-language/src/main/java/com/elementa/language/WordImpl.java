
package com.elementa.language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

import com.elementa.language.accidence.Value;
import com.elementa.language.alphabet.HasLetters;
import com.elementa.language.alphabet.Letterifier;
import com.elementa.language.form.Form;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.Phoneme;
import com.elementa.language.phonology.PhonemeString;
import com.elementa.language.phonology.Phonemifier;
import com.elementa.language.phonology.Syllabifier;
import com.elementa.language.phonology.Syllable;
import com.elementa.language.util.ImmutableArray;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

/**
 * A basic implementation of {@link Word}.
 * 
 * @author Jake Shilling
 * @see ParaphrasticWordImpl
 */
public class WordImpl extends ImmutableArray<Syllable> implements Word {
	
	private static final long serialVersionUID = -3930234380516761574L;
	
	@Nonnull private final Syllable[] syllables;
	@Nonnull private final Form form;
	
	@AssistedInject
	protected WordImpl (
			Syllabifier syllabifier,
			Phonemifier phonemifier,
			Letterifier letterifier,
			@Assisted Form form,
			@Assisted String string) {
		
		this (form, syllabifier.syllabify(phonemifier.phonemify(letterifier.letterify(string))));
	}
	
	@AssistedInject
	protected WordImpl (
			Syllabifier syllabifier,
			Phonemifier phonemifier,
			@Assisted Form form,
			@Assisted HasLetters...hasLetters) {
		
		this (form, syllabifier.syllabify(phonemifier.phonemify(hasLetters)));
	}
	
	@AssistedInject
	protected WordImpl (
			Syllabifier syllabifier, 
			@Assisted Form form, 
			@Assisted HasPhonemes...phonemes) {
		
		this (form, syllabifier.syllabify(phonemes));
	}
	
	@AssistedInject
	protected WordImpl (
			@Assisted Form form, 
			@Assisted Syllable...syllables) {
		
		this.syllables = syllables;
		this.form = form;
	}

	/** {@inheritDoc} */
	@Override
	public Syllable[] getArray() {
		return this.syllables;
	}

	/** {@inheritDoc} */
	@Override
	public Syllable[] asSyllables() {
		return this.getArray();
	}

	/** {@inheritDoc} */
	@Override
	public Phoneme[] asPhonemes() {
		List<Phoneme> phonemes = new ArrayList<>();
		
		for (Syllable x : this.asSyllables()) {
			phonemes.addAll(x);
		}
		
		return phonemes.toArray(new Phoneme[0]);
	}

	/** {@inheritDoc} */
	@Override
	public Form getForm() {
		return this.form;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Syllable x : this.syllables)
			sb.append(x.toString());
		
		return sb.toString();
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals (Object o) {
		
		if (o instanceof Word) {
			
			Word that = (Word) o;
			
			return this.toString().equals(that.toString())
					&& this.getForm().equals(that.getForm());
			
		} else if (o instanceof Form || o instanceof Value) {
			
			return this.getForm().equals(o);
			
		}
		
		return false;
	}
	
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		return Objects.hash(Arrays.hashCode(this.syllables), this.form);
	}

	/** {@inheritDoc} */
	@Override
	public PhonemeString toPhonemeString() {
		return new PhonemeString (this.syllables);
	}

}
