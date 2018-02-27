package com.elementa.language.morphology.verb;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Nonnull;

import com.elementa.language.Lexeme;
import com.elementa.language.LexemeFactory;
import com.elementa.language.Word;
import com.elementa.language.WordFactory;
import com.elementa.language.accidence.Types;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.IrregularFormBuilder;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.PhonemeString;
import com.elementa.language.phonology.Phonemes;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import static com.elementa.language.morphology.MorphologicalGroup.*;

@Singleton
public class VerbForms implements IrregularFormBuilder {
	
	@Nonnull private final VerbAnalyzer analyzer;
	@Nonnull private final VerbStems stems;
	@Nonnull private final Values values;
	@Nonnull private final Types types;
	@Nonnull private final Phonemes phonemes;
	@Nonnull private final WordFactory words;
	@Nonnull private final FormFactory forms;
	@Nonnull private final LexemeFactory lexemes;
	
	@Nonnull private final ImmutableMap<Form, HasPhonemes> helpers;
	
	@Inject
	private VerbForms(
			VerbAnalyzer analyzer,
			VerbStems stems,
			Values values,
			Types types,
			Phonemes phonemes,
			WordFactory words,
			FormFactory forms,
			LexemeFactory lexemes) {
		this.analyzer = analyzer;
		this.stems = stems;
		this.values = values;
		this.types = types;
		this.phonemes = phonemes;
		this.words = words;
		this.forms = forms;
		this.lexemes = lexemes;
		
		this.helpers = new ImmutableMap.Builder<Form, HasPhonemes>()
				
				.put(forms.verb(values.present(), values.active(), values.infinitive()),
						new PhonemeString (phonemes.E(), phonemes.S(), phonemes.S(), phonemes.E()))
				
				.put(forms.verb(values.present(), values.active(), values.indicative(), values.singular(), values.firstPerson()),
						new PhonemeString (phonemes.S(), phonemes.U(), phonemes.M()))
				.put(forms.verb(values.present(), values.active(), values.indicative(), values.singular(), values.secondPerson()),
						new PhonemeString (phonemes.E(), phonemes.S()))
				.put(forms.verb(values.present(), values.active(), values.indicative(), values.singular(), values.thirdPerson()),
						new PhonemeString (phonemes.E(), phonemes.S(), phonemes.T()))
				.put(forms.verb(values.present(), values.active(), values.indicative(), values.plural(), values.firstPerson()),
						new PhonemeString (phonemes.S(), phonemes.U(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(forms.verb(values.present(), values.active(), values.indicative(), values.plural(), values.secondPerson()),
						new PhonemeString (phonemes.E(), phonemes.S(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(forms.verb(values.present(), values.active(), values.indicative(), values.plural(), values.thirdPerson()),
						new PhonemeString (phonemes.S(), phonemes.U(), phonemes.N(), phonemes.T()))
				
				.put(forms.verb(values.present(), values.active(), values.subjunctive(), values.singular(), values.firstPerson()),
						new PhonemeString (phonemes.S(), phonemes.I(), phonemes.M()))
				.put(forms.verb(values.present(), values.active(), values.subjunctive(), values.singular(), values.secondPerson()),
						new PhonemeString (phonemes.S(), phonemes.LONG_I(), phonemes.S()))
				.put(forms.verb(values.present(), values.active(), values.subjunctive(), values.singular(), values.thirdPerson()),
						new PhonemeString (phonemes.S(), phonemes.I(), phonemes.T()))
				.put(forms.verb(values.present(), values.active(), values.subjunctive(), values.plural(), values.firstPerson()),
						new PhonemeString (phonemes.S(), phonemes.LONG_I(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(forms.verb(values.present(), values.active(), values.subjunctive(), values.plural(), values.secondPerson()),
						new PhonemeString (phonemes.S(), phonemes.LONG_I(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(forms.verb(values.present(), values.active(), values.subjunctive(), values.plural(), values.thirdPerson()),
						new PhonemeString (phonemes.S(), phonemes.I(), phonemes.N(), phonemes.T()))
				
				.put(forms.verb(values.imperfect(), values.active(), values.indicative(), values.singular(), values.firstPerson()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.A(), phonemes.M()))
				.put(forms.verb(values.imperfect(), values.active(), values.indicative(), values.singular(), values.secondPerson()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_A(), phonemes.S()))
				.put(forms.verb(values.imperfect(), values.active(), values.indicative(), values.singular(), values.thirdPerson()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.A(), phonemes.T()))
				.put(forms.verb(values.imperfect(), values.active(), values.indicative(), values.plural(), values.firstPerson()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_A(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(forms.verb(values.imperfect(), values.active(), values.indicative(), values.plural(), values.secondPerson()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_A(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(forms.verb(values.imperfect(), values.active(), values.indicative(), values.plural(), values.thirdPerson()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.A(), phonemes.N(), phonemes.T()))
				
				.put(forms.verb(values.imperfect(), values.active(), values.subjunctive(), values.singular(), values.firstPerson()),
						new PhonemeString (phonemes.E(), phonemes.S(), phonemes.S(), phonemes.E(), phonemes.M()))
				.put(forms.verb(values.imperfect(), values.active(), values.subjunctive(), values.singular(), values.secondPerson()),
						new PhonemeString (phonemes.E(), phonemes.S(), phonemes.S(), phonemes.LONG_E(), phonemes.S()))
				.put(forms.verb(values.imperfect(), values.active(), values.subjunctive(), values.singular(), values.thirdPerson()),
						new PhonemeString (phonemes.E(), phonemes.S(), phonemes.S(), phonemes.E(), phonemes.T()))
				.put(forms.verb(values.imperfect(), values.active(), values.subjunctive(), values.plural(), values.firstPerson()),
						new PhonemeString (phonemes.E(), phonemes.S(), phonemes.S(), phonemes.LONG_E(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(forms.verb(values.imperfect(), values.active(), values.subjunctive(), values.plural(), values.secondPerson()),
						new PhonemeString (phonemes.E(), phonemes.S(), phonemes.S(), phonemes.LONG_E(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(forms.verb(values.imperfect(), values.active(), values.subjunctive(), values.plural(), values.thirdPerson()),
						new PhonemeString (phonemes.E(), phonemes.S(), phonemes.S(), phonemes.E(), phonemes.N(), phonemes.T()))
				
				.put(forms.verb(values.future(), values.active(), values.indicative(), values.singular(), values.firstPerson()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_O()))
				.put(forms.verb(values.future(), values.active(), values.indicative(), values.singular(), values.secondPerson()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.S()))
				.put(forms.verb(values.future(), values.active(), values.indicative(), values.singular(), values.thirdPerson()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.T()))
				.put(forms.verb(values.future(), values.active(), values.indicative(), values.plural(), values.firstPerson()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(forms.verb(values.future(), values.active(), values.indicative(), values.plural(), values.secondPerson()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(forms.verb(values.future(), values.active(), values.indicative(), values.plural(), values.thirdPerson()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.U(), phonemes.N(), phonemes.T()))
				
				.build();
	}
	
	private Optional<Collection<Word>> participle (Multimap<Form, Word> principleParts, Form form) {
		
		MorphologicalGroup group = this.analyzer.analyze(principleParts);
		Set<Word> words = new HashSet<>();
		Set<Word> ret = new HashSet<>();
		
		if (form.equals(values.present())) {
			
			PhonemeString nom = null;
			PhonemeString gen = null;
			if (group == FIRST_CONJUGATION || group == FIRST_CONJUGATION_DEPONENT) {
				nom = new PhonemeString (phonemes.LONG_A(), phonemes.N(), phonemes.S());
				gen = new PhonemeString (phonemes.A(), phonemes.N(), phonemes.T(), phonemes.I(), phonemes.S());
			}
			
			else if (group == SECOND_CONJUGATION || group == SECOND_CONJUGATION_DEPONENT
					|| group == THIRD_CONJUGATION_REGULAR || group == THIRD_CONJUGATION_REGULAR_DEPONENT) {
				nom = new PhonemeString (phonemes.LONG_E(), phonemes.N(), phonemes.S());
				gen = new PhonemeString (phonemes.E(), phonemes.N(), phonemes.T(), phonemes.I(), phonemes.S());
			}
			
			else if (group == THIRD_CONJUGATION_IO || group == THIRD_CONJUGATION_IO_DEPONENT
					|| group == FOURTH_CONJUGATION || group == FOURTH_CONJUGATION_DEPONENT) {
				nom = new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.N(), phonemes.S());
				gen = new PhonemeString (phonemes.I(), phonemes.E(), phonemes.N(), phonemes.T(), phonemes.I(), phonemes.S());
			}
			
			for (HasPhonemes x : this.stems.get(principleParts, form)) {
				words.add(this.words.create(
						forms.adjective(values.positive(), values.nominative(), 
								values.omnium(), values.singular()), 
						x, nom));
				words.add(this.words.create(
						forms.adjective(values.positive(), values.genitive(), 
								values.omnium(), values.singular()), 
						x, gen));
			}
			
		}
		
		if (form.equals(values.future(), values.passive())) {
			
			PhonemeString stem = null;
			if (group == FIRST_CONJUGATION || group == FIRST_CONJUGATION_DEPONENT) {
				stem = new PhonemeString (phonemes.A(), phonemes.N(), phonemes.D());
			}
			
			else if (group == SECOND_CONJUGATION || group == SECOND_CONJUGATION_DEPONENT
					|| group == THIRD_CONJUGATION_REGULAR || group == THIRD_CONJUGATION_REGULAR_DEPONENT) {
				stem = new PhonemeString (phonemes.E(), phonemes.N(), phonemes.D());
			}
			
			else if (group == THIRD_CONJUGATION_IO || group == THIRD_CONJUGATION_IO_DEPONENT
					|| group == FOURTH_CONJUGATION || group == FOURTH_CONJUGATION_DEPONENT) {
				stem = new PhonemeString (phonemes.I(), phonemes.E(), phonemes.N(), phonemes.D());
			}
			
			for (HasPhonemes x : this.stems.get(principleParts, form)) {
				words.add(this.words.create(
						forms.adjective(values.positive(), values.nominative(), 
								values.masculine(), values.singular()), 
						x, stem, phonemes.U(), phonemes.S()));
				words.add(this.words.create(
						forms.adjective(values.positive(), values.nominative(), 
								values.feminine(), values.singular()), 
						x, stem, phonemes.A()));
				words.add(this.words.create(
						forms.adjective(values.positive(), values.nominative(), 
								values.neuter(), values.singular()), 
						x, stem, phonemes.U(), phonemes.M()));
			}
			
		}
		
		if (form.equals(values.future(), values.active())) {
			for (HasPhonemes x : this.stems.get(principleParts, form)) {
				words.add(this.words.create(
						forms.adjective(values.positive(), values.nominative(), 
								values.masculine(), values.singular()), 
						x, phonemes.LONG_U(), phonemes.R(), phonemes.U(), phonemes.S()));
				words.add(this.words.create(
						forms.adjective(values.positive(), values.nominative(), 
								values.feminine(), values.singular()), 
						x, phonemes.LONG_U(), phonemes.R(), phonemes.A()));
				words.add(this.words.create(
						forms.adjective(values.positive(), values.nominative(), 
								values.neuter(), values.singular()), 
						x, phonemes.LONG_U(), phonemes.R(), phonemes.U(), phonemes.M()));
			}
		}
		
		if (form.equals(values.perfect())) {
			for (HasPhonemes x : this.stems.get(principleParts, form)) {
				words.add(this.words.create(
						forms.adjective(values.positive(), values.nominative(), 
								values.masculine(), values.singular()), 
						x, phonemes.U(), phonemes.S()));
				words.add(this.words.create(
						forms.adjective(values.positive(), values.nominative(), 
								values.feminine(), values.singular()), 
						x, phonemes.A()));
				words.add(this.words.create(
						forms.adjective(values.positive(), values.nominative(), 
								values.neuter(), values.singular()), 
						x, phonemes.U(), phonemes.M()));
			}
		}
		
		Lexeme adj = lexemes.adjective(words.toArray(new Word[0]));
		Collection<Word> result = adj.get(forms.adjective(values.positive(),
				form.get(types.Gender()).get(), form.get(types.Number()).get(), form.get(types.Case()).get()));
		
		for (Word word : result) {
			ret.add(this.words.create(form, word));
		}
		
		return Optional.of(ret);
		
	}
	
	private Optional<Collection<Word>> gerund (Multimap<Form, Word> principleParts, Form form) {
		Set<Word> words = new HashSet<>();
		Optional<Collection<Word>> noms = this.participle(principleParts, 
				forms.verb(values.future(), values.passive(), values.participle(),
						values.neuter(), values.nominative(), values.singular()));
		Optional<Collection<Word>> gens = this.participle(principleParts, 
				forms.verb(values.future(), values.passive(), values.participle(),
						values.neuter(), values.genitive(), values.singular()));
		
		if (noms.isPresent()) {
			for (Word word : noms.get()) {
				words.add(this.words.create(forms.noun(values.nominative(), values.singular(), values.neuter()),
						word.toPhonemeString()));
			}
		}
		if (gens.isPresent()) {
			for (Word word : gens.get()) {
				words.add(this.words.create(forms.noun(values.genitive(), values.singular(), values.neuter()),
						word.toPhonemeString()));
			}
		}
		
		Lexeme lexeme = lexemes.noun(words.toArray(new Word[0]));
		
		Collection<Word> result = lexeme.get(forms.noun(
				values.neuter(), values.singular(), form.get(types.Case()).get()));
		Set<Word> ret = new HashSet<>();
		for (Word word : result) {
			ret.add(this.words.create(form, word));
		}
		
		return Optional.of(ret);
	}
	
	private Optional<Collection<Word>> supine (Multimap<Form, Word> principleParts, Form form) {
		PhonemeString ending = null;
		if (form.equals(values.accusative()))
			ending = new PhonemeString (phonemes.U(), phonemes.M());
		else
			ending = new PhonemeString (phonemes.LONG_U());
		
		Collection<HasPhonemes> stems = this.stems.get(principleParts, form);
		Set<Word> ret = new HashSet<>();
		for (HasPhonemes x : stems) {
			ret.add(this.words.create(form, x, ending));
		}
		
		return Optional.of(ret);
	}
	
	private Optional<Collection<Word>> paraphrastic (Multimap<Form, Word> principleParts, Form form) {
		Set<Word> ret = new HashSet<>();
		
		if (!this.analyzer.isDeponenet(principleParts)) {
			
			if (form.equals(values.future(), values.active(), values.infinitive())) {
				
				Optional<Collection<Word>> result = this.participle(principleParts, 
						forms.verb(values.future(), values.active(), values.participle(),
								values.masculine(), values.nominative(), values.singular()));
				if (!result.isPresent())
					return Optional.empty();
				
				HasPhonemes helper = this.helpers.get(forms.verb(values.present(), values.active(), values.infinitive()));
				
				for (Word word : result.get()) {
					ret.add(words.createParaphrastic(form, word, 
							this.words.create(forms.verb(values.present(), values.active(), 
									values.infinitive()), helper)));
				}
				
			}
			
			else if (form.equals(values.future(), values.passive(), values.infinitive())) {
				
				Optional<Collection<Word>> result = this.supine(principleParts, 
						forms.verb(values.accusative(), values.supine()));
				if (!result.isPresent())
					return Optional.empty();
				
				HasPhonemes helper = new PhonemeString (phonemes.LONG_I(), phonemes.R(), phonemes.LONG_I());
				
				for (Word word : result.get()) {
					ret.add(words.createParaphrastic(form, word, 
							this.words.create(forms.verb(values.present(), values.passive(), 
									values.infinitive()), helper)));
				}
				
			}
			
			else if (form.equals(values.perfect(), values.passive(), values.infinitive())) {
				
				Optional<Collection<Word>> result = this.participle(principleParts, 
						forms.verb(values.perfect(), values.passive(), values.participle(),
								values.masculine(), values.nominative(), values.singular()));
				if (!result.isPresent())
					return Optional.empty();
				
				HasPhonemes helper = this.helpers.get(forms.verb(values.present(), values.active(), values.infinitive()));
				
				for (Word word : result.get()) {
					ret.add(words.createParaphrastic(form, word, 
							this.words.create(forms.verb(values.present(), values.active(), 
									values.infinitive()), helper)));
				}
				
			}
			
			else if (form.equals(values.perfect(), values.passive()) 
					&& (form.equals(values.indicative()) || form.equals(values.subjunctive()))) {
				
				Optional<Collection<Word>> result = this.participle(principleParts, 
						forms.verb(values.perfect(), values.passive(), values.participle(),
								values.masculine(), values.nominative(), form.get(types.Number()).get()));
				if (!result.isPresent())
					return Optional.empty();
				
				HasPhonemes helper = this.helpers.get(
						forms.verb(values.present(), values.active(), 
								form.get(types.Mood()).get(), form.get(types.Person()).get(),
								form.get(types.Number()).get()));
				
				for (Word word : result.get()) {
					ret.add(words.createParaphrastic(form, word, 
							this.words.create(forms.verb(values.present(), values.active(), 
									form.get(types.Mood()).get(), form.get(types.Person()).get(),
									form.get(types.Number()).get()), helper)));
				}
			}
			
			else if (form.equals(values.pluperfect(), values.passive()) 
					&& (form.equals(values.indicative()) || form.equals(values.subjunctive()))) {
				
				Optional<Collection<Word>> result = this.participle(principleParts, 
						forms.verb(values.perfect(), values.passive(), values.participle(),
								values.masculine(), values.nominative(), form.get(types.Number()).get()));
				if (!result.isPresent())
					return Optional.empty();
				
				HasPhonemes helper = this.helpers.get(
						forms.verb(values.imperfect(), values.active(), 
								form.get(types.Mood()).get(), form.get(types.Person()).get(),
								form.get(types.Number()).get()));
				
				for (Word word : result.get()) {
					ret.add(words.createParaphrastic(form, word, 
							this.words.create(forms.verb(values.imperfect(), values.active(), 
									form.get(types.Mood()).get(), form.get(types.Person()).get(),
									form.get(types.Number()).get()), helper)));
				}
			}
			
			else if (form.equals(values.futurePerfect(), values.passive(), values.indicative())) {
				
				Optional<Collection<Word>> result = this.participle(principleParts, 
						forms.verb(values.perfect(), values.passive(), values.participle(),
								values.masculine(), values.nominative(), form.get(types.Number()).get()));
				if (!result.isPresent())
					return Optional.empty();
				
				HasPhonemes helper = this.helpers.get(
						forms.verb(values.future(), values.active(), values.indicative(),
								form.get(types.Person()).get(),
								form.get(types.Number()).get()));
				
				for (Word word : result.get()) {
					ret.add(words.createParaphrastic(form, word, 
							this.words.create(forms.verb(values.future(), values.active(), 
									values.indicative(), form.get(types.Person()).get(),
									form.get(types.Number()).get()), helper)));
				}
			}
				
		} else {
			
			if (form.equals(values.future(), values.active(), values.infinitive())) {
				
				Optional<Collection<Word>> result = this.participle(principleParts, 
						forms.verb(values.future(), values.active(), values.participle(),
								values.masculine(), values.nominative(), values.singular()));
				if (!result.isPresent())
					return Optional.empty();
				
				HasPhonemes helper = this.helpers.get(forms.verb(values.present(), values.active(), values.infinitive()));
				
				for (Word word : result.get()) {
					ret.add(words.createParaphrastic(form, word, 
							this.words.create(forms.verb(values.present(), values.active(), 
									values.infinitive()), helper)));
				}
				
			}
			
			else if (form.equals(values.perfect(), values.active(), values.infinitive())) {
				
				Optional<Collection<Word>> result = this.participle(principleParts, 
						forms.verb(values.perfect(), values.active(), values.participle(),
								values.masculine(), values.nominative(), values.singular()));
				if (!result.isPresent())
					return Optional.empty();
				
				HasPhonemes helper = this.helpers.get(forms.verb(values.present(), values.active(), values.infinitive()));
				
				for (Word word : result.get()) {
					ret.add(words.createParaphrastic(form, word, 
							this.words.create(forms.verb(values.present(), values.active(), 
									values.infinitive()), helper)));
				}
				
			}
			
			else if (form.equals(values.perfect(), values.active()) 
					&& (form.equals(values.indicative()) || form.equals(values.subjunctive()))) {
				
				Optional<Collection<Word>> result = this.participle(principleParts, 
						forms.verb(values.perfect(), values.active(), values.participle(),
								values.masculine(), values.nominative(), form.get(types.Number()).get()));
				if (!result.isPresent())
					return Optional.empty();
				
				HasPhonemes helper = this.helpers.get(
						forms.verb(values.present(), values.active(), 
								form.get(types.Mood()).get(), form.get(types.Person()).get(),
								form.get(types.Number()).get()));
				
				for (Word word : result.get()) {
					ret.add(words.createParaphrastic(form, word, 
							this.words.create(forms.verb(values.present(), values.active(), 
									form.get(types.Mood()).get(), form.get(types.Person()).get(),
									form.get(types.Number()).get()), helper)));
				}
			}
			
			else if (form.equals(values.pluperfect(), values.active()) 
					&& (form.equals(values.indicative()) || form.equals(values.subjunctive()))) {
				
				Optional<Collection<Word>> result = this.participle(principleParts, 
						forms.verb(values.perfect(), values.active(), values.participle(),
								values.masculine(), values.nominative(), form.get(types.Number()).get()));
				if (!result.isPresent())
					return Optional.empty();
				
				HasPhonemes helper = this.helpers.get(
						forms.verb(values.imperfect(), values.active(), 
								form.get(types.Mood()).get(), form.get(types.Person()).get(),
								form.get(types.Number()).get()));
				
				for (Word word : result.get()) {
					ret.add(words.createParaphrastic(form, word, 
							this.words.create(forms.verb(values.imperfect(), values.active(), 
									form.get(types.Mood()).get(), form.get(types.Person()).get(),
									form.get(types.Number()).get()), helper)));
				}
			}
			
			else if (form.equals(values.futurePerfect(), values.active(), values.indicative())) {
				
				Optional<Collection<Word>> result = this.participle(principleParts, 
						forms.verb(values.perfect(), values.active(), values.participle(),
								values.masculine(), values.nominative(), form.get(types.Number()).get()));
				if (!result.isPresent())
					return Optional.empty();
				
				HasPhonemes helper = this.helpers.get(
						forms.verb(values.future(), values.active(), values.indicative(),
								form.get(types.Person()).get(),
								form.get(types.Number()).get()));
				
				for (Word word : result.get()) {
					ret.add(words.createParaphrastic(form, word, 
							this.words.create(forms.verb(values.future(), values.active(), 
									values.indicative(), form.get(types.Person()).get(),
									form.get(types.Number()).get()), helper)));
				}
			}
			
		}
		
		return Optional.of(ret);
	}

	@Override
	public Optional<Collection<Word>> build(Multimap<Form, Word> principleParts, Form form) {
		
		if (this.analyzer.isDeponenet(principleParts) && form.equals(values.passive()))
			if (!form.equals(values.future(), values.passive(), values.participle()))
				return Optional.of(new HashSet<>());
		
		if (form.equals(values.participle()))
			return this.participle(principleParts, form);
		if (form.equals(values.gerund()))
			return this.gerund(principleParts, form);
		if (form.equals(values.supine()))
			return this.supine(principleParts, form);
		
		if (form.equals(values.future(), values.active(), values.infinitive())
				|| form.equals(values.future(), values.passive(), values.infinitive())
				|| (form.equals(values.passive())
						&& (form.equals(values.perfect())
								|| form.equals(values.pluperfect())
								|| form.equals(values.futurePerfect()))))
			
			return this.paraphrastic(principleParts, form);
		
		if ((this.analyzer.isDeponenet(principleParts))
				&& (form.equals(values.perfect())
						|| form.equals(values.pluperfect())
						|| form.equals(values.futurePerfect())))
			
			return this.paraphrastic(principleParts, form);
		
		return Optional.empty();
	}

}
