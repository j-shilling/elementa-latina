package com.elementa.client.widgets.textbox;

import com.elementa.client.widgets.HasValidity;
import com.elementa.client.widgets.SelfStylingWidget;
import com.elementa.client.widgets.ValidityChecker;
import com.elementa.client.widgets.WidgetStyler;
import com.google.common.base.Optional;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.ui.HasText;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

abstract public class AbstractTextBoxPresenter 
		extends PresenterWidget<AbstractTextBoxPresenter.MyView>
		implements TextBoxUiHandlers, SelfStylingWidget, HasValidity, HasText {
	
	private boolean required;
	private Optional<Boolean> valid;
	private Optional<ValidityChecker> checker;
	
	private final HandlerManager hm;
	
    interface MyView extends View, HasUiHandlers<TextBoxUiHandlers>  {
    	WidgetStyler getStyler();
    	void setValid();
    	void setInvalid();
    	void setNeutral();
    	
    	String getText();
    	void setText(String text);
    	void setFocus (boolean val);
    }

    AbstractTextBoxPresenter(
            EventBus eventBus,
            MyView view) {
        super(eventBus, view);
        
        this.hm = new HandlerManager(this);
        
        this.required = false;
        this.valid = Optional.absent();
        this.checker = Optional.absent();
        
        this.getView().setUiHandlers(this);
        
        this.getView().setText("");
        
        this.addValidityChangeHandler(event -> {
        	
        	if (AbstractTextBoxPresenter.this.isInvalid()) {
        		AbstractTextBoxPresenter.this.getView().setInvalid();
        		return;
        	}
        	
        	if (AbstractTextBoxPresenter.this.isValid()) {
        		AbstractTextBoxPresenter.this.getView().setValid();
        		return;
        	}
        	
        	AbstractTextBoxPresenter.this.getView().setNeutral();
        	return;
        	
        });
        
    }
    
    public boolean isRequired() {
    	return this.required;
    }
    
    public void setRequired(boolean val) {
    	this.required = val;
    	this.onTextChange(false);
    }
    
    public void setRegex (String regex) {
    	this.setValidityChecker(o -> {
    		RegExp r = RegExp.compile(regex);
			MyView view = this.getView();
			String text = view.getText();
			
			MatchResult matcher = r.exec(text);
			
			if (matcher != null) {
				this.setValid();
			} else if (!this.isRequired() && text.isEmpty()) {
				this.setNeutral();
			} else {
				this.setInvalid();
			}
    	});
    }
    
    @Override
	public HandlerManager getHandlerManager() {
    	return this.hm;
    }
    
    @Override
    public void setText(String text) {
    	this.getView().setText(text);
    }
    
	@Override
	public String getText() {
		return this.getView().getText();
	}

	@Override
	public void onTextChange(boolean manual) {
		
		this.check();
		this.hm.fireEvent(new TextBoxChangeEvent(manual));
	}

	@Override
	public WidgetStyler getStyler() {
		return this.getView().getStyler();
	}

	public HandlerRegistration addTextBoxChangeHandler(TextBoxChangeHandler handler) {
		return hm.addHandler(TextBoxChangeEvent.TYPE, handler);
	}
	
	public void setFocus (boolean val) {
		this.getView().setFocus(val);
	}
    
	@Override
	public Optional<Boolean> getValidityValue() {
		return this.valid;
	}

	@Override
	public void setValidityValue(Optional<Boolean> val) {
		this.valid = val;
	}

	@Override
	public void setValidityChecker(ValidityChecker checker) {
		this.checker = Optional.fromNullable(checker);
	}

	@Override
	public Optional<ValidityChecker> getValidityChecker() {
		return this.checker;
	}
}