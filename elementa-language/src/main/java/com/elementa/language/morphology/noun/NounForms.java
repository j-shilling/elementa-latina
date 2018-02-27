package com.elementa.language.morphology.noun;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import javax.annotation.Nonnull;

import com.elementa.language.Word;
import com.elementa.language.WordFactory;
import com.elementa.language.accidence.Types;
import com.elementa.language.accidence.Value;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.IrregularFormBuilder;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.phonology.PhonemeString;
import com.elementa.language.phonology.Phonemes;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import static com.elementa.language.morphology.MorphologicalGroup.SECOND_DECLENSION;
import static com.elementa.language.morphology.MorphologicalGroup.THIRD_DECLENSION_ISTEM;
import static com.elementa.language.morphology.MorphologicalGroup.THIRD_DECLENSION_REGULAR;


@Singleton
public class NounForms implements IrregularFormBuilder {
	
	@Nonnull private final NounAnalyzer analyzer;
	@Nonnull private final FormFactory formFactory;
	@Nonnull private final WordFactory wordFactory;
	@Nonnull private final Phonemes phonemes;
	
	@Nonnull private final Types types;
	@Nonnull private final Values values;
	
	@Inject
	private NounForms (NounAnalyzer analyzer,
			FormFactory formFactory,
			WordFactory wordFactory,
			Phonemes phonemes,
			Types types,
			Values values) {
		this.analyzer = analyzer;
		this.formFactory = formFactory;
		this.wordFactory = wordFactory;
		this.phonemes = phonemes;
		this.types = types;
		this.values = values;
	}
	

	@Override
	public Optional<Collection<Word>> build(Multimap<Form, Word> principleParts, Form form) {
		
		MorphologicalGroup group = this.analyzer.analyze (principleParts);
		
		Collection<Word> allWords = principleParts.values();
		if (allWords.isEmpty())
			throw new IllegalArgumentException ("This noun has no principle parts");
		
		Optional<Value> gender = allWords.toArray(new Word[0])[0].getForm().get(this.types.Gender());
		if (!gender.isPresent())
			throw new IllegalArgumentException ("This noun has no gender");
		
		if (!form.equals(gender.get())) {
			if ( ! ((gender.get().equals(this.values.omnium()))
					|| (gender.get().equals(this.values.common())
							&& (form.equals(this.values.masculine()) || form.equals(this.values.feminine())))))
			return Optional.of(new HashSet<Word>());
		}
		
		if (form.equals(this.values.singular())) {
			if (principleParts.get(formFactory.noun(gender.get(), this.values.genitive(), this.values.singular())).isEmpty())
				return Optional.of(new HashSet<Word>());
		}
		
		if (group == SECOND_DECLENSION && form.equals(this.values.vocative(), this.values.singular())) {
			
			if (form.equals(this.values.masculine())) {
				Collection<Word> result = principleParts.get(
						this.formFactory.noun(this.values.masculine(), this.values.singular(), this.values.nominative()));
				
				if (result.isEmpty())
					return Optional.empty();
				
				HashSet<Word> ret = new HashSet<>();
				for (Word nom : result) {
					if (nom.endsWith(this.phonemes.I(), this.phonemes.U(), this.phonemes.S())) {
						
						PhonemeString str = nom.toPhonemeString();
						ret.add(this.wordFactory.create(form, 
								str.substring(0, str.size() - 3).concat(this.phonemes.LONG_I())));
						
					} else if (nom.endsWith(this.phonemes.U(), this.phonemes.S())) {
						
						PhonemeString str = nom.toPhonemeString();
						ret.add(this.wordFactory.create(form, 
							str.substring(0, str.size() - 2).concat(this.phonemes.E())));
						
					}
				}
				return Optional.of(ret);
			} else {
				
				Collection<Word> result = principleParts.get(
						this.formFactory.noun(gender.get(), this.values.singular(), this.values.nominative()));
				
				if (result.isEmpty())
					return Optional.empty();
				
				HashSet<Word> ret = new HashSet<>();
				for (Word nom : result) {
					ret.add(this.wordFactory.create(form, nom.asSyllables()));
				}
				return Optional.of(ret);
				
			}
			
		} else if (group == THIRD_DECLENSION_REGULAR || group == THIRD_DECLENSION_ISTEM) {
			
			if (form.equals(this.values.vocative(), this.values.singular()) 
					|| form.equals(this.values.neuter(), this.values.accusative(), this.values.singular())) {
				
				Collection<Word> result = principleParts.get(
						this.formFactory.noun(gender.get(), this.values.singular(), this.values.nominative()));
				
				if (result.isEmpty())
					return Optional.empty();
				
				HashSet<Word> ret = new HashSet<>();
				for (Word nom : result) {
					ret.add(this.wordFactory.create(form, nom.asSyllables()));
				}
				return Optional.of(ret);
				
			}
			
		}
		
		return Optional.empty();
		
	}

}
