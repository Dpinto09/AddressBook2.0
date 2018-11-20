package com.telran.repeat.test;


import com.telran.repeat.model.Contact;
import com.telran.repeat.provider.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ContactCreationTest extends TestBase {


    @BeforeMethod

    public void ensurePrecondition() {

        if (!app.getContactHelper().isOnTheHomePage()) {

            app.getNavigationHelper().openHomePage();

        }

    }


    @Test(dataProvider = "validContact", dataProviderClass = StaticProvider.class)


    public void createContactTest(Contact contact) {


        int before = app.getContactHelper().getContactCount();


        app.getContactHelper().initContactCreation();

        app.getContactHelper().fillContactForm(contact);

        app.getContactHelper().confirmContactCreation();


        int after = app.getContactHelper().getContactCount();


        Assert.assertEquals(after, before + 1);

    }

}