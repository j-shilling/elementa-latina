package com.elementa.server.api;

import javax.inject.Singleton;

import com.elementa.shared.api.DictionaryResource;
import com.elementa.shared.api.LogsResource;
import com.elementa.shared.api.UsersResource;
import com.google.inject.AbstractModule;
import com.elementa.server.api.JacksonProvider;

public class ApiModule extends AbstractModule {
    @Override
    protected void configure() {
    	bind(JacksonProvider.class).in(Singleton.class);

        bind(UsersResource.class).to(UsersResourceImpl.class);
        bind(LogsResource.class).to(LogsResourceImpl.class);
        bind(DictionaryResource.class).to(DictionaryResourceImpl.class);
    }
}
