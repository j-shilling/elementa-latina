package com.elementa.client.widgets.paradigm;

import java.util.Collection;

import com.elementa.shared.dto.Paradigm;
import com.elementa.shared.dto.form.FormDto;
import com.google.common.base.Preconditions;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class IndeclinableTable extends Composite implements ParadigmPresenter.Table {

	private static IndeclinableTableUiBinder uiBinder = GWT.create(IndeclinableTableUiBinder.class);

	interface IndeclinableTableUiBinder extends UiBinder<Widget, IndeclinableTable> {
	}
	
	@UiField
	OneColumnTable table;

	public IndeclinableTable(ParadigmCellClickedHandler handler, 
			Paradigm paradigm, Collection<FormDto> forms) {
		
		initWidget(uiBinder.createAndBindUi(this));
		
		Preconditions.checkNotNull(paradigm, "Paradigm must not be null");
		Preconditions.checkNotNull(forms, "Forms must not be null");
		Preconditions.checkArgument(!paradigm.isEmpty(), "Paradigm must not be empty");
		
		FormDto form = paradigm.toArray()[0].getForm();
		if (forms.isEmpty() || forms.contains(form))
			this.table.add(new ParadigmCell (handler, form, paradigm.get(form)));
	}

}
