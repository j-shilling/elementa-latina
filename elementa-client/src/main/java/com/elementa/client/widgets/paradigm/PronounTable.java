package com.elementa.client.widgets.paradigm;

import static com.elementa.shared.dto.accidence.Accident.*;

import java.util.Collection;

import com.elementa.shared.dto.Paradigm;
import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.accidence.AccidentType;
import com.elementa.shared.dto.form.FormDto;
import com.elementa.shared.dto.form.FormDtoFactory;
import com.google.common.base.Preconditions;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class PronounTable extends Composite implements ParadigmPresenter.Table {

	private static PronounTableUiBinder uiBinder = GWT.create(PronounTableUiBinder.class);

	interface PronounTableUiBinder extends UiBinder<Widget, PronounTable> {
	}
	
	@UiField
	TwoColumnTable m;
	@UiField
	TwoColumnTable f;
	@UiField
	TwoColumnTable n;

	public PronounTable(FormDtoFactory factory, ParadigmCellClickedHandler handler, 
			Paradigm paradigm, Collection<FormDto> forms) {
		initWidget(uiBinder.createAndBindUi(this));
		
		Preconditions.checkNotNull(paradigm, "Paradigm must not be null");
		Preconditions.checkNotNull(forms, "Forms must not be null");
		Preconditions.checkArgument(!paradigm.isEmpty(), "Paradigm must not be empty");
		
		FormDto form = paradigm.toArray()[0].getForm();
		
		Preconditions.checkArgument(form.get(AccidentType.PART_OF_SPEECH).isPresent(), "A part of speech must be present");
		Preconditions.checkArgument(form.get(AccidentType.PART_OF_SPEECH).get() == PRONOUN, "Words must be pronouns");
		Preconditions.checkArgument(form.get(AccidentType.PERSON).isPresent(), "A pronoun should have person");
		
		Accident person = form.get(AccidentType.PERSON).get();
		
		/*
		 * Positive
		 */
		
		form = factory.pronoun(person, MASCULINE, NOMINATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.m.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, MASCULINE, GENITIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.m.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, MASCULINE, DATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.m.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, MASCULINE, ACCUSATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.m.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, MASCULINE, ABLATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.m.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, MASCULINE, VOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.m.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.pronoun(person, MASCULINE, NOMINATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.m.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, MASCULINE, GENITIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.m.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, MASCULINE, DATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.m.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, MASCULINE, ACCUSATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.m.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, MASCULINE, ABLATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.m.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, MASCULINE, VOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.m.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.pronoun(person, FEMININE, NOMINATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.f.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, FEMININE, GENITIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.f.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, FEMININE, DATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.f.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, FEMININE, ACCUSATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.f.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, FEMININE, ABLATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.f.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, FEMININE, VOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.f.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.pronoun(person, FEMININE, NOMINATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.f.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, FEMININE, GENITIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.f.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, FEMININE, DATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.f.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, FEMININE, ACCUSATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.f.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, FEMININE, ABLATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.f.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, FEMININE, VOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.f.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.pronoun(person, NEUTER, NOMINATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.n.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, NEUTER, GENITIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.n.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, NEUTER, DATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.n.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, NEUTER, ACCUSATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.n.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, NEUTER, ABLATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.n.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, NEUTER, VOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.n.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.pronoun(person, NEUTER, NOMINATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.n.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, NEUTER, GENITIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.n.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, NEUTER, DATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.n.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, NEUTER, ACCUSATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.n.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, NEUTER, ABLATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.n.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.pronoun(person, NEUTER, VOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.n.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
	}

}
