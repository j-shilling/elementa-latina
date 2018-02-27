package com.elementa.language.morphology.adjectives;

import static com.elementa.language.morphology.MorphologicalGroup.FIRST_SECOND_DECLENSION;
import static com.elementa.language.morphology.MorphologicalGroup.THIRD_DECLENSION_THREE_TERMINATION;
import static com.elementa.language.morphology.MorphologicalGroup.THIRD_DECLENSION_TWO_TERMINATION;
import static com.elementa.language.morphology.MorphologicalGroup.THIRD_DECLENSION_ONE_TERMINATION;

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

@Singleton
public class AdjectiveEndings implements EndingGetter {
	
	@Nonnull private final EndingsTable table;
	@Nonnull private final Values values;
	@Nonnull private final Types types;
	@Nonnull private final FormFactory forms;
	
	@Inject
	private AdjectiveEndings(
			Phonemes phonemes,
			FormFactory forms,
			Values values,
			Types types) {
		
		this.values = values;
		this.forms = forms;
		this.types = types;
		
		this.table = new EndingsTable.Builder()
				
				/* POSITIVE */
				
				/* First / Second Declension */
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.nominative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.ablative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.vocative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.locative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.accusative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.nominative(), values.feminine(), values.singular()),
						phonemes.A())
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.A(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.ablative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_A()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.vocative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.A()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.locative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.accusative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.nominative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.accusative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.ablative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.vocative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.locative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.positive(), values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				/* 3rd decl. 3 terminations */
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.locative(), values.masculine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.masculine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.locative(), values.feminine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.feminine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.locative(), values.neuter(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.A()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.A()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.A()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.positive(), values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				/* 3rd decl. 2 terminations */
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.locative(), values.masculine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.masculine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.locative(), values.feminine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.feminine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.locative(), values.neuter(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.A()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.A()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.A()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.positive(), values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				/* 3rd decl. 1 terminations */
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.masculine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.locative(), values.masculine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.masculine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.feminine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.locative(), values.feminine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.feminine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.neuter(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.locative(), values.neuter(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.A()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.A()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.A()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.positive(), values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				/* COMPARATIVES */
				
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.masculine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.masculine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.masculine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.feminine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.feminine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.feminine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.neuter(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.neuter(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.masculine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.masculine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.masculine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.feminine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.feminine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.feminine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.neuter(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.neuter(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.masculine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.masculine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.masculine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.feminine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.feminine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.feminine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.neuter(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.neuter(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.comparative(), values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.ablative(), values.masculine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.locative(), values.masculine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.accusative(), values.masculine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.ablative(), values.feminine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.locative(), values.feminine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.accusative(), values.feminine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.ablative(), values.neuter(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.locative(), values.neuter(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.comparative(), values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				/* SUPERLATIVE */
				
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.nominative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.ablative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.vocative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.locative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.accusative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.nominative(), values.feminine(), values.singular()),
						phonemes.A())
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.A(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.ablative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_A()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.vocative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.A()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.locative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.accusative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.nominative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.accusative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.ablative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.vocative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.locative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(FIRST_SECOND_DECLENSION, forms.adjective(values.superlative(), values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.feminine(), values.singular()),
						phonemes.A())
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.A(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_A()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_THREE_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.feminine(), values.singular()),
						phonemes.A())
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.A(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_A()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_TWO_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.feminine(), values.singular()),
						phonemes.A())
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.A(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_A()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(THIRD_DECLENSION_ONE_TERMINATION, forms.adjective(values.superlative(), values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.build();
		
	}

	@Override
	public Collection<HasPhonemes> get(Form form, MorphologicalGroup group) {
		if (form.equals(this.values.common()) || form.equals(this.values.omnium())) {
			form = forms.adjective(values.positive(), form.get(this.types.Number()).get(), 
					form.get(this.types.Case()).get(), this.values.masculine());
		}
		
		return this.table.get(form, group);
	}

}
