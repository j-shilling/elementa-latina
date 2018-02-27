package com.elementa.shared.dto.form;

import java.util.EnumSet;
import java.util.Set;

import javax.inject.Inject;

import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.accidence.AccidentType;
import com.google.inject.Singleton;

@Singleton
public class FormDtoFactory {
	
	private final FormDtoModules modules;
	private final FormDtoComparators comparators;
	
	@Inject
	private FormDtoFactory (FormDtoModules modules, FormDtoComparators comparators) {
		this.modules = modules;
		this.comparators = comparators;
	}
	
	public FormDto create (Accident...values) {
		Set<Accident> vals = EnumSet.noneOf(Accident.class);
		Accident pos = null;
		
		for (Accident val : values) {
			if (val.getType() == AccidentType.PART_OF_SPEECH)
				pos = val;
			else
				vals.add(val);
		}
		
		if (pos != null) {
			
			switch (pos) {
			case NOUN:			return this.noun(vals.toArray(new Accident[0]));
			case ADJECTIVE:		return this.adjective(vals.toArray(new Accident[0]));
			case ADVERB:		return this.adverb(vals.toArray(new Accident[0]));
			case PRONOUN:		return this.pronoun(vals.toArray(new Accident[0]));
			case VERB:			return this.verb(vals.toArray(new Accident[0]));
			case INTERJECTION:	return this.interjection();
			case CONJUNCTION:	return this.conjunction();
			case PREPOSITION:	return this.preposition();
			default:
				break;
			}
			
		}
		
		throw new IllegalArgumentException ("Could not parse part of speech " + pos);
	}
	
	public FormDto noun(Accident... values) {
		FormDtoModule module = this.modules.noun();
		
		if (module.validate(values))
			return new FormDto (this.comparators.noun(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a noun: " + values);
					
	}

	public FormDto adjective(Accident... values) {
		FormDtoModule module = this.modules.adjective();
		
		if (module.validate(values))
			return new FormDto (this.comparators.adjective(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as an adjective: " + values);
	}

	public FormDto pronoun(Accident... values) {
		FormDtoModule module = this.modules.pronoun();
		
		if (module.validate(values))
			return new FormDto (this.comparators.pronoun(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a pronoun: " + values);
	}

	public FormDto adverb(Accident... values) {
		FormDtoModule module = this.modules.adverb();
		
		if (module.validate(values))
			return new FormDto (this.comparators.adverb(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as an adverb: " + values);
	}

	public FormDto verb(Accident... values) {
		FormDtoModule module = this.modules.verb();
		
		if (module.validate(values))
			return new FormDto (this.comparators.verb(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a verb: " + values);
	}

	public FormDto conjunction() {
		FormDtoModule module = this.modules.conjunction();
		
		if (module.validate())
			return new FormDto (this.comparators.conjunction(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a conjunction");
	}

	public FormDto preposition() {
		FormDtoModule module = this.modules.preposition();
		
		if (module.validate())
			return new FormDto (this.comparators.preposition(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a preposition");
	}

	public FormDto interjection() {
		FormDtoModule module = this.modules.interjection();
		
		if (module.validate())
			return new FormDto (this.comparators.interjection(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as an interjection");
	}
}
