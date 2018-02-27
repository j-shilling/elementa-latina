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

public class VerbTable extends Composite implements ParadigmPresenter.Table {

	private static VerbTableUiBinder uiBinder = GWT.create(VerbTableUiBinder.class);

	interface VerbTableUiBinder extends UiBinder<Widget, VerbTable> {
	}
	
	@UiField
	TwoColumnTable presentActiveIndicative;
	@UiField
	TwoColumnTable imperfectActiveIndicative;
	@UiField
	TwoColumnTable futureActiveIndicative;
	@UiField
	TwoColumnTable perfectActiveIndicative;
	@UiField
	TwoColumnTable pluperfectActiveIndicative;
	@UiField
	TwoColumnTable futurePerfectActiveIndicative;
	@UiField
	TwoColumnTable presentPassiveIndicative;
	@UiField
	TwoColumnTable imperfectPassiveIndicative;
	@UiField
	TwoColumnTable futurePassiveIndicative;
	@UiField
	TwoColumnTable perfectPassiveIndicative;
	@UiField
	TwoColumnTable pluperfectPassiveIndicative;
	@UiField
	TwoColumnTable futurePerfectPassiveIndicative;
	
	@UiField
	TwoColumnTable presentActiveSubjunctive;
	@UiField
	TwoColumnTable imperfectActiveSubjunctive;
	@UiField
	TwoColumnTable perfectActiveSubjunctive;
	@UiField
	TwoColumnTable pluperfectActiveSubjunctive;
	@UiField
	TwoColumnTable presentPassiveSubjunctive;
	@UiField
	TwoColumnTable imperfectPassiveSubjunctive;
	@UiField
	TwoColumnTable perfectPassiveSubjunctive;
	@UiField
	TwoColumnTable pluperfectPassiveSubjunctive;
	
	@UiField
	TwoColumnTable presentActiveImperative;
	@UiField
	TwoColumnTable futureActiveImperative;
	@UiField
	TwoColumnTable presentPassiveImperative;
	@UiField
	TwoColumnTable futurePassiveImperative;
	
	@UiField
	TwoColumnTable presentActiveInfinitive;
	@UiField
	TwoColumnTable futureActiveInfinitive;
	@UiField
	TwoColumnTable perfectActiveInfinitive;
	@UiField
	TwoColumnTable presentPassiveInfinitive;
	@UiField
	TwoColumnTable futurePassiveInfinitive;
	@UiField
	TwoColumnTable perfectPassiveInfinitive;
	
	@UiField
	TwoColumnTable presentActiveParticipleMasculine;
	@UiField
	TwoColumnTable presentActiveParticipleFeminine;
	@UiField
	TwoColumnTable presentActiveParticipleNeuter;
	@UiField
	TwoColumnTable futureActiveParticipleMasculine;
	@UiField
	TwoColumnTable futureActiveParticipleFeminine;
	@UiField
	TwoColumnTable futureActiveParticipleNeuter;
	@UiField
	TwoColumnTable perfectActiveParticipleMasculine;
	@UiField
	TwoColumnTable perfectActiveParticipleFeminine;
	@UiField
	TwoColumnTable perfectActiveParticipleNeuter;
	@UiField
	TwoColumnTable futurePassiveParticipleMasculine;
	@UiField
	TwoColumnTable futurePassiveParticipleFeminine;
	@UiField
	TwoColumnTable futurePassiveParticipleNeuter;
	@UiField
	TwoColumnTable perfectPassiveParticipleMasculine;
	@UiField
	TwoColumnTable perfectPassiveParticipleFeminine;
	@UiField
	TwoColumnTable perfectPassiveParticipleNeuter;
	
	@UiField
	TwoColumnTable gerund;
	@UiField
	OneColumnTable supine;
	
