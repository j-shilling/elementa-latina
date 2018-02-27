package com.elementa.client.widgets.paradigm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.elementa.client.resources.AppResources;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;

class ParadigmTab extends Composite implements HasWidgets, IsWidget, ParadigmTabComponent {
	
	private final TabPanel panel = new TabPanel();
	private final AppResources res = GWT.create(AppResources.class);
	private final List<Label> tabs = new ArrayList<>();
	
	private String text = new String();
	
	
	public ParadigmTab() {
		initWidget(this.panel);
		
		panel.getDeckPanel().setStyleName(this.res.w3().Border0());
		panel.getTabBar().setStyleName(this.res.w3().Border0());
		panel.getTabBar().addStyleName(this.res.w3().MarginTop());
		
		panel.addSelectionHandler(new SelectionHandler<Integer> () {

			@Override
			public void onSelection(SelectionEvent<Integer> event) {
				int index = event.getSelectedItem();
				
				for (int i = 0; i < panel.getWidgetCount(); i++) {
					Label label = tabs.get(i);
					
					if (i == index) {
						label.removeStyleName(res.theme().Light2());
						label.addStyleName(res.theme().Light3());
					} else {
						label.removeStyleName(res.theme().Light3());
						label.addStyleName(res.theme().Light2());
					}
				}
			}
			
		});
	}

	@Override
	public Widget asWidget() {
		return this.panel;
	}

	@Override
	public void add(Widget w) {
		if (w instanceof ParadigmTabComponent) {
			Label tab = new Label (((ParadigmTabComponent)w).getLabelText());
			
			tab.setStyleName(this.res.w3().Large());
			tab.addStyleName(this.res.w3().Padding());
			tab.addStyleName(this.res.w3().Button());
			tab.addStyleName(this.res.theme().Light3());
			
			this.tabs.add(tab);
			
			SimplePanel panel = new SimplePanel();
			panel.setStyleName(this.res.w3().Row());
			panel.add(w);
			
			this.panel.add(panel, tab);
			this.panel.selectTab(0);
			return;
		}
		
		throw new IllegalArgumentException ("Only ParadigmTabComponents can be added to a ParadigmTab");
	}

	@Override
	public void clear() {
		this.tabs.clear();
		this.panel.clear();
	}

	@Override
	public Iterator<Widget> iterator() {
		return this.panel.iterator();
	}

	@Override
	public boolean remove(Widget w) {
		int index = this.panel.getWidgetIndex(w);
		this.tabs.remove(index);
		return this.panel.remove(w);
	}

	@Override
	public String getLabelText() {
		return this.text;
	}

	@Override
	public void setLabelText(String text) {
		this.text = text;
	}

}
