package com.telRan.addressbook.test;

import com.telRan.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.openHome();
        if (!app.isPresent()) {
            app.getContactHelper().addNewContact();
        }

    }
    @Test
    public void testsContactModification(){
        app.getNavigationHelper().openSite("\"http://localhost/addressbook/index.php");
        app.getContactHelper().editContact();
        app.getContactHelper().fillNewContactForm(new ContactData("Pablo","Dominguez","La casa de papel","09463728234","pablo.cocaina@gmail.com"));
        app.getContactHelper().submitEditContact();

    }

}
