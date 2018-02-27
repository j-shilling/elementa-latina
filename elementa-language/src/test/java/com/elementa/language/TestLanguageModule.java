package com.elementa.language;

import com.elementa.language.accidence.AccidentAbstractModule;
import com.elementa.language.accidence.TestAccidentModule;
import com.elementa.language.alphabet.AlphabetAbstractModule;
import com.elementa.language.alphabet.TestAlphabetModule;
import com.elementa.language.form.FormAbstractModule;
import com.elementa.language.form.TestFormModule;

public class TestLanguageModule extends LanguageModule {

	@Override
	protected AccidentAbstractModule accidentModule() {
		return new TestAccidentModule();
	}

	@Override
	protected FormAbstractModule formModule() {
		return new TestFormModule();
	}

	@Override
	protected AlphabetAbstractModule alphabetModule() {
		return new TestAlphabetModule();
	}

}
