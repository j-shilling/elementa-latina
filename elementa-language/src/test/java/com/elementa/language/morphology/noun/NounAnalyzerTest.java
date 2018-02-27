package com.elementa.language.morphology.noun;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.elementa.language.TestLanguageModule;
import com.elementa.language.Word;
import com.elementa.language.WordFactory;
import com.elementa.language.accidence.Value;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.MorphologicalGroup;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Guice;
import com.google.inject.Injector;

import static com.elementa.language.morphology.MorphologicalGroup.*;

@RunWith(Parameterized.class)
public class NounAnalyzerTest {
	
	private static Injector injector = Guice.createInjector(new TestLanguageModule());
	private static Values values = injector.getInstance(Values.class);
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        	{
        		"ancilla",
        		"ancillae",
        		values.feminine(),
        		values.singular(),
        		FIRST_DECLENSION
        	},
        	{
        		"Athenae",
        		"Athenārum",
        		values.feminine(),
        		values.plural(),
        		FIRST_DECLENSION
        	},
        	{
        		"servus",
        		"servī",
        		values.masculine(),
        		values.singular(),
        		SECOND_DECLENSION
        	},
        	{
        		"Accī",
        		"Accōrum",
        		values.masculine(),
        		values.plural(),
        		SECOND_DECLENSION
        	},
        	{
        		"filius",
        		"filiī",
        		values.masculine(),
        		values.singular(),
        		SECOND_DECLENSION
        	},
        	{
        		"templum",
        		"templī",
        		values.neuter(),
        		values.singular(),
        		SECOND_DECLENSION
        	},
        	{
        		"castra",
        		"castrōrum",
        		values.neuter(),
        		values.plural(),
        		SECOND_DECLENSION
        	},
        	{
        		"dux",
        		"ducis",
        		values.masculine(),
        		values.singular(),
        		THIRD_DECLENSION_REGULAR
        	},
        	{
        		"caput",
        		"capitis",
        		values.neuter(),
        		values.singular(),
        		THIRD_DECLENSION_REGULAR
        	},
        	{
        		"nox",
        		"noctis",
        		values.feminine(),
        		values.singular(),
        		THIRD_DECLENSION_ISTEM
        	},
        	{
        		"nubes",
        		"nubis",
        		values.feminine(),
        		values.singular(),
        		THIRD_DECLENSION_ISTEM
        	},
        	{
        		"sedile",
        		"sedilis",
        		values.neuter(),
        		values.singular(),
        		THIRD_DECLENSION_ISTEM
        	},
        	{
        		"animal",
        		"animalis",
        		values.neuter(),
        		values.singular(),
        		THIRD_DECLENSION_ISTEM
        	},
        	{
        		"calcar",
        		"calcaris",
        		values.neuter(),
        		values.singular(),
        		THIRD_DECLENSION_ISTEM
        	},
        	{
        		"Saturnalia",
        		"Saturnalium",
        		values.neuter(),
        		values.plural(),
        		THIRD_DECLENSION_ISTEM
        	},
        	{
        		"Lares",
        		"Larum",
        		values.masculine(),
        		values.plural(),
        		THIRD_DECLENSION_REGULAR
        	},
        	{
        		"manus",
        		"manūs",
        		values.feminine(),
        		values.singular(),
        		FOURTH_DECLENSION
        	},
        	{
        		"lacus",
        		"lacūs",
        		values.masculine(),
        		values.singular(),
        		FOURTH_DECLENSION
        	},
        	{
        		"genū",
        		"genūs",
        		values.neuter(),
        		values.singular(),
        		FOURTH_DECLENSION
        	},
        	{
        		"idūs",
        		"iduum",
        		values.feminine(),
        		values.plural(),
        		FOURTH_DECLENSION
        	},
        	{
        		"diēs",
        		"diēī",
        		values.masculine(),
        		values.singular(),
        		FIFTH_DECLENSION
        	}
        });
    }
	
	private final NounAnalyzer analyzer;
	private final Multimap<Form, Word> principleParts;
	private final MorphologicalGroup result;
	
	public NounAnalyzerTest (String nom, String gen,
			Value gender, Value number, MorphologicalGroup result) {
		
		
		
		WordFactory wordFactory = injector.getInstance(WordFactory.class);
		FormFactory formFactory = injector.getInstance(FormFactory.class);
		
		analyzer = injector.getInstance(NounAnalyzer.class);
		
		Form nomForm = formFactory.noun(number, gender, values.nominative());
		Form genForm = formFactory.noun(number, gender, values.genitive());
		
		this.principleParts = new ImmutableMultimap.Builder<Form, Word>()
				.put(nomForm, wordFactory.create(nomForm, nom))
				.put(genForm, wordFactory.create(genForm, gen))
				.build();
		
		this.result = result;
	}

	@Test
	public void test() {
		MorphologicalGroup got = this.analyzer.analyze(this.principleParts);
		if (this.result != got) {
			StringBuilder sb = new StringBuilder();
			sb.append("Input: ");
			for (Word word : this.principleParts.values()) {
				sb.append("\t" + word.toString() + "\n");
			}
			sb.append("Result: " + got);
			
			fail (sb.toString());
		}
	}

}
