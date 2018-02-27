package com.elementa.client.widgets.actionbutton;

import com.elementa.client.resources.ResourceLoader;
import com.elementa.client.widgets.actionbutton.ActionButtonPresenter;
import com.elementa.client.widgets.actionbutton.ActionButtonView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ActionButtonGwtTest extends GWTTestCase {

	public static int count = 0;

	public static class Handler implements Action {

		@Override
		public void execute() {
			count++;
		}

	}

	public static class TestModule extends AbstractPresenterModule {

		@Override
		protected void configure() {
			bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
			bind(ResourceLoader.class).asEagerSingleton();

			bindPresenterWidget(ActionButtonPresenter.class, ActionButtonPresenter.MyView.class,
					ActionButtonView.class);
		}

	}

	@GinModules(TestModule.class)
	public interface Injector extends Ginjector {
		public static final Injector INSTANCE = GWT.create(Injector.class);

		public ActionButtonPresenter getActionButton();
	}

	@Override
	public String getModuleName() {
		return "com.elementa.Elementa";
	}

	public void testActionButtonMultiHandlers() {
		ActionButtonPresenter btn = Injector.INSTANCE.getActionButton();

		btn.setAction(new Handler());
		btn.setAction(new Handler());
		btn.setAction(new Handler());
		btn.setAction(new Handler());
		btn.setAction(new Handler());
		btn.setAction(new Handler());
		btn.setAction(new Handler());

		count = 0;
		btn.click();

		assertTrue(count == 1);
	}

	public void testActionButtonDisable() {
		ActionButtonPresenter btn = Injector.INSTANCE.getActionButton();

		btn.setAction(new Handler());

		btn.disable();
		count = 0;
		btn.click();

		assertTrue(count == 0);
	}

	public void testActionButtonDisableEnable() {
		ActionButtonPresenter btn = Injector.INSTANCE.getActionButton();

		btn.setAction(new Handler());

		btn.disable();
		btn.enable();
		count = 0;
		btn.click();

		assertTrue(count == 1);
	}
}
