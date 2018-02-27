package com.elementa.language;

import javax.annotation.Nonnull;

import com.elementa.language.alphabet.HasLetters;
import com.elementa.language.alphabet.Letterifier;
import com.elementa.language.form.Form;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.Phoneme;
import com.elementa.language.phonology.Phonemes;
import com.elementa.language.phonology.Phonemifier;
import com.elementa.language.phonology.Syllabifier;
import com.elementa.language.phonology.Syllable;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * An implementation of {@link WordFactory}
 * 
 * @author Jake Shilling
 *
 */
@Singleton
public class WordFactoryImpl implements WordFactory {
	
	@Nonnull private final Syllabifier syllabifier;
	@Nonnull private final Phonemifier phonemifier;
	@Nonnull private final Letterifier letterifier;
	@Nonnull private final Phoneme separator;
	
	@Inject
	private WordFactoryImpl (
			Syllabifier syllabifier,
			Phonemifier phonemifier,
			Letterifier letterifier,
			Phonemes phonemes) {
		this.syllabifier = syllabifier;
		this.phonemifier = phonemifier;
		this.letterifier = letterifier;
		this.separator = phonemes.endOfWord();
	}

	/** {@inheritDoc} */
	@Override
	public Word create(Form form, HasPhonemes... phonemes) {
		return new WordImpl (syllabifier, form, phonemes);
	}

	/** {@inheritDoc} */
	@Override
	public Word create(Form form, Syllable... syllables) {
		return new WordImpl (form, syllables);
	}

	/** {@inheritDoc} */
	@Override
	public Word create(Form form, HasLetters... hasLetters) {
		return new WordImpl (syllabifier, phonemifier, form, hasLetters);
	}

	/** {@inheritDoc} */
	@Override
	public Word create(Form form, String string) {
		return new WordImpl (syllabifier, phonemifier, letterifier, form, string);
	}

	/** {@inheritDoc} */
	@Override
	public Word createParaphrastic(Form form, Word... words) {
		return new ParaphrasticWordImpl (form, separator, words);
	}

}
