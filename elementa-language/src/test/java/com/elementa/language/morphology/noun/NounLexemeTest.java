package com.elementa.language.morphology.noun;

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
import com.elementa.language.accidence.Value;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Guice;
import com.google.inject.Injector;

@RunWith(Parameterized.class)
public class NounLexemeTest {
	
	private static Injector injector = Guice.createInjector(new TestLanguageModule());
	private static FormFactory forms = injector.getInstance(FormFactory.class);
	private static WordFactory words = injector.getInstance(WordFactory.class);
	private static LexemeFactory lexemes = injector.getInstance(LexemeFactory.class);
	private static Values values = injector.getInstance(Values.class);
	
	private static Form[] allForms = new Form [] {
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
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        	{
        		"ancilla",
        		"ancillae",
        		values.feminine(),
        		values.singular(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.feminine(), values.singular()), "ancilla"),
        				words.create(forms.noun(values.genitive(), values.feminine(), values.singular()), "ancillae"),
        				words.create(forms.noun(values.dative(), values.feminine(), values.singular()), "ancillae"),
        				words.create(forms.noun(values.accusative(), values.feminine(), values.singular()), "ancillam"),
        				words.create(forms.noun(values.ablative(), values.feminine(), values.singular()), "ancillā"),
        				words.create(forms.noun(values.vocative(), values.feminine(), values.singular()), "ancilla"),
        				words.create(forms.noun(values.locative(), values.feminine(), values.singular()), "ancillae"),
        				
        				words.create(forms.noun(values.nominative(), values.feminine(), values.plural()), "ancillae"),
        				words.create(forms.noun(values.genitive(), values.feminine(), values.plural()), "ancillārum"),
        				words.create(forms.noun(values.dative(), values.feminine(), values.plural()), "ancillīs"),
        				words.create(forms.noun(values.accusative(), values.feminine(), values.plural()), "ancillās"),
        				words.create(forms.noun(values.ablative(), values.feminine(), values.plural()), "ancillīs"),
        				words.create(forms.noun(values.vocative(), values.feminine(), values.plural()), "ancillae"),
        				words.create(forms.noun(values.locative(), values.feminine(), values.plural()), "ancillīs"),
        		}
        	},
        	{
        		"Athenae",
        		"Athenārum",
        		values.feminine(),
        		values.plural(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.feminine(), values.plural()), "athenae"),
        				words.create(forms.noun(values.genitive(), values.feminine(), values.plural()), "athenārum"),
        				words.create(forms.noun(values.dative(), values.feminine(), values.plural()), "athenīs"),
        				words.create(forms.noun(values.accusative(), values.feminine(), values.plural()), "athenās"),
        				words.create(forms.noun(values.ablative(), values.feminine(), values.plural()), "athenīs"),
        				words.create(forms.noun(values.vocative(), values.feminine(), values.plural()), "athenae"),
        				words.create(forms.noun(values.locative(), values.feminine(), values.plural()), "athenīs"),
        		}
        	},
        	{
        		"servus",
        		"servī",
        		values.masculine(),
        		values.singular(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.masculine(), values.singular()), "servus"),
        				words.create(forms.noun(values.genitive(), values.masculine(), values.singular()), "servī"),
        				words.create(forms.noun(values.dative(), values.masculine(), values.singular()), "servō"),
        				words.create(forms.noun(values.accusative(), values.masculine(), values.singular()), "servum"),
        				words.create(forms.noun(values.ablative(), values.masculine(), values.singular()), "servō"),
        				words.create(forms.noun(values.vocative(), values.masculine(), values.singular()), "serve"),
        				words.create(forms.noun(values.locative(), values.masculine(), values.singular()), "servī"),
        				
        				words.create(forms.noun(values.nominative(), values.masculine(), values.plural()), "servī"),
        				words.create(forms.noun(values.genitive(), values.masculine(), values.plural()), "servōrum"),
        				words.create(forms.noun(values.dative(), values.masculine(), values.plural()), "servīs"),
        				words.create(forms.noun(values.accusative(), values.masculine(), values.plural()), "servōs"),
        				words.create(forms.noun(values.ablative(), values.masculine(), values.plural()), "servīs"),
        				words.create(forms.noun(values.vocative(), values.masculine(), values.plural()), "servī"),
        				words.create(forms.noun(values.locative(), values.masculine(), values.plural()), "servīs"),
        		}
        	},
        	{
        		"Accī",
        		"Accōrum",
        		values.masculine(),
        		values.plural(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.masculine(), values.plural()), "accī"),
        				words.create(forms.noun(values.genitive(), values.masculine(), values.plural()), "accōrum"),
        				words.create(forms.noun(values.dative(), values.masculine(), values.plural()), "accīs"),
        				words.create(forms.noun(values.accusative(), values.masculine(), values.plural()), "accōs"),
        				words.create(forms.noun(values.ablative(), values.masculine(), values.plural()), "accīs"),
        				words.create(forms.noun(values.vocative(), values.masculine(), values.plural()), "accī"),
        				words.create(forms.noun(values.locative(), values.masculine(), values.plural()), "accīs"),
        		}
        	},
        	{
        		"filius",
        		"filiī",
        		values.masculine(),
        		values.singular(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.masculine(), values.singular()), "filius"),
        				words.create(forms.noun(values.genitive(), values.masculine(), values.singular()), "filiī"),
        				words.create(forms.noun(values.dative(), values.masculine(), values.singular()), "filiō"),
        				words.create(forms.noun(values.accusative(), values.masculine(), values.singular()), "filium"),
        				words.create(forms.noun(values.ablative(), values.masculine(), values.singular()), "filiō"),
        				words.create(forms.noun(values.vocative(), values.masculine(), values.singular()), "filī"),
        				words.create(forms.noun(values.locative(), values.masculine(), values.singular()), "filiī"),
        				
        				words.create(forms.noun(values.nominative(), values.masculine(), values.plural()), "filiī"),
        				words.create(forms.noun(values.genitive(), values.masculine(), values.plural()), "filiōrum"),
        				words.create(forms.noun(values.dative(), values.masculine(), values.plural()), "filiīs"),
        				words.create(forms.noun(values.accusative(), values.masculine(), values.plural()), "filiōs"),
        				words.create(forms.noun(values.ablative(), values.masculine(), values.plural()), "filiīs"),
        				words.create(forms.noun(values.vocative(), values.masculine(), values.plural()), "filiī"),
        				words.create(forms.noun(values.locative(), values.masculine(), values.plural()), "filiīs"),
        		}
        	},
        	{
        		"templum",
        		"templī",
        		values.neuter(),
        		values.singular(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.neuter(), values.singular()), "templum"),
        				words.create(forms.noun(values.genitive(), values.neuter(), values.singular()), "templī"),
        				words.create(forms.noun(values.dative(), values.neuter(), values.singular()), "templō"),
        				words.create(forms.noun(values.accusative(), values.neuter(), values.singular()), "templum"),
        				words.create(forms.noun(values.ablative(), values.neuter(), values.singular()), "templō"),
        				words.create(forms.noun(values.vocative(), values.neuter(), values.singular()), "templum"),
        				words.create(forms.noun(values.locative(), values.neuter(), values.singular()), "templī"),
        				
        				words.create(forms.noun(values.nominative(), values.neuter(), values.plural()), "templa"),
        				words.create(forms.noun(values.genitive(), values.neuter(), values.plural()), "templōrum"),
        				words.create(forms.noun(values.dative(), values.neuter(), values.plural()), "templīs"),
        				words.create(forms.noun(values.accusative(), values.neuter(), values.plural()), "templa"),
        				words.create(forms.noun(values.ablative(), values.neuter(), values.plural()), "templīs"),
        				words.create(forms.noun(values.vocative(), values.neuter(), values.plural()), "templa"),
        				words.create(forms.noun(values.locative(), values.neuter(), values.plural()), "templīs"),
        		}
        	},
        	
        	{
        		"castra",
        		"castrōrum",
        		values.neuter(),
        		values.plural(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.neuter(), values.plural()), "castra"),
        				words.create(forms.noun(values.genitive(), values.neuter(), values.plural()), "castrōrum"),
        				words.create(forms.noun(values.dative(), values.neuter(), values.plural()), "castrīs"),
        				words.create(forms.noun(values.accusative(), values.neuter(), values.plural()), "castra"),
        				words.create(forms.noun(values.ablative(), values.neuter(), values.plural()), "castrīs"),
        				words.create(forms.noun(values.vocative(), values.neuter(), values.plural()), "castra"),
        				words.create(forms.noun(values.locative(), values.neuter(), values.plural()), "castrīs"),
        		}
        	},
        	{
        		"dux",
        		"ducis",
        		values.masculine(),
        		values.singular(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.masculine(), values.singular()), "dux"),
        				words.create(forms.noun(values.genitive(), values.masculine(), values.singular()), "ducis"),
        				words.create(forms.noun(values.dative(), values.masculine(), values.singular()), "ducī"),
        				words.create(forms.noun(values.accusative(), values.masculine(), values.singular()), "ducem"),
        				words.create(forms.noun(values.ablative(), values.masculine(), values.singular()), "duce"),
        				words.create(forms.noun(values.vocative(), values.masculine(), values.singular()), "dux"),
        				words.create(forms.noun(values.locative(), values.masculine(), values.singular()), "duce"),
        				words.create(forms.noun(values.locative(), values.masculine(), values.singular()), "ducī"),
        				
        				words.create(forms.noun(values.nominative(), values.masculine(), values.plural()), "ducēs"),
        				words.create(forms.noun(values.genitive(), values.masculine(), values.plural()), "ducum"),
        				words.create(forms.noun(values.dative(), values.masculine(), values.plural()), "ducibus"),
        				words.create(forms.noun(values.accusative(), values.masculine(), values.plural()), "ducēs"),
        				words.create(forms.noun(values.ablative(), values.masculine(), values.plural()), "ducibus"),
        				words.create(forms.noun(values.vocative(), values.masculine(), values.plural()), "ducēs"),
        				words.create(forms.noun(values.locative(), values.masculine(), values.plural()), "ducibus"),
        		}
        	},
        	{
        		"caput",
        		"capitis",
        		values.neuter(),
        		values.singular(),
        		

        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.neuter(), values.singular()), "caput"),
        				words.create(forms.noun(values.genitive(), values.neuter(), values.singular()), "capitis"),
        				words.create(forms.noun(values.dative(), values.neuter(), values.singular()), "capitī"),
        				words.create(forms.noun(values.accusative(), values.neuter(), values.singular()), "caput"),
        				words.create(forms.noun(values.ablative(), values.neuter(), values.singular()), "capite"),
        				words.create(forms.noun(values.vocative(), values.neuter(), values.singular()), "caput"),
        				words.create(forms.noun(values.locative(), values.neuter(), values.singular()), "capite"),
        				words.create(forms.noun(values.locative(), values.neuter(), values.singular()), "capitī"),
        				
        				words.create(forms.noun(values.nominative(), values.neuter(), values.plural()), "capita"),
        				words.create(forms.noun(values.genitive(), values.neuter(), values.plural()), "capitum"),
        				words.create(forms.noun(values.dative(), values.neuter(), values.plural()), "capitibus"),
        				words.create(forms.noun(values.accusative(), values.neuter(), values.plural()), "capita"),
        				words.create(forms.noun(values.ablative(), values.neuter(), values.plural()), "capitibus"),
        				words.create(forms.noun(values.vocative(), values.neuter(), values.plural()), "capita"),
        				words.create(forms.noun(values.locative(), values.neuter(), values.plural()), "capitibus"),
        		}
        	},
        	{
        		"nox",
        		"noctis",
        		values.feminine(),
        		values.singular(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.feminine(), values.singular()), "nox"),
        				words.create(forms.noun(values.genitive(), values.feminine(), values.singular()), "noctis"),
        				words.create(forms.noun(values.dative(), values.feminine(), values.singular()), "noctī"),
        				words.create(forms.noun(values.accusative(), values.feminine(), values.singular()), "noctem"),
        				words.create(forms.noun(values.ablative(), values.feminine(), values.singular()), "nocte"),
        				words.create(forms.noun(values.vocative(), values.feminine(), values.singular()), "nox"),
        				words.create(forms.noun(values.locative(), values.feminine(), values.singular()), "nocte"),
        				words.create(forms.noun(values.locative(), values.feminine(), values.singular()), "noctī"),
        				
        				words.create(forms.noun(values.nominative(), values.feminine(), values.plural()), "noctēs"),
        				words.create(forms.noun(values.genitive(), values.feminine(), values.plural()), "noctium"),
        				words.create(forms.noun(values.dative(), values.feminine(), values.plural()), "noctibus"),
        				words.create(forms.noun(values.accusative(), values.feminine(), values.plural()), "noctēs"),
        				words.create(forms.noun(values.accusative(), values.feminine(), values.plural()), "noctīs"),
        				words.create(forms.noun(values.ablative(), values.feminine(), values.plural()), "noctibus"),
        				words.create(forms.noun(values.vocative(), values.feminine(), values.plural()), "noctēs"),
        				words.create(forms.noun(values.locative(), values.feminine(), values.plural()), "noctibus"),
        		}
        	},
        	{
        		"nubes",
        		"nubis",
        		values.feminine(),
        		values.singular(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.feminine(), values.singular()), "nubes"),
        				words.create(forms.noun(values.genitive(), values.feminine(), values.singular()), "nubis"),
        				words.create(forms.noun(values.dative(), values.feminine(), values.singular()), "nubī"),
        				words.create(forms.noun(values.accusative(), values.feminine(), values.singular()), "nubem"),
        				words.create(forms.noun(values.ablative(), values.feminine(), values.singular()), "nube"),
        				words.create(forms.noun(values.vocative(), values.feminine(), values.singular()), "nubes"),
        				words.create(forms.noun(values.locative(), values.feminine(), values.singular()), "nube"),
        				words.create(forms.noun(values.locative(), values.feminine(), values.singular()), "nubī"),
        				
        				words.create(forms.noun(values.nominative(), values.feminine(), values.plural()), "nubēs"),
        				words.create(forms.noun(values.genitive(), values.feminine(), values.plural()), "nubium"),
        				words.create(forms.noun(values.dative(), values.feminine(), values.plural()), "nubibus"),
        				words.create(forms.noun(values.accusative(), values.feminine(), values.plural()), "nubēs"),
        				words.create(forms.noun(values.accusative(), values.feminine(), values.plural()), "nubīs"),
        				words.create(forms.noun(values.ablative(), values.feminine(), values.plural()), "nubibus"),
        				words.create(forms.noun(values.vocative(), values.feminine(), values.plural()), "nubēs"),
        				words.create(forms.noun(values.locative(), values.feminine(), values.plural()), "nubibus"),
        		}
        	},
        	{
        		"sedile",
        		"sedilis",
        		values.neuter(),
        		values.singular(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.neuter(), values.singular()), "sedile"),
        				words.create(forms.noun(values.genitive(), values.neuter(), values.singular()), "sedilis"),
        				words.create(forms.noun(values.dative(), values.neuter(), values.singular()), "sedilī"),
        				words.create(forms.noun(values.accusative(), values.neuter(), values.singular()), "sedile"),
        				words.create(forms.noun(values.ablative(), values.neuter(), values.singular()), "sedilī"),
        				words.create(forms.noun(values.vocative(), values.neuter(), values.singular()), "sedile"),
        				words.create(forms.noun(values.locative(), values.neuter(), values.singular()), "sedilī"),
        				
        				words.create(forms.noun(values.nominative(), values.neuter(), values.plural()), "sedilia"),
        				words.create(forms.noun(values.genitive(), values.neuter(), values.plural()), "sedilium"),
        				words.create(forms.noun(values.dative(), values.neuter(), values.plural()), "sedilibus"),
        				words.create(forms.noun(values.accusative(), values.neuter(), values.plural()), "sedilia"),
        				words.create(forms.noun(values.ablative(), values.neuter(), values.plural()), "sedilibus"),
        				words.create(forms.noun(values.vocative(), values.neuter(), values.plural()), "sedilia"),
        				words.create(forms.noun(values.locative(), values.neuter(), values.plural()), "sedilibus"),
        		}
        	},
        	{
        		"animal",
        		"animalis",
        		values.neuter(),
        		values.singular(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.neuter(), values.singular()), "animal"),
        				words.create(forms.noun(values.genitive(), values.neuter(), values.singular()), "animalis"),
        				words.create(forms.noun(values.dative(), values.neuter(), values.singular()), "animalī"),
        				words.create(forms.noun(values.accusative(), values.neuter(), values.singular()), "animal"),
        				words.create(forms.noun(values.ablative(), values.neuter(), values.singular()), "animalī"),
        				words.create(forms.noun(values.vocative(), values.neuter(), values.singular()), "animal"),
        				words.create(forms.noun(values.locative(), values.neuter(), values.singular()), "animalī"),
        				
        				words.create(forms.noun(values.nominative(), values.neuter(), values.plural()), "animalia"),
        				words.create(forms.noun(values.genitive(), values.neuter(), values.plural()), "animalium"),
        				words.create(forms.noun(values.dative(), values.neuter(), values.plural()), "animalibus"),
        				words.create(forms.noun(values.accusative(), values.neuter(), values.plural()), "animalia"),
        				words.create(forms.noun(values.ablative(), values.neuter(), values.plural()), "animalibus"),
        				words.create(forms.noun(values.vocative(), values.neuter(), values.plural()), "animalia"),
        				words.create(forms.noun(values.locative(), values.neuter(), values.plural()), "animalibus"),
        		}
        	},
        	{
        		"calcar",
        		"calcaris",
        		values.neuter(),
        		values.singular(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.neuter(), values.singular()), "calcar"),
        				words.create(forms.noun(values.genitive(), values.neuter(), values.singular()), "calcaris"),
        				words.create(forms.noun(values.dative(), values.neuter(), values.singular()), "calcarī"),
        				words.create(forms.noun(values.accusative(), values.neuter(), values.singular()), "calcar"),
        				words.create(forms.noun(values.ablative(), values.neuter(), values.singular()), "calcarī"),
        				words.create(forms.noun(values.vocative(), values.neuter(), values.singular()), "calcar"),
        				words.create(forms.noun(values.locative(), values.neuter(), values.singular()), "calcarī"),
        				
        				words.create(forms.noun(values.nominative(), values.neuter(), values.plural()), "calcaria"),
        				words.create(forms.noun(values.genitive(), values.neuter(), values.plural()), "calcarium"),
        				words.create(forms.noun(values.dative(), values.neuter(), values.plural()), "calcaribus"),
        				words.create(forms.noun(values.accusative(), values.neuter(), values.plural()), "calcaria"),
        				words.create(forms.noun(values.ablative(), values.neuter(), values.plural()), "calcaribus"),
        				words.create(forms.noun(values.vocative(), values.neuter(), values.plural()), "calcaria"),
        				words.create(forms.noun(values.locative(), values.neuter(), values.plural()), "calcaribus"),
        		}
        	},
        	{
        		"Saturnalia",
        		"Saturnalium",
        		values.neuter(),
        		values.plural(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.neuter(), values.plural()), "saturnalia"),
        				words.create(forms.noun(values.genitive(), values.neuter(), values.plural()), "saturnalium"),
        				words.create(forms.noun(values.dative(), values.neuter(), values.plural()), "saturnalibus"),
        				words.create(forms.noun(values.accusative(), values.neuter(), values.plural()), "saturnalia"),
        				words.create(forms.noun(values.ablative(), values.neuter(), values.plural()), "saturnalibus"),
        				words.create(forms.noun(values.vocative(), values.neuter(), values.plural()), "saturnalia"),
        				words.create(forms.noun(values.locative(), values.neuter(), values.plural()), "saturnalibus"),
        		}
        	},
        	{
        		"larēs",
        		"Larum",
        		values.masculine(),
        		values.plural(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.masculine(), values.plural()), "larēs"),
        				words.create(forms.noun(values.genitive(), values.masculine(), values.plural()), "larum"),
        				words.create(forms.noun(values.dative(), values.masculine(), values.plural()), "laribus"),
        				words.create(forms.noun(values.accusative(), values.masculine(), values.plural()), "larēs"),
        				words.create(forms.noun(values.ablative(), values.masculine(), values.plural()), "laribus"),
        				words.create(forms.noun(values.vocative(), values.masculine(), values.plural()), "larēs"),
        				words.create(forms.noun(values.locative(), values.masculine(), values.plural()), "laribus"),
        		}
        	},
        	{
        		"manus",
        		"manūs",
        		values.feminine(),
        		values.singular(),
        		
        		new Word[] {
	        		words.create(forms.noun(values.nominative(), values.feminine(), values.singular()), "manus"),
					words.create(forms.noun(values.genitive(), values.feminine(), values.singular()), "manūs"),
					words.create(forms.noun(values.dative(), values.feminine(), values.singular()), "manuī"),
					words.create(forms.noun(values.dative(), values.feminine(), values.singular()), "manū"),
					words.create(forms.noun(values.accusative(), values.feminine(), values.singular()), "manum"),
					words.create(forms.noun(values.ablative(), values.feminine(), values.singular()), "manū"),
					words.create(forms.noun(values.vocative(), values.feminine(), values.singular()), "manus"),
					
					words.create(forms.noun(values.nominative(), values.feminine(), values.plural()), "manūs"),
					words.create(forms.noun(values.genitive(), values.feminine(), values.plural()), "manuum"),
					words.create(forms.noun(values.dative(), values.feminine(), values.plural()), "manibus"),
					words.create(forms.noun(values.accusative(), values.feminine(), values.plural()), "manūs"),
					words.create(forms.noun(values.ablative(), values.feminine(), values.plural()), "manibus"),
					words.create(forms.noun(values.vocative(), values.feminine(), values.plural()), "manūs")
        		}
        	},
        	{
        		"lacus",
        		"lacūs",
        		values.masculine(),
        		values.singular(),
        		
        		new Word[] {
    	        		words.create(forms.noun(values.nominative(), values.masculine(), values.singular()), "lacus"),
    					words.create(forms.noun(values.genitive(), values.masculine(), values.singular()), "lacūs"),
    					words.create(forms.noun(values.dative(), values.masculine(), values.singular()), "lacuī"),
    					words.create(forms.noun(values.dative(), values.masculine(), values.singular()), "lacū"),
    					words.create(forms.noun(values.accusative(), values.masculine(), values.singular()), "lacum"),
    					words.create(forms.noun(values.ablative(), values.masculine(), values.singular()), "lacū"),
    					words.create(forms.noun(values.vocative(), values.masculine(), values.singular()), "lacus"),
    					
    					words.create(forms.noun(values.nominative(), values.masculine(), values.plural()), "lacūs"),
    					words.create(forms.noun(values.genitive(), values.masculine(), values.plural()), "lacuum"),
    					words.create(forms.noun(values.dative(), values.masculine(), values.plural()), "lacibus"),
    					words.create(forms.noun(values.accusative(), values.masculine(), values.plural()), "lacūs"),
    					words.create(forms.noun(values.ablative(), values.masculine(), values.plural()), "lacibus"),
    					words.create(forms.noun(values.vocative(), values.masculine(), values.plural()), "lacūs")
            	}
        	},
        	{
        		"genū",
        		"genūs",
        		values.neuter(),
        		values.singular(),
        		
        		new Word[] {
    	        		words.create(forms.noun(values.nominative(), values.neuter(), values.singular()), "genū"),
    					words.create(forms.noun(values.genitive(), values.neuter(), values.singular()), "genūs"),
    					words.create(forms.noun(values.dative(), values.neuter(), values.singular()), "genū"),
    					words.create(forms.noun(values.accusative(), values.neuter(), values.singular()), "genū"),
    					words.create(forms.noun(values.ablative(), values.neuter(), values.singular()), "genū"),
    					words.create(forms.noun(values.vocative(), values.neuter(), values.singular()), "genū"),
    					
    					words.create(forms.noun(values.nominative(), values.neuter(), values.plural()), "genua"),
    					words.create(forms.noun(values.genitive(), values.neuter(), values.plural()), "genuum"),
    					words.create(forms.noun(values.dative(), values.neuter(), values.plural()), "genibus"),
    					words.create(forms.noun(values.accusative(), values.neuter(), values.plural()), "genua"),
    					words.create(forms.noun(values.ablative(), values.neuter(), values.plural()), "genibus"),
    					words.create(forms.noun(values.vocative(), values.neuter(), values.plural()), "genua")
            	}
        	},
        	{
        		"idūs",
        		"iduum",
        		values.feminine(),
        		values.plural(),
        		

        		new Word[] {
        			words.create(forms.noun(values.nominative(), values.feminine(), values.plural()), "idūs"),
					words.create(forms.noun(values.genitive(), values.feminine(), values.plural()), "iduum"),
					words.create(forms.noun(values.dative(), values.feminine(), values.plural()), "idibus"),
					words.create(forms.noun(values.accusative(), values.feminine(), values.plural()), "idūs"),
					words.create(forms.noun(values.ablative(), values.feminine(), values.plural()), "idibus"),
					words.create(forms.noun(values.vocative(), values.feminine(), values.plural()), "idūs")
        		}
        	},
        	{
        		"diēs",
        		"diēī",
        		values.common(),
        		values.singular(),
        		
        		new Word[] {
        				words.create(forms.noun(values.nominative(), values.masculine(), values.singular()), "diēs"),
        				words.create(forms.noun(values.genitive(), values.masculine(), values.singular()), "diēī"),
        				words.create(forms.noun(values.dative(), values.masculine(), values.singular()), "diēī"),
        				words.create(forms.noun(values.accusative(), values.masculine(), values.singular()), "diem"),
        				words.create(forms.noun(values.ablative(), values.masculine(), values.singular()), "diē"),
        				words.create(forms.noun(values.vocative(), values.masculine(), values.singular()), "diēs"),
        				
        				words.create(forms.noun(values.nominative(), values.masculine(), values.plural()), "diēs"),
        				words.create(forms.noun(values.genitive(), values.masculine(), values.plural()), "diērum"),
        				words.create(forms.noun(values.dative(), values.masculine(), values.plural()), "diēbus"),
        				words.create(forms.noun(values.accusative(), values.masculine(), values.plural()), "diēs"),
        				words.create(forms.noun(values.ablative(), values.masculine(), values.plural()), "diēbus"),
        				words.create(forms.noun(values.vocative(), values.masculine(), values.plural()), "diēs"),
        				
        				words.create(forms.noun(values.nominative(), values.feminine(), values.singular()), "diēs"),
        				words.create(forms.noun(values.genitive(), values.feminine(), values.singular()), "diēī"),
        				words.create(forms.noun(values.dative(), values.feminine(), values.singular()), "diēī"),
        				words.create(forms.noun(values.accusative(), values.feminine(), values.singular()), "diem"),
        				words.create(forms.noun(values.ablative(), values.feminine(), values.singular()), "diē"),
        				words.create(forms.noun(values.vocative(), values.feminine(), values.singular()), "diēs"),
        				
        				words.create(forms.noun(values.nominative(), values.feminine(), values.plural()), "diēs"),
        				words.create(forms.noun(values.genitive(), values.feminine(), values.plural()), "diērum"),
        				words.create(forms.noun(values.dative(), values.feminine(), values.plural()), "diēbus"),
        				words.create(forms.noun(values.accusative(), values.feminine(), values.plural()), "diēs"),
        				words.create(forms.noun(values.ablative(), values.feminine(), values.plural()), "diēbus"),
        				words.create(forms.noun(values.vocative(), values.feminine(), values.plural()), "diēs")
        		}
        	}
        });
    }
    
    private Word nom;
    private Word gen;
    
    private Multimap<Form, Word> expected;
    
    public NounLexemeTest (String nom, String gen, Value gender, Value number, Word[] expected) {
    	this.nom = words.create(forms.noun(number, gender, values.nominative()), nom);
    	this.gen = words.create(forms.noun(number, gender, values.genitive()), gen);
    	
    	ImmutableMultimap.Builder<Form, Word> builder = new ImmutableMultimap.Builder<>();
    	for (Word word : expected) {
    		builder.put(word.getForm(), word);
    	}
    	
    	this.expected = builder.build();
    }

	@Test
	public void test() {
		Lexeme lexeme = lexemes.noun(nom, gen);
		
		for (Form form : allForms) {
			Collection<Word> result = lexeme.get(form);
			Collection<Word> expected = this.expected.get(form);
			
			if (result.size() != expected.size()) {
				fail (form + " did not give the expected number of responses\n"
						+ "We wanted: " + expected.toString() + "\n"
						+ "We got: " + result.toString());
			}
			
			for (Word word : expected) {
				boolean found = false;
				
				for (Word x : result) {
					if (x.equals(word)) {
						found = true;
						break;
					}
				}
				
				if (!found) {
					fail ("Did not form " + form + " correctly.\n"
							+ "We wanted: " + expected.toString() + "\n"
							+ "We got: " + result.toString());
				}
			}
		}
	}

}
