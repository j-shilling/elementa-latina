package com.elementa.language.form;

import javax.inject.Inject;

import com.elementa.language.accidence.Value;
import com.google.inject.Singleton;

@Singleton
public class FormFactoryImpl implements FormFactory {
	
	private final FormModules modules;
	private final FormComparators comparators;
	
	@Inject
	private FormFactoryImpl (FormModules modules, FormComparators comparators) {
		this.modules = modules;
		this.comparators = comparators;
	}

	@Override
	public Form noun(Value... values) {
		FormModule module = this.modules.noun();
		
		if (module.validate(values))
			return new FormImpl (this.comparators.noun(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a noun: " + values);
					
	}

	@Override
	public Form adjective(Value... values) {
		FormModule module = this.modules.adjective();
		
		if (module.validate(values))
			return new FormImpl (this.comparators.adjective(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as an adjective: " + values);
	}

	@Override
	public Form pronoun(Value... values) {
		FormModule module = this.modules.pronoun();
		
		if (module.validate(values))
			return new FormImpl (this.comparators.pronoun(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a pronoun: " + values);
	}

	@Override
	public Form adverb(Value... values) {
		FormModule module = this.modules.adverb();
		
		if (module.validate(values))
			return new FormImpl (this.comparators.adverb(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as an adverb: " + values);
	}

	@Override
	public Form verb(Value... values) {
		FormModule module = this.modules.verb();
		
		if (module.validate(values))
			return new FormImpl (this.comparators.verb(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a verb: " + values);
	}

	@Override
	public Form conjunction() {
		FormModule module = this.modules.conjunction();
		
		if (module.validate())
			return new FormImpl (this.comparators.conjunction(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a conjunction");
	}

	@Override
	public Form preposition() {
		FormModule module = this.modules.preposition();
		
		if (module.validate())
			return new FormImpl (this.comparators.preposition(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a preposition");
	}

	@Override
	public Form interjection() {
		FormModule module = this.modules.interjection();
		
		if (module.validate())
			return new FormImpl (this.comparators.interjection(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as an interjection");
	}

	@Override
	public Form[] get(Value partOfSpeech) {
		// TODO Auto-generated method stub
		return null;
	}

}
