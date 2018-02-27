package com.elementa.client.widgets.accidentlistbox;

import javax.inject.Inject;

import com.elementa.client.StringFactory;
import com.elementa.client.widgets.SelfStylingWidget;
import com.elementa.client.widgets.WidgetStyler;
import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.accidence.AccidentType;
import com.google.common.base.Preconditions;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class AccidentListBoxPresenter 
		extends PresenterWidget<AccidentListBoxPresenter.MyView>
		implements SelfStylingWidget {

	interface MyView extends View {
		WidgetStyler getStyler();
		void addItem (String item, String value);
		void clear();
		int getItemCount();
		String getValue(int index);
		void setSelectedIndex(int index);
		String getSelectedValue();
		HandlerRegistration addClickHandler (ClickHandler handler);
	}
	
	private final StringFactory strings;
	
	@Inject
	public AccidentListBoxPresenter(
			EventBus eventBus, 
			MyView view,
			StringFactory strings) {
		super(eventBus, view);
		
		this.strings = strings;
		
		this.setType(AccidentType.NO_TYPE);
	}
	
	public void setType (AccidentType type) {
		Preconditions.checkNotNull(type, "Cannot set type to null.");
		
		this.getView().clear();
		for (Accident val : type.getValues()) {
			this.getView().addItem(this.strings.toString(val), 
					Integer.toString(val.toInt()));
		}
	}
	
	public void setSelected (Accident val) {
		Preconditions.checkNotNull(val, "Cannot set value to null");
		
		for (int i = 0; i < this.getView().getItemCount(); i++) {
			if (this.getView().getValue(i).equals(Integer.toString(val.toInt()))) {
				this.getView().setSelectedIndex(i);
				return;
			}
		}
		
		throw new IllegalArgumentException ("Cannot set the value of this listbox to " + val);
	}
	
	public Accident getSelected() {
		return Accident.fromInt(Integer.parseInt(this.getView().getSelectedValue()));
	}
	
	public HandlerRegistration addClickHandler (ClickHandler handler) {
		return this.getView().addClickHandler(handler);
	}

	@Override
	public WidgetStyler getStyler() {
		return this.getView().getStyler();
	}

}
