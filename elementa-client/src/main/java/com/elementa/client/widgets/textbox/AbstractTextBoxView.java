package com.elementa.client.widgets.textbox;

import com.elementa.client.resources.AppResources;
import com.elementa.client.widgets.WidgetStyler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

abstract class AbstractTextBoxView
		extends ViewWithUiHandlers<TextBoxUiHandlers> 
		implements TextBoxPresenter.MyView {
	
    interface Binder extends UiBinder<Widget, AbstractTextBoxView> {
    }
    private static Binder uiBinder = GWT.create(Binder.class);
    
    private final WidgetStyler styler;
    private final String validStyle;
    private final String invalidStyle;

    @UiField
    SimplePanel panel;
    
    private final TextBox textBox;

    AbstractTextBoxView(
    		AppResources res,
    		TextBox textBox) {
        initWidget(uiBinder.createAndBindUi(this));
        
        this.styler = new WidgetStyler (textBox);
        this.validStyle = res.w3().BorderGreen();
        this.invalidStyle = res.w3().BorderRed();
        
        this.textBox = textBox;
        
        this.textBox.addKeyUpHandler(event -> {

			AbstractTextBoxView.this
				.getUiHandlers()
				.onTextChange(true);
        	
        });
        
        this.styler.addStyle(
				res.w3().Input(),
				res.w3().Border(),
				res.theme().Light5());
        this.styler.setStyles();
        
        this.panel.add(this.textBox);
    }

	@Override
	public WidgetStyler getStyler() {
		return this.styler;
	}

	@Override
	public void setValid() {
		this.styler.delStyle(invalidStyle);
		this.styler.addStyle(validStyle);
		this.styler.setStyles();
	}

	@Override
	public void setInvalid() {
		this.styler.delStyle(validStyle);
		this.styler.addStyle(invalidStyle);
		this.styler.setStyles();
	}

	@Override
	public void setNeutral() {
		this.styler.delStyle(validStyle);
		this.styler.delStyle(invalidStyle);
		this.styler.setStyles();
	}

	@Override
	public String getText() {
		return this.textBox.getText();
	}

	@Override
	public void setText(String text) {
		this.textBox.setText(text);
		this.getUiHandlers().onTextChange(false);
	}
    
	@Override
	public void setFocus (boolean val) {
		this.textBox.setFocus(val);
	}
}