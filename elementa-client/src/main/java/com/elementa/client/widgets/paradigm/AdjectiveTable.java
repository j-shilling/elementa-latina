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

public class AdjectiveTable extends Composite implements ParadigmPresenter.Table {

	private static AdjectiveTableUiBinder uiBinder = GWT.create(AdjectiveTableUiBinder.class);

	interface AdjectiveTableUiBinder extends UiBinder<Widget, AdjectiveTable> {
	}
	
	@UiField
	TwoColumnTable mPos;
	@UiField
	TwoColumnTable fPos;
	@UiField
	TwoColumnTable nPos;
	
	@UiField
	TwoColumnTable mCom;
	@UiField
	TwoColumnTable fCom;
	@UiField
	TwoColumnTable nCom;
	
	@UiField
	TwoColumnTable mSup;
	@UiField
	TwoColumnTable fSup;
	@UiField
	TwoColumnTable nSup;

	public AdjectiveTable(FormDtoFactory factory, ParadigmCellClickedHandler handler, 
			Paradigm paradigm, Collection<FormDto> forms) {
		initWidget(uiBinder.createAndBindUi(this));
		
		Preconditions.checkNotNull(paradigm, "Paradigm must not be null");
		Preconditions.checkNotNull(forms, "Forms must not be null");
		Preconditions.checkArgument(!paradigm.isEmpty(), "Paradigm must not be empty");
		
		FormDto form = paradigm.toArray()[0].getForm();
		
		Preconditions.checkArgument(form.get(AccidentType.PART_OF_SPEECH).isPresent(), "A part of speech must be present");
		Preconditions.checkArgument(form.get(AccidentType.PART_OF_SPEECH).get() == ADJECTIVE, "Words must be adjectives");
		
		
		/*
		 * Positive
		 */
		
		form = factory.adjective(POSITIVE, MASCULINE, NOMINATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, MASCULINE, GENITIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, MASCULINE, DATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, MASCULINE, ACCUSATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, MASCULINE, ABLATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, MASCULINE, VOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, MASCULINE, LOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(POSITIVE, MASCULINE, NOMINATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, MASCULINE, GENITIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, MASCULINE, DATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, MASCULINE, ACCUSATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, MASCULINE, ABLATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, MASCULINE, VOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, MASCULINE, LOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(POSITIVE, FEMININE, NOMINATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, FEMININE, GENITIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, FEMININE, DATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, FEMININE, ACCUSATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, FEMININE, ABLATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, FEMININE, VOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, FEMININE, LOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(POSITIVE, FEMININE, NOMINATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, FEMININE, GENITIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, FEMININE, DATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, FEMININE, ACCUSATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, FEMININE, ABLATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, FEMININE, VOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, FEMININE, LOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(POSITIVE, NEUTER, NOMINATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, NEUTER, GENITIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, NEUTER, DATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, NEUTER, ACCUSATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, NEUTER, ABLATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, NEUTER, VOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, NEUTER, LOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(POSITIVE, NEUTER, NOMINATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, NEUTER, GENITIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, NEUTER, DATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, NEUTER, ACCUSATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, NEUTER, ABLATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, NEUTER, VOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(POSITIVE, NEUTER, LOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nPos.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
		/*
		 * Comparative
		 */
		
		form = factory.adjective(COMPARATIVE, MASCULINE, NOMINATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, MASCULINE, GENITIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, MASCULINE, DATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, MASCULINE, ACCUSATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, MASCULINE, ABLATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, MASCULINE, VOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, MASCULINE, LOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(COMPARATIVE, MASCULINE, NOMINATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, MASCULINE, GENITIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, MASCULINE, DATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, MASCULINE, ACCUSATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, MASCULINE, ABLATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, MASCULINE, VOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, MASCULINE, LOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(COMPARATIVE, FEMININE, NOMINATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, FEMININE, GENITIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, FEMININE, DATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, FEMININE, ACCUSATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, FEMININE, ABLATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, FEMININE, VOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, FEMININE, LOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(COMPARATIVE, FEMININE, NOMINATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, FEMININE, GENITIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, FEMININE, DATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, FEMININE, ACCUSATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, FEMININE, ABLATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, FEMININE, VOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, FEMININE, LOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(COMPARATIVE, NEUTER, NOMINATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, NEUTER, GENITIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, NEUTER, DATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, NEUTER, ACCUSATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, NEUTER, ABLATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, NEUTER, VOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, NEUTER, LOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(COMPARATIVE, NEUTER, NOMINATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, NEUTER, GENITIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, NEUTER, DATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, NEUTER, ACCUSATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, NEUTER, ABLATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, NEUTER, VOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(COMPARATIVE, NEUTER, LOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nCom.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
		/*
		 * Superlative
		 */
		
		form = factory.adjective(SUPERLATIVE, MASCULINE, NOMINATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, MASCULINE, GENITIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, MASCULINE, DATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, MASCULINE, ACCUSATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, MASCULINE, ABLATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, MASCULINE, VOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, MASCULINE, LOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(SUPERLATIVE, MASCULINE, NOMINATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, MASCULINE, GENITIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, MASCULINE, DATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, MASCULINE, ACCUSATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, MASCULINE, ABLATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, MASCULINE, VOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, MASCULINE, LOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.mSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(SUPERLATIVE, FEMININE, NOMINATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, FEMININE, GENITIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, FEMININE, DATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, FEMININE, ACCUSATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, FEMININE, ABLATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, FEMININE, VOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, FEMININE, LOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(SUPERLATIVE, FEMININE, NOMINATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, FEMININE, GENITIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, FEMININE, DATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, FEMININE, ACCUSATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, FEMININE, ABLATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, FEMININE, VOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, FEMININE, LOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.fSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(SUPERLATIVE, NEUTER, NOMINATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, NEUTER, GENITIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, NEUTER, DATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, NEUTER, ACCUSATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, NEUTER, ABLATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, NEUTER, VOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, NEUTER, LOCATIVE, SINGULAR);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.adjective(SUPERLATIVE, NEUTER, NOMINATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, NEUTER, GENITIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, NEUTER, DATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, NEUTER, ACCUSATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, NEUTER, ABLATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, NEUTER, VOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.adjective(SUPERLATIVE, NEUTER, LOCATIVE, PLURAL);
		if (forms.isEmpty() || forms.contains(form))
			this.nSup.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
	}

}
