package com.elementa.language.morphology.verb;

import java.util.Collection;

import javax.annotation.Nonnull;

import com.elementa.language.accidence.Types;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.EndingGetter;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.PhonemeString;
import com.elementa.language.phonology.Phonemes;
import com.elementa.language.table.EndingsTable;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import static com.elementa.language.morphology.MorphologicalGroup.THIRD_CONJUGATION_IO;
import static com.elementa.language.morphology.MorphologicalGroup.THIRD_CONJUGATION_IO_DEPONENT;

@Singleton
public class VerbIOConjugationEndings implements EndingGetter {
	
	@Nonnull private final EndingsTable table;
	
	@Inject
	private VerbIOConjugationEndings(
			Phonemes phonemes,
			FormFactory forms,
			Values values,
			Types types) {
		
		this.table = new EndingsTable.Builder()
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.present(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_O()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.present(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.present(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.T()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.present(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.present(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.present(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.N(), phonemes.T()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.imperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.A(), phonemes.M()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.imperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.LONG_A(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.imperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.A(), phonemes.T()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.imperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.LONG_A(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.imperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.LONG_A(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.imperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.A(), phonemes.N(), phonemes.T()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.future(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.A(), phonemes.M()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.future(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(),phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.future(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.E(), phonemes.T()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.future(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.future(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.future(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.E(), phonemes.N(), phonemes.T()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.perfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.perfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.S(), phonemes.T(), phonemes.LONG_I()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.perfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.T()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.perfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.perfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.S(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.perfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.LONG_E(), phonemes.R(), phonemes.U(), phonemes.N(), phonemes.T()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.perfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.LONG_E(), phonemes.R(), phonemes.E()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.pluperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.A(), phonemes.M()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.pluperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_A(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.pluperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.A(), phonemes.T()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.pluperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_A(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.pluperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_A(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.pluperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.A(), phonemes.N(), phonemes.T()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.futurePerfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_O()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.futurePerfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.futurePerfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.T()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.futurePerfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.futurePerfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.futurePerfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.N(), phonemes.T()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.present(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.A(), phonemes.M()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.present(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.LONG_A(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.present(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.A(), phonemes.T()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.present(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.LONG_A(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.present(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.LONG_A(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.present(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.A(), phonemes.N(), phonemes.T()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.imperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.E(), phonemes.M()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.imperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.imperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.E(), phonemes.T()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.imperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_E(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.imperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_E(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.imperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.E(), phonemes.N(), phonemes.T()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.perfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.M()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.perfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.perfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.T()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.perfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.perfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.perfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.I(), phonemes.N(), phonemes.T()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.pluperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.S(), phonemes.S(), phonemes.E(), phonemes.M()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.pluperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.S(), phonemes.S(), phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.pluperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.S(), phonemes.S(), phonemes.E(), phonemes.T()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.pluperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.S(), phonemes.S(), phonemes.LONG_E(), phonemes.M(), phonemes.U(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.pluperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.S(), phonemes.S(), phonemes.LONG_E(), phonemes.T(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.pluperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.S(), phonemes.S(), phonemes.E(), phonemes.N(), phonemes.T()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.present(), values.active(), values.imperative()),
						new PhonemeString (phonemes.E()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.present(), values.active(), values.imperative()),
						new PhonemeString (phonemes.I(), phonemes.T(), phonemes.E()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.future(), values.active(), values.imperative()),
						new PhonemeString (phonemes.I(), phonemes.T(), phonemes.LONG_O()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.future(), values.active(), values.imperative()),
						new PhonemeString (phonemes.I(), phonemes.T(), phonemes.LONG_O(), phonemes.T(), phonemes.E()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.future(), values.active(), values.imperative()),
						new PhonemeString (phonemes.I(), phonemes.T(), phonemes.LONG_O()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.future(), values.active(), values.imperative()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.N(), phonemes.T(), phonemes.LONG_O()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.present(), values.active(), values.infinitive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.E()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.perfect(), values.active(), values.infinitive()),
						new PhonemeString (phonemes.I(), phonemes.S(), phonemes.S(), phonemes.E()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.present(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.O(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.present(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.E(), phonemes.R(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.present(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.E(), phonemes.R(), phonemes.E()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.present(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.T(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.present(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.M(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.present(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.M(), phonemes.I(), phonemes.N(), phonemes.LONG_I()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.present(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.N(), phonemes.T(), phonemes.U(), phonemes.R()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.imperfect(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.A(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.imperfect(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.LONG_A(), phonemes.R(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.imperfect(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.LONG_A(), phonemes.R(), phonemes.E()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.imperfect(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.LONG_A(), phonemes.T(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.imperfect(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.LONG_A(), phonemes.M(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.imperfect(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.LONG_A(), phonemes.M(), phonemes.I(), phonemes.N(), phonemes.LONG_I()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.imperfect(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.A(), phonemes.N(), phonemes.T(), phonemes.U(), phonemes.R()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.future(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.A(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.future(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.R(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.future(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.R(), phonemes.E()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.future(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.T(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.future(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.M(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.future(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.M(), phonemes.I(), phonemes.N(), phonemes.LONG_I()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.future(), values.passive(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.E(), phonemes.N(), phonemes.T(), phonemes.U(), phonemes.R()))

				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.present(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.A(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.present(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.LONG_A(), phonemes.R(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.present(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.LONG_A(), phonemes.R(), phonemes.E()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.present(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.LONG_A(), phonemes.T(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.present(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.LONG_A(), phonemes.M(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.present(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.LONG_A(), phonemes.M(), phonemes.I(), phonemes.N(), phonemes.LONG_I()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.present(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.A(), phonemes.N(), phonemes.T(), phonemes.U(), phonemes.R()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.singular(), values.imperfect(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.E(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.imperfect(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_E(), phonemes.R(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.imperfect(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_E(), phonemes.R(), phonemes.E()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.imperfect(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_E(), phonemes.T(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.firstPerson(), values.plural(), values.imperfect(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_E(), phonemes.M(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.imperfect(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_E(), phonemes.M(), phonemes.I(), phonemes.N(), phonemes.LONG_I()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.imperfect(), values.passive(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.E(), phonemes.N(), phonemes.T(), phonemes.U(), phonemes.R()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.present(), values.passive(), values.imperative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.E()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.plural(), values.present(), values.passive(), values.imperative()),
						new PhonemeString (phonemes.I(), phonemes.M(), phonemes.I(), phonemes.N(), phonemes.LONG_I()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.secondPerson(), values.singular(), values.future(), values.passive(), values.imperative()),
						new PhonemeString (phonemes.I(), phonemes.T(), phonemes.O(), phonemes.R()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.singular(), values.future(), values.passive(), values.imperative()),
						new PhonemeString (phonemes.I(), phonemes.T(), phonemes.O(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO, forms.verb(values.thirdPerson(), values.plural(), values.future(), values.passive(), values.imperative()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.N(), phonemes.T(), phonemes.O(), phonemes.R()))
				
				.put(THIRD_CONJUGATION_IO, forms.verb(values.present(), values.passive(), values.infinitive()),
						new PhonemeString (phonemes.LONG_I()))
				

				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.firstPerson(), values.singular(), values.present(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.O(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.singular(), values.present(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.E(), phonemes.R(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.singular(), values.present(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.E(), phonemes.R(), phonemes.E()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.thirdPerson(), values.singular(), values.present(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.T(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.firstPerson(), values.plural(), values.present(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.M(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.plural(), values.present(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.M(), phonemes.I(), phonemes.N(), phonemes.LONG_I()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.thirdPerson(), values.plural(), values.present(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.N(), phonemes.T(), phonemes.U(), phonemes.R()))
				
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.firstPerson(), values.singular(), values.imperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.A(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.singular(), values.imperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.LONG_A(), phonemes.R(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.singular(), values.imperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.LONG_A(), phonemes.R(), phonemes.E()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.thirdPerson(), values.singular(), values.imperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.LONG_A(), phonemes.T(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.firstPerson(), values.plural(), values.imperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.LONG_A(), phonemes.M(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.plural(), values.imperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.LONG_A(), phonemes.M(), phonemes.I(), phonemes.N(), phonemes.LONG_I()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.thirdPerson(), values.plural(), values.imperfect(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.B(), phonemes.A(), phonemes.N(), phonemes.T(), phonemes.U(), phonemes.R()))
				
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.firstPerson(), values.singular(), values.future(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.A(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.singular(), values.future(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.R(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.singular(), values.future(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.R(), phonemes.E()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.thirdPerson(), values.singular(), values.future(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.T(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.firstPerson(), values.plural(), values.future(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.M(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.plural(), values.future(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.LONG_E(), phonemes.M(), phonemes.I(), phonemes.N(), phonemes.LONG_I()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.thirdPerson(), values.plural(), values.future(), values.active(), values.indicative()),
						new PhonemeString (phonemes.I(), phonemes.E(), phonemes.N(), phonemes.T(), phonemes.U(), phonemes.R()))

				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.firstPerson(), values.singular(), values.present(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.A(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.singular(), values.present(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.LONG_A(), phonemes.R(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.singular(), values.present(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.LONG_A(), phonemes.R(), phonemes.E()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.thirdPerson(), values.singular(), values.present(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.LONG_A(), phonemes.T(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.firstPerson(), values.plural(), values.present(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.LONG_A(), phonemes.M(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.plural(), values.present(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.LONG_A(), phonemes.M(), phonemes.I(), phonemes.N(), phonemes.LONG_I()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.thirdPerson(), values.plural(), values.present(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.I(), phonemes.A(), phonemes.N(), phonemes.T(), phonemes.U(), phonemes.R()))
				
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.firstPerson(), values.singular(), values.imperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.E(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.singular(), values.imperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_E(), phonemes.R(), phonemes.I(), phonemes.S()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.singular(), values.imperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_E(), phonemes.R(), phonemes.E()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.thirdPerson(), values.singular(), values.imperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_E(), phonemes.T(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.firstPerson(), values.plural(), values.imperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_E(), phonemes.M(), phonemes.U(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.plural(), values.imperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.LONG_E(), phonemes.M(), phonemes.I(), phonemes.N(), phonemes.LONG_I()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.thirdPerson(), values.plural(), values.imperfect(), values.active(), values.subjunctive()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.E(), phonemes.N(), phonemes.T(), phonemes.U(), phonemes.R()))
				
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.singular(), values.present(), values.active(), values.imperative()),
						new PhonemeString (phonemes.E(), phonemes.R(), phonemes.E()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.plural(), values.present(), values.active(), values.imperative()),
						new PhonemeString (phonemes.I(), phonemes.M(), phonemes.I(), phonemes.N(), phonemes.LONG_I()))
				
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.secondPerson(), values.singular(), values.future(), values.active(), values.imperative()),
						new PhonemeString (phonemes.I(), phonemes.T(), phonemes.O(), phonemes.R()))
				
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.thirdPerson(), values.singular(), values.future(), values.active(), values.imperative()),
						new PhonemeString (phonemes.I(), phonemes.T(), phonemes.O(), phonemes.R()))
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.thirdPerson(), values.plural(), values.future(), values.active(), values.imperative()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.N(), phonemes.T(), phonemes.O(), phonemes.R()))
				
				.put(THIRD_CONJUGATION_IO_DEPONENT, forms.verb(values.present(), values.active(), values.infinitive()),
						new PhonemeString (phonemes.LONG_I()))
				
				.build();
	}

	@Override
	public Collection<HasPhonemes> get(Form form, MorphologicalGroup group) {
		return this.table.get(form, group);
	}

}
