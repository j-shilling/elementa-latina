package com.elementa.server.language;

import com.elementa.language.accidence.AccidentAbstractModule;
import com.elementa.language.alphabet.AlphabetAbstractModule;
import com.elementa.language.form.FormAbstractModule;

public class LanguageModule extends com.elementa.language.LanguageModule {

	@Override
	protected AccidentAbstractModule accidentModule() {
		return new AccidentModule();
	}

	@Override
	protected FormAbstractModule formModule() {
		return new FormModule();
	}

	@Override
	protected AlphabetAbstractModule alphabetModule() {
		return new AlphabetModule();
	}

}
