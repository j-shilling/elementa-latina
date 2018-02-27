package com.elementa.client.widgets.paradigm;

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

import static com.elementa.shared.dto.accidence.Accident.*;

class NounTable extends Composite implements ParadigmPresenter.Table {
	
	private static NounTableUiBinder uiBinder = GWT.create(NounTableUiBinder.class);

	interface NounTableUiBinder extends UiBinder<Widget, NounTable> {
	}
	
	@UiField
	TwoColumnTable table;
	
	protected NounTable (FormDtoFactory factory, ParadigmCellClickedHandler handler, 
			Paradigm paradigm, Collection<FormDto> forms) {
		
		this.initWidget(uiBinder.createAndBindUi(this));
		
		Preconditions.checkNotNull(paradigm, "Paradigm must not be null");
		Preconditions.checkNotNull(forms, "Forms must not be null");
		Preconditions.checkArgument(!paradigm.isEmpty(), "Paradigm must not be empty");
		
		FormDto form = paradigm.toArray()[0].getForm();
		
		Preconditions.checkArgument(form.get(AccidentType.PART_OF_SPEECH).isPresent(), "A part of speech must be present");
		Preconditions.checkArgument(form.get(AccidentType.PART_OF_SPEECH).get() == NOUN, "Words must be nouns");
		
		Preconditions.checkArgument(form.get(AccidentType.GENDER).isPresent(), "Nouns must have gender");
		
		Accident gender = form.get(AccidentType.GENDER).get();
		
		form = factory.noun(gender, NOMINATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.noun(gender, GENITIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.noun(gender, DATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.noun(gender, ACCUSATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.noun(gender, ABLATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.noun(gender, VOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.noun(gender, LOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.noun(gender, NOMINATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.noun(gender, GENITIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.noun(gender, DATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.noun(gender, ACCUSATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.noun(gender, ABLATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.noun(gender, VOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.noun(gender, LOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.table.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
	}

}
