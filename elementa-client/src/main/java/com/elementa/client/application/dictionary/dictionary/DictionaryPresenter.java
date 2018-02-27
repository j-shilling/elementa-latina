package com.elementa.client.application.dictionary.dictionary;

import com.elementa.client.application.ApplicationPresenter;
import com.elementa.client.place.HasTitle;
import com.elementa.client.place.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class DictionaryPresenter 
		extends Presenter<DictionaryPresenter.MyView, DictionaryPresenter.MyProxy> 
		implements HasTitle {
    interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.DICTIONARY)
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<DictionaryPresenter> {
    }

    @Inject
    DictionaryPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
    }

	@Override
	public String getTitle() {
		return "Dictionary";
	}
}
