package com.elementa.language.morphology.noun;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.Nonnull;

import com.elementa.language.Word;
import com.elementa.language.accidence.Types;
import com.elementa.language.accidence.Value;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.morphology.StemGetter;
import com.elementa.language.phonology.HasPhonemes;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import static com.elementa.language.morphology.MorphologicalGroup.SECOND_DECLENSION;
import static com.elementa.language.morphology.MorphologicalGroup.THIRD_DECLENSION_ISTEM;
import static com.elementa.language.morphology.MorphologicalGroup.THIRD_DECLENSION_REGULAR;

@Singleton
public class NounStem implements StemGetter {
	
	@Nonnull private final NounEndings endings;
	@Nonnull private final NounAnalyzer analyzer;
	@Nonnull private final FormFactory formFactory;
	
	@Nonnull private final Types types;
	@Nonnull private final Values values;
	
	@Inject
	private NounStem (NounEndings endings,
			NounAnalyzer analyzer,
			FormFactory formFactory,
			Types types,
			Values values) {
		this.endings = endings;
		this.analyzer = analyzer;
		this.formFactory = formFactory;
		this.values = values;
		this.types = types;
	}

	@Override
	public Collection<HasPhonemes> get(Multimap<Form, Word> principleParts, Form form) {
		
		Collection<HasPhonemes> ret = new HashSet<>();
		MorphologicalGroup group = this.analyzer.analyze(principleParts);
		
		if (group == SECOND_DECLENSION || group == THIRD_DECLENSION_REGULAR || group == THIRD_DECLENSION_ISTEM)
			if (form.equals(this.values.nominative(), this.values.singular()) || form.equals(this.values.vocative(), this.values.singular()))
				return ret;
		
		if (group == THIRD_DECLENSION_REGULAR || group == THIRD_DECLENSION_ISTEM)
			if (form.equals(this.values.neuter(), this.values.accusative(), this.values.singular()))
				return ret;
		
		Word[] allWords = principleParts.values().toArray(new Word[0]);
		if (allWords.length == 0)
			throw new IllegalArgumentException ("This noun has no principle parts.");
		
		if (!allWords[0].getForm().get(this.types.Gender()).isPresent())
			throw new IllegalArgumentException ("This noun has no gender.");
		
		Value gender = allWords[0].getForm().get(this.types.Gender()).get();
		Value number = this.values.singular();
				
		Collection<Word> genitives = principleParts.get(
				this.formFactory.noun(gender, this.values.genitive(), this.values.singular()));
		if (genitives.isEmpty()) {
			genitives = principleParts.get(
					this.formFactory.noun(gender, this.values.genitive(), this.values.plural()));
			number = this.values.plural();
		}
		
		if (genitives.isEmpty())
			throw new IllegalArgumentException ("This noun has no genitive form.");
		
		Collection<HasPhonemes> endings = this.endings.get(
				this.formFactory.noun(gender, number, this.values.genitive()),
				this.analyzer.analyze(principleParts));
		
		for (Word word : genitives) {
			for (HasPhonemes x : endings) {
				if (word.endsWith(x)) {
					ret.add(
							word.toPhonemeString().substring(0, word.toPhonemeString().size() - x.toPhonemeString().size()));
				}
			}
		}
		
		return ret;
	}

}
