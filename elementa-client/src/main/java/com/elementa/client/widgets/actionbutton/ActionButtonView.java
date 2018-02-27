package com.elementa.client.widgets.actionbutton;

import javax.inject.Inject;

import com.elementa.client.resources.AppResources;
import com.elementa.client.widgets.SelfStylingWidget;
import com.elementa.client.widgets.WidgetStyler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class ActionButtonView 
	extends ViewWithUiHandlers<ActionButtonUiHandlers> 
	implements ActionButtonPresenter.MyView, SelfStylingWidget {
	
    interface Binder extends UiBinder<Widget, ActionButtonView> {
    }

    @UiField
    Label btn;
    
    private final WidgetStyler styler;

    @Inject
    ActionButtonView(Binder uiBinder, AppResources res) {
        initWidget(uiBinder.createAndBindUi(this));
        styler = new WidgetStyler (btn);
        
        btn.addClickHandler(event -> getUiHandlers().click());
        
        this.addStyle(
				res.w3().Btn(),
				res.w3().Xlarge(),
				res.w3().RoundXlarge(),
				res.w3().Right(),
				res.theme().Light2());
    }

	@Override
	public WidgetStyler getStyler() {
		return this.styler;
	}

	@Override
	public void setText(String text) {
		this.btn.setText(text);
	}
    
}