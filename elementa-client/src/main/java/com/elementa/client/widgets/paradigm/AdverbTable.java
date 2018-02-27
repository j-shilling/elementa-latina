package com.elementa.client.widgets.paradigm;

import static com.elementa.shared.dto.accidence.Accident.*;

import java.util.Collection;

import com.elementa.shared.dto.Paradigm;
import com.elementa.shared.dto.accidence.AccidentType;
import com.elementa.shared.dto.form.FormDto;
import com.elementa.shared.dto.form.FormDtoFactory;
import com.google.common.base.Preconditions;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AdverbTable extends Composite implements ParadigmPresenter.Table {

	private static AdverbTableUiBinder uiBinder = GWT.create(AdverbTableUiBinder.class);

	interface AdverbTableUiBinder extends UiBinder<Widget, AdverbTable> {
	}
	
	@UiField
	OneColumnTable table;

	public AdverbTable(FormDtoFactory factory, ParadigmCellClickedHandler handler, 
			Paradigm paradigm, Collection<FormDto> forms) {
		
		initWidget(uiBinder.createAndBindUi(this));
		
		Preconditions.checkNotNull(paradigm, "Paradigm must not be null");
		Preconditions.checkNotNull(forms, "Forms must not be null");
		Preconditions.checkArgument(!paradigm.isEmpty(), "Paradigm must not be empty");
		
		FormDto form = paradigm.toArray()[0].getForm();
		
		Preconditions.checkArgument(form.get(AccidentType.PART_OF_SPEECH).isPresent(), "A part of speech must be present");
		Preconditions.checkArgument(form.get(AccidentType.PART_OF_SPEECH).get() == ADVERB, "Words must be adverbs");
		
		form = factory.adverb(POSITIVE);
		if (forms.isEmpty() || forms.contains(form))
			this.table.add(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adverb(COMPARATIVE);
		if (forms.isEmpty() || forms.contains(form))
			this.table.add(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adverb(SUPERLATIVE);
		if (forms.isEmpty() || forms.contains(form))
			this.table.add(new ParadigmCell (handler, form, paradigm.get(form)));
	}

}
