package com.telRan.addressbook.manager;

import com.telRan.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {



    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewContact() {

        click(By.name("submit"));
    }

    public void fillNewContactForm(ContactData contactData) {
        click(By.xpath("//a[@href='edit.php']"));
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getPhoneMobile());
        type(By.name("email"), contactData.getEmail());
        submitNewContact();

    }

    public void addNewContact() {
       click(By.xpath("//a[@href='edit.php']"));

    }

    public void submitEditContact() {
        click(By.name("update"));
    }

    public void editContact() {

        click(By.xpath("//img[@title='EDIT']"));
    }

    public int getContactsCount() {

        return wd.findElements(By.name("selected[]")).size();
    }

    public void confirmAlert() {

        wd.switchTo().alert().accept();
    }

    public void deleteContact() {

        click(By.xpath("//input[@value='DELETE']"));

    }

    public void selectContact() {

        click(By.name("selected[]"));

    }

    public void selectAllContacts() {
        click(By.id("MassCB"));
    }
}
