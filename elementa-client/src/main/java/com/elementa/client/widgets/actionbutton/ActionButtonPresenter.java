package com.elementa.client.widgets.actionbutton;

import com.elementa.client.resources.AppResources;
import com.elementa.client.widgets.SelfStylingWidget;
import com.elementa.client.widgets.WidgetStyler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class ActionButtonPresenter 
		extends PresenterWidget<ActionButtonPresenter.MyView>
		implements ActionButtonUiHandlers, SelfStylingWidget {
	
    protected interface MyView extends View, HasUiHandlers<ActionButtonUiHandlers>, SelfStylingWidget  {
    	public void setText(String text);
    }
    
    Action action = null;
    boolean enabled = false;
    AppResources res = null;

    @Inject
    ActionButtonPresenter(
            EventBus eventBus,
            MyView view,
            AppResources res) {
        super(eventBus, view);
        this.getView().setUiHandlers(this);
        this.res = res;
    }
    
    public void setAction (Action action) {
    	this.action = action;
    	this.enabled = true;
    }
    
    public boolean isEnabled() {
    	return this.enabled;
    }
    
    public void setEnabled(boolean val) {
    	if (val)
    		this.enable();
    	else
    		this.disable();
    }
    
    public void disable() {
    	this.addStyle(res.w3().Disabled());
    	this.enabled = false;
    }
    
    public void enable() {
    	this.delStyle(res.w3().Disabled());
    	this.enabled = true;
    }
    
    public void setText (String text) {
    	this.getView().setText(text);
    }
    
    @Override
    public void click() {
    	if (this.enabled && (this.action != null))
    		this.action.execute();
    }

	@Override
	public WidgetStyler getStyler() {
		return this.getView().getStyler();
	}
    
}