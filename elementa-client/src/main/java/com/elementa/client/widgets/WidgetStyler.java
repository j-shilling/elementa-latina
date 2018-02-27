package com.elementa.client.widgets;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.user.client.ui.UIObject;

public class WidgetStyler {
	private final Set<String> styles;
	private final UIObject w;
	
	public WidgetStyler (UIObject obj) {
		w = obj;
		styles = new HashSet<String>();
	}
	
	public void addStyle(String name) {
		if (name == null) {
			return;
		}
		if (name.isEmpty()) {
			return;
		}
		styles.add(name);
	}
	
	public void delStyle(String name) {
		styles.remove(name);
	}
	
	public void setStyles() {
		if (styles == null || styles.isEmpty()) {
			return;
		}
		
		String[] strs = styles.toArray(new String[0]);
		
		w.setStyleName(strs[0]);
					
		for (int i = 1; i < strs.length; i ++) {
			w.addStyleName(strs[i]);
		}
		
	}

	public void addStyle(String...names) {
		for (int i = 0; i < names.length; i++) {
			addStyle(names[i]);
		}
	}
	
	public Set<String> getStyles() {
		return styles;
	}
}
