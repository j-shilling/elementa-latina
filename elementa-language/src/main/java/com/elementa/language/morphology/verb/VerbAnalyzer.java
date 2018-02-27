package com.elementa.language.morphology.verb;

import java.util.Collection;

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
public class VerbAnalyzer implements LexemeAnalyzer {
	
	@Nonnull private final Phonemes phonemes;
	@Nonnull private final Values values;
	@Nonnull private final FormFactory forms;
	
	@Inject
	private VerbAnalyzer(
			Phonemes phonemes,
			Values values,
			FormFactory forms) {
		this.phonemes = phonemes;
		this.values = values;
		this.forms = forms;
	}
	
	public boolean isDeponenet (Multimap<Form, Word> principleParts) {
		MorphologicalGroup group =  this.analyze(principleParts);
		
		return group == MorphologicalGroup.FIRST_CONJUGATION_DEPONENT
				|| group == MorphologicalGroup.SECOND_CONJUGATION_DEPONENT
				|| group == MorphologicalGroup.THIRD_CONJUGATION_REGULAR_DEPONENT
				|| group == MorphologicalGroup.THIRD_CONJUGATION_IO_DEPONENT
				|| group == MorphologicalGroup.FOURTH_CONJUGATION_DEPONENT;
	}

	@Override
	public MorphologicalGroup analyze(Multimap<Form, Word> principleParts) {
		
		Collection<Word> infinitives = principleParts.get(forms.verb(
				values.present(), values.active(), values.infinitive()));
		if (infinitives.isEmpty())
			throw new IllegalArgumentException ("This verb has no infinitive");
		
		Word inf = infinitives.toArray(new Word[0])[0];
		
		if (inf.endsWith(phonemes.LONG_A(), phonemes.R(), phonemes.E()))
			return MorphologicalGroup.FIRST_CONJUGATION;
		else if (inf.endsWith(phonemes.LONG_A(), phonemes.R(), phonemes.LONG_I()))
			return MorphologicalGroup.FIRST_CONJUGATION_DEPONENT;
		else if (inf.endsWith(phonemes.LONG_E(), phonemes.R(), phonemes.E()))
			return MorphologicalGroup.SECOND_CONJUGATION;
		else if (inf.endsWith(phonemes.LONG_E(), phonemes.R(), phonemes.LONG_I()))
			return MorphologicalGroup.SECOND_CONJUGATION_DEPONENT;
		else if (inf.endsWith(phonemes.LONG_I(), phonemes.R(), phonemes.E()))
			return MorphologicalGroup.FOURTH_CONJUGATION;
		else if (inf.endsWith(phonemes.LONG_I(), phonemes.R(), phonemes.LONG_I()))
			return MorphologicalGroup.FOURTH_CONJUGATION_DEPONENT;
		
		else if (inf.endsWith(phonemes.E(), phonemes.R(), phonemes.E())) {
			
			Collection<Word> presents = principleParts.get(forms.verb(
					values.present(), values.active(), values.indicative(), values.firstPerson(), values.singular()));
			if (presents.isEmpty())
				throw new IllegalArgumentException ("This verb has no first principle part");
			
			Word pres = presents.toArray(new Word[0])[0];
			
			if (pres.endsWith(phonemes.I(), phonemes.LONG_O()))
				return MorphologicalGroup.THIRD_CONJUGATION_IO;
			else if (pres.endsWith(phonemes.LONG_O()))
				return MorphologicalGroup.THIRD_CONJUGATION_REGULAR;
			
		}
		
		else if (inf.endsWith(phonemes.LONG_I())) {
			
			Collection<Word> presents = principleParts.get(forms.verb(
					values.present(), values.active(), values.indicative(), values.firstPerson(), values.singular()));
			if (presents.isEmpty())
				throw new IllegalArgumentException ("This verb has no first principle part");
			
			Word pres = presents.toArray(new Word[0])[0];
			
			if (pres.endsWith(phonemes.I(), phonemes.O(), phonemes.R()))
				return MorphologicalGroup.THIRD_CONJUGATION_IO_DEPONENT;
			else if (pres.endsWith(phonemes.O(), phonemes.R()))
				return MorphologicalGroup.THIRD_CONJUGATION_REGULAR_DEPONENT;
			
		}
		
		throw new IllegalArgumentException 
			("Cannot parse a verb with these principle parts: " + principleParts.values());
	}

}
