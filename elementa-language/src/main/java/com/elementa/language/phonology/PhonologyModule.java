package com.elementa.language.phonology;

import com.google.inject.AbstractModule;

public class PhonologyModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(Phonemifier.class).to(PhonemifierImpl.class);
		this.bind(Syllabifier.class).to(SyllabifierImpl.class);
	}

}
