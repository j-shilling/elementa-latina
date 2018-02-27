package com.elementa.language.morphology.adjectives;

import java.util.Optional;

import javax.annotation.Nonnull;

import com.elementa.language.Word;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.LexemeAnalyzer;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.phonology.Phonemes;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class AdjectiveAnalyzer implements LexemeAnalyzer {
	
	@Nonnull private final FormFactory forms;
	@Nonnull private final Values values;
	@Nonnull private final Phonemes phonemes;
	
	@Inject
	private AdjectiveAnalyzer (
			FormFactory forms,
			Values values,
			Phonemes phonemes) {
		this.forms = forms;
		this.values = values;
		this.phonemes = phonemes;
	}

	@Override
	public MorphologicalGroup analyze(Multimap<Form, Word> principleParts) {
		
		Optional<Word> masculine = principleParts.get(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular())).isEmpty() ?
				Optional.empty() : Optional.of(principleParts.get(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular())).toArray(new Word[0])[0]);
		Optional<Word> feminine = principleParts.get(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular())).isEmpty() ?
				Optional.empty() : Optional.of(principleParts.get(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular())).toArray(new Word[0])[0]);
		Optional<Word> neuter = principleParts.get(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular())).isEmpty() ?
				Optional.empty() : Optional.of(principleParts.get(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular())).toArray(new Word[0])[0]);
		Optional<Word> common = principleParts.get(forms.adjective(values.positive(), values.common(), values.nominative(), values.singular())).isEmpty() ?
				Optional.empty() : Optional.of(principleParts.get(forms.adjective(values.positive(), values.common(), values.nominative(), values.singular())).toArray(new Word[0])[0]);
		Optional<Word> omnium = principleParts.get(forms.adjective(values.positive(), values.omnium(), values.nominative(), values.singular())).isEmpty() ?
				Optional.empty() : Optional.of(principleParts.get(forms.adjective(values.positive(), values.omnium(), values.nominative(), values.singular())).toArray(new Word[0])[0]);

		if (feminine.isPresent() && neuter.isPresent()) {
			if (feminine.get().endsWith(phonemes.A()) && neuter.get().endsWith(phonemes.U(), phonemes.M()))
				return MorphologicalGroup.FIRST_SECOND_DECLENSION;
		}
		
		if (feminine.isPresent() && masculine.isPresent()) {
			if (feminine.get().toPhonemeString().equals(masculine.get().toPhonemeString())) {
				if (neuter.isPresent()) {
					if (masculine.get().toPhonemeString().equals(neuter.get().toPhonemeString())) {
						return MorphologicalGroup.THIRD_DECLENSION_ONE_TERMINATION;
					} else
						return MorphologicalGroup.THIRD_DECLENSION_TWO_TERMINATION;
				}
			} else {
				return MorphologicalGroup.THIRD_DECLENSION_THREE_TERMINATION;
			}
		}
		
		if (common.isPresent())
			return MorphologicalGroup.THIRD_DECLENSION_TWO_TERMINATION;
		
		if (omnium.isPresent())
			return MorphologicalGroup.THIRD_DECLENSION_ONE_TERMINATION;
		
		throw new IllegalArgumentException (
				"Could not parse the given principle parts: " + principleParts);
	}

}
