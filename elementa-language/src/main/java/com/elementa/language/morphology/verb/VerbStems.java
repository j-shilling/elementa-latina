package com.elementa.language.morphology.verb;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nonnull;

import com.elementa.language.Word;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.morphology.StemGetter;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.Phonemes;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class VerbStems implements StemGetter {
	
	@Nonnull private final VerbAnalyzer analyzer;
	@Nonnull private final Phonemes phonemes;
	@Nonnull private final FormFactory forms;
	@Nonnull private final Values values;
	
	@Inject
	private VerbStems (
			VerbAnalyzer analyzer,
			Phonemes phonemes,
			FormFactory forms,
			Values values) {
		this.analyzer = analyzer;
		this.phonemes = phonemes;
		this.forms = forms;
		this.values = values;
	}
	
	private Collection<HasPhonemes> present (Multimap<Form, Word> principleParts) {
		MorphologicalGroup group = this.analyzer.analyze(principleParts);
		Collection<Word> infinitives = principleParts.get(
				forms.verb(values.present(), values.active(), values.infinitive()));
		Set<HasPhonemes> ret = new HashSet<>();
		
		if (group != MorphologicalGroup.THIRD_CONJUGATION_IO_DEPONENT
				&& group != MorphologicalGroup.THIRD_CONJUGATION_REGULAR_DEPONENT) {
			
			for (Word word : infinitives) {
				ret.add(word.toPhonemeString().substring(0, word.toPhonemeString().size() - 3));
			}
			
		} else {
			
			for (Word word : infinitives) {
				ret.add(word.toPhonemeString().substring(0, word.toPhonemeString().size() - 1));
			}
			
		}
		
		return ret;
	}
	
	private Collection<HasPhonemes> perfect (Multimap<Form, Word> principleParts) {
		Collection<Word> perfects = principleParts.get(forms.verb(
				values.firstPerson(), values.singular(), values.perfect(), values.active(), values.indicative()));
		Set<HasPhonemes> ret = new HashSet<>();
		
		for (Word word : perfects) {
			if (word.endsWith(phonemes.LONG_I()))
				ret.add(word.toPhonemeString().substring(0, word.toPhonemeString().size() - 1));
		}
		
		return ret;
	}
	
	private Collection<HasPhonemes> supine (Multimap<Form, Word> principleParts) {
		Collection<Word> supines = principleParts.get(forms.verb(
				values.accusative(), values.supine()));
		if (supines.isEmpty())
			supines = principleParts.get(forms.verb(
					values.perfect(), values.passive(), values.participle(), 
					values.masculine(), values.nominative(), values.singular()));
		if (supines.isEmpty())
			supines = principleParts.get(forms.verb(
					values.perfect(), values.active(), values.participle(), 
					values.masculine(), values.nominative(), values.singular()));
		Set<HasPhonemes> ret = new HashSet<>();
		
		for (Word word : supines) {
			if (word.endsWith(phonemes.U(), phonemes.S()) || word.endsWith(phonemes.U(), phonemes.M()))
				ret.add(word.toPhonemeString().substring(0, word.toPhonemeString().size() - 2));
		}
		
		return ret;
	}

	@Override
	public Collection<HasPhonemes> get(Multimap<Form, Word> principleParts, Form form) {
		
		if (form.equals(values.present())
				|| (form.equals(values.future()) 
						&& !form.equals(values.infinitive()) 
						&& !form.equals(values.active(), values.participle()))
				|| form.equals(values.imperfect())
				|| form.equals(values.gerund())) {
			
			return this.present(principleParts);
			
		}
		
		else if (form.equals(values.perfect(), values.participle())
				|| form.equals(values.supine())
				|| form.equals(values.future(), values.active(), values.participle())) {
			return this.supine(principleParts);
		}
		
		else if (form.equals(values.perfect())
				|| form.equals(values.pluperfect())
				|| form.equals(values.futurePerfect())) {
			
			return this.perfect(principleParts);
		}
		
		return new HashSet<>();
		
	}

}
