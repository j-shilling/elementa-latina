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
import com.elementa.language.accidence.Types;
import com.elementa.language.accidence.Value;
import com.elementa.language.accidence.Values;
import com.elementa.language.alphabet.Letterifier;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.adjectives.AdjectiveStems;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.PhonemeString;
import com.elementa.language.phonology.Phonemifier;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Guice;
import com.google.inject.Injector;

@RunWith(Parameterized.class)
public class AdjectiveStemTest {
	
	private static Injector injector = Guice.createInjector(new TestLanguageModule());
	private static FormFactory forms = injector.getInstance(FormFactory.class);
	private static WordFactory words = injector.getInstance(WordFactory.class);
	private static Values values = injector.getInstance(Values.class);
	private static Types types = injector.getInstance(Types.class);
	
	private static Form[] allForms = new Form [] {
			forms.adjective(values.positive(), values.feminine(), values.singular(), values.genitive()),
			forms.adjective(values.positive(), values.feminine(), values.singular(), values.dative()),
			forms.adjective(values.positive(), values.feminine(), values.singular(), values.accusative()),
			forms.adjective(values.positive(), values.feminine(), values.singular(), values.ablative()),
			forms.adjective(values.positive(), values.feminine(), values.singular(), values.vocative()),
			forms.adjective(values.positive(), values.feminine(), values.singular(), values.locative()),
			forms.adjective(values.positive(), values.feminine(), values.plural(), values.nominative()),
			forms.adjective(values.positive(), values.feminine(), values.plural(), values.genitive()),
			forms.adjective(values.positive(), values.feminine(), values.plural(), values.dative()),
			forms.adjective(values.positive(), values.feminine(), values.plural(), values.accusative()),
			forms.adjective(values.positive(), values.feminine(), values.plural(), values.ablative()),
			forms.adjective(values.positive(), values.feminine(), values.plural(), values.vocative()),
			forms.adjective(values.positive(), values.feminine(), values.plural(), values.locative()),
			
			forms.adjective(values.positive(), values.masculine(), values.singular(), values.genitive()),
			forms.adjective(values.positive(), values.masculine(), values.singular(), values.dative()),
			forms.adjective(values.positive(), values.masculine(), values.singular(), values.accusative()),
			forms.adjective(values.positive(), values.masculine(), values.singular(), values.ablative()),
			forms.adjective(values.positive(), values.masculine(), values.singular(), values.locative()),
			forms.adjective(values.positive(), values.masculine(), values.plural(), values.nominative()),
			forms.adjective(values.positive(), values.masculine(), values.plural(), values.genitive()),
			forms.adjective(values.positive(), values.masculine(), values.plural(), values.dative()),
			forms.adjective(values.positive(), values.masculine(), values.plural(), values.accusative()),
			forms.adjective(values.positive(), values.masculine(), values.plural(), values.ablative()),
			forms.adjective(values.positive(), values.masculine(), values.plural(), values.vocative()),
			forms.adjective(values.positive(), values.masculine(), values.plural(), values.locative()),
			
			forms.adjective(values.positive(), values.neuter(), values.singular(), values.genitive()),
			forms.adjective(values.positive(), values.neuter(), values.singular(), values.dative()),
			forms.adjective(values.positive(), values.neuter(), values.singular(), values.accusative()),
			forms.adjective(values.positive(), values.neuter(), values.singular(), values.locative()),
			forms.adjective(values.positive(), values.neuter(), values.plural(), values.nominative()),
			forms.adjective(values.positive(), values.neuter(), values.plural(), values.genitive()),
			forms.adjective(values.positive(), values.neuter(), values.plural(), values.dative()),
			forms.adjective(values.positive(), values.neuter(), values.plural(), values.accusative()),
			forms.adjective(values.positive(), values.neuter(), values.plural(), values.ablative()),
			forms.adjective(values.positive(), values.neuter(), values.plural(), values.vocative()),
			forms.adjective(values.positive(), values.neuter(), values.plural(), values.locative()),
			
			forms.adjective(values.comparative(), values.feminine(), values.singular(), values.genitive()),
			forms.adjective(values.comparative(), values.feminine(), values.singular(), values.dative()),
			forms.adjective(values.comparative(), values.feminine(), values.singular(), values.accusative()),
			forms.adjective(values.comparative(), values.feminine(), values.singular(), values.ablative()),
			forms.adjective(values.comparative(), values.feminine(), values.singular(), values.vocative()),
			forms.adjective(values.comparative(), values.feminine(), values.singular(), values.locative()),
			forms.adjective(values.comparative(), values.feminine(), values.plural(), values.nominative()),
			forms.adjective(values.comparative(), values.feminine(), values.plural(), values.genitive()),
			forms.adjective(values.comparative(), values.feminine(), values.plural(), values.dative()),
			forms.adjective(values.comparative(), values.feminine(), values.plural(), values.accusative()),
			forms.adjective(values.comparative(), values.feminine(), values.plural(), values.ablative()),
			forms.adjective(values.comparative(), values.feminine(), values.plural(), values.vocative()),
			forms.adjective(values.comparative(), values.feminine(), values.plural(), values.locative()),
			
			forms.adjective(values.comparative(), values.masculine(), values.singular(), values.genitive()),
			forms.adjective(values.comparative(), values.masculine(), values.singular(), values.dative()),
			forms.adjective(values.comparative(), values.masculine(), values.singular(), values.accusative()),
			forms.adjective(values.comparative(), values.masculine(), values.singular(), values.ablative()),
			forms.adjective(values.comparative(), values.masculine(), values.singular(), values.locative()),
			forms.adjective(values.comparative(), values.masculine(), values.plural(), values.nominative()),
			forms.adjective(values.comparative(), values.masculine(), values.plural(), values.genitive()),
			forms.adjective(values.comparative(), values.masculine(), values.plural(), values.dative()),
			forms.adjective(values.comparative(), values.masculine(), values.plural(), values.accusative()),
			forms.adjective(values.comparative(), values.masculine(), values.plural(), values.ablative()),
			forms.adjective(values.comparative(), values.masculine(), values.plural(), values.vocative()),
			forms.adjective(values.comparative(), values.masculine(), values.plural(), values.locative()),
			
			forms.adjective(values.comparative(), values.neuter(), values.singular(), values.genitive()),
			forms.adjective(values.comparative(), values.neuter(), values.singular(), values.dative()),
			forms.adjective(values.comparative(), values.neuter(), values.singular(), values.locative()),
			forms.adjective(values.comparative(), values.neuter(), values.plural(), values.nominative()),
			forms.adjective(values.comparative(), values.neuter(), values.plural(), values.genitive()),
			forms.adjective(values.comparative(), values.neuter(), values.plural(), values.dative()),
			forms.adjective(values.comparative(), values.neuter(), values.plural(), values.accusative()),
			forms.adjective(values.comparative(), values.neuter(), values.plural(), values.ablative()),
			forms.adjective(values.comparative(), values.neuter(), values.plural(), values.vocative()),
			forms.adjective(values.comparative(), values.neuter(), values.plural(), values.locative()),
			
			forms.adjective(values.superlative(), values.feminine(), values.singular(), values.genitive()),
			forms.adjective(values.superlative(), values.feminine(), values.singular(), values.dative()),
			forms.adjective(values.superlative(), values.feminine(), values.singular(), values.accusative()),
			forms.adjective(values.superlative(), values.feminine(), values.singular(), values.ablative()),
			forms.adjective(values.superlative(), values.feminine(), values.singular(), values.vocative()),
			forms.adjective(values.superlative(), values.feminine(), values.singular(), values.locative()),
			forms.adjective(values.superlative(), values.feminine(), values.plural(), values.nominative()),
			forms.adjective(values.superlative(), values.feminine(), values.plural(), values.genitive()),
			forms.adjective(values.superlative(), values.feminine(), values.plural(), values.dative()),
			forms.adjective(values.superlative(), values.feminine(), values.plural(), values.accusative()),
			forms.adjective(values.superlative(), values.feminine(), values.plural(), values.ablative()),
			forms.adjective(values.superlative(), values.feminine(), values.plural(), values.vocative()),
			forms.adjective(values.superlative(), values.feminine(), values.plural(), values.locative()),
			
			forms.adjective(values.superlative(), values.masculine(), values.singular(), values.genitive()),
			forms.adjective(values.superlative(), values.masculine(), values.singular(), values.dative()),
			forms.adjective(values.superlative(), values.masculine(), values.singular(), values.accusative()),
			forms.adjective(values.superlative(), values.masculine(), values.singular(), values.ablative()),
			forms.adjective(values.superlative(), values.masculine(), values.singular(), values.locative()),
			forms.adjective(values.superlative(), values.masculine(), values.plural(), values.nominative()),
			forms.adjective(values.superlative(), values.masculine(), values.plural(), values.genitive()),
			forms.adjective(values.superlative(), values.masculine(), values.plural(), values.dative()),
			forms.adjective(values.superlative(), values.masculine(), values.plural(), values.accusative()),
			forms.adjective(values.superlative(), values.masculine(), values.plural(), values.ablative()),
			forms.adjective(values.superlative(), values.masculine(), values.plural(), values.vocative()),
			forms.adjective(values.superlative(), values.masculine(), values.plural(), values.locative()),
			
			forms.adjective(values.superlative(), values.neuter(), values.singular(), values.genitive()),
			forms.adjective(values.superlative(), values.neuter(), values.singular(), values.dative()),
			forms.adjective(values.superlative(), values.neuter(), values.singular(), values.accusative()),
			forms.adjective(values.superlative(), values.neuter(), values.singular(), values.locative()),
			forms.adjective(values.superlative(), values.neuter(), values.plural(), values.nominative()),
			forms.adjective(values.superlative(), values.neuter(), values.plural(), values.genitive()),
			forms.adjective(values.superlative(), values.neuter(), values.plural(), values.dative()),
			forms.adjective(values.superlative(), values.neuter(), values.plural(), values.accusative()),
			forms.adjective(values.superlative(), values.neuter(), values.plural(), values.ablative()),
			forms.adjective(values.superlative(), values.neuter(), values.plural(), values.vocative()),
			forms.adjective(values.superlative(), values.neuter(), values.plural(), values.locative()),
	};
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()), "laetus"),
	        			words.create(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()), "laeta"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "laetum"),
	        	},
	        	
	        	"laet",
	        	"laetiōr",
	        	"laetissim"
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()), "miser"),
	        			words.create(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()), "misera"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "miserum"),
	        	},
	        	
	        	"miser",
	        	"miseriōr",
	        	"miserrim"
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()), "pulcher"),
	        			words.create(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()), "pulchra"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "pulchrum"),
	        	},
	        	
	        	"pulchr",
	        	"pulchriōr",
	        	"pulcherrim"
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()), "acer"),
	        			words.create(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()), "acris"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "acre"),
	        	},
	        	
	        	"acr",
	        	"acriōr",
	        	"acerrim"
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()), "levis"),
	        			words.create(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()), "levis"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "leve"),
	        	},
	        	
	        	"lev",
	        	"leviōr",
	        	"levissim"
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.common(), values.nominative(), values.singular()), "levis"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "leve"),
	        	},
	        	
	        	"lev",
	        	"leviōr",
	        	"levissim"
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.masculine(), values.nominative(), values.singular()), "atrox"),
	        			words.create(forms.adjective(values.positive(), values.feminine(), values.nominative(), values.singular()), "atrox"),
	        			words.create(forms.adjective(values.positive(), values.neuter(), values.nominative(), values.singular()), "atrox"),
	        	},
	        	
	        	"atroc",
	        	"atrociōr",
	        	"atrocissim"
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.omnium(), values.nominative(), values.singular()), "atrox")
	        	},
	        	
	        	"atroc",
	        	"atrociōr",
	        	"atrocissim"
        	},
        	{
	        	new Word[] {
	        			words.create(forms.adjective(values.positive(), values.omnium(), values.nominative(), values.singular()), "egens")
	        	},
	        	
	        	"egent",
	        	"egentiōr",
	        	"egentissim"
        	}
        });
    }
    
    private final Multimap<Value, HasPhonemes> expected;
    private final Word[] pps;
    
    public AdjectiveStemTest (Word[] pps, String pos, String com, String sup) {
    	this.pps = pps;
    	
    	Letterifier letterifier = injector.getInstance(Letterifier.class);
    	Phonemifier phonemifier = injector.getInstance(Phonemifier.class);
    	ImmutableMultimap.Builder<Value, HasPhonemes> builder = new ImmutableMultimap.Builder<>();
    	builder.put(values.positive(), new PhonemeString(phonemifier.phonemify(letterifier.letterify(pos))));
    	builder.put(values.comparative(), new PhonemeString(phonemifier.phonemify(letterifier.letterify(com))));
    	builder.put(values.superlative(), new PhonemeString(phonemifier.phonemify(letterifier.letterify(sup))));
    	this.expected = builder.build();
    }
	@Test
	public void test() {
		ImmutableMultimap.Builder<Form, Word> builder = new ImmutableMultimap.Builder<>();
    	
    	for (Word word : pps) {
    		builder.put(word.getForm(), word);
    	}
    	
    	Multimap<Form, Word> principleParts = builder.build();
    	AdjectiveStems stems = injector.getInstance(AdjectiveStems.class);
    	
    	for (Form form : allForms) {
    		Value degree = form.get(types.Degree()).get();
    		
    		Collection<HasPhonemes> wanted = this.expected.get(degree);
    		Collection<HasPhonemes> result = stems.get(principleParts, form);
    		
    		if (result.size() != wanted.size()) {
    			fail ("Wanted: " + wanted + "\nGot: " + result + "\n");
    		}
    		
    		for (HasPhonemes x : wanted) {
    			if (!result.contains(x)) {
    				fail ("Wanted: " + wanted + "\nGot: " + result + "\n");
    			}
    		}
    	}
	}

}
