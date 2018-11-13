package com.telRan.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.openHome();
        if (!app.isGroupPresent()) {
            app.getContactHelper().addNewContact();
        }

    }

    @Test
    public void testsDeleteFirstContact() {

        int before = app.getContactHelper().getContactsCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmAlert();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after, before - 1);

    }

    @Test
    public void testsDeleteLastContact() {

        int before = app.getContactHelper().getContactsCount();
        app.selectByIndex(before - 1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmAlert();
        app.openHome();

        int after = app.getContactHelper().getContactsCount();

        Assert.assertEquals(after, before - 1);


    }

    @Test
    public void testsDeleteAllContacts() {

        app.getContactHelper().selectAllContacts();
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmAlert();
        app.openHome();
    }

}
