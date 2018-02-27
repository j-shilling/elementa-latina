package com.elementa.language.morphology.adjective;

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
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.morphology.adjectives.AdjectiveAnalyzer;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Guice;
import com.google.inject.Injector;

@RunWith(Parameterized.class)
public class AdjectiveAnalyzerTest {
	
	private static Injector injector = Guice.createInjector(new TestLanguageModule());
	private static FormFactory forms = injector.getInstance(FormFactory.class);
	private static WordFactory words = injector.getInstance(WordFactory.class);
	private static Values values = injector.getInstance(Values.class);
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()), "bonus"),
	        			words.create(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()), "bona"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "bonum"),
	        	},
	        	
	        	MorphologicalGroup.FIRST_SECOND_DECLENSION
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()), "miser"),
	        			words.create(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()), "misera"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "miserum"),
	        	},
	        	
	        	MorphologicalGroup.FIRST_SECOND_DECLENSION
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()), "niger"),
	        			words.create(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()), "nigra"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "nigrum"),
	        	},
	        	
	        	MorphologicalGroup.FIRST_SECOND_DECLENSION
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()), "acer"),
	        			words.create(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()), "acris"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "acre"),
	        	},
	        	
	        	MorphologicalGroup.THIRD_DECLENSION_THREE_TERMINATION
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()), "levis"),
	        			words.create(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()), "levis"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "leve"),
	        	},
	        	
	        	MorphologicalGroup.THIRD_DECLENSION_TWO_TERMINATION
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.common(), values.nominative(), values.singular()), "levis"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "leve"),
	        	},
	        	
	        	MorphologicalGroup.THIRD_DECLENSION_TWO_TERMINATION
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()), "atrox"),
	        			words.create(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()), "atrox"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "atrox"),
	        	},
	        	
	        	MorphologicalGroup.THIRD_DECLENSION_ONE_TERMINATION
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.omnium(), values.nominative(), values.singular()), "atrox")
	        	},
	        	
	        	MorphologicalGroup.THIRD_DECLENSION_ONE_TERMINATION
        	}
        });
    }
    
    private final Word[] pps;
    private final MorphologicalGroup expected;
    private final AdjectiveAnalyzer analyzer;
    
    public AdjectiveAnalyzerTest(Word[] pps, MorphologicalGroup expected) {
    	this.pps = pps;
    	this.expected = expected;
    	this.analyzer = injector.getInstance(AdjectiveAnalyzer.class);
    }

	@Test
	public void test() {
		ImmutableMultimap.Builder<Form, Word> builder = new ImmutableMultimap.Builder<>();
    	
    	for (Word word : pps) {
    		builder.put(word.getForm(), word);
    	}
    	
    	Multimap<Form, Word> principleParts = builder.build();
    	
    	MorphologicalGroup result = this.analyzer.analyze(principleParts);
    	
    	if (result != expected) {
    		fail ("Failed: got " + result + " from " + pps);
    	}
	}

}
