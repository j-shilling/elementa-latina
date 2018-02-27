package com.elementa.client.widgets.paradigm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.inject.Inject;

import com.elementa.shared.dto.Paradigm;
import com.elementa.shared.dto.WordDto;
import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.accidence.AccidentType;
import com.elementa.shared.dto.form.FormDto;
import com.elementa.shared.dto.form.FormDtoFactory;
import com.google.common.base.Preconditions;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * Presenter used to display a {@link com.elementa.shared.dto.Paradigm} to the
 * user. The table should show words organized by there form. If a paradigm has
 * only one form, only one cell will be shown; if there are two properties the
 * paradigm is declined by, a table with two rows will be shown. For any additional
 * properties affection the inflection of the table, collections of two-rowed
 * tables will be shown in different tabs.
 * 
 * @author Jake Shilling
 *
 */
public class ParadigmPresenter extends PresenterWidget<ParadigmPresenter.MyView> 
		implements ParadigmCellClickedHandler {
	
	/**
	 * Defines the behavior of the view associated with this presenter.
	 * 
	 * @author Jake Shilling
	 *
	 */
	interface MyView extends View {
		/**
		 * Delete any child widgets
		 */
		public void clear();
		
		/**
		 * Adds a table to the View
		 */
		public void add (Table table);
	}
	
	/**
	 * Defines the behavior of a given Table, a template
	 * used to display a given part of speech.
	 * 
	 * @author Jake Shilling
	 *
	 */
	interface Table extends IsWidget {
	}
	
	private final FormDtoFactory factory;
	
	@Inject
	public ParadigmPresenter(
			EventBus eventBus, 
			MyView view,
			FormDtoFactory factory) {
		super(eventBus, view);
		
		this.factory = factory;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCellClicked (WordDto...words) {
		
	}
	
	/**
	 * Reset and display the given paradigm.
	 * 
	 * @param paradigm		Paradigm to display
	 * @param forms			If this array is not empty, only the
	 * 						given forms will be displayed.
	 */
	public void setParadigm (Paradigm paradigm, FormDto...forms) {
		this.setParadigm(paradigm, Arrays.asList(forms));
	}
	
	/**
	 * Reset and display the given paradigm.
	 * 
	 * @param paradigm		Paradigm to display
	 * @param forms			If this collection is not empty, only the
	 * 						given forms will be displayed.
	 */
	public void setParadigm (Paradigm paradigm, Collection<FormDto> forms) {
		/* Check sanity of the parameters */
		Preconditions.checkNotNull(paradigm, "Cannot display a null paradigm");
		if (forms == null)
			forms = new ArrayList<FormDto>();
		
		/* Clear any previous table stored in this object */
		this.getView().clear();
		
		/* Do nothing if the paradigm is empty */
		if (paradigm.isEmpty())
			return;
		
		/* Find the right table to use */
		Optional<Accident> partOfSpeech = paradigm.toArray()[0].getForm().get(AccidentType.PART_OF_SPEECH);
		Preconditions.checkArgument(partOfSpeech.isPresent(), "Could not find the part of speech for this paradigm");
		
		Table table = null;
		switch (partOfSpeech.get()) {
		case NOUN:				table = new NounTable (factory, this, paradigm, forms); break;
		case PRONOUN:			table = new PronounTable (factory, this, paradigm, forms); break;
		case ADJECTIVE:			table = new AdjectiveTable (factory, this, paradigm, forms); break;
		case ADVERB:			table = new AdverbTable (factory, this, paradigm, forms); break;
		case VERB:				table = new VerbTable (factory, this, paradigm, forms); break;
		case PREPOSITION:		table = new IndeclinableTable (this, paradigm, forms); break;
		case CONJUNCTION:		table = new IndeclinableTable (this, paradigm, forms); break;
		case INTERJECTION:		table = new IndeclinableTable (this, paradigm, forms); break;
		default:				break;
		}
		Preconditions.checkNotNull(table, "Could not find a template to display the part of speech " + partOfSpeech.get());
		
		/* Display the Table */
		this.getView().add(table);
	}

}
