package com.elementa.language;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.elementa.language.accidence.Value;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Guice;
import com.google.inject.Injector;

@RunWith(Parameterized.class)
public class LexemeCreateText {
	
	private static final Injector injector = Guice.createInjector(new TestLanguageModule());
	private static final WordFactory words = injector.getInstance(WordFactory.class);
	private static final FormFactory forms = injector.getInstance(FormFactory.class);
	private static final LexemeFactory lexemes = injector.getInstance(LexemeFactory.class);
	private static final Values values = injector.getInstance(Values.class);
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        	{
        		"servus,      servi, m.",
        		values.noun(),
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.singular(), values.masculine()),
        						"servus"),
        				words.create(forms.noun(values.genitive(), values.singular(), values.masculine()),
        						"servī"),
        		}
        	},
        	{
        		"saeculum/saeclum,	saeculi / saecli n.",
        		values.noun(),
        		new Word[] {
        				words.create(forms.noun(values.neuter(), values.nominative(), values.singular()),
        						"saeculum"),
        				words.create(forms.noun(values.neuter(), values.nominative(), values.singular()), 
        						"saeclum"),
        				words.create(forms.noun(values.neuter(), values.genitive(), values.singular()), 
        						"saeculī"),
        				words.create(forms.noun(values.neuter(), values.genitive(), values.singular()), 
        						"saeclī")
        		}
        	},
        	{
        		"saec(u)lum, saec(u)li n.",
        		values.noun(),
        		new Word[] {
        				words.create(forms.noun(values.neuter(), values.nominative(), values.singular()),
        						"saeculum"),
        				words.create(forms.noun(values.neuter(), values.nominative(), values.singular()), 
        						"saeclum"),
        				words.create(forms.noun(values.neuter(), values.genitive(), values.singular()), 
        						"saeculī"),
        				words.create(forms.noun(values.neuter(), values.genitive(), values.singular()), 
        						"saeclī")
        		}
        	},
        	{
        		"dies,diei, m./f.",
        		values.noun(),
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.common(), values.singular()), 
        						"dies"),
        				words.create(forms.noun(values.genitive(), values.common(), values.singular()),
        						"diēī"),
        		}
        	},
        	{
        		"laetus, laeta, laetum",
        		values.adjective(),
        		new Word[] {
        				words.create(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()), "laetus"),
	        			words.create(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()), "laeta"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "laetum"),
        		}
        	},
        	{
        		"levis, leve",
        		values.adjective(),
        		new Word[] {
        				words.create(forms.adjective(values.positive(), values.common(), values.nominative(), values.singular()), "levis"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "leve"),        		}
        	},
        	{
        		"atrox",
        		values.adjective(),
        		new Word[] {
	        			words.create(forms.adjective(values.positive(), values.omnium(), values.nominative(), values.singular()), "atrox")
        		}
        	},
        	{
        		"non",
        		values.adverb(),
        		new Word[] {
        				words.create(forms.adverb(values.positive()), "non")
        		}
        	},
        	{
        		"bene, melius, optime",
        		values.adverb(),
        		new Word[] {
        				words.create(forms.adverb(values.positive()), "bene"),
        				words.create(forms.adverb(values.comparative()), "melius"),
        				words.create(forms.adverb(values.superlative()), "optimē")
        		}
        	},
        	{
        		"hic, haec, hoc",
        		values.pronoun(),
        		new Word[] {
        				words.create(forms.pronoun(values.thirdPerson(), values.masculine(), values.nominative(), values.singular()), "hic"),
	        			words.create(forms.pronoun(values.thirdPerson(), values.feminine(), values.nominative(), values.singular()), "haec"),
	        			words.create(forms.pronoun(values.thirdPerson(), values.neuter(), values.nominative(), values.singular()), "hoc"),
        		}
        	},
        	{
        		"amo, amare, amavi, amatum",
        		values.verb(),
        		new Word[] {
    					words.create(forms.verb(values.firstPerson(), values.present(), values.active(), values.singular(), values.indicative()),
    							"amō"),
    					words.create(forms.verb(values.present(), values.active(), values.infinitive()),
    							"amāre"),
    					words.create(forms.verb(values.firstPerson(), values.perfect(), values.active(), values.singular(), values.indicative()),
    							"amavī"),
    					words.create(forms.verb(values.accusative(), values.supine()),
    							"amatum"),
    			}
        	},
        	{
        		"amo, amare, amavi, amatus",
        		values.verb(),
        		new Word[] {
    					words.create(forms.verb(values.firstPerson(), values.present(), values.active(), values.singular(), values.indicative()),
    							"amō"),
    					words.create(forms.verb(values.present(), values.active(), values.infinitive()),
    							"amāre"),
    					words.create(forms.verb(values.firstPerson(), values.perfect(), values.active(), values.singular(), values.indicative()),
    							"amavī"),
    					words.create(forms.verb(values.perfect(), values.passive(), values.participle(), values.nominative(), values.masculine(), values.singular()),
    							"amatus"),
    			}
        	},
        	{
        		"miror, mirari, miratus sum",
        		values.verb(),
        		new Word[] {
    					words.create(forms.verb(values.firstPerson(), values.present(), values.active(), values.singular(), values.indicative()),
    							"miror"),
    					words.create(forms.verb(values.present(), values.active(), values.infinitive()),
    							"mirārī"),
    					words.create(forms.verb(values.perfect(), values.active(), values.participle(), values.nominative(), values.masculine(), values.singular()),
    							"miratus"),
    			}
        	},
        	{
        		"miror, mirari, miratus",
        		values.verb(),
        		new Word[] {
    					words.create(forms.verb(values.firstPerson(), values.present(), values.active(), values.singular(), values.indicative()),
    							"miror"),
    					words.create(forms.verb(values.present(), values.active(), values.infinitive()),
    							"mirārī"),
    					words.create(forms.verb(values.perfect(), values.active(), values.participle(), values.nominative(), values.masculine(), values.singular()),
    							"miratus"),
    			}
        	},
        	{
        		"miror, mirari, miratum",
        		values.verb(),
        		new Word[] {
    					words.create(forms.verb(values.firstPerson(), values.present(), values.active(), values.singular(), values.indicative()),
    							"miror"),
    					words.create(forms.verb(values.present(), values.active(), values.infinitive()),
    							"mirārī"),
    					words.create(forms.verb(values.accusative(), values.supine()),
    							"miratum"),
    			}
        	},
        	{
        		"ac, atque",
        		values.conjunction(),
        		new Word[] {
        				words.create(forms.conjunction(), "ac"),
        				words.create(forms.conjunction(), "atque")
        		}
        	}
        });
    }
    
    private final String input;
    private final Value partOfSpeech;
    private final Multimap<Form, Word> expected;
    
    public LexemeCreateText (String input, Value partOfSpeech, Word[] expected) {
    	this.input = input;
    	this.partOfSpeech = partOfSpeech;
    	
    	ImmutableMultimap.Builder<Form, Word> builder = new ImmutableMultimap.Builder<Form, Word>();
    	
    	for (Word word : expected) {
    		builder.put(word.getForm(), word);
    	}
    	
    	this.expected = builder.build();
    }

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		Lexeme lexeme = lexemes.create(this.partOfSpeech, this.input);
		
		Field field = null;
		try {
			field = lexeme.getClass().getDeclaredField("principleParts");
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		field.setAccessible(true);
		
		Multimap<Form, Word> principleParts = null;
		try {
			principleParts = (Multimap<Form, Word>) field.get(lexeme);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		if (this.expected.size() != principleParts.size())
			fail ("Wanted: " + expected + "\nGot: " + principleParts);
		
		for (Word word : this.expected.values()) {
			if (!principleParts.containsEntry(word.getForm(), word))
				fail ("Wanted: " + expected + "\nGot: " + principleParts);
		}
	}

}
