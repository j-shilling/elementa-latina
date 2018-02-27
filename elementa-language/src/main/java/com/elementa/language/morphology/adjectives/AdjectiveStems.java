package com.elementa.language.morphology.adjectives;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.elementa.language.Word;
import com.elementa.language.accidence.Types;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.morphology.StemGetter;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.Phoneme;
import com.elementa.language.phonology.PhonemeString;
import com.elementa.language.phonology.Phonemes;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import static com.elementa.language.morphology.MorphologicalGroup.THIRD_DECLENSION_ONE_TERMINATION;

@Singleton
public class AdjectiveStems implements StemGetter {
	
	private final AdjectiveAnalyzer analyzer;
	
	private final Values values;
	private final Types types;
	private final Phonemes phonemes;
	private final FormFactory forms;
	
	@Inject
	private AdjectiveStems (
			AdjectiveAnalyzer analyzer,
			Values values,
			Phonemes phonemes,
			FormFactory forms,
			Types types) {
		this.analyzer = analyzer;
		this.values = values;
		this.phonemes = phonemes;
		this.forms = forms;
		this.types = types;
	}

	@Override
	public Collection<HasPhonemes> get(Multimap<Form, Word> principleParts, Form form) {
		
		MorphologicalGroup group = this.analyzer.analyze(principleParts);
		Set<HasPhonemes> ret = new HashSet<>();
		
		if (form.equals(values.positive())) {
			
			if (form.equals(values.masculine(), values.singular(), values.nominative())) {
				
				Collection<Word> result = principleParts.get(form);
				for (Word word : result) {
					if (word.endsWith(phonemes.U(), phonemes.S()))
						ret.add(word.toPhonemeString().substring(0, word.toPhonemeString().size() - 2));
				}
				
				return ret;
			}
			
			if (group == THIRD_DECLENSION_ONE_TERMINATION) {
				
				if (form.equals(values.nominative(), values.singular()))
					return ret;
				
				Collection<Word> result = principleParts.get(
						forms.adjective(values.positive(), values.genitive(), values.singular(), values.neuter()));
				
				if (result.isEmpty())
					result = principleParts.get(
							forms.adjective(values.positive(), values.genitive(), values.singular(), values.omnium()));
					
				if (result.isEmpty())
					result = principleParts.get(
							forms.adjective(values.positive(), values.nominative(), values.singular(), values.neuter()));
				if (result.isEmpty())
					result = principleParts.get(
							forms.adjective(values.positive(), values.nominative(), values.singular(), values.omnium()));
				if (result.isEmpty())
					throw new IllegalArgumentException ("This adjective has no principle part");
					
				for (Word word : result) {
					if (word.getForm().equals(values.genitive())) {
						ret.add(new PhonemeString (
								word.toPhonemeString().substring(0, word.toPhonemeString().size() - 2)));
					}
					
					else if (word.endsWith(phonemes.X())) {
						ret.add(new PhonemeString (
								word.toPhonemeString().substring(0, word.toPhonemeString().size() - 1),
								phonemes.C()));
					}
					
					else if (word.endsWith(phonemes.N(), phonemes.S())) {
						ret.add(new PhonemeString (
								word.toPhonemeString().substring(0, word.toPhonemeString().size() - 1),
								phonemes.T()));
					}
					
					else if (word.endsWith(phonemes.P(), phonemes.S())) {
						ret.add( new PhonemeString (
								word.toPhonemeString().substring(0, word.toPhonemeString().size() - 1),
								phonemes.I(), phonemes.T()));
					}
					
					else {
						ret.add(word.toPhonemeString());
					}
				}
				
				return ret;
			}
			
			Collection<Word> result = principleParts.get(
					forms.adjective(values.positive(), values.nominative(), values.singular(), values.neuter()));
		
			if (result.isEmpty())
				throw new IllegalArgumentException(
						"This adjective is not a one termination, but has no neuter form");
			
			Word neuter = result.toArray(new Word[0])[0];
			
			result = principleParts.get(
					forms.adjective(values.positive(), values.nominative(), values.singular(), values.feminine()));
		
			if (result.isEmpty())
				result = principleParts.get(
						forms.adjective(values.positive(), values.nominative(), values.singular(), values.common()));
			
			if (result.isEmpty())
				throw new IllegalArgumentException(
						"This adjective is not a one termination, but has no feminine or common form");
			
			Word feminine = result.toArray(new Word[0])[0];
			
			List<Phoneme> list = new ArrayList<>();
			int size = neuter.toPhonemeString().size() > feminine.toPhonemeString().size() ?
					neuter.toPhonemeString().size() : feminine.toPhonemeString().size();
			for (int i = 0; i < size; i ++) {
				if (neuter.asPhonemes()[i].equals(feminine.asPhonemes()[i])) {
					list.add(neuter.asPhonemes()[i]);
				} else {
					break;
				}
			}
			
			ret.add(new PhonemeString (list.toArray(new Phoneme[0])));
		
		} else if (form.equals(values.comparative())) {
			
			Form newForm = forms.adjective(values.positive(), values.singular(),
					form.get(types.Gender()).get(), values.genitive());
			Collection<HasPhonemes> result = this.get(principleParts, newForm);
			
			for (HasPhonemes x : result) {
				if (form.equals(values.neuter(), values.singular()) 
						&& (form.equals(values.nominative()) || form.equals(values.accusative())))
					ret.add(new PhonemeString (x, phonemes.I(), phonemes.U(), phonemes.S()));
				else if (form.equals(values.nominative(), values.singular()))
					ret.add(new PhonemeString (x, phonemes.I(), phonemes.O(), phonemes.R()));
				else
					ret.add(new PhonemeString (x, phonemes.I(), phonemes.LONG_O(), phonemes.R()));
			}
		
		} else if (form.equals(values.superlative())) {
			
			Collection<Word> result = principleParts.get(
					forms.adjective(values.positive(), values.nominative(), values.singular(), values.masculine()));
		
			if (result.isEmpty()) {
				result = principleParts.get(
						forms.adjective(values.positive(), values.nominative(), values.singular(), values.common()));
			}
			
			if (result.isEmpty()) {
				result = principleParts.get(
						forms.adjective(values.positive(), values.nominative(), values.singular(), values.omnium()));
			}
			
			if (result.isEmpty()) {
				throw new IllegalArgumentException ("This adjective as no masculine, common, or omnium form");
			}
			
			Collection<HasPhonemes> stem = this.get(principleParts, 
					forms.adjective(values.positive(), form.get(types.Gender()).get(),
							values.singular(), values.genitive()));
			for (Word word : result) {
				if (word.endsWith(phonemes.E(), phonemes.R()))
					ret.add(new PhonemeString(word, phonemes.R(), phonemes.I(), phonemes.M()));
				else {
					for (HasPhonemes x : stem) {
						ret.add(new PhonemeString (x, phonemes.I(), phonemes.S(), phonemes.S(), phonemes.I(), phonemes.M()));
					}
				}		
			}
		} else {
			throw new IllegalArgumentException ("This form doesn't make sense " + form);
		}
		
		return ret;
	}

}
