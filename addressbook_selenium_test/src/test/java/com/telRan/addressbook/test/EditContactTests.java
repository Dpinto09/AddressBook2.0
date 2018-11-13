package com.telRan.addressbook.test;

import com.telRan.addressbook.dataProvider.ContactsProvider;
import com.telRan.addressbook.dataProvider.GroupsProvider;
import com.telRan.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.openHome();
        if (!app.isGroupPresent()) {
            app.getContactHelper().addNewContact();
        }

    }
    @Test(dataProvider = "validContact", dataProviderClass = ContactsProvider.class)
    public void testsContactModification(ContactData contactData){
        app.getNavigationHelper().openSite("http://localhost/addressbook/index.php");
        app.getContactHelper().editContact();
        app.getContactHelper().fillNewContactForm(contactData);
        app.getContactHelper().submitEditContact();

    }

}
