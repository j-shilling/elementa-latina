package com.elementa.language.morphology.noun;

import java.util.Collection;

import javax.annotation.Nonnull;

import com.elementa.language.Word;
import com.elementa.language.accidence.Types;
import com.elementa.language.accidence.Value;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.LexemeAnalyzer;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.phonology.Phoneme;
import com.elementa.language.phonology.Phonemes;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class NounAnalyzer implements LexemeAnalyzer {
	
	@Nonnull private final FormFactory formFactory;
	@Nonnull private final Phonemes phonemes;
	
	@Nonnull private final Types types;
	@Nonnull private final Values values;
	
	@Inject
	private NounAnalyzer (FormFactory formFactory,
			Phonemes phonemes,
			Types types,
			Values values) {
		this.formFactory = formFactory;
		this.phonemes = phonemes;
		this.types = types;
		this.values = values;
	}

	@Override
	public MorphologicalGroup analyze(Multimap<Form, Word> principleParts) {
		
		Word[] allWords = principleParts.values().toArray(new Word[0]);
		if (allWords.length == 0)
			throw new IllegalArgumentException ("This noun has no principle parts.");
		
		if (!allWords[0].getForm().get(this.types.Gender()).isPresent())
			throw new IllegalArgumentException ("This noun has no Gender().");
		
		Value gender = allWords[0].getForm().get(this.types.Gender()).get();
		
		Collection<Word> result = principleParts.get(
				this.formFactory.noun(gender, this.values.genitive(), this.values.singular()));
		if (result.isEmpty())
			result = principleParts.get(
					this.formFactory.noun(gender, this.values.genitive(), this.values.plural()));
		
		if (result.isEmpty())
			throw new IllegalArgumentException ("This noun has no this.values.genitive() form.");
		
		Word gen = result.toArray(new Word[0])[0];
		if (gen.endsWith(this.phonemes.LONG_A(), this.phonemes.R(), this.phonemes.U(), this.phonemes.M()))
			return MorphologicalGroup.FIRST_DECLENSION;
		else if (gen.endsWith(this.phonemes.LONG_O(), this.phonemes.R(), this.phonemes.U(), this.phonemes.M()))
			return MorphologicalGroup.SECOND_DECLENSION;
		else if (gen.endsWith(this.phonemes.LONG_E(), this.phonemes.R(), this.phonemes.U(), this.phonemes.M()))
			return MorphologicalGroup.FIFTH_DECLENSION;
		else if (gen.endsWith(this.phonemes.U(), this.phonemes.U(), this.phonemes.M()))
			return MorphologicalGroup.FOURTH_DECLENSION;
		else if (gen.endsWith(this.phonemes.I(), this.phonemes.U(), this.phonemes.M()))
			return MorphologicalGroup.THIRD_DECLENSION_ISTEM;
		else if (gen.endsWith(this.phonemes.U(), this.phonemes.M()))
			return MorphologicalGroup.THIRD_DECLENSION_REGULAR;
		else if (gen.endsWith(this.phonemes.AE()))
			return MorphologicalGroup.FIRST_DECLENSION;
		else if (gen.endsWith(this.phonemes.LONG_U(), this.phonemes.S()))
			return MorphologicalGroup.FOURTH_DECLENSION;
		else if (gen.endsWith(this.phonemes.LONG_I())) {
		
			if (gen.endsWith(this.phonemes.LONG_E(), this.phonemes.LONG_I())
					|| gen.endsWith(this.phonemes.E(), this.phonemes.LONG_I())) {
				
				result = principleParts.get(
						this.formFactory.noun(gender, this.values.nominative(), this.values.singular()));
				if (result.isEmpty())
					throw new IllegalArgumentException ("This noun has no nominative singular form.");
				
				if (result.toArray(new Word[0])[0].endsWith(new Phoneme[] {
						this.phonemes.LONG_E(), this.phonemes.S()
				})) {
					return MorphologicalGroup.FIFTH_DECLENSION;
				} else
					return MorphologicalGroup.SECOND_DECLENSION;
				
			} else {
				return MorphologicalGroup.SECOND_DECLENSION;
			}
		}
		
		if (!gen.endsWith(this.phonemes.I(), this.phonemes.S()))
			throw new IllegalArgumentException ("Cannot parse this this.values.genitive() form: " + gen);
		
		/* We know its 3rd, but is it istem */
		if (gender.equals(this.values.neuter())) {
			
			result = principleParts.get(
					this.formFactory.noun(gender, this.values.nominative(), this.values.singular()));
			if (result.isEmpty())
				throw new IllegalArgumentException ("This noun has no nominative singular form.");
			
			Word nom = result.toArray(new Word[0])[0];
			
			/* Neuters ending in -e, -al, -ar */
			if (nom.endsWith(this.phonemes.E())
					|| nom.endsWith(new Phoneme[] { this.phonemes.A(), this.phonemes.L() })
					|| nom.endsWith(new Phoneme[] { this.phonemes.A(), this.phonemes.R() }))
				return MorphologicalGroup.THIRD_DECLENSION_ISTEM;
			else
				return MorphologicalGroup.THIRD_DECLENSION_REGULAR;
			
		} else {
			
			result = principleParts.get(
					this.formFactory.noun(gender, this.values.nominative(), this.values.singular()));
			if (result.isEmpty())
				throw new IllegalArgumentException ("This noun has no nominative singular form.");
			
			/* Masc. and Fem. perisyllabics */
			if (gen.asSyllables().length == result.toArray(new Word[0])[0].asSyllables().length)
				return MorphologicalGroup.THIRD_DECLENSION_ISTEM;
			
			/* Masc and Fem with a stem ending in two consonants */
			if (gen.asPhonemes().length >= 4) {
				Phoneme last = gen.asPhonemes()[gen.asPhonemes().length - 3];
				Phoneme secondToLast = gen.asPhonemes()[gen.asPhonemes().length - 4];
				
				if (last.isConsonant() && secondToLast.isConsonant())
					return MorphologicalGroup.THIRD_DECLENSION_ISTEM;
			}
			
			return MorphologicalGroup.THIRD_DECLENSION_REGULAR;
			
		}
		
	}

}
