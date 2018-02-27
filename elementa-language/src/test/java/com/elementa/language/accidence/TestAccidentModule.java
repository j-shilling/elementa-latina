package com.elementa.language.accidence;

import com.elementa.language.accidence.AccidentAbstractModule;
import com.elementa.language.accidence.Types;
import com.elementa.language.accidence.Values;

public class TestAccidentModule extends AccidentAbstractModule {

	@Override
	protected Class<? extends Values> values() {
		return ValuesImpl.class;
	}

	@Override
	protected Class<? extends Types> types() {
		return TypesImpl.class;
	}

}
