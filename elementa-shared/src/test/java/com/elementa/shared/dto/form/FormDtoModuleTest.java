package com.elementa.shared.dto.form;

import static com.elementa.shared.dto.accidence.Accident.*;
import static com.elementa.shared.dto.accidence.AccidentType.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class FormDtoModuleTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testContradictoryRequirements() {
		new FormDtoModule() {

			@Override
			protected void configure() {
				this.requires(MASCULINE);
				this.forbids(MASCULINE);
			}
			
		}.validate(MASCULINE, NOMINATIVE, SINGULAR);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testContradictoryInconsistentRequiredValues() {
		new FormDtoModule() {

			@Override
			protected void configure() {
				this.requires(MASCULINE);
				this.requires(FEMININE);
			}
			
		}.validate(MASCULINE, NOMINATIVE, SINGULAR);
	}
	
	@Test
	public void testMissingRequiredType() {
		assertFalse(
					new FormDtoModule() {

						@Override
						protected void configure() {
							this.requires(NUMBER, GENDER, CASE);
						}
						
					}.validate(NOMINATIVE, SINGULAR)
				);
	}
	
	@Test
	public void testExtraType() {
		assertFalse(
					new FormDtoModule() {

						@Override
						protected void configure() {
							this.requires(NUMBER, GENDER, CASE);
						}
						
					}.validate(NOMINATIVE, SINGULAR, PRESENT)
				);
	}
	
	@Test
	public void testImplyValue() {
		assertTrue(
					new FormDtoModule() {

						@Override
						protected void configure() {
							this.requires(NOUN);
							this.requires(NUMBER, GENDER, CASE);
						}
						
					}.validate(NOMINATIVE, SINGULAR, MASCULINE)
				);
	}
	
	@Test
	public void testImplyValueRedundant() {
		assertTrue(
					new FormDtoModule() {

						@Override
						protected void configure() {
							this.requires(NOUN);
							this.requires(NUMBER, GENDER, CASE);
						}
						
					}.validate(NOUN, NOMINATIVE, SINGULAR, MASCULINE)
				);
	}
	
	@Test
	public void testValueOfForbiddenType() {
		assertFalse(
					new FormDtoModule() {

						@Override
						protected void configure() {
							this.requires(NOUN);
							this.requires(NUMBER, GENDER, CASE);
							this.forbids(MASCULINE);
						}
						
					}.validate(NOUN, NOMINATIVE, SINGULAR, MASCULINE)
				);
	}
	
	@Test
	public void testValueForbidsValue() {
		assertFalse(
					new FormDtoModule() {

						@Override
						protected void configure() {
							this.requires(NOUN);
							this.requires(NUMBER, GENDER, CASE);
							this.value(MASCULINE).forbids(SINGULAR);;
						}
						
					}.validate(NOUN, NOMINATIVE, SINGULAR, MASCULINE)
				);
	}
	
	@Test
	public void testValueForbidsType() {
		assertFalse(
					new FormDtoModule() {

						@Override
						protected void configure() {
							this.requires(NOUN);
							this.requires(NUMBER, GENDER, CASE);
							this.value(MASCULINE).forbids(NUMBER);;
						}
						
					}.validate(NOUN, NOMINATIVE, SINGULAR, MASCULINE)
				);
	}
	
	@Test
	public void testValueAllowsType() {
		assertTrue(
					new FormDtoModule() {

						@Override
						protected void configure() {
							this.requires(NOUN);
							this.requires(NUMBER, GENDER, CASE);
							this.value(MASCULINE).requires(TENSE);
						}
						
					}.validate(NOUN, NOMINATIVE, SINGULAR, MASCULINE, PRESENT)
				);
	}

}
