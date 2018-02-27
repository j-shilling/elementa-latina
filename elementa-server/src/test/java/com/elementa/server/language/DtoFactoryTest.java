package com.elementa.server.language;

import static org.junit.Assert.*;

import org.junit.Test;

import com.elementa.language.Word;
import com.elementa.language.WordFactory;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.FormFactory;
import com.elementa.shared.dto.UserPreferences;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class DtoFactoryTest {
	
	private final Injector injector = Guice.createInjector(new LanguageModule(), new AbstractModule() {

		@Override
		protected void configure() {
			this.bind(DtoFactory.class);
		}
		
	});
	
	private final DtoFactory factory = injector.getInstance(DtoFactory.class);
	private final FormFactory forms = injector.getInstance(FormFactory.class);
	private final Values values = injector.getInstance(Values.class);
	private final WordFactory words = injector.getInstance(WordFactory.class);

	@Test
	public void testMacrons() {
		UserPreferences with = new UserPreferences.Builder()
				.useMacrons(true)
				.build();
		UserPreferences without = new UserPreferences.Builder()
				.useMacrons(false)
				.build();
		
		Word word = words.create(forms.verb(values.perfect(), values.passive(), values.participle(), values.nominative(), values.masculine(), values.singular()), 
				"cōnsūmptus");
		
		assertTrue (this.factory.create(with, word).getText().equals("cōnsūmptus"));
		assertTrue (this.factory.create(without, word).getText().equals("consumptus"));
	}
	
	@Test
	public void testDiaeresis() {
		UserPreferences with = new UserPreferences.Builder()
				.useDiaereses(true)
				.build();
		UserPreferences without = new UserPreferences.Builder()
				.useDiaereses(false)
				.build();
		
		Word word = words.create(forms.noun(values.nominative(), values.singular(), values.neuter()), 
				"aër");
		
		assertTrue (this.factory.create(with, word).getText().equals("aër"));
		assertTrue (this.factory.create(without, word).getText().equals("aer"));
	}
	
	@Test
	public void testJ() {
		UserPreferences with = new UserPreferences.Builder()
				.useJ(true)
				.build();
		UserPreferences without = new UserPreferences.Builder()
				.useJ(false)
				.build();
		
		Word word = words.create(forms.pronoun(values.thirdPerson(), values.masculine(), values.genitive(), values.singular()), 
				"ejus");
		
		assertTrue (this.factory.create(with, word).getText().equals("ejus"));
		assertTrue (this.factory.create(without, word).getText().equals("eius"));
	}
	
	@Test
	public void testV() {
		UserPreferences with = new UserPreferences.Builder()
				.useV(true)
				.build();
		UserPreferences without = new UserPreferences.Builder()
				.useV(false)
				.build();
		
		Word word = words.create(forms.verb(values.imperative(), values.secondPerson(), values.present(), values.singular(), values.active()),
				"vidi");
		
		assertTrue (this.factory.create(with, word).getText().equals("vidi"));
		assertTrue (this.factory.create(without, word).getText().equals("uidi"));
	}
	
	

}
