package com.elementa.server.language;

import com.elementa.language.form.FormAbstractModule;
import com.elementa.language.form.FormFactory;

public class FormModule extends FormAbstractModule {

	@Override
	protected Class<? extends FormFactory> factory() {
		return FormFactoryImpl.class;
	}

}
