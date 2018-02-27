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
import com.elementa.language.alphabet.Letterifier;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.PhonemeString;
import com.elementa.language.phonology.Phonemifier;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Guice;
import com.google.inject.Injector;

@RunWith(Parameterized.class)
public class NounStemTest {
	
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
        		"ancill"
        	},
        	{
        		"Athenae",
        		"Athenārum",
        		values.feminine(),
        		values.plural(),
        		"athen"
        	},
        	{
        		"servus",
        		"servī",
        		values.masculine(),
        		values.singular(),
        		"serv"
        	},
        	{
        		"Accī",
        		"Accōrum",
        		values.masculine(),
        		values.plural(),
        		"acc"
        	},
        	{
        		"filius",
        		"filiī",
        		values.masculine(),
        		values.singular(),
        		"fili"
        	},
        	{
        		"templum",
        		"templī",
        		values.neuter(),
        		values.singular(),
        		"templ"
        	},
        	{
        		"castra",
        		"castrōrum",
        		values.neuter(),
        		values.plural(),
        		"castr"
        	},
        	{
        		"dux",
        		"ducis",
        		values.masculine(),
        		values.singular(),
        		"duc"
        	},
        	{
        		"caput",
        		"capitis",
        		values.neuter(),
        		values.singular(),
        		"capit"
        	},
        	{
        		"nox",
        		"noctis",
        		values.feminine(),
        		values.singular(),
        		"noct"
        	},
        	{
        		"nubes",
        		"nubis",
        		values.feminine(),
        		values.singular(),
        		"nub"
        	},
        	{
        		"sedile",
        		"sedilis",
        		values.neuter(),
        		values.singular(),
        		"sedil"
        	},
        	{
        		"animal",
        		"animalis",
        		values.neuter(),
        		values.singular(),
        		"animal"
        	},
        	{
        		"calcar",
        		"calcaris",
        		values.neuter(),
        		values.singular(),
        		"calcar"
        	},
        	{
        		"Saturnalia",
        		"Saturnalium",
        		values.neuter(),
        		values.plural(),
        		"saturnal"
        	},
        	{
        		"Lares",
        		"Larum",
        		values.masculine(),
        		values.plural(),
        		"lar"
        	},
        	{
        		"manus",
        		"manūs",
        		values.feminine(),
        		values.singular(),
        		"man"
        	},
        	{
        		"lacus",
        		"lacūs",
        		values.masculine(),
        		values.singular(),
        		"lac"
        	},
        	{
        		"genū",
        		"genūs",
        		values.neuter(),
        		values.singular(),
        		"gen"
        	},
        	{
        		"idūs",
        		"iduum",
        		values.feminine(),
        		values.plural(),
        		"id"
        	},
        	{
        		"diēs",
        		"diēī",
        		values.masculine(),
        		values.singular(),
        		"di"
        	}
        });
    }
	
	private final NounStem stem;
	private final Letterifier letterifier;
	private final Phonemifier phonemifier;
	private final Form form;
	private final Multimap<Form, Word> principleParts;
	private final String result;
	
	public NounStemTest (String nom, String gen,
			Value gender, Value number, String result) {
		
		WordFactory wordFactory = injector.getInstance(WordFactory.class);
		FormFactory formFactory = injector.getInstance(FormFactory.class);
		
		stem = injector.getInstance(NounStem.class);
		letterifier = injector.getInstance(Letterifier.class);
		phonemifier = injector.getInstance(Phonemifier.class);
		
		Form nomForm = formFactory.noun(number, gender, values.nominative());
		Form genForm = formFactory.noun(number, gender, values.genitive());
		
		this.principleParts = new ImmutableMultimap.Builder<Form, Word>()
				.put(nomForm, wordFactory.create(nomForm, nom))
				.put(genForm, wordFactory.create(genForm, gen))
				.build();
		
		this.result = result;
		this.form = genForm;
	}

	@Test
	public void test() {
		Collection<HasPhonemes> got = this.stem.get(this.principleParts, this.form);
		if (!got.contains(
				new PhonemeString (phonemifier.phonemify(letterifier.letterify(this.result))))) {
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
