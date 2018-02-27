package com.elementa.language.morphology.adverb;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.elementa.language.Word;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.StemGetter;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.PhonemeString;
import com.elementa.language.phonology.Phonemes;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class AdverbStems implements StemGetter {

	private final Values values;
	private final Phonemes phonemes;
	private final FormFactory forms;
	
	@Inject
	private AdverbStems (
			Values values,
			Phonemes phonemes,
			FormFactory forms) {
		this.values = values;
		this.phonemes = phonemes;
		this.forms = forms;
	}
	
	@Override
	public Collection<HasPhonemes> get(Multimap<Form, Word> principleParts, Form form) {
		Set<HasPhonemes> ret = new HashSet<>();
		
		if (form.equals(values.positive())) {
			
			for (Word word : principleParts.get(form)) {
				if (word.endsWith(phonemes.LONG_E())) {
					ret.add(word.toPhonemeString().substring(0, word.toPhonemeString().size() - 1));
				} else if (word.endsWith(phonemes.N(), phonemes.T(), phonemes.E(), phonemes.R())) {
					ret.add(word.toPhonemeString().substring(0, word.toPhonemeString().size() - 2));
				} else if (word.endsWith(phonemes.I(), phonemes.T(), phonemes.E(), phonemes.R())) {
					ret.add(word.toPhonemeString().substring(0, word.toPhonemeString().size() - 4));
				} 
			}
			
		} else if (form.equals(values.comparative())) {
			
			Collection<Word> result = principleParts.get(form);
			if (!result.isEmpty()) {
				for (Word word : result) {
					if (word.endsWith(phonemes.I(), phonemes.U(), phonemes.S())) {
						ret.add(word.toPhonemeString().substring(0, word.toPhonemeString().size() - 3));
					}
				}
			} else {
				return this.get(principleParts, forms.adverb(values.positive()));
			}
			
		} else if (form.equals(values.superlative())) {
			
			Collection<Word> result = principleParts.get(form);
			if (!result.isEmpty()) {
				for (Word word : result) {
					if (word.endsWith(phonemes.LONG_E())) {
						ret.add(word.toPhonemeString().substring(0, word.toPhonemeString().size() - 1));
					}
				}
			} else {
				Collection<HasPhonemes> pos = this.get(principleParts, forms.adverb(values.positive()));
				for (HasPhonemes x : pos) {
					if (x.endsWith(phonemes.E(), phonemes.R())) {
						ret.add(new PhonemeString (x, phonemes.R(), phonemes.I(), phonemes.M()));
					} else {
						ret.add(new PhonemeString (x, phonemes.I(), phonemes.S(), phonemes.S(),
								phonemes.I(), phonemes.M()));
					}
				}
			}
			
		}
		
		return ret;
	}

}