	public VerbTable(FormDtoFactory factory, ParadigmCellClickedHandler handler, 
			Paradigm paradigm, Collection<FormDto> forms) {
		initWidget(uiBinder.createAndBindUi(this));
		
		Preconditions.checkNotNull(paradigm, "Paradigm must not be null");
		Preconditions.checkNotNull(forms, "Forms must not be null");
		Preconditions.checkArgument(!paradigm.isEmpty(), "Paradigm must not be empty");
		
		FormDto form = paradigm.toArray()[0].getForm();
		
		Preconditions.checkArgument(form.get(AccidentType.PART_OF_SPEECH).isPresent(), "A part of speech must be present");
		Preconditions.checkArgument(form.get(AccidentType.PART_OF_SPEECH).get() == VERB, "Words must be verbs");
		
		form = factory.verb(INDICATIVE, ACTIVE, PRESENT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PRESENT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PRESENT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PRESENT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PRESENT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PRESENT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, IMPERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, IMPERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, IMPERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, IMPERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, IMPERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, IMPERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, FUTURE, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futureActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, FUTURE, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futureActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, FUTURE, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futureActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, FUTURE, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futureActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, FUTURE, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futureActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, FUTURE, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futureActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PLUPERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PLUPERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PLUPERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PLUPERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PLUPERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, PLUPERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, FUTURE_PERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePerfectActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, FUTURE_PERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePerfectActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, FUTURE_PERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePerfectActiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, FUTURE_PERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePerfectActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, FUTURE_PERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePerfectActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, ACTIVE, FUTURE_PERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePerfectActiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.verb(INDICATIVE, PASSIVE, PRESENT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PRESENT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PRESENT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PRESENT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PRESENT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PRESENT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, IMPERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, IMPERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, IMPERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, IMPERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, IMPERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, IMPERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, FUTURE, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, FUTURE, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, FUTURE, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, FUTURE, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, FUTURE, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, FUTURE, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PLUPERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PLUPERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PLUPERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PLUPERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PLUPERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, PLUPERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, FUTURE_PERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePerfectPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, FUTURE_PERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePerfectPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, FUTURE_PERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePerfectPassiveIndicative.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, FUTURE_PERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePerfectPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, FUTURE_PERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePerfectPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(INDICATIVE, PASSIVE, FUTURE_PERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			futurePerfectPassiveIndicative.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
		
		
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PRESENT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentActiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PRESENT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentActiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PRESENT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentActiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PRESENT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentActiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PRESENT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentActiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PRESENT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentActiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, IMPERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectActiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, IMPERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectActiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, IMPERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectActiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, IMPERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectActiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, IMPERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectActiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, IMPERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectActiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectActiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectActiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectActiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectActiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectActiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectActiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PLUPERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectActiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PLUPERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectActiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PLUPERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectActiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PLUPERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectActiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PLUPERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectActiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, ACTIVE, PLUPERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectActiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PRESENT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentPassiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PRESENT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentPassiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PRESENT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentPassiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PRESENT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentPassiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PRESENT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentPassiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PRESENT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			presentPassiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, IMPERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectPassiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, IMPERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectPassiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, IMPERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectPassiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, IMPERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectPassiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, IMPERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectPassiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, IMPERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			imperfectPassiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectPassiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectPassiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectPassiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectPassiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectPassiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			perfectPassiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PLUPERFECT, SINGULAR, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectPassiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PLUPERFECT, SINGULAR, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectPassiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PLUPERFECT, SINGULAR, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectPassiveSubjunctive.addLeft(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PLUPERFECT, PLURAL, FIRST_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectPassiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PLUPERFECT, PLURAL, SECOND_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectPassiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		form = factory.verb(SUBJUNCTIVE, PASSIVE, PLUPERFECT, PLURAL, THIRD_PERSON);
		if (forms.isEmpty() || forms.contains(form))
			pluperfectPassiveSubjunctive.addRight(new ParadigmCell (handler, form, paradigm.get(form)));
		
	}

}
