package com.elementa.language.morphology;

import java.util.Collection;

import com.elementa.language.form.Form;
import com.elementa.language.phonology.HasPhonemes;

public interface EndingGetter {
	public Collection<HasPhonemes> get (Form form, MorphologicalGroup group);
}
