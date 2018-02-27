package com.elementa.client.application.dictionary.editwordforms;

import com.elementa.client.StringConstants;
import com.elementa.client.application.AdminOnlyGatekeeper;
import com.elementa.client.application.ApplicationPresenter;
import com.elementa.client.place.HasTitle;
import com.elementa.client.place.NameTokens;
import com.elementa.client.place.ParameterTokens;
import com.elementa.client.widgets.paradigm.ParadigmPresenter;
import com.elementa.shared.dto.Paradigm;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class EditWordFormsPresenter 
		extends Presenter<EditWordFormsPresenter.MyView, EditWordFormsPresenter.MyProxy>
		implements HasTitle {
	
	

	interface MyView extends View {
		void print (String text);
		void clear();
    }

    @NameToken(NameTokens.EDIT_WORD_FORMS)
    @ProxyStandard
    @UseGatekeeper (AdminOnlyGatekeeper.class)
    interface MyProxy extends ProxyPlace<EditWordFormsPresenter> {
    }
    
    public static PermanentSlot<ParadigmPresenter> SLOT = new PermanentSlot<>();
    
    private final ParadigmPresenter paradigm;
    private final StringConstants constants;
    
    @Inject
    public EditWordFormsPresenter(
    		EventBus eventBus, 
    		MyView view,
    		MyProxy proxy,
    		ParadigmPresenter paradigm,
    		StringConstants constants) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
		
		this.setInSlot(SLOT, paradigm);
		this.paradigm = paradigm;
		this.constants = constants;
	}
    
    @Override
	public void prepareFromRequest(PlaceRequest request) {
		String str = request.getParameter(ParameterTokens.PARADIGM, "");
		Paradigm paradigm = new Paradigm (str);
		
		this.paradigm.setParadigm(paradigm);
		
		super.prepareFromRequest(request);
    }

	@Override
	public String getTitle() {
		return this.constants.editWordForms();
	}
    
    
}
