package com.telran.repeat.test;


import com.telran.repeat.model.Contact;

import com.telran.repeat.provider.StaticProvider;

import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;


public class ContactModificationTest extends TestBase {

    @BeforeMethod

    public void ensurePreconditions() {


        app.getNavigationHelper().openHomePage();


        if (!app.getContactHelper().isContactPresent()) {

            app.getContactHelper().createContact();

        }

    }


    @Test(dataProvider = "validContact", dataProviderClass = StaticProvider.class)

    public void testsContactModification(Contact contact) {


        app.getContactHelper().initContactModification();

        app.getContactHelper().fillContactForm(contact);

        app.getContactHelper().confirmContactModification();


    }


}