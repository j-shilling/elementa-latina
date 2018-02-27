package com.elementa.language.morphology.noun;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import com.elementa.language.Lexeme;
import com.elementa.language.LexemeFactory;
import com.elementa.language.TestLanguageModule;
import com.elementa.language.Word;
import com.elementa.language.WordFactory;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.google.common.collect.ImmutableMultimap;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class NounLexemeMultiStemTest {

	@Test
	public void test() {
		Injector injector = Guice.createInjector(new TestLanguageModule());
		WordFactory words = injector.getInstance(WordFactory.class);
		FormFactory forms = injector.getInstance(FormFactory.class);
		LexemeFactory lexemes = injector.getInstance(LexemeFactory.class);
		Values values = injector.getInstance(Values.class);
		
		Form[] allForms = new Form [] {
				forms.noun(values.feminine(), values.singular(), values.nominative()),
				forms.noun(values.feminine(), values.singular(), values.genitive()),
				forms.noun(values.feminine(), values.singular(), values.dative()),
				forms.noun(values.feminine(), values.singular(), values.accusative()),
				forms.noun(values.feminine(), values.singular(), values.ablative()),
				forms.noun(values.feminine(), values.singular(), values.vocative()),
				forms.noun(values.feminine(), values.singular(), values.locative()),
				forms.noun(values.feminine(), values.plural(), values.nominative()),
				forms.noun(values.feminine(), values.plural(), values.genitive()),
				forms.noun(values.feminine(), values.plural(), values.dative()),
				forms.noun(values.feminine(), values.plural(), values.accusative()),
				forms.noun(values.feminine(), values.plural(), values.ablative()),
				forms.noun(values.feminine(), values.plural(), values.vocative()),
				forms.noun(values.feminine(), values.plural(), values.locative()),
				
				forms.noun(values.masculine(), values.singular(), values.nominative()),
				forms.noun(values.masculine(), values.singular(), values.genitive()),
				forms.noun(values.masculine(), values.singular(), values.dative()),
				forms.noun(values.masculine(), values.singular(), values.accusative()),
				forms.noun(values.masculine(), values.singular(), values.ablative()),
				forms.noun(values.masculine(), values.singular(), values.vocative()),
				forms.noun(values.masculine(), values.singular(), values.locative()),
				forms.noun(values.masculine(), values.plural(), values.nominative()),
				forms.noun(values.masculine(), values.plural(), values.genitive()),
				forms.noun(values.masculine(), values.plural(), values.dative()),
				forms.noun(values.masculine(), values.plural(), values.accusative()),
				forms.noun(values.masculine(), values.plural(), values.ablative()),
				forms.noun(values.masculine(), values.plural(), values.vocative()),
				forms.noun(values.masculine(), values.plural(), values.locative()),
				
				forms.noun(values.neuter(), values.singular(), values.nominative()),
				forms.noun(values.neuter(), values.singular(), values.genitive()),
				forms.noun(values.neuter(), values.singular(), values.dative()),
				forms.noun(values.neuter(), values.singular(), values.accusative()),
				forms.noun(values.neuter(), values.singular(), values.ablative()),
				forms.noun(values.neuter(), values.singular(), values.vocative()),
				forms.noun(values.neuter(), values.singular(), values.locative()),
				forms.noun(values.neuter(), values.plural(), values.nominative()),
				forms.noun(values.neuter(), values.plural(), values.genitive()),
				forms.noun(values.neuter(), values.plural(), values.dative()),
				forms.noun(values.neuter(), values.plural(), values.accusative()),
				forms.noun(values.neuter(), values.plural(), values.ablative()),
				forms.noun(values.neuter(), values.plural(), values.vocative()),
				forms.noun(values.neuter(), values.plural(), values.locative()),
		};
		
		Word nom1 = words.create(forms.noun(values.neuter(), values.nominative(), values.singular()), "saeculum");
		Word nom2 = words.create(forms.noun(values.neuter(), values.nominative(), values.singular()), "saeclum");
		Word gen1 = words.create(forms.noun(values.neuter(), values.genitive(), values.singular()), "saeculī");
		Word gen2 = words.create(forms.noun(values.neuter(), values.genitive(), values.singular()), "saeclī");
		
		Word[] expected = new Word[] {
				words.create(forms.noun(values.nominative(), values.neuter(), values.singular()), "saeculum"),
				words.create(forms.noun(values.genitive(), values.neuter(), values.singular()), "saeculī"),
				words.create(forms.noun(values.dative(), values.neuter(), values.singular()), "saeculō"),
				words.create(forms.noun(values.accusative(), values.neuter(), values.singular()), "saeculum"),
				words.create(forms.noun(values.ablative(), values.neuter(), values.singular()), "saeculō"),
				words.create(forms.noun(values.vocative(), values.neuter(), values.singular()), "saeculum"),
				words.create(forms.noun(values.locative(), values.neuter(), values.singular()), "saeculī"),
				
				words.create(forms.noun(values.nominative(), values.neuter(), values.plural()), "saecula"),
				words.create(forms.noun(values.genitive(), values.neuter(), values.plural()), "saeculōrum"),
				words.create(forms.noun(values.dative(), values.neuter(), values.plural()), "saeculīs"),
				words.create(forms.noun(values.accusative(), values.neuter(), values.plural()), "saecula"),
				words.create(forms.noun(values.ablative(), values.neuter(), values.plural()), "saeculīs"),
				words.create(forms.noun(values.vocative(), values.neuter(), values.plural()), "saecula"),
				words.create(forms.noun(values.locative(), values.neuter(), values.plural()), "saeculīs"),
				
				words.create(forms.noun(values.nominative(), values.neuter(), values.singular()), "saeclum"),
				words.create(forms.noun(values.genitive(), values.neuter(), values.singular()), "saeclī"),
				words.create(forms.noun(values.dative(), values.neuter(), values.singular()), "saeclō"),
				words.create(forms.noun(values.accusative(), values.neuter(), values.singular()), "saeclum"),
				words.create(forms.noun(values.ablative(), values.neuter(), values.singular()), "saeclō"),
				words.create(forms.noun(values.vocative(), values.neuter(), values.singular()), "saeclum"),
				words.create(forms.noun(values.locative(), values.neuter(), values.singular()), "saeclī"),
				
				words.create(forms.noun(values.nominative(), values.neuter(), values.plural()), "saecla"),
				words.create(forms.noun(values.genitive(), values.neuter(), values.plural()), "saeclōrum"),
				words.create(forms.noun(values.dative(), values.neuter(), values.plural()), "saeclīs"),
				words.create(forms.noun(values.accusative(), values.neuter(), values.plural()), "saecla"),
				words.create(forms.noun(values.ablative(), values.neuter(), values.plural()), "saeclīs"),
				words.create(forms.noun(values.vocative(), values.neuter(), values.plural()), "saecla"),
				words.create(forms.noun(values.locative(), values.neuter(), values.plural()), "saeclīs"),
		};
		
		ImmutableMultimap.Builder<Form, Word> builder = new ImmutableMultimap.Builder<>();
    	for (Word word : expected) {
    		builder.put(word.getForm(), word);
    	}
    	
    	ImmutableMultimap<Form, Word> table = builder.build();
    	
    	Lexeme lexeme = lexemes.noun(nom1, gen1, nom2, gen2);
    	
    	for (Form form : allForms) {
			Collection<Word> result = lexeme.get(form);
			Collection<Word> wanted = table.get(form);
			
			if (result.size() != wanted.size()) {
				fail (form + " did not give the expected number of responses\n"
						+ "We wanted: " + wanted.toString() + "\n"
						+ "We got: " + result.toString());
			}
			
			for (Word word : wanted) {
				boolean found = false;
				
				for (Word x : result) {
					if (x.equals(word)) {
						found = true;
						break;
					}
				}
				
				if (!found) {
					fail ("Did not form " + form + " correctly.\n"
							+ "We wanted: " + wanted.toString() + "\n"
							+ "We got: " + result.toString());
				}
			}
		}
	}

}
