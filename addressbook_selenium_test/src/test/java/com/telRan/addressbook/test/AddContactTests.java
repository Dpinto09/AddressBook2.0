package com.telRan.addressbook.test;

import com.telRan.addressbook.dataProvider.ContactsProvider;
import com.telRan.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @Test(dataProvider = "validContact",
    dataProviderClass = ContactsProvider.class)
    public void testsAddContact(ContactData contactData) {

        app.getContactHelper().addNewContact();

        app.getContactHelper().fillNewContactForm(contactData);
        app.getContactHelper().submitNewContact();

        app.getContactHelper().addNewContact();
        app.getContactHelper().fillNewContactForm(contactData);
        app.getContactHelper().submitNewContact();

    }

}
