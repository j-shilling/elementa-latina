package com.elementa.language.morphology.indeclinable;

import java.util.Collection;
import java.util.HashSet;

import com.elementa.language.form.Form;
import com.elementa.language.morphology.EndingGetter;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.phonology.HasPhonemes;
import com.google.inject.Singleton;

@Singleton
public class IndeclinableEndings implements EndingGetter {

	@Override
	public Collection<HasPhonemes> get(Form form, MorphologicalGroup group) {
		return new HashSet<HasPhonemes>();
	}

}
