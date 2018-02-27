package com.elementa.server.guice;

import com.google.inject.AbstractModule;
import com.elementa.server.api.ApiModule;
import com.elementa.server.dao.DaoModule;
import com.elementa.server.language.LanguageModule;
import com.elementa.server.security.SecurityModule;
import com.elementa.shared.SharedGuiceModule;

public class ServerModule extends AbstractModule {
	@Override
    protected void configure() {
		install(new SecurityModule());
		install(new ApiModule());
        install(new DaoModule());
        install(new LanguageModule());
        install(new SharedGuiceModule());
    }
}
