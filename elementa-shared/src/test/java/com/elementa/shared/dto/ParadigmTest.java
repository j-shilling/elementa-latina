package com.elementa.shared.dto;

import static com.elementa.shared.dto.accidence.Accident.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.elementa.shared.dto.form.FormDtoFactory;
import com.elementa.shared.dto.form.FormDtoGuiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class ParadigmTest {
	
	private static Injector injector = Guice.createInjector(new FormDtoGuiceModule());
	private static FormDtoFactory forms = injector.getInstance(FormDtoFactory.class);

	@Test
	public void test() {
		
		Paradigm.Builder builder = new Paradigm.Builder();
		
		builder.add(new WordDto("servus", forms.noun(NOMINATIVE, MASCULINE, SINGULAR)));
		builder.add(new WordDto("servī", forms.noun(GENITIVE, MASCULINE, SINGULAR)));
		builder.add(new WordDto("servō", forms.noun(DATIVE, MASCULINE, SINGULAR)));
		builder.add(new WordDto("servum", forms.noun(ACCUSATIVE, MASCULINE, SINGULAR)));
		builder.add(new WordDto("servō", forms.noun(ABLATIVE, MASCULINE, SINGULAR)));
		
		builder.add(new WordDto("servī", forms.noun(NOMINATIVE, MASCULINE, PLURAL)));
		builder.add(new WordDto("servōrum", forms.noun(GENITIVE, MASCULINE, PLURAL)));
		builder.add(new WordDto("servīs", forms.noun(DATIVE, MASCULINE, PLURAL)));
		builder.add(new WordDto("servōs", forms.noun(ACCUSATIVE, MASCULINE, PLURAL)));
		builder.add(new WordDto("servīs", forms.noun(ABLATIVE, MASCULINE, PLURAL)));
		
		Paradigm one = builder.build();
		Paradigm two = new Paradigm (one.toString());
		
		assertTrue (one.equals(two));
	}

}
