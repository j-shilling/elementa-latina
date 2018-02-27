package com.elementa.client.gin;

import com.elementa.client.CurrentUser;
import com.elementa.client.Logger;
import com.elementa.client.application.ApplicationModule;
import com.elementa.client.place.NameTokens;
import com.elementa.client.resources.ResourceLoader;
import com.elementa.shared.SharedGinModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule
                .Builder()
                .defaultPlace(NameTokens.DICTIONARY)
                .errorPlace(NameTokens.DICTIONARY)
                .unauthorizedPlace(NameTokens.LOGIN)
                .build());
        install(new DispatchModule());
        install(new SharedGinModule());
        install(new ApplicationModule());

        bind(ResourceLoader.class).asEagerSingleton();
        bind(CurrentUser.class).asEagerSingleton();
        bind(Logger.class).asEagerSingleton();
    }
}
