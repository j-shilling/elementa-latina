package com.elementa.language.morphology.adverb;

import java.util.Collection;

import javax.annotation.Nonnull;

import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.EndingGetter;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.PhonemeString;
import com.elementa.language.phonology.Phonemes;
import com.elementa.language.table.EndingsTable;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import static com.elementa.language.morphology.MorphologicalGroup.ADVERB_FROM_FIRST_SECOND_ADJECTIVE;
import static com.elementa.language.morphology.MorphologicalGroup.ADVERB_FROM_THIRD_ADJECTIVE;


@Singleton
public class AdverbEndings implements EndingGetter {
	
	@Nonnull private final EndingsTable table;
	
	@Inject
	private AdverbEndings (
			Values values, 
			Phonemes phonemes, 
			FormFactory forms) {
		
		this.table = new EndingsTable.Builder()
				
				.put(ADVERB_FROM_FIRST_SECOND_ADJECTIVE, forms.adverb(values.positive()), 
						phonemes.LONG_E())
				.put(ADVERB_FROM_FIRST_SECOND_ADJECTIVE, forms.adverb(values.comparative()), 
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.S()))
				.put(ADVERB_FROM_FIRST_SECOND_ADJECTIVE, forms.adverb(values.superlative()), 
						phonemes.LONG_E())
				
				.put(ADVERB_FROM_THIRD_ADJECTIVE, forms.adverb(values.positive()), 
						new PhonemeString (phonemes.T(), phonemes.E(), phonemes.R()))
				.put(ADVERB_FROM_THIRD_ADJECTIVE, forms.adverb(values.comparative()), 
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.S()))
				.put(ADVERB_FROM_THIRD_ADJECTIVE, forms.adverb(values.superlative()), 
						phonemes.LONG_E())
				
				.build();
	}

	@Override
	public Collection<HasPhonemes> get(Form form, MorphologicalGroup group) {
		return this.table.get(form, group);
	}

}
