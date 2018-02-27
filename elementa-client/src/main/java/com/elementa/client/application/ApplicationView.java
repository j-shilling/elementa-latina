package com.elementa.client.application;

import javax.inject.Inject;

import com.elementa.client.place.HasTitle;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class ApplicationView 
		extends ViewWithUiHandlers<ApplicationUiHandlers> 
		implements ApplicationPresenter.MyView {
	
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField
    FlowPanel contentPanel;
    @UiField
    Label title;
    @UiField
    Label openNav;
    @UiField
    SimplePanel messenger;

    @Inject
    ApplicationView(
            Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        bindSlot(ApplicationPresenter.SLOT_MAIN, contentPanel);
        bindSlot(ApplicationPresenter.MESSENGER, messenger);
    }

	@Override
	public void setTitle(String text) {
		title.setText(text);
	}
	
	@Override
    public void setInSlot (Object Slot, IsWidget content) {
    	if (content instanceof HasTitle) {
    		title.setText(((HasTitle) content).getTitle());
    	} else {
    		title.setText("");
    	}
    	
    	super.setInSlot (Slot, content);
    }
	
	@UiHandler("openNav")
	public void onOpenNavClick (ClickEvent event) {
		this.getUiHandlers().onOpenNav();
	}
}
