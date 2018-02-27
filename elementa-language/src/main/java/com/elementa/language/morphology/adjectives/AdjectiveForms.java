package com.elementa.language.morphology.adjectives;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.elementa.language.Lexeme;
import com.elementa.language.LexemeFactory;
import com.elementa.language.Word;
import com.elementa.language.WordFactory;
import com.elementa.language.accidence.Types;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.IrregularFormBuilder;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.Phonemes;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class AdjectiveForms implements IrregularFormBuilder {
	
	private final Values values;
	private final Types types;
	private final AdjectiveStems stems;
	private final WordFactory words;
	private final AdjectiveAnalyzer analyzer;
	private final FormFactory forms;
	private final Phonemes phonemes;
	private final Provider<LexemeFactory> lexemes;
	
	@Inject
	private AdjectiveForms (
			Values values, 
			Types types,
			AdjectiveStems stems,
			WordFactory words,
			AdjectiveAnalyzer analyzer,
			FormFactory forms,
			Phonemes phonemes,
			Provider<LexemeFactory> lexemes) {
		this.values = values;
		this.stems = stems;
		this.words = words;
		this.analyzer = analyzer;
		this.forms = forms;
		this.types = types;
		this.phonemes = phonemes;
		this.lexemes = lexemes;
	}

	@Override
	public Optional<Collection<Word>> build(Multimap<Form, Word> principleParts, Form form) {
		
		if (form.equals(values.common())) {
			Set<Word> ret = new HashSet<>();
			Lexeme lexeme = lexemes.get().adjective(principleParts.values().toArray(new Word[0]));
			
			Collection<Word> masc = lexeme.get(forms.adjective(values.masculine(),
					form.get(types.Degree()).get(), form.get(types.Number()).get(), form.get(types.Case()).get()));
			Collection<Word> fem = lexeme.get(forms.adjective(values.feminine(),
					form.get(types.Degree()).get(), form.get(types.Number()).get(), form.get(types.Case()).get()));
		
			for (Word word : masc) {
				for (Word x : fem) {
					if (word.toPhonemeString().equals(x.toPhonemeString()))
						ret.add(words.create(form, word));
				}
			}
			
			return Optional.of(ret);
		}
		
		if (form.equals(values.omnium())) {
			Set<Word> ret = new HashSet<>();
			Lexeme lexeme = lexemes.get().adjective(principleParts.values().toArray(new Word[0]));
			
			Collection<Word> masc = lexeme.get(forms.adjective(values.masculine(),
					form.get(types.Degree()).get(), form.get(types.Number()).get(), form.get(types.Case()).get()));
			Collection<Word> fem = lexeme.get(forms.adjective(values.feminine(),
					form.get(types.Degree()).get(), form.get(types.Number()).get(), form.get(types.Case()).get()));
			Collection<Word> neut = lexeme.get(forms.adjective(values.neuter(),
					form.get(types.Degree()).get(), form.get(types.Number()).get(), form.get(types.Case()).get()));
		
			for (Word word : masc) {
				for (Word x : fem) {
					if (word.toPhonemeString().equals(x.toPhonemeString())) {
						for (Word y : neut) {
							if (x.toPhonemeString().equals(y.toPhonemeString()))
								ret.add(words.create(form, word));
						}
					}
				}
			}
			
			return Optional.of(ret);
		}
		
		if (form.equals(values.positive(), values.nominative(), values.singular())) {
			Set<Word> ret = new HashSet<>();
			
			if (form.equals(values.masculine()) || form.equals(values.feminine())) {
				Collection<Word> result = principleParts.get(forms.adjective(
						values.common(), values.nominative(), values.singular(), values.positive()));
				
				if (result.isEmpty()) {
					result = principleParts.get(forms.adjective(
							values.omnium(), values.nominative(), values.singular(), values.positive()));
				}
				
				for (Word word : result) {
					ret.add(words.create(form, word));
				}
			}
			
			if (form.equals(values.neuter())) {
				Collection<Word> result = principleParts.get(forms.adjective(
						values.omnium(), values.nominative(), values.singular(), values.positive()));
				
				for (Word word : result) {
					ret.add(words.create(form, word));
				}
			}
			
			return Optional.of(ret);
		}
		
		if (form.equals(values.neuter(), values.accusative())) {
			Set<Word> ret = new HashSet<>();
			Lexeme lexeme = lexemes.get().adjective(principleParts.values().toArray(new Word[0]));
			
			Collection<Word> nom = lexeme.get(forms.adjective(values.neuter(), values.nominative(),
					form.get(types.Degree()).get(), form.get(types.Number()).get()));
			
			for (Word word : nom) {
				ret.add(words.create(form, word));
			}
			
			return Optional.of(ret);
		}
		
		if (form.equals(values.comparative(), values.nominative(), values.singular())
				|| (form.equals(values.comparative(), values.neuter(), values.accusative(), values.singular()))) {
			
			Set<Word> ret = new HashSet<>();
			for (HasPhonemes x : this.stems.get(principleParts, form)) {
				ret.add(words.create(form, x));
			}
			
			return Optional.of(ret);
			
		}
		
		if (form.equals(values.vocative(), values.singular())) {
			
			Lexeme lexeme = lexemes.get().adjective(principleParts.values().toArray(new Word[0]));
			Collection<Word> noms = lexeme.get(forms.adjective(values.nominative(), values.singular(),
					form.get(types.Gender()).get(), form.get(types.Degree()).get()));
			MorphologicalGroup group = this.analyzer.analyze(principleParts);
			
			Set<Word> ret = new HashSet<>();
			if (form.equals(values.masculine())
					&& (form.equals(values.superlative())
							|| (form.equals(values.positive()) && group == MorphologicalGroup.FIRST_SECOND_DECLENSION))) {
				
				for (Word word : noms) {
					if (word.endsWith(phonemes.U(), phonemes.S()))
						ret.add(words.create(form,
								word.toPhonemeString().substring(0, word.toPhonemeString().size() - 2),
								phonemes.E()));
					else
						ret.add(words.create(form, word));
				}
				return Optional.of(ret);
			} else {
				for (Word word : noms) {
					ret.add(words.create(form, word));
				}
				return Optional.of(ret);
			}
		}
		
		if (form.equals(values.common(), values.comparative())) {
			
			Lexeme lexeme = lexemes.get().adjective(principleParts.values().toArray(new Word[0]));
			return Optional.of(lexeme.get(
					forms.adjective(values.masculine(), values.comparative(),
							form.get(types.Case()).get(), form.get(types.Number()).get())));
			
		}
		
		return Optional.empty();
		
	}
	

}
