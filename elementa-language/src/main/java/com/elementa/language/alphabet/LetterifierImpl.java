package com.elementa.language.alphabet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.Phoneme;
import com.elementa.language.phonology.PhonemeString;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class LetterifierImpl implements Letterifier {
	
	@Nonnull private final Provider<CharSet> chars;
	@Nonnull private final Provider<PhonemeSet> phonemes;
	@Nonnull private final Provider<LettersFactory> factory;
	
	@Inject
	private LetterifierImpl (
			Provider<LettersFactory> factory, 
			Provider<CharSet> chars, 
			Provider<PhonemeSet> phonemes) {
		this.chars = chars;
		this.phonemes = phonemes;
		this.factory = factory;
	}

	/** {@inheritDoc} */
	@Override
	public Letters letterify(String string) {
		List<Letter> ret = new ArrayList<>();
		
		for (Character x : string.toCharArray()) {
			Optional<Letter> l = chars.get().get (x);
			
			if (l.isPresent())
				ret.add(l.get());
			else
				throw new IllegalArgumentException (
						"Unrecognized character: " + x);
		}
		
		return this.factory.get().create (ret);
	}

	/** {@inheritDoc} */
	@Override
	public Letters letterify(HasPhonemes... hasPhonemes) {
		PhonemeString str = new PhonemeString (hasPhonemes);
		Letters ret = this.factory.get().create();
		
		for (Phoneme x : str.getArray()) {
			Optional<Letters> result = this.phonemes.get().get(x);
			if (result.isPresent())
				ret = ret.concat(result.get());
		}
		
		return ret;
	}

}
