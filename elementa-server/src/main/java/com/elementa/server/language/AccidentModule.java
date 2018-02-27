package com.elementa.server.language;

import com.elementa.language.accidence.AccidentAbstractModule;
import com.elementa.language.accidence.Types;
import com.elementa.language.accidence.Values;

/**
 * Used by the language module to bind implementations of
 * Values and Types.
 * 
 * @author Jake Shilling
 *
 */
public class AccidentModule extends AccidentAbstractModule {

	/** {@inheritDoc} */
	@Override
	protected Class<? extends Values> values() {
		return ValuesImpl.class;
	}

	/** {@inheritDoc} */
	@Override
	protected Class<? extends Types> types() {
		return TypesImpl.class;
	}

}
