package com.elementa.language.morphology;

import java.util.Collection;

import com.elementa.language.Word;
import com.elementa.language.form.Form;
import com.elementa.language.phonology.HasPhonemes;
import com.google.common.collect.Multimap;

public interface StemGetter {
	public Collection<HasPhonemes> get (Multimap<Form, Word> principleParts, Form form);
}
