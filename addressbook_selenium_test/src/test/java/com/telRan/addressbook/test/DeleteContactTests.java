package com.telRan.addressbook.test;

import com.telRan.addressbook.dataProvider.StaticProvider;
import com.telRan.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {


    @BeforeMethod

    public void ensurePreconditions() {
        app.openHome();
        if (!app.isContactPresent()) {
            app.getContactHelper().fillNewContactForm(new ContactData().setFirstName("Default_First_Name").setLastName("Default_Last_Name").setAddress("Default_Address").setPhoneMobile("Default_Phone_Number").setEmail("Default_Email"));
            app.getContactHelper().fillNewContactForm(new ContactData().setFirstName("Default_First_Name").setLastName("Default_Last_Name").setAddress("Default_Address").setPhoneMobile("Default_Phone_Number").setEmail("Default_Email"));
            app.getContactHelper().fillNewContactForm(new ContactData().setFirstName("Default_First_Name").setLastName("Default_Last_Name").setAddress("Default_Address").setPhoneMobile("Default_Phone_Number").setEmail("Default_Email"));
            app.getContactHelper().fillNewContactForm(new ContactData().setFirstName("Default_First_Name").setLastName("Default_Last_Name").setAddress("Default_Address").setPhoneMobile("Default_Phone_Number").setEmail("Default_Email"));

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
    public void testsDeleteAllContacts() throws InterruptedException {

        app.getContactHelper().selectAllContacts();
        app.getContactHelper().deleteContact();
        Thread.sleep(3000);
        app.getContactHelper().confirmAlert();
        app.openHome();
    }

}
