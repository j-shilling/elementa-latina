package com.elementa.client.application;

import com.elementa.client.application.navigation.NavPresenter;
import com.elementa.shared.api.UsersResource;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.NavigationEvent;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;

public class ApplicationPresenter
        extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> 
		implements ApplicationUiHandlers {
	
    interface MyView extends View, HasUiHandlers<ApplicationUiHandlers> {
    	public void setTitle(String text);
    }

    @ProxyStandard
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    public static final NestedSlot SLOT_MAIN = new NestedSlot();
    public static final PermanentSlot<MessengerPresenter> MESSENGER = new PermanentSlot<>();
    private final NavPresenter navPresenter;

    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            NavPresenter navPresenter,
            MessengerPresenter messenger,
            ResourceDelegate<UsersResource> users) {
        super(eventBus, view, proxy, RevealType.Root);
        this.getView().setUiHandlers(this);
        this.navPresenter = navPresenter;
        this.setInSlot(MESSENGER, messenger);
        
        this.getEventBus().addHandler(NavigationEvent.getType(), event -> {
        	messenger.fine("");
        });
    }

	@Override
	public void onOpenNav() {
		this.addToPopupSlot(navPresenter);
	}
}
