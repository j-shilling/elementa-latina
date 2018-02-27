package com.elementa.language;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.phonology.Phonemes;
import com.elementa.language.phonology.Syllable;
import com.google.inject.Guice;
import com.google.inject.Injector;

@RunWith(Parameterized.class)
public class WordTest {
	
	private static final Injector injector = Guice.createInjector(new TestLanguageModule());
	private static final Phonemes phonemes = injector.getInstance(Phonemes.class);
	private static final WordFactory words = injector.getInstance(WordFactory.class);
	private static final FormFactory forms = injector.getInstance(FormFactory.class);
	private static final Values values = injector.getInstance(Values.class);
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        	{
        		"dea",
        		forms.noun(values.nominative(), values.feminine(), values.singular()),
        		new Syllable[] {
        				new Syllable (phonemes.D(), phonemes.E()),
        				new Syllable (phonemes.A())
        		}
        	},
        	{
        		"deae",
        		forms.noun(values.genitive(), values.feminine(), values.singular()),
        		new Syllable[] {
        				new Syllable (phonemes.D(), phonemes.E()),
        				new Syllable (phonemes.AE())
        		}
        	},
        	{
        		"amīcus",
        		forms.noun(values.nominative(), values.masculine(), values.singular()),
        		new Syllable[] {
        				new Syllable (phonemes.A()),
        				new Syllable (phonemes.M(), phonemes.LONG_I()),
        				new Syllable (phonemes.C(), phonemes.U(), phonemes.S())
        		}
        	},
        	{
        		"mittō",
        		forms.verb(values.firstPerson(), values.singular(), values.active(), values.present(), values.indicative()),
        		new Syllable[] {
        				new Syllable (phonemes.M(), phonemes.I(), phonemes.T()),
        				new Syllable (phonemes.T(), phonemes.LONG_O())
        		}
        	},
        	{
        		"servāre",
        		forms.verb(values.infinitive(), values.active(), values.present()),
        		new Syllable[] {
        				new Syllable (phonemes.S(), phonemes.E(), phonemes.R()),
        				new Syllable (phonemes.V(), phonemes.LONG_A()),
        				new Syllable (phonemes.R(), phonemes.E())
        		}
        	},
        	{
        		"cōnsūmptus",
        		forms.verb(values.perfect(), values.passive(), values.participle(), values.nominative(), values.masculine(), values.singular()),
        		new Syllable[] {
        				new Syllable (phonemes.C(), phonemes.LONG_O(), phonemes.N()),
        				new Syllable (phonemes.S(), phonemes.LONG_U(), phonemes.M(), phonemes.P()),
        				new Syllable (phonemes.T(), phonemes.U(), phonemes.S())
        		}
        	},
        	{
        		"patrem",
        		forms.noun(values.masculine(), values.accusative(), values.singular()),
        		new Syllable[] {
        				new Syllable (phonemes.P(), phonemes.A()),
        				new Syllable (phonemes.TR(), phonemes.E(), phonemes.M())
        		}
        	},
        	{
        		"castra",
        		forms.noun(values.neuter(), values.nominative(), values.plural()),
        		new Syllable[] {
        				new Syllable (phonemes.C(), phonemes.A(), phonemes.S()),
        				new Syllable (phonemes.TR(), phonemes.A())
        		}
        	},
        	{
        		"loquācem",
        		forms.adjective(values.positive(), values.masculine(), values.accusative(), values.singular()),
        		new Syllable[] {
        				new Syllable (phonemes.L(), phonemes.O()),
        				new Syllable (phonemes.QU(), phonemes.LONG_A()),
        				new Syllable (phonemes.C(), phonemes.E(), phonemes.M())
        		}
        	}
        });
    }
    
    private final String string;
    private final Form form;
    private final Syllable[] expected;
    
    public WordTest (String string, Form form, Syllable[] expected) {
    	this.string = string;
    	this.form = form;
    	this.expected = expected;
    }
    
    @Test
    public void testSyllabification() {
    	Word word = words.create(this.form, this.string);
    	Syllable[] result = word.asSyllables();
    	
    	assertTrue (result.length == this.expected.length);
    	
    	for (int i = 0; i < result.length; i ++)
    		assertTrue (result[i].equals(this.expected[i]));
    }

}
