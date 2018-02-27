package com.elementa.client.application.dictionary.dictionary;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class DictionaryView extends ViewImpl implements DictionaryPresenter.MyView {
    interface Binder extends UiBinder<Widget, DictionaryView> {
    }

    @Inject
    DictionaryView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
