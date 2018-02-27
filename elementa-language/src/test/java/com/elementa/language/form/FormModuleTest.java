package com.elementa.language.form;

import static org.junit.Assert.*;

import org.junit.Test;

import com.elementa.language.TestLanguageModule;
import com.elementa.language.accidence.Types;
import com.elementa.language.accidence.Values;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class FormModuleTest {
	
	private final Injector injector = Guice.createInjector(new TestLanguageModule());
	private final Types types = injector.getInstance(Types.class);
	private final Values values = injector.getInstance(Values.class);

	@Test(expected = IllegalArgumentException.class)
	public void testContradictoryRequirements() {
		new FormModule() {

			@Override
			protected void configure() {
				this.requires(values.masculine());
				this.forbids(values.masculine());
			}
			
		}.validate(values.masculine(), values.nominative(), values.singular());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testContradictoryInconsistentRequiredValues() {
		new FormModule() {

			@Override
			protected void configure() {
				this.requires(values.masculine());
				this.requires(values.feminine());
			}
			
		}.validate(values.masculine(), values.nominative(), values.singular());
	}
	
	@Test
	public void testMissingRequiredType() {
		assertFalse(
					new FormModule() {

						@Override
						protected void configure() {
							this.requires(types.Number(), types.Gender(), types.Case());
						}
						
					}.validate(values.nominative(), values.singular())
				);
	}
	
	@Test
	public void testExtraType() {
		assertFalse(
					new FormModule() {

						@Override
						protected void configure() {
							this.requires(types.Number(), types.Gender(), types.Case());
						}
						
					}.validate(values.nominative(), values.singular(), values.present())
				);
	}
	
	@Test
	public void testImplyValue() {
		assertTrue(
					new FormModule() {

						@Override
						protected void configure() {
							this.requires(values.noun());
							this.requires(types.Number(), types.Gender(), types.Case());
						}
						
					}.validate(values.nominative(), values.singular(), values.masculine())
				);
	}
	
	@Test
	public void testImplyValueRedundant() {
		assertTrue(
					new FormModule() {

						@Override
						protected void configure() {
							this.requires(values.noun());
							this.requires(types.Number(), types.Gender(), types.Case());
						}
						
					}.validate(values.noun(), values.nominative(), values.singular(), values.masculine())
				);
	}
	
	@Test
	public void testValueOfForbiddenType() {
		assertFalse(
					new FormModule() {

						@Override
						protected void configure() {
							this.requires(values.noun());
							this.requires(types.Number(), types.Gender(), types.Case());
							this.forbids(values.masculine());
						}
						
					}.validate(values.noun(), values.nominative(), values.singular(), values.masculine())
				);
	}
	
	@Test
	public void testValueForbidsValue() {
		assertFalse(
					new FormModule() {

						@Override
						protected void configure() {
							this.requires(values.noun());
							this.requires(types.Number(), types.Gender(), types.Case());
							this.value(values.masculine()).forbids(values.singular());;
						}
						
					}.validate(values.noun(), values.nominative(), values.singular(), values.masculine())
				);
	}
	
	@Test
	public void testValueForbidsType() {
		assertFalse(
					new FormModule() {

						@Override
						protected void configure() {
							this.requires(values.noun());
							this.requires(types.Number(), types.Gender(), types.Case());
							this.value(values.masculine()).forbids(types.Number());;
						}
						
					}.validate(values.noun(), values.nominative(), values.singular(), values.masculine())
				);
	}
	
	@Test
	public void testValueAllowsType() {
		assertTrue(
					new FormModule() {

						@Override
						protected void configure() {
							this.requires(values.noun());
							this.requires(types.Number(), types.Gender(), types.Case());
							this.value(values.masculine()).requires(types.Tense());
						}
						
					}.validate(values.noun(), values.nominative(), values.singular(), values.masculine(), values.present())
				);
	}

}
