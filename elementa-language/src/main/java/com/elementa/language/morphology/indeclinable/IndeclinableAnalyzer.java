package com.elementa.language.morphology.indeclinable;

import com.elementa.language.Word;
import com.elementa.language.form.Form;
import com.elementa.language.morphology.LexemeAnalyzer;
import com.elementa.language.morphology.MorphologicalGroup;
import com.google.common.collect.Multimap;
import com.google.inject.Singleton;

@Singleton
public class IndeclinableAnalyzer implements LexemeAnalyzer {

	@Override
	public MorphologicalGroup analyze(Multimap<Form, Word> principleParts) {
		return MorphologicalGroup.INDECLINABLE;
	}

}
