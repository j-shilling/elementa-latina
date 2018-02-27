package com.elementa.language.morphology.verb;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.Nonnull;

import com.elementa.language.form.Form;
import com.elementa.language.morphology.EndingGetter;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.phonology.HasPhonemes;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import static com.elementa.language.morphology.MorphologicalGroup.*;

@Singleton
public class VerbEndings implements EndingGetter {
	
	@Nonnull private final VerbFirstConjugationEndings first;
	@Nonnull private final VerbSecondConjugationEndings second;
	@Nonnull private final VerbThirdConjugationEndings third;
	@Nonnull private final VerbIOConjugationEndings io;
	@Nonnull private final VerbFourthConjugationEndings fourth;
	
	@Inject
	private VerbEndings (
			VerbFirstConjugationEndings first,
			VerbSecondConjugationEndings second,
			VerbThirdConjugationEndings third,
			VerbIOConjugationEndings io,
			VerbFourthConjugationEndings fourth) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.io = io;
		this.fourth = fourth;
	}

	@Override
	public Collection<HasPhonemes> get(Form form, MorphologicalGroup group) {
		
		if (group == FIRST_CONJUGATION || group == FIRST_CONJUGATION_DEPONENT)
			return this.first.get(form, group);
		
		else if (group == SECOND_CONJUGATION || group == SECOND_CONJUGATION_DEPONENT)
			return this.second.get(form, group);
		
		else if (group == THIRD_CONJUGATION_REGULAR || group == THIRD_CONJUGATION_REGULAR_DEPONENT)
			return this.third.get(form, group);
		
		else if (group == THIRD_CONJUGATION_IO || group == THIRD_CONJUGATION_IO_DEPONENT)
			return this.io.get(form, group);
		
		else if (group == FOURTH_CONJUGATION || group == FOURTH_CONJUGATION_DEPONENT)
			return this.fourth.get(form, group);
			
		return new HashSet<>();
	}

}
