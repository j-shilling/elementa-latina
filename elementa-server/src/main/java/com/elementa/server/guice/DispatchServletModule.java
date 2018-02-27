package com.elementa.server.guice;

import com.google.inject.servlet.ServletModule;
import com.arcbees.guicyresteasy.GuiceRestEasyFilterDispatcher;
import com.elementa.shared.api.ApiPaths;

public class DispatchServletModule extends ServletModule {
    @Override
    public void configureServlets() {
    	filter(ApiPaths.ROOT + "/*").through(GuiceRestEasyFilterDispatcher.class);
    }
}
