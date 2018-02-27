package com.elementa.language.morphology.indeclinable;

import java.util.Collection;
import java.util.Optional;

import com.elementa.language.Word;
import com.elementa.language.form.Form;
import com.elementa.language.morphology.IrregularFormBuilder;
import com.google.common.collect.Multimap;
import com.google.inject.Singleton;

@Singleton
public class IndeclinableForms implements IrregularFormBuilder {

	@Override
	public Optional<Collection<Word>> build(Multimap<Form, Word> principleParts, Form form) {
		return Optional.empty();
	}

}
