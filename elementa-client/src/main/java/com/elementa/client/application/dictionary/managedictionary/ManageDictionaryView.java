package com.elementa.client.application.dictionary.managedictionary;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;


class ManageDictionaryView 
		extends ViewWithUiHandlers<ManageDictionaryUiHandlers> 
		implements ManageDictionaryPresenter.MyView {
    interface Binder extends UiBinder<Widget, ManageDictionaryView> {
    }
    
    @UiField
    FocusPanel focus;

    @UiField
    SimplePanel searchTxtBox;
    @UiField
    SimplePanel table;
    
    @UiField
    SimplePanel listBox;
    @UiField
    SimplePanel newWordTxtBox;
    @UiField
    SimplePanel addBtn;

    @Inject
    ManageDictionaryView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        
        this.bindSlot(ManageDictionaryPresenter.ADD_BUTTON, this.addBtn);
        this.bindSlot(ManageDictionaryPresenter.NEW_WORD, this.newWordTxtBox);
        this.bindSlot(ManageDictionaryPresenter.PART_OF_SPEECH, this.listBox);
        
        this.focus.addKeyDownHandler(event -> {
        	if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER)
        		this.getUiHandlers().onEnter();
        });
    }
}