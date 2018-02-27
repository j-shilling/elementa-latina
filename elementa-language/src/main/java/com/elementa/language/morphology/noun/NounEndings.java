package com.elementa.language.morphology.noun;

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

import static com.elementa.language.morphology.MorphologicalGroup.FIRST_DECLENSION;
import static com.elementa.language.morphology.MorphologicalGroup.SECOND_DECLENSION;
import static com.elementa.language.morphology.MorphologicalGroup.THIRD_DECLENSION_REGULAR;
import static com.elementa.language.morphology.MorphologicalGroup.THIRD_DECLENSION_ISTEM;
import static com.elementa.language.morphology.MorphologicalGroup.FOURTH_DECLENSION;
import static com.elementa.language.morphology.MorphologicalGroup.FIFTH_DECLENSION;

@Singleton
public class NounEndings implements EndingGetter {
	
	@Nonnull private final EndingsTable table;
	@Nonnull private final Values values;
	@Nonnull private final Types types;
	@Nonnull private final FormFactory forms;
	
	@Inject
	private NounEndings(
			Phonemes phonemes,
			FormFactory forms,
			Values values,
			Types types) {
		
		this.values = values;
		this.types = types;
		this.forms = forms;
		this.table = new EndingsTable.Builder()
				
				/* FIRST DECLENSION */
				.put(FIRST_DECLENSION, forms.noun(values.nominative(), values.feminine(), values.singular()),
						phonemes.A())
				.put(FIRST_DECLENSION, forms.noun(values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_DECLENSION, forms.noun(values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_DECLENSION, forms.noun(values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.A(), phonemes.M()))
				.put(FIRST_DECLENSION, forms.noun(values.ablative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_A()))
				.put(FIRST_DECLENSION, forms.noun(values.vocative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.A()))
				.put(FIRST_DECLENSION, forms.noun(values.locative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_DECLENSION, forms.noun(values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_DECLENSION, forms.noun(values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(FIRST_DECLENSION, forms.noun(values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_DECLENSION, forms.noun(values.accusative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.S()))
				.put(FIRST_DECLENSION, forms.noun(values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_DECLENSION, forms.noun(values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_DECLENSION, forms.noun(values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(FIRST_DECLENSION, forms.noun(values.nominative(), values.masculine(), values.singular()),
						phonemes.A())
				.put(FIRST_DECLENSION, forms.noun(values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_DECLENSION, forms.noun(values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_DECLENSION, forms.noun(values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.A(), phonemes.M()))
				.put(FIRST_DECLENSION, forms.noun(values.ablative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_A()))
				.put(FIRST_DECLENSION, forms.noun(values.vocative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.A()))
				.put(FIRST_DECLENSION, forms.noun(values.locative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_DECLENSION, forms.noun(values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_DECLENSION, forms.noun(values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(FIRST_DECLENSION, forms.noun(values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_DECLENSION, forms.noun(values.accusative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_A(), phonemes.S()))
				.put(FIRST_DECLENSION, forms.noun(values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(FIRST_DECLENSION, forms.noun(values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.AE()))
				.put(FIRST_DECLENSION, forms.noun(values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				/* SECOND DECLENSION */
				.put(SECOND_DECLENSION, forms.noun(values.nominative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.S()))
				.put(SECOND_DECLENSION, forms.noun(values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(SECOND_DECLENSION, forms.noun(values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(SECOND_DECLENSION, forms.noun(values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(SECOND_DECLENSION, forms.noun(values.ablative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(SECOND_DECLENSION, forms.noun(values.vocative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E()))
				.put(SECOND_DECLENSION, forms.noun(values.locative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(SECOND_DECLENSION, forms.noun(values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(SECOND_DECLENSION, forms.noun(values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(SECOND_DECLENSION, forms.noun(values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(SECOND_DECLENSION, forms.noun(values.accusative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.S()))
				.put(SECOND_DECLENSION, forms.noun(values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(SECOND_DECLENSION, forms.noun(values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(SECOND_DECLENSION, forms.noun(values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(SECOND_DECLENSION, forms.noun(values.nominative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.S()))
				.put(SECOND_DECLENSION, forms.noun(values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(SECOND_DECLENSION, forms.noun(values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(SECOND_DECLENSION, forms.noun(values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(SECOND_DECLENSION, forms.noun(values.ablative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(SECOND_DECLENSION, forms.noun(values.vocative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.S()))
				.put(SECOND_DECLENSION, forms.noun(values.locative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(SECOND_DECLENSION, forms.noun(values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(SECOND_DECLENSION, forms.noun(values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(SECOND_DECLENSION, forms.noun(values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(SECOND_DECLENSION, forms.noun(values.accusative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.S()))
				.put(SECOND_DECLENSION, forms.noun(values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(SECOND_DECLENSION, forms.noun(values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I()))
				.put(SECOND_DECLENSION, forms.noun(values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				.put(SECOND_DECLENSION, forms.noun(values.nominative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(SECOND_DECLENSION, forms.noun(values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(SECOND_DECLENSION, forms.noun(values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(SECOND_DECLENSION, forms.noun(values.accusative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(SECOND_DECLENSION, forms.noun(values.ablative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_O()))
				.put(SECOND_DECLENSION, forms.noun(values.vocative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.U(), phonemes.M()))
				.put(SECOND_DECLENSION, forms.noun(values.locative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(SECOND_DECLENSION, forms.noun(values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(SECOND_DECLENSION, forms.noun(values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_O(), phonemes.R(), phonemes.U(), phonemes.M()))
				.put(SECOND_DECLENSION, forms.noun(values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(SECOND_DECLENSION, forms.noun(values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(SECOND_DECLENSION, forms.noun(values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				.put(SECOND_DECLENSION, forms.noun(values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.A()))
				.put(SECOND_DECLENSION, forms.noun(values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.LONG_I(), phonemes.S()))
				
				/* THIRD DECLENSION */
				.put(new PhonemeString (phonemes.I(), phonemes.S()), 
						forms.noun(values.genitive(), values.masculine(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.LONG_I()), 
						forms.noun(values.dative(), values.masculine(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.E(), phonemes.M()), 
						forms.noun(values.accusative(), values.masculine(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.E()), 
						forms.noun(values.ablative(), values.masculine(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) }, 
						forms.noun(values.locative(), values.masculine(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.nominative(), values.masculine(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.U(), phonemes.M()), 
						forms.noun(values.genitive(), values.masculine(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.dative(), values.masculine(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.accusative(), values.masculine(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.ablative(), values.masculine(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.vocative(), values.masculine(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.locative(), values.masculine(), values.plural()), THIRD_DECLENSION_REGULAR)
				
				.put(new PhonemeString (phonemes.I(), phonemes.S()), 
						forms.noun(values.genitive(), values.feminine(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.LONG_I()), 
						forms.noun(values.dative(), values.feminine(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.E(), phonemes.M()), 
						forms.noun(values.accusative(), values.feminine(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.E()), 
						forms.noun(values.ablative(), values.feminine(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) }, 
						forms.noun(values.locative(), values.feminine(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.nominative(), values.feminine(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.U(), phonemes.M()), 
						forms.noun(values.genitive(), values.feminine(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.dative(), values.feminine(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.accusative(), values.feminine(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.ablative(), values.feminine(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.vocative(), values.feminine(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.locative(), values.feminine(), values.plural()), THIRD_DECLENSION_REGULAR)
				
				.put(new PhonemeString (phonemes.I(), phonemes.S()), 
						forms.noun(values.genitive(), values.neuter(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.LONG_I()), 
						forms.noun(values.dative(), values.neuter(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.E()), 
						forms.noun(values.ablative(), values.neuter(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) }, 
						forms.noun(values.locative(), values.neuter(), values.singular()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.A()), 
						forms.noun(values.nominative(), values.neuter(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.U(), phonemes.M()), 
						forms.noun(values.genitive(), values.neuter(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.dative(), values.neuter(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.A()), 
						forms.noun(values.accusative(), values.neuter(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.ablative(), values.neuter(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.A()), 
						forms.noun(values.vocative(), values.neuter(), values.plural()), THIRD_DECLENSION_REGULAR)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.locative(), values.neuter(), values.plural()), THIRD_DECLENSION_REGULAR)
				
				/* THIRD DECLENSION ISTEM */
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.genitive(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.dative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.accusative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.ablative(), values.masculine(), values.singular()),
						new PhonemeString (phonemes.E()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.locative(), values.masculine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.nominative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.genitive(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.dative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.accusative(), values.masculine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.ablative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.vocative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.locative(), values.masculine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.genitive(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.dative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.accusative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.E(), phonemes.M()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.ablative(), values.feminine(), values.singular()),
						new PhonemeString (phonemes.E()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.locative(), values.feminine(), values.singular()),
						new PhonemeString[] { new PhonemeString (phonemes.LONG_I()), new PhonemeString (phonemes.E()) })
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.nominative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.genitive(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.dative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.accusative(), values.feminine(), values.plural()),
						new PhonemeString[] {new PhonemeString (phonemes.LONG_E(), phonemes.S()),  new PhonemeString (phonemes.LONG_I(), phonemes.S()) })
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.ablative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.vocative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.LONG_E(), phonemes.S()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.locative(), values.feminine(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.genitive(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.I(), phonemes.S()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.dative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.ablative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.locative(), values.neuter(), values.singular()),
						new PhonemeString (phonemes.LONG_I()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.nominative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.A()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.genitive(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.U(), phonemes.M()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.dative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.accusative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.A()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.ablative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.vocative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.A()))
				.put(THIRD_DECLENSION_ISTEM, forms.noun(values.locative(), values.neuter(), values.plural()),
						new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()))
				
				/* FOURTH DECLENSION */
				.put(new PhonemeString (phonemes.U(), phonemes.S()), 
						forms.noun(values.nominative(), values.masculine(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U(), phonemes.S()), 
						forms.noun(values.genitive(), values.masculine(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString[] { new PhonemeString (phonemes.U(), phonemes.LONG_I()), new PhonemeString (phonemes.LONG_U()) }, 
						forms.noun(values.dative(), values.masculine(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.U(), phonemes.M()), 
						forms.noun(values.accusative(), values.masculine(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U()), 
						forms.noun(values.ablative(), values.masculine(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.U(), phonemes.S()), 
						forms.noun(values.vocative(), values.masculine(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U(), phonemes.S()), 
						forms.noun(values.nominative(), values.masculine(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.U(), phonemes.U(), phonemes.M()), 
						forms.noun(values.genitive(), values.masculine(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.dative(), values.masculine(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U(), phonemes.S()), 
						forms.noun(values.accusative(), values.masculine(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.ablative(), values.masculine(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U(), phonemes.S()), 
						forms.noun(values.vocative(), values.masculine(), values.plural()), FOURTH_DECLENSION)
				
				.put(new PhonemeString (phonemes.U(), phonemes.S()), 
						forms.noun(values.nominative(), values.feminine(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U(), phonemes.S()), 
						forms.noun(values.genitive(), values.feminine(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString[] { new PhonemeString (phonemes.U(), phonemes.LONG_I()), new PhonemeString (phonemes.LONG_U()) }, 
						forms.noun(values.dative(), values.feminine(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.U(), phonemes.M()), 
						forms.noun(values.accusative(), values.feminine(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U()), 
						forms.noun(values.ablative(), values.feminine(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.U(), phonemes.S()), 
						forms.noun(values.vocative(), values.feminine(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U(), phonemes.S()), 
						forms.noun(values.nominative(), values.feminine(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.U(), phonemes.U(), phonemes.M()), 
						forms.noun(values.genitive(), values.feminine(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.dative(), values.feminine(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U(), phonemes.S()), 
						forms.noun(values.accusative(), values.feminine(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.ablative(), values.feminine(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U(), phonemes.S()), 
						forms.noun(values.vocative(), values.feminine(), values.plural()), FOURTH_DECLENSION)
				
				.put(new PhonemeString (phonemes.LONG_U()), 
						forms.noun(values.nominative(), values.neuter(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U(), phonemes.S()), 
						forms.noun(values.genitive(), values.neuter(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U()),
						forms.noun(values.dative(), values.neuter(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U()),
						forms.noun(values.accusative(), values.neuter(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U()), 
						forms.noun(values.ablative(), values.neuter(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_U()), 
						forms.noun(values.vocative(), values.neuter(), values.singular()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.U(), phonemes.A()), 
						forms.noun(values.nominative(), values.neuter(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.U(), phonemes.U(), phonemes.M()), 
						forms.noun(values.genitive(), values.neuter(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.dative(), values.neuter(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.U(), phonemes.A()), 
						forms.noun(values.accusative(), values.neuter(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.I(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.ablative(), values.neuter(), values.plural()), FOURTH_DECLENSION)
				.put(new PhonemeString (phonemes.U(), phonemes.A()), 
						forms.noun(values.vocative(), values.neuter(), values.plural()), FOURTH_DECLENSION)
				
				/* FIFTH DECLENSION */
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.nominative(), values.masculine(), values.singular()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.LONG_I()), 
						forms.noun(values.genitive(), values.masculine(), values.singular()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.LONG_I()), 
						forms.noun(values.dative(), values.masculine(), values.singular()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.E(), phonemes.M()), 
						forms.noun(values.accusative(), values.masculine(), values.singular()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E()), 
						forms.noun(values.ablative(), values.masculine(), values.singular()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.vocative(), values.masculine(), values.singular()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.nominative(), values.masculine(), values.plural()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.R(), phonemes.U(), phonemes.M()), 
						forms.noun(values.genitive(), values.masculine(), values.plural()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.dative(), values.masculine(), values.plural()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.accusative(), values.masculine(), values.plural()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.ablative(), values.masculine(), values.plural()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.vocative(), values.masculine(), values.plural()), FIFTH_DECLENSION)
				
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.nominative(), values.feminine(), values.singular()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.LONG_I()), 
						forms.noun(values.genitive(), values.feminine(), values.singular()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.LONG_I()), 
						forms.noun(values.dative(), values.feminine(), values.singular()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.E(), phonemes.M()), 
						forms.noun(values.accusative(), values.feminine(), values.singular()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E()), 
						forms.noun(values.ablative(), values.feminine(), values.singular()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.vocative(), values.feminine(), values.singular()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.nominative(), values.feminine(), values.plural()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.R(), phonemes.U(), phonemes.M()), 
						forms.noun(values.genitive(), values.feminine(), values.plural()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.dative(), values.feminine(), values.plural()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.accusative(), values.feminine(), values.plural()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.B(), phonemes.U(), phonemes.S()), 
						forms.noun(values.ablative(), values.feminine(), values.plural()), FIFTH_DECLENSION)
				.put(new PhonemeString (phonemes.LONG_E(), phonemes.S()), 
						forms.noun(values.vocative(), values.feminine(), values.plural()), FIFTH_DECLENSION)
				
				.build();
	}
	
	@Override
	public Collection<HasPhonemes> get(Form form, MorphologicalGroup group) {
		
		if (form.equals(this.values.common()) || form.equals(this.values.omnium())) {
			form = forms.noun(form.get(this.types.Number()).get(), 
					form.get(this.types.Case()).get(), this.values.masculine());
		}
		
		return this.table.get(form, group);
	}

}
