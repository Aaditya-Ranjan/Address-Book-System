package com.addressbook;

public class AddressBook {
    ContactPerson contact;

    public void addContact(ContactPerson contact) {
        this.contact = contact;
        System.out.println("Contact Added: " + contact.firstName + " " + contact.lastName);
    }
}