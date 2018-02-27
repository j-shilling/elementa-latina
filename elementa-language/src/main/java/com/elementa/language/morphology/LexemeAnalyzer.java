package com.elementa.language.morphology;

import com.elementa.language.Word;
import com.elementa.language.form.Form;
import com.google.common.collect.Multimap;

public interface LexemeAnalyzer {
	public MorphologicalGroup analyze (Multimap<Form, Word> principleParts);
}
