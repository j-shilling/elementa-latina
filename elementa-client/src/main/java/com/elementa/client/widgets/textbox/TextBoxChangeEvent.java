package com.elementa.client.widgets.textbox;

import com.google.gwt.event.shared.GwtEvent;

public class TextBoxChangeEvent extends GwtEvent<TextBoxChangeHandler> {
	
	public static Type<TextBoxChangeHandler> TYPE = new Type<TextBoxChangeHandler>();
	
	private final boolean manual;
	
	public TextBoxChangeEvent(boolean val) {
		this.manual = val;
	}
	
	public boolean isManualChange() {
		return this.manual;
	}
	
	@Override
	public Type<TextBoxChangeHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(TextBoxChangeHandler handler) {
		handler.onTextBoxChange(this);
	}

}
