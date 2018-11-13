package com.telRan.addressbook.model;

public class ContactData {
    private  String firstName;
    private  String lastName;
    private  String address;
    private  String phoneMobile;
    private  String email;

    public ContactData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData setAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
        return this;
    }

    public ContactData setEmail(String email) {
        this.email = email;
    return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneMobile='" + phoneMobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
