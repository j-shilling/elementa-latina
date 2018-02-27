package com.elementa.language.alphabet;

public class TestAlphabetModule extends AlphabetAbstractModule {
	
	private static class Elements implements ElementSet {
		
	}

	@Override
	protected Class<? extends ElementSet> elements() {
		return Elements.class;
	}

	@Override
	protected Class<? extends Letterifier> letterifier() {
		return LetterifierImpl.class;
	}

}
