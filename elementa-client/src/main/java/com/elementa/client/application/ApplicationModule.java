package com.elementa.client.application;

import com.elementa.client.application.accounts.AccountInformationModule;
import com.elementa.client.application.accounts.editaccount.EditAccountModule;
import com.elementa.client.application.accounts.manageaccounts.ManageAccountsModule;
import com.elementa.client.application.dictionary.dictionary.DictionaryModule;
import com.elementa.client.application.dictionary.editwordforms.EditWordFormsModule;
import com.elementa.client.application.dictionary.managedictionary.ManageDictionaryModule;
import com.elementa.client.application.login.LoginModule;
import com.elementa.client.application.navigation.NavModule;
import com.elementa.client.widgets.accidentlistbox.AccidentListBoxModule;
import com.elementa.client.widgets.actionbutton.ActionButtonModule;
import com.elementa.client.widgets.authenticator.AuthenticatorModule;
import com.elementa.client.widgets.paradigm.ParadigmModule;
import com.elementa.client.widgets.textbox.TextBoxModule;
import com.elementa.client.widgets.textbox.PasswordTextBoxModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new ManageAccountsModule());
		install(new ManageDictionaryModule());
		install(new EditWordFormsModule());
		install(new EditAccountModule());
		install(new DictionaryModule());
        install(new LoginModule());
        install(new NavModule());
        install(new MessengerModule());
        install(new AuthenticatorModule());
        install(new AccidentListBoxModule());
        install(new ParadigmModule());
        
        install(new AccountInformationModule());
        install(new ActionButtonModule());
        install(new TextBoxModule());
        install(new PasswordTextBoxModule());

        bindPresenter(ApplicationPresenter.class, 
        		ApplicationPresenter.MyView.class, 
        		ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
