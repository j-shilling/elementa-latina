package com.elementa.language.morphology.indeclinable;

import java.util.Collection;
import java.util.HashSet;

import com.elementa.language.Word;
import com.elementa.language.form.Form;
import com.elementa.language.morphology.StemGetter;
import com.elementa.language.phonology.HasPhonemes;
import com.google.common.collect.Multimap;
import com.google.inject.Singleton;

@Singleton
public class IndeclinableStems implements StemGetter {

	@Override
	public Collection<HasPhonemes> get(Multimap<Form, Word> principleParts, Form form) {
		return new HashSet<HasPhonemes>();
	}

}
