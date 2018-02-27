package com.elementa.client.resources;

import javax.inject.Inject;

public class ResourceLoader {
    @Inject
    ResourceLoader(
    		AppResources appResources) {
        appResources.normalize().ensureInjected();
        appResources.style().ensureInjected();
        appResources.w3().ensureInjected();
        appResources.theme().ensureInjected();
    }
}
