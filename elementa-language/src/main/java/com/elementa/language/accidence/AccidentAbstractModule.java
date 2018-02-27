package com.elementa.language.accidence;

import com.google.inject.AbstractModule;

/**
 * A GUICE Module used to bind the implementations of 
 * {@link Types} and {@link Values}.
 * 
 * @author Jake Shilling
 * @see Type
 * @see Value
 */
public abstract class AccidentAbstractModule extends AbstractModule {
	
	/** @return the class implementing @{Values} */
	protected abstract Class<? extends Values> values();
	/** @return the class implementing @{Types} */
	protected abstract Class<? extends Types> types();

	/** {@inheritDoc} */
	@Override
	final protected void configure() {
		this.bind(Values.class).to(this.values());
		this.bind(Types.class).to(this.types());
	}

}
