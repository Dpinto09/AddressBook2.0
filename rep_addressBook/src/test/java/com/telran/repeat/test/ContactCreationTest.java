package com.telran.repeat.test;


import com.telran.repeat.model.Contact;
import com.telran.repeat.provider.StaticProvider;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;


public class ContactCreationTest extends TestBase {


    @BeforeMethod

    public void ensurePrecondition() {

        if (!app.getContactHelper().isOnTheHomePage()) {

            app.getNavigationHelper().openHomePage();

        }

    }


    @Test(dataProvider = "validContact", dataProviderClass = StaticProvider.class)

    public void createContactTest1(Contact contact) {


        int before = app.getContactHelper().getContactCount();


        app.getContactHelper().initContactCreation();

        app.getContactHelper().fillContactForm(contact);


        app.getContactHelper().confirmContactCreation();


        int after = app.getContactHelper().getContactCount();


        Assert.assertEquals(after, before + 1);

    }

    @Test
    public void createContactTest2() {


        int before = app.getContactHelper().getContactCount();


        app.getContactHelper().initContactCreation();

        app.getContactHelper().fillContactForm(new Contact().setfName("FName").setlName("LName").setEmail("Email").setPhoneHome("Phone").setGroup("test4").setPhoto(new File("src/test/resources/ButtonActivateInProfilPage.jpg")));


        app.getContactHelper().confirmContactCreation();


        int after = app.getContactHelper().getContactCount();


        Assert.assertEquals(after, before + 1);

    }
}