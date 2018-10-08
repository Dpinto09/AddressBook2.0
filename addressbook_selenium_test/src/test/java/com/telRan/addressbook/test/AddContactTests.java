package com.telRan.addressbook.test;

import com.telRan.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @Test
    public void testsAddContact() {

        app.getContactHelper().addNewContact();
        app.getContactHelper().fillNewContactForm(new ContactData("Amit", "Benjamin", "בר כוכבא 209 אשקלון", "0585162383", "stev.sarfati@gmail.com"));
        app.getContactHelper().submitNewContact();

        app.getContactHelper().addNewContact();
        app.getContactHelper().fillNewContactForm(new ContactData("Ben", "Nadjer", "Ashdod", "026346179", "zizidu95@gmail.com"));
        app.getContactHelper().submitNewContact();

    }

}
