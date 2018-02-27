package com.elementa.server.language;

import com.elementa.language.alphabet.AlphabetAbstractModule;
import com.elementa.language.alphabet.ElementSet;

public class AlphabetModule extends AlphabetAbstractModule {

	@Override
	protected Class<? extends ElementSet> elements() {
		return ServerAlphabet.class;
	}

}
