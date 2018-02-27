package com.elementa.client.application.dictionary.managedictionary;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.elementa.client.CurrentUser;
import com.elementa.client.Logger;
import com.elementa.client.StringConstants;
import com.elementa.client.application.AdminOnlyGatekeeper;
import com.elementa.client.application.ApplicationPresenter;
import com.elementa.client.callbacks.CallBack;
import com.elementa.client.place.HasTitle;
import com.elementa.client.place.NameTokens;
import com.elementa.client.place.ParameterTokens;
import com.elementa.client.resources.AppResources;
import com.elementa.client.widgets.accidentlistbox.AccidentListBoxPresenter;
import com.elementa.client.widgets.actionbutton.ActionButtonPresenter;
import com.elementa.client.widgets.textbox.TextBoxPresenter;
import com.elementa.shared.api.DictionaryResource;
import com.elementa.shared.dto.Paradigm;
import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.accidence.AccidentType;

public class ManageDictionaryPresenter 
		extends Presenter<ManageDictionaryPresenter.MyView, ManageDictionaryPresenter.MyProxy> 
		implements HasTitle, ManageDictionaryUiHandlers {
    interface MyView extends View, HasUiHandlers<ManageDictionaryUiHandlers>  {
    }

    @NameToken(NameTokens.MANAGE_DICTIONARY)
    @ProxyStandard
    @UseGatekeeper (AdminOnlyGatekeeper.class)
    interface MyProxy extends ProxyPlace<ManageDictionaryPresenter> {
    }
    
    public static final PermanentSlot<AccidentListBoxPresenter> PART_OF_SPEECH = new PermanentSlot<>();
    public static final PermanentSlot<TextBoxPresenter> NEW_WORD = new PermanentSlot<>();
    public static final PermanentSlot<ActionButtonPresenter> ADD_BUTTON = new PermanentSlot<>();
    
    private final StringConstants constants;
    private final TextBoxPresenter newWord;
    private final AccidentListBoxPresenter listBox;
    private final ActionButtonPresenter add;
    
    private boolean autoSelect;

    @Inject
    ManageDictionaryPresenter(
    		Logger logger,
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,
            StringConstants constants,
            AppResources res,
            PlaceManager placeManager,
            AccidentListBoxPresenter listBox,
            TextBoxPresenter newWord,
            ActionButtonPresenter add,
            ResourceDelegate<DictionaryResource> dictionary,
            CurrentUser user) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        this.getView().setUiHandlers(this);
        
        this.constants = constants;
        this.newWord = newWord;
        this.listBox = listBox;
        this.add = add;
        
        this.setInSlot(PART_OF_SPEECH, listBox);
        this.setInSlot(NEW_WORD, newWord);
        this.setInSlot(ADD_BUTTON, add);
        
        listBox.setType(AccidentType.PART_OF_SPEECH);
        listBox.addStyle(res.w3().Select(),
        		res.w3().Large(),
        		res.w3().Border());
        listBox.addClickHandler(event -> { this.autoSelect = false; });
        
        newWord.addStyle(res.w3().Large());
        newWord.setRegex("^[ a-zA-Z,./()]+$");
        newWord.addTextBoxChangeHandler(event -> {
        	if (this.autoSelect) {
	        	int size = newWord.getText().split("\\s").length;
	        	
	        	if (size == 4) {
	        		this.listBox.setSelected(Accident.VERB);
	        	} else if (size == 3) {
	        		String last = newWord.getText().split("\\s")[2]
	        				.replaceAll("[\\s,\\./]", "")
	        				.toLowerCase();
	        		
	        		if (last.equals("m") || last.equals("f") || last.equals("n")
	        				|| last.equals("mf") || last.equals("mfn"))
	        			this.listBox.setSelected(Accident.NOUN);
	        		else
	        			this.listBox.setSelected(Accident.ADJECTIVE);
	        	} else if (size == 2) {
	        		this.listBox.setSelected(Accident.NOUN);
	        	} else if (size == 1) {
	        		this.listBox.setSelected(Accident.ADVERB);
	        	}
        	}
        });
        newWord.addValidityChangeHandler(event -> {
        	add.setEnabled(newWord.isValid());
        });
        
        add.setText("+");
        add.disable();
        
        add.setAction(() -> {
        	dictionary.withCallback(new CallBack<Paradigm> (logger) {

				@Override
				public void onSuccess(Paradigm result) {
					placeManager.revealPlace(new PlaceRequest.Builder()
							.nameToken(NameTokens.EDIT_WORD_FORMS)
							.with(ParameterTokens.PARADIGM, result.toString())
							.build());
				}
        		
        	}).getParadigmFromUserInput(user.getAuthorization(),
        			listBox.getSelected().toInt(),
        			newWord.getText());
        });
    }

	@Override
	public String getTitle() {
		return this.constants.manageDictionary();
	}
	
	@Override 
	public void onReveal() {
		this.newWord.setText("");
		this.newWord.setFocus(true);
		this.listBox.setSelected(Accident.NOUN);
		this.autoSelect = true;
	}

	@Override
	public void onEnter() {
		this.add.click();
	}
    
}