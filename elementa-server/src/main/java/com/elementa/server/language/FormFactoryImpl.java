package com.elementa.server.language;

import java.util.Arrays;

import javax.inject.Inject;

import com.elementa.language.accidence.Value;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormComparators;
import com.elementa.language.form.FormFactory;
import com.elementa.language.form.FormModule;
import com.elementa.language.form.FormModules;
import com.google.inject.Singleton;

@Singleton
public class FormFactoryImpl implements FormFactory {
	
	private final FormModules modules;
	private final FormComparators comparators;
	private final Values values;
	
	@Inject
	private FormFactoryImpl (FormModules modules, FormComparators comparators, Values values) {
		this.modules = modules;
		this.comparators = comparators;
		this.values = values;
	}

	/** {@inheritDoc} */
	@Override
	public Form noun(Value... values) {
		FormModule module = this.modules.noun();
		
		if (module.validate(values))
			return new FormImpl (this.comparators.noun(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a noun: " + Arrays.toString(values));
					
	}

	/** {@inheritDoc} */
	@Override
	public Form adjective(Value... values) {
		FormModule module = this.modules.adjective();
		
		if (module.validate(values))
			return new FormImpl (this.comparators.adjective(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as an adjective: " + Arrays.toString(values));
	}

	/** {@inheritDoc} */
	@Override
	public Form pronoun(Value... values) {
		FormModule module = this.modules.pronoun();
		
		if (module.validate(values))
			return new FormImpl (this.comparators.pronoun(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a pronoun: " + Arrays.toString(values));
	}

	/** {@inheritDoc} */
	@Override
	public Form adverb(Value... values) {
		FormModule module = this.modules.adverb();
		
		if (module.validate(values))
			return new FormImpl (this.comparators.adverb(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as an adverb: " + Arrays.toString(values));
	}

	/** {@inheritDoc} */
	@Override
	public Form verb(Value... values) {
		FormModule module = this.modules.verb();
		
		if (module.validate(values))
			return new FormImpl (this.comparators.verb(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a verb: " + Arrays.toString(values));
	}

	/** {@inheritDoc} */
	@Override
	public Form conjunction() {
		FormModule module = this.modules.conjunction();
		
		if (module.validate())
			return new FormImpl (this.comparators.conjunction(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a conjunction");
	}

	/** {@inheritDoc} */
	@Override
	public Form preposition() {
		FormModule module = this.modules.preposition();
		
		if (module.validate())
			return new FormImpl (this.comparators.preposition(), module.getValues());
		else
			throw new IllegalArgumentException ("Could not validate these values as a preposition");
	}

	/** {@inheritDoc} */
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
		
		if (partOfSpeech.equals(values.noun())) {
			return new Form[] {
					this.noun(values.masculine(), values.nominative(), values.singular()),
					this.noun(values.masculine(), values.genitive(), values.singular()),
					this.noun(values.masculine(), values.dative(), values.singular()),
					this.noun(values.masculine(), values.accusative(), values.singular()),
					this.noun(values.masculine(), values.ablative(), values.singular()),
					this.noun(values.masculine(), values.vocative(), values.singular()),
					this.noun(values.masculine(), values.locative(), values.singular()),
					this.noun(values.masculine(), values.nominative(), values.plural()),
					this.noun(values.masculine(), values.genitive(), values.plural()),
					this.noun(values.masculine(), values.dative(), values.plural()),
					this.noun(values.masculine(), values.accusative(), values.plural()),
					this.noun(values.masculine(), values.ablative(), values.plural()),
					this.noun(values.masculine(), values.vocative(), values.plural()),
					this.noun(values.masculine(), values.locative(), values.plural()),
					
					this.noun(values.feminine(), values.nominative(), values.singular()),
					this.noun(values.feminine(), values.genitive(), values.singular()),
					this.noun(values.feminine(), values.dative(), values.singular()),
					this.noun(values.feminine(), values.accusative(), values.singular()),
					this.noun(values.feminine(), values.ablative(), values.singular()),
					this.noun(values.feminine(), values.vocative(), values.singular()),
					this.noun(values.feminine(), values.locative(), values.singular()),
					this.noun(values.feminine(), values.nominative(), values.plural()),
					this.noun(values.feminine(), values.genitive(), values.plural()),
					this.noun(values.feminine(), values.dative(), values.plural()),
					this.noun(values.feminine(), values.accusative(), values.plural()),
					this.noun(values.feminine(), values.ablative(), values.plural()),
					this.noun(values.feminine(), values.vocative(), values.plural()),
					this.noun(values.feminine(), values.locative(), values.plural()),
					
					this.noun(values.neuter(), values.nominative(), values.singular()),
					this.noun(values.neuter(), values.genitive(), values.singular()),
					this.noun(values.neuter(), values.dative(), values.singular()),
					this.noun(values.neuter(), values.accusative(), values.singular()),
					this.noun(values.neuter(), values.ablative(), values.singular()),
					this.noun(values.neuter(), values.vocative(), values.singular()),
					this.noun(values.neuter(), values.locative(), values.singular()),
					this.noun(values.neuter(), values.nominative(), values.plural()),
					this.noun(values.neuter(), values.genitive(), values.plural()),
					this.noun(values.neuter(), values.dative(), values.plural()),
					this.noun(values.neuter(), values.accusative(), values.plural()),
					this.noun(values.neuter(), values.ablative(), values.plural()),
					this.noun(values.neuter(), values.vocative(), values.plural()),
					this.noun(values.neuter(), values.locative(), values.plural())
			};
		
		}
		
		else if (partOfSpeech.equals(values.pronoun())) {
			return new Form[] {
					this.pronoun(values.firstPerson(), values.masculine(), values.nominative(), values.singular()),
					this.pronoun(values.firstPerson(), values.masculine(), values.genitive(), values.singular()),
					this.pronoun(values.firstPerson(), values.masculine(), values.dative(), values.singular()),
					this.pronoun(values.firstPerson(), values.masculine(), values.accusative(), values.singular()),
					this.pronoun(values.firstPerson(), values.masculine(), values.ablative(), values.singular()),
					this.pronoun(values.firstPerson(), values.masculine(), values.vocative(), values.singular()),
					this.pronoun(values.firstPerson(), values.masculine(), values.locative(), values.singular()),
					this.pronoun(values.firstPerson(), values.masculine(), values.nominative(), values.plural()),
					this.pronoun(values.firstPerson(), values.masculine(), values.genitive(), values.plural()),
					this.pronoun(values.firstPerson(), values.masculine(), values.dative(), values.plural()),
					this.pronoun(values.firstPerson(), values.masculine(), values.accusative(), values.plural()),
					this.pronoun(values.firstPerson(), values.masculine(), values.ablative(), values.plural()),
					this.pronoun(values.firstPerson(), values.masculine(), values.vocative(), values.plural()),
					this.pronoun(values.firstPerson(), values.masculine(), values.locative(), values.plural()),
					
					this.pronoun(values.firstPerson(), values.feminine(), values.nominative(), values.singular()),
					this.pronoun(values.firstPerson(), values.feminine(), values.genitive(), values.singular()),
					this.pronoun(values.firstPerson(), values.feminine(), values.dative(), values.singular()),
					this.pronoun(values.firstPerson(), values.feminine(), values.accusative(), values.singular()),
					this.pronoun(values.firstPerson(), values.feminine(), values.ablative(), values.singular()),
					this.pronoun(values.firstPerson(), values.feminine(), values.vocative(), values.singular()),
					this.pronoun(values.firstPerson(), values.feminine(), values.locative(), values.singular()),
					this.pronoun(values.firstPerson(), values.feminine(), values.nominative(), values.plural()),
					this.pronoun(values.firstPerson(), values.feminine(), values.genitive(), values.plural()),
					this.pronoun(values.firstPerson(), values.feminine(), values.dative(), values.plural()),
					this.pronoun(values.firstPerson(), values.feminine(), values.accusative(), values.plural()),
					this.pronoun(values.firstPerson(), values.feminine(), values.ablative(), values.plural()),
					this.pronoun(values.firstPerson(), values.feminine(), values.vocative(), values.plural()),
					this.pronoun(values.firstPerson(), values.feminine(), values.locative(), values.plural()),
					
					this.pronoun(values.firstPerson(), values.neuter(), values.nominative(), values.singular()),
					this.pronoun(values.firstPerson(), values.neuter(), values.genitive(), values.singular()),
					this.pronoun(values.firstPerson(), values.neuter(), values.dative(), values.singular()),
					this.pronoun(values.firstPerson(), values.neuter(), values.accusative(), values.singular()),
					this.pronoun(values.firstPerson(), values.neuter(), values.ablative(), values.singular()),
					this.pronoun(values.firstPerson(), values.neuter(), values.vocative(), values.singular()),
					this.pronoun(values.firstPerson(), values.neuter(), values.locative(), values.singular()),
					this.pronoun(values.firstPerson(), values.neuter(), values.nominative(), values.plural()),
					this.pronoun(values.firstPerson(), values.neuter(), values.genitive(), values.plural()),
					this.pronoun(values.firstPerson(), values.neuter(), values.dative(), values.plural()),
					this.pronoun(values.firstPerson(), values.neuter(), values.accusative(), values.plural()),
					this.pronoun(values.firstPerson(), values.neuter(), values.ablative(), values.plural()),
					this.pronoun(values.firstPerson(), values.neuter(), values.vocative(), values.plural()),
					this.pronoun(values.firstPerson(), values.neuter(), values.locative(), values.plural()),
					
					this.pronoun(values.secondPerson(), values.masculine(), values.nominative(), values.singular()),
					this.pronoun(values.secondPerson(), values.masculine(), values.genitive(), values.singular()),
					this.pronoun(values.secondPerson(), values.masculine(), values.dative(), values.singular()),
					this.pronoun(values.secondPerson(), values.masculine(), values.accusative(), values.singular()),
					this.pronoun(values.secondPerson(), values.masculine(), values.ablative(), values.singular()),
					this.pronoun(values.secondPerson(), values.masculine(), values.vocative(), values.singular()),
					this.pronoun(values.secondPerson(), values.masculine(), values.locative(), values.singular()),
					this.pronoun(values.secondPerson(), values.masculine(), values.nominative(), values.plural()),
					this.pronoun(values.secondPerson(), values.masculine(), values.genitive(), values.plural()),
					this.pronoun(values.secondPerson(), values.masculine(), values.dative(), values.plural()),
					this.pronoun(values.secondPerson(), values.masculine(), values.accusative(), values.plural()),
					this.pronoun(values.secondPerson(), values.masculine(), values.ablative(), values.plural()),
					this.pronoun(values.secondPerson(), values.masculine(), values.vocative(), values.plural()),
					this.pronoun(values.secondPerson(), values.masculine(), values.locative(), values.plural()),
					
					this.pronoun(values.secondPerson(), values.feminine(), values.nominative(), values.singular()),
					this.pronoun(values.secondPerson(), values.feminine(), values.genitive(), values.singular()),
					this.pronoun(values.secondPerson(), values.feminine(), values.dative(), values.singular()),
					this.pronoun(values.secondPerson(), values.feminine(), values.accusative(), values.singular()),
					this.pronoun(values.secondPerson(), values.feminine(), values.ablative(), values.singular()),
					this.pronoun(values.secondPerson(), values.feminine(), values.vocative(), values.singular()),
					this.pronoun(values.secondPerson(), values.feminine(), values.locative(), values.singular()),
					this.pronoun(values.secondPerson(), values.feminine(), values.nominative(), values.plural()),
					this.pronoun(values.secondPerson(), values.feminine(), values.genitive(), values.plural()),
					this.pronoun(values.secondPerson(), values.feminine(), values.dative(), values.plural()),
					this.pronoun(values.secondPerson(), values.feminine(), values.accusative(), values.plural()),
					this.pronoun(values.secondPerson(), values.feminine(), values.ablative(), values.plural()),
					this.pronoun(values.secondPerson(), values.feminine(), values.vocative(), values.plural()),
					this.pronoun(values.secondPerson(), values.feminine(), values.locative(), values.plural()),
					
					this.pronoun(values.secondPerson(), values.neuter(), values.nominative(), values.singular()),
					this.pronoun(values.secondPerson(), values.neuter(), values.genitive(), values.singular()),
					this.pronoun(values.secondPerson(), values.neuter(), values.dative(), values.singular()),
					this.pronoun(values.secondPerson(), values.neuter(), values.accusative(), values.singular()),
					this.pronoun(values.secondPerson(), values.neuter(), values.ablative(), values.singular()),
					this.pronoun(values.secondPerson(), values.neuter(), values.vocative(), values.singular()),
					this.pronoun(values.secondPerson(), values.neuter(), values.locative(), values.singular()),
					this.pronoun(values.secondPerson(), values.neuter(), values.nominative(), values.plural()),
					this.pronoun(values.secondPerson(), values.neuter(), values.genitive(), values.plural()),
					this.pronoun(values.secondPerson(), values.neuter(), values.dative(), values.plural()),
					this.pronoun(values.secondPerson(), values.neuter(), values.accusative(), values.plural()),
					this.pronoun(values.secondPerson(), values.neuter(), values.ablative(), values.plural()),
					this.pronoun(values.secondPerson(), values.neuter(), values.vocative(), values.plural()),
					this.pronoun(values.secondPerson(), values.neuter(), values.locative(), values.plural()),
			
					this.pronoun(values.thirdPerson(), values.masculine(), values.nominative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.masculine(), values.genitive(), values.singular()),
					this.pronoun(values.thirdPerson(), values.masculine(), values.dative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.masculine(), values.accusative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.masculine(), values.ablative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.masculine(), values.vocative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.masculine(), values.locative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.masculine(), values.nominative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.masculine(), values.genitive(), values.plural()),
					this.pronoun(values.thirdPerson(), values.masculine(), values.dative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.masculine(), values.accusative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.masculine(), values.ablative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.masculine(), values.vocative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.masculine(), values.locative(), values.plural()),
					
					this.pronoun(values.thirdPerson(), values.feminine(), values.nominative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.feminine(), values.genitive(), values.singular()),
					this.pronoun(values.thirdPerson(), values.feminine(), values.dative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.feminine(), values.accusative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.feminine(), values.ablative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.feminine(), values.vocative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.feminine(), values.locative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.feminine(), values.nominative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.feminine(), values.genitive(), values.plural()),
					this.pronoun(values.thirdPerson(), values.feminine(), values.dative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.feminine(), values.accusative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.feminine(), values.ablative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.feminine(), values.vocative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.feminine(), values.locative(), values.plural()),
					
					this.pronoun(values.thirdPerson(), values.neuter(), values.nominative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.neuter(), values.genitive(), values.singular()),
					this.pronoun(values.thirdPerson(), values.neuter(), values.dative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.neuter(), values.accusative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.neuter(), values.ablative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.neuter(), values.vocative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.neuter(), values.locative(), values.singular()),
					this.pronoun(values.thirdPerson(), values.neuter(), values.nominative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.neuter(), values.genitive(), values.plural()),
					this.pronoun(values.thirdPerson(), values.neuter(), values.dative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.neuter(), values.accusative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.neuter(), values.ablative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.neuter(), values.vocative(), values.plural()),
					this.pronoun(values.thirdPerson(), values.neuter(), values.locative(), values.plural())
			};
		}
		
		else if (partOfSpeech.equals(values.adjective())) {
			return new Form[] {
					this.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()),
					this.adjective(values.positive(), values.masculine(), values.genitive(), values.singular()),
					this.adjective(values.positive(), values.masculine(), values.dative(), values.singular()),
					this.adjective(values.positive(), values.masculine(), values.accusative(), values.singular()),
					this.adjective(values.positive(), values.masculine(), values.ablative(), values.singular()),
					this.adjective(values.positive(), values.masculine(), values.vocative(), values.singular()),
					this.adjective(values.positive(), values.masculine(), values.locative(), values.singular()),
					this.adjective(values.positive(), values.masculine(), values.nominative(), values.plural()),
					this.adjective(values.positive(), values.masculine(), values.genitive(), values.plural()),
					this.adjective(values.positive(), values.masculine(), values.dative(), values.plural()),
					this.adjective(values.positive(), values.masculine(), values.accusative(), values.plural()),
					this.adjective(values.positive(), values.masculine(), values.ablative(), values.plural()),
					this.adjective(values.positive(), values.masculine(), values.vocative(), values.plural()),
					this.adjective(values.positive(), values.masculine(), values.locative(), values.plural()),
					
					this.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()),
					this.adjective(values.positive(), values.feminine(), values.genitive(), values.singular()),
					this.adjective(values.positive(), values.feminine(), values.dative(), values.singular()),
					this.adjective(values.positive(), values.feminine(), values.accusative(), values.singular()),
					this.adjective(values.positive(), values.feminine(), values.ablative(), values.singular()),
					this.adjective(values.positive(), values.feminine(), values.vocative(), values.singular()),
					this.adjective(values.positive(), values.feminine(), values.locative(), values.singular()),
					this.adjective(values.positive(), values.feminine(), values.nominative(), values.plural()),
					this.adjective(values.positive(), values.feminine(), values.genitive(), values.plural()),
					this.adjective(values.positive(), values.feminine(), values.dative(), values.plural()),
					this.adjective(values.positive(), values.feminine(), values.accusative(), values.plural()),
					this.adjective(values.positive(), values.feminine(), values.ablative(), values.plural()),
					this.adjective(values.positive(), values.feminine(), values.vocative(), values.plural()),
					this.adjective(values.positive(), values.feminine(), values.locative(), values.plural()),
					
					this.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()),
					this.adjective(values.positive(), values.neuter(), values.genitive(), values.singular()),
					this.adjective(values.positive(), values.neuter(), values.dative(), values.singular()),
					this.adjective(values.positive(), values.neuter(), values.accusative(), values.singular()),
					this.adjective(values.positive(), values.neuter(), values.ablative(), values.singular()),
					this.adjective(values.positive(), values.neuter(), values.vocative(), values.singular()),
					this.adjective(values.positive(), values.neuter(), values.locative(), values.singular()),
					this.adjective(values.positive(), values.neuter(), values.nominative(), values.plural()),
					this.adjective(values.positive(), values.neuter(), values.genitive(), values.plural()),
					this.adjective(values.positive(), values.neuter(), values.dative(), values.plural()),
					this.adjective(values.positive(), values.neuter(), values.accusative(), values.plural()),
					this.adjective(values.positive(), values.neuter(), values.ablative(), values.plural()),
					this.adjective(values.positive(), values.neuter(), values.vocative(), values.plural()),
					this.adjective(values.positive(), values.neuter(), values.locative(), values.plural()),
					
					this.adjective(values.comparative(), values.masculine(), values.nominative(), values.singular()),
					this.adjective(values.comparative(), values.masculine(), values.genitive(), values.singular()),
					this.adjective(values.comparative(), values.masculine(), values.dative(), values.singular()),
					this.adjective(values.comparative(), values.masculine(), values.accusative(), values.singular()),
					this.adjective(values.comparative(), values.masculine(), values.ablative(), values.singular()),
					this.adjective(values.comparative(), values.masculine(), values.vocative(), values.singular()),
					this.adjective(values.comparative(), values.masculine(), values.locative(), values.singular()),
					this.adjective(values.comparative(), values.masculine(), values.nominative(), values.plural()),
					this.adjective(values.comparative(), values.masculine(), values.genitive(), values.plural()),
					this.adjective(values.comparative(), values.masculine(), values.dative(), values.plural()),
					this.adjective(values.comparative(), values.masculine(), values.accusative(), values.plural()),
					this.adjective(values.comparative(), values.masculine(), values.ablative(), values.plural()),
					this.adjective(values.comparative(), values.masculine(), values.vocative(), values.plural()),
					this.adjective(values.comparative(), values.masculine(), values.locative(), values.plural()),
					
					this.adjective(values.comparative(), values.feminine(), values.nominative(), values.singular()),
					this.adjective(values.comparative(), values.feminine(), values.genitive(), values.singular()),
					this.adjective(values.comparative(), values.feminine(), values.dative(), values.singular()),
					this.adjective(values.comparative(), values.feminine(), values.accusative(), values.singular()),
					this.adjective(values.comparative(), values.feminine(), values.ablative(), values.singular()),
					this.adjective(values.comparative(), values.feminine(), values.vocative(), values.singular()),
					this.adjective(values.comparative(), values.feminine(), values.locative(), values.singular()),
					this.adjective(values.comparative(), values.feminine(), values.nominative(), values.plural()),
					this.adjective(values.comparative(), values.feminine(), values.genitive(), values.plural()),
					this.adjective(values.comparative(), values.feminine(), values.dative(), values.plural()),
					this.adjective(values.comparative(), values.feminine(), values.accusative(), values.plural()),
					this.adjective(values.comparative(), values.feminine(), values.ablative(), values.plural()),
					this.adjective(values.comparative(), values.feminine(), values.vocative(), values.plural()),
					this.adjective(values.comparative(), values.feminine(), values.locative(), values.plural()),
					
					this.adjective(values.comparative(), values.neuter(), values.nominative(), values.singular()),
					this.adjective(values.comparative(), values.neuter(), values.genitive(), values.singular()),
					this.adjective(values.comparative(), values.neuter(), values.dative(), values.singular()),
					this.adjective(values.comparative(), values.neuter(), values.accusative(), values.singular()),
					this.adjective(values.comparative(), values.neuter(), values.ablative(), values.singular()),
					this.adjective(values.comparative(), values.neuter(), values.vocative(), values.singular()),
					this.adjective(values.comparative(), values.neuter(), values.locative(), values.singular()),
					this.adjective(values.comparative(), values.neuter(), values.nominative(), values.plural()),
					this.adjective(values.comparative(), values.neuter(), values.genitive(), values.plural()),
					this.adjective(values.comparative(), values.neuter(), values.dative(), values.plural()),
					this.adjective(values.comparative(), values.neuter(), values.accusative(), values.plural()),
					this.adjective(values.comparative(), values.neuter(), values.ablative(), values.plural()),
					this.adjective(values.comparative(), values.neuter(), values.vocative(), values.plural()),
					this.adjective(values.comparative(), values.neuter(), values.locative(), values.plural()),
			
					this.adjective(values.superlative(), values.masculine(), values.nominative(), values.singular()),
					this.adjective(values.superlative(), values.masculine(), values.genitive(), values.singular()),
					this.adjective(values.superlative(), values.masculine(), values.dative(), values.singular()),
					this.adjective(values.superlative(), values.masculine(), values.accusative(), values.singular()),
					this.adjective(values.superlative(), values.masculine(), values.ablative(), values.singular()),
					this.adjective(values.superlative(), values.masculine(), values.vocative(), values.singular()),
					this.adjective(values.superlative(), values.masculine(), values.locative(), values.singular()),
					this.adjective(values.superlative(), values.masculine(), values.nominative(), values.plural()),
					this.adjective(values.superlative(), values.masculine(), values.genitive(), values.plural()),
					this.adjective(values.superlative(), values.masculine(), values.dative(), values.plural()),
					this.adjective(values.superlative(), values.masculine(), values.accusative(), values.plural()),
					this.adjective(values.superlative(), values.masculine(), values.ablative(), values.plural()),
					this.adjective(values.superlative(), values.masculine(), values.vocative(), values.plural()),
					this.adjective(values.superlative(), values.masculine(), values.locative(), values.plural()),
					
					this.adjective(values.superlative(), values.feminine(), values.nominative(), values.singular()),
					this.adjective(values.superlative(), values.feminine(), values.genitive(), values.singular()),
					this.adjective(values.superlative(), values.feminine(), values.dative(), values.singular()),
					this.adjective(values.superlative(), values.feminine(), values.accusative(), values.singular()),
					this.adjective(values.superlative(), values.feminine(), values.ablative(), values.singular()),
					this.adjective(values.superlative(), values.feminine(), values.vocative(), values.singular()),
					this.adjective(values.superlative(), values.feminine(), values.locative(), values.singular()),
					this.adjective(values.superlative(), values.feminine(), values.nominative(), values.plural()),
					this.adjective(values.superlative(), values.feminine(), values.genitive(), values.plural()),
					this.adjective(values.superlative(), values.feminine(), values.dative(), values.plural()),
					this.adjective(values.superlative(), values.feminine(), values.accusative(), values.plural()),
					this.adjective(values.superlative(), values.feminine(), values.ablative(), values.plural()),
					this.adjective(values.superlative(), values.feminine(), values.vocative(), values.plural()),
					this.adjective(values.superlative(), values.feminine(), values.locative(), values.plural()),
					
					this.adjective(values.superlative(), values.neuter(), values.nominative(), values.singular()),
					this.adjective(values.superlative(), values.neuter(), values.genitive(), values.singular()),
					this.adjective(values.superlative(), values.neuter(), values.dative(), values.singular()),
					this.adjective(values.superlative(), values.neuter(), values.accusative(), values.singular()),
					this.adjective(values.superlative(), values.neuter(), values.ablative(), values.singular()),
					this.adjective(values.superlative(), values.neuter(), values.vocative(), values.singular()),
					this.adjective(values.superlative(), values.neuter(), values.locative(), values.singular()),
					this.adjective(values.superlative(), values.neuter(), values.nominative(), values.plural()),
					this.adjective(values.superlative(), values.neuter(), values.genitive(), values.plural()),
					this.adjective(values.superlative(), values.neuter(), values.dative(), values.plural()),
					this.adjective(values.superlative(), values.neuter(), values.accusative(), values.plural()),
					this.adjective(values.superlative(), values.neuter(), values.ablative(), values.plural()),
					this.adjective(values.superlative(), values.neuter(), values.vocative(), values.plural()),
					this.adjective(values.superlative(), values.neuter(), values.locative(), values.plural())
			};
		}
		
		else if (partOfSpeech.equals(values.adverb())) {
			return new Form[] {
					this.adverb(values.positive()),
					this.adverb(values.comparative()),
					this.adverb(values.superlative())
			};
		}
		
		else if (partOfSpeech.equals(values.verb())) {
			return new Form[] {
					this.verb(values.firstPerson(), values.singular(), values.present(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.present(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.present(), values.active(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.present(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.present(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.present(), values.active(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.imperfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.imperfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.imperfect(), values.active(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.imperfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.imperfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.imperfect(), values.active(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.future(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.future(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.future(), values.active(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.future(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.future(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.future(), values.active(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.perfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.perfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.perfect(), values.active(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.perfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.perfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.perfect(), values.active(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.pluperfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.pluperfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.pluperfect(), values.active(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.pluperfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.pluperfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.pluperfect(), values.active(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.futurePerfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.futurePerfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.futurePerfect(), values.active(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.futurePerfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.futurePerfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.futurePerfect(), values.active(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.present(), values.passive(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.present(), values.passive(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.present(), values.passive(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.present(), values.passive(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.present(), values.passive(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.present(), values.passive(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.imperfect(), values.passive(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.imperfect(), values.passive(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.imperfect(), values.passive(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.imperfect(), values.passive(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.imperfect(), values.passive(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.imperfect(), values.passive(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.future(), values.passive(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.future(), values.passive(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.future(), values.passive(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.future(), values.passive(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.future(), values.passive(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.future(), values.passive(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.perfect(), values.passive(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.perfect(), values.passive(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.perfect(), values.passive(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.perfect(), values.passive(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.perfect(), values.passive(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.perfect(), values.passive(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.pluperfect(), values.passive(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.pluperfect(), values.passive(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.pluperfect(), values.passive(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.pluperfect(), values.passive(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.pluperfect(), values.passive(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.pluperfect(), values.passive(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.futurePerfect(), values.passive(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.futurePerfect(), values.passive(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.futurePerfect(), values.passive(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.futurePerfect(), values.passive(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.futurePerfect(), values.passive(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.futurePerfect(), values.passive(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.present(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.present(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.present(), values.active(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.present(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.present(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.present(), values.active(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.imperfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.imperfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.imperfect(), values.active(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.imperfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.imperfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.imperfect(), values.active(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.future(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.future(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.future(), values.active(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.future(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.future(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.future(), values.active(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.perfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.perfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.perfect(), values.active(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.perfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.perfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.perfect(), values.active(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.pluperfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.pluperfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.pluperfect(), values.active(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.pluperfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.pluperfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.pluperfect(), values.active(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.futurePerfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.singular(), values.futurePerfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.singular(), values.futurePerfect(), values.active(), values.indicative()),
					this.verb(values.firstPerson(), values.plural(), values.futurePerfect(), values.active(), values.indicative()),
					this.verb(values.secondPerson(), values.plural(), values.futurePerfect(), values.active(), values.indicative()),
					this.verb(values.thirdPerson(), values.plural(), values.futurePerfect(), values.active(), values.indicative()),
					
					this.verb(values.firstPerson(), values.singular(), values.present(), values.passive(), values.subjunctive()),
					this.verb(values.secondPerson(), values.singular(), values.present(), values.passive(), values.subjunctive()),
					this.verb(values.thirdPerson(), values.singular(), values.present(), values.passive(), values.subjunctive()),
					this.verb(values.firstPerson(), values.plural(), values.present(), values.passive(), values.subjunctive()),
					this.verb(values.secondPerson(), values.plural(), values.present(), values.passive(), values.subjunctive()),
					this.verb(values.thirdPerson(), values.plural(), values.present(), values.passive(), values.subjunctive()),
					
					this.verb(values.firstPerson(), values.singular(), values.imperfect(), values.passive(), values.subjunctive()),
					this.verb(values.secondPerson(), values.singular(), values.imperfect(), values.passive(), values.subjunctive()),
					this.verb(values.thirdPerson(), values.singular(), values.imperfect(), values.passive(), values.subjunctive()),
					this.verb(values.firstPerson(), values.plural(), values.imperfect(), values.passive(), values.subjunctive()),
					this.verb(values.secondPerson(), values.plural(), values.imperfect(), values.passive(), values.subjunctive()),
					this.verb(values.thirdPerson(), values.plural(), values.imperfect(), values.passive(), values.subjunctive()),
					
					this.verb(values.firstPerson(), values.singular(), values.perfect(), values.passive(), values.subjunctive()),
					this.verb(values.secondPerson(), values.singular(), values.perfect(), values.passive(), values.subjunctive()),
					this.verb(values.thirdPerson(), values.singular(), values.perfect(), values.passive(), values.subjunctive()),
					this.verb(values.firstPerson(), values.plural(), values.perfect(), values.passive(), values.subjunctive()),
					this.verb(values.secondPerson(), values.plural(), values.perfect(), values.passive(), values.subjunctive()),
					this.verb(values.thirdPerson(), values.plural(), values.perfect(), values.passive(), values.subjunctive()),
					
					this.verb(values.firstPerson(), values.singular(), values.pluperfect(), values.passive(), values.subjunctive()),
					this.verb(values.secondPerson(), values.singular(), values.pluperfect(), values.passive(), values.subjunctive()),
					this.verb(values.thirdPerson(), values.singular(), values.pluperfect(), values.passive(), values.subjunctive()),
					this.verb(values.firstPerson(), values.plural(), values.pluperfect(), values.passive(), values.subjunctive()),
					this.verb(values.secondPerson(), values.plural(), values.pluperfect(), values.passive(), values.subjunctive()),
					this.verb(values.thirdPerson(), values.plural(), values.pluperfect(), values.passive(), values.subjunctive()),
					
					this.verb(values.secondPerson(), values.singular(), values.present(), values.active(), values.imperative()),
					this.verb(values.secondPerson(), values.plural(), values.present(), values.active(), values.imperative()),
					this.verb(values.secondPerson(), values.singular(), values.future(), values.active(), values.imperative()),
					this.verb(values.secondPerson(), values.plural(), values.future(), values.active(), values.imperative()),
					this.verb(values.thirdPerson(), values.plural(), values.future(), values.active(), values.imperative()),
					this.verb(values.thirdPerson(), values.plural(), values.future(), values.active(), values.imperative()),
					this.verb(values.secondPerson(), values.singular(), values.present(), values.passive(), values.imperative()),
					this.verb(values.secondPerson(), values.plural(), values.present(), values.passive(), values.imperative()),
					this.verb(values.secondPerson(), values.singular(), values.future(), values.passive(), values.imperative()),
					this.verb(values.thirdPerson(), values.plural(), values.future(), values.passive(), values.imperative()),
					this.verb(values.secondPerson(), values.singular(), values.future(), values.passive(), values.imperative()),
					this.verb(values.thirdPerson(), values.plural(), values.future(), values.passive(), values.imperative()),
					
					this.verb(values.present(), values.active(), values.infinitive()),
					this.verb(values.perfect(), values.active(), values.infinitive()),
					this.verb(values.future(), values.active(), values.infinitive()),
					this.verb(values.present(), values.passive(), values.infinitive()),
					this.verb(values.perfect(), values.passive(), values.infinitive()),
					this.verb(values.future(), values.passive(), values.infinitive()),
					
					this.verb(values.accusative(), values.supine()),
					this.verb(values.ablative(), values.supine()),
					this.verb(values.genitive(), values.gerund()),
					this.verb(values.dative(), values.gerund()),
					this.verb(values.accusative(), values.gerund()),
					this.verb(values.ablative(), values.gerund()),
					
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.nominative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.genitive(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.dative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.accusative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.ablative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.vocative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.locative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.nominative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.genitive(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.dative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.accusative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.ablative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.vocative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.masculine(), values.locative(), values.plural()),
					
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.nominative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.genitive(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.dative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.accusative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.ablative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.vocative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.locative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.nominative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.genitive(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.dative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.accusative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.ablative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.vocative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.feminine(), values.locative(), values.plural()),
					
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.nominative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.genitive(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.dative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.accusative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.ablative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.vocative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.locative(), values.singular()),
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.nominative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.genitive(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.dative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.accusative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.ablative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.vocative(), values.plural()),
					this.verb(values.present(), values.active(), values.participle(), values.neuter(), values.locative(), values.plural()),
					
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.nominative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.genitive(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.dative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.accusative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.ablative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.vocative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.locative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.nominative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.genitive(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.dative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.accusative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.ablative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.vocative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.masculine(), values.locative(), values.plural()),
					
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.nominative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.genitive(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.dative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.accusative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.ablative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.vocative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.locative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.nominative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.genitive(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.dative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.accusative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.ablative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.vocative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.feminine(), values.locative(), values.plural()),
					
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.nominative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.genitive(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.dative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.accusative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.ablative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.vocative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.locative(), values.singular()),
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.nominative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.genitive(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.dative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.accusative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.ablative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.vocative(), values.plural()),
					this.verb(values.perfect(), values.active(), values.participle(), values.neuter(), values.locative(), values.plural()),
					
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.nominative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.genitive(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.dative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.accusative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.ablative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.vocative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.locative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.nominative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.genitive(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.dative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.accusative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.ablative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.vocative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.masculine(), values.locative(), values.plural()),
					
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.nominative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.genitive(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.dative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.accusative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.ablative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.vocative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.locative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.nominative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.genitive(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.dative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.accusative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.ablative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.vocative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.feminine(), values.locative(), values.plural()),
					
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.nominative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.genitive(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.dative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.accusative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.ablative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.vocative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.locative(), values.singular()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.nominative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.genitive(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.dative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.accusative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.ablative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.vocative(), values.plural()),
					this.verb(values.perfect(), values.passive(), values.participle(), values.neuter(), values.locative(), values.plural()),
					
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.nominative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.genitive(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.dative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.accusative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.ablative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.vocative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.locative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.nominative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.genitive(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.dative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.accusative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.ablative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.vocative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.masculine(), values.locative(), values.plural()),
					
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.nominative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.genitive(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.dative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.accusative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.ablative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.vocative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.locative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.nominative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.genitive(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.dative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.accusative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.ablative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.vocative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.feminine(), values.locative(), values.plural()),
					
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.nominative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.genitive(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.dative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.accusative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.ablative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.vocative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.locative(), values.singular()),
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.nominative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.genitive(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.dative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.accusative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.ablative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.vocative(), values.plural()),
					this.verb(values.future(), values.active(), values.participle(), values.neuter(), values.locative(), values.plural()),
					
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.nominative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.genitive(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.dative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.accusative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.ablative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.vocative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.locative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.nominative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.genitive(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.dative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.accusative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.ablative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.vocative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.masculine(), values.locative(), values.plural()),
					
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.nominative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.genitive(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.dative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.accusative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.ablative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.vocative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.locative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.nominative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.genitive(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.dative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.accusative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.ablative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.vocative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.feminine(), values.locative(), values.plural()),
					
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.nominative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.genitive(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.dative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.accusative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.ablative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.vocative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.locative(), values.singular()),
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.nominative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.genitive(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.dative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.accusative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.ablative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.vocative(), values.plural()),
					this.verb(values.future(), values.passive(), values.participle(), values.neuter(), values.locative(), values.plural())
			};
		}
		
		else if (partOfSpeech.equals(values.conjunction())) {
			return new Form[] {
					this.conjunction()
			};
		}
		
		else if (partOfSpeech.equals(values.preposition())) {
			return new Form[] {
					this.preposition()
			};
		}
		
		else if (partOfSpeech.equals(values.interjection())) {
			return new Form[] {
					this.interjection()
			};
		}
		
		else {
			throw new IllegalArgumentException ("Cannot recognize the part of speech " + partOfSpeech);
		}
		
	}

}
