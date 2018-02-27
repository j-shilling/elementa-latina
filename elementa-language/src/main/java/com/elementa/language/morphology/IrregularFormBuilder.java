package com.elementa.language.morphology;

import java.util.Collection;
import java.util.Optional;

import com.elementa.language.Word;
import com.elementa.language.form.Form;
import com.google.common.collect.Multimap;

public interface IrregularFormBuilder {
	Optional<Collection<Word>> build (Multimap<Form, Word> principleParts, Form form);
}
