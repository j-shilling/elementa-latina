package com.elementa.client.widgets;

import com.google.gwt.event.shared.EventHandler;

@FunctionalInterface
public interface ValidityChangeHandler extends EventHandler {
	public void onChange (ValidityChangeEvent event);
}
