package com.elementa.language.form;

public class TestFormModule extends FormAbstractModule {

	@Override
	protected Class<? extends FormFactory> factory() {
		return FormFactoryImpl.class;
	}

}
