package com.elementa.language.morphology.adverb;

import java.util.Collection;

import com.elementa.language.Word;
import com.elementa.language.form.Form;
import com.elementa.language.morphology.LexemeAnalyzer;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.phonology.Phonemes;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class AdverbAnalyzer implements LexemeAnalyzer {
	
	private final Phonemes phonemes;
	
	@Inject
	private AdverbAnalyzer (Phonemes phonemes) {
		this.phonemes = phonemes;
	}

	@Override
	public MorphologicalGroup analyze(Multimap<Form, Word> principleParts) {
		Collection<Word> result = principleParts.values();
		
		if (result.isEmpty()) {
			throw new IllegalArgumentException ("This adverb has no principle parts.");
		}
		
		Word pos = result.toArray(new Word[0])[0];
		
		if (pos.endsWith(phonemes.LONG_E()))
			return MorphologicalGroup.ADVERB_FROM_FIRST_SECOND_ADJECTIVE;
		if (pos.endsWith(phonemes.T(), phonemes.E(), phonemes.R()))
			return MorphologicalGroup.ADVERB_FROM_THIRD_ADJECTIVE;
		
		return MorphologicalGroup.ADVERB_NOT_FROM_ADJECTIVE;
	}

}
