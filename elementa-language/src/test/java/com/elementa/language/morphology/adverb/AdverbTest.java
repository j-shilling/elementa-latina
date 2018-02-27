package com.elementa.language.morphology.adverb;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.elementa.language.Lexeme;
import com.elementa.language.LexemeFactory;
import com.elementa.language.TestLanguageModule;
import com.elementa.language.Word;
import com.elementa.language.WordFactory;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Guice;
import com.google.inject.Injector;

@RunWith(Parameterized.class)
public class AdverbTest {
	
	private static Injector injector = Guice.createInjector(new TestLanguageModule());
	private static FormFactory forms = injector.getInstance(FormFactory.class);
	private static WordFactory words = injector.getInstance(WordFactory.class);
	private static LexemeFactory lexemes = injector.getInstance(LexemeFactory.class);
	private static Values values = injector.getInstance(Values.class);
	
	private static Form[] allForms = new Form [] {
			forms.adverb(values.positive()),
			forms.adverb(values.comparative()),
			forms.adverb(values.superlative())
	};
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        	{
        		new Word[] {
        				words.create(forms.adverb(values.positive()), "nōn")
        		},
        		
        		new Word[] {
        				words.create(forms.adverb(values.positive()), "nōn")
        		}
        	},
        	{
        		new Word[] {
        				words.create(forms.adverb(values.positive()), "fortiter")
        		},
        		
        		new Word[] {
        				words.create(forms.adverb(values.positive()), "fortiter"),
        				words.create(forms.adverb(values.comparative()), "fortius"),
        				words.create(forms.adverb(values.superlative()), "fortissimē")
        		}
        	},
        	{
        		new Word[] {
        				words.create(forms.adverb(values.positive()), "laetē")
        		},
        		
        		new Word[] {
        				words.create(forms.adverb(values.positive()), "laetē"),
        				words.create(forms.adverb(values.comparative()), "laetius"),
        				words.create(forms.adverb(values.superlative()), "laetissimē")
        		}
        	},
        	{
        		new Word[] {
        				words.create(forms.adverb(values.positive()), "miserē")
        		},
        		
        		new Word[] {
        				words.create(forms.adverb(values.positive()), "miserē"),
        				words.create(forms.adverb(values.comparative()), "miserius"),
        				words.create(forms.adverb(values.superlative()), "miserrimē")
        		}
        	}
        });
    }
    
    private final Lexeme lexeme;
    private final Multimap<Form, Word> expected;
    
    public AdverbTest (Word[] pp, Word[] expected) {
    	this.lexeme = lexemes.adverb(pp);
    	
    	ImmutableMultimap.Builder<Form, Word> builder = new ImmutableMultimap.Builder<>();
    	for (Word word : expected) {
    		builder.put(word.getForm(), word);
    	}
    	
    	this.expected = builder.build();
    }

	@Test
	public void test() {
		for (Form form : allForms) {
			Collection<Word> result = this.lexeme.get(form);
			Collection<Word> expected = this.expected.get(form);
			
			if (result.size() != expected.size()) {
				fail (form + "\nWanted: " + expected + "\nGot: " + result);
			}
			
			for (Word word : expected) {
				if (!result.contains(word)) {
					fail (form + "\nWanted: " + expected + "\nGot: " + result);
				}
			}
		}
	}

}
