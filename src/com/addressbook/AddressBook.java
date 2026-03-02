package com.addressbook;

import java.util.ArrayList;

public class AddressBook {
    ArrayList<ContactPerson> contactList = new ArrayList<>();

    public void addContact(ContactPerson contact) {
        contactList.add(contact);
        System.out.println("Contact Added: " + contact.firstName + " " + contact.lastName);
    }

    public void editContact(String firstName, String lastName,
                            String newAddress, String newCity, String newState,
                            String newZip, String newPhoneNumber, String newEmail) {
        boolean found = false;
        for (ContactPerson contact : contactList) {
            if (contact.firstName.equalsIgnoreCase(firstName) &&
                    contact.lastName.equalsIgnoreCase(lastName)) {
                contact.address = newAddress;
                contact.city = newCity;
                contact.state = newState;
                contact.zip = newZip;
                contact.phoneNumber = newPhoneNumber;
                contact.email = newEmail;
                System.out.println("Contact Updated: " + contact.firstName + " " + contact.lastName);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact Not Found: " + firstName + " " + lastName);
        }
    }

    public void deleteContact(String firstName, String lastName) {
        boolean found = false;
        for (ContactPerson contact : contactList) {
            if (contact.firstName.equalsIgnoreCase(firstName) &&
                    contact.lastName.equalsIgnoreCase(lastName)) {
                contactList.remove(contact);
                System.out.println("Contact Deleted: " + contact.firstName + " " + contact.lastName);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact Not Found: " + firstName + " " + lastName);
        }
    }

    public void displayAllContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No Contacts Found!");
            return;
        }
        System.out.println("\n--- All Contacts ---");
        for (ContactPerson contact : contactList) {
            System.out.println(contact.firstName + " " + contact.lastName +
                    " | " + contact.address +
                    " | " + contact.city +
                    " | " + contact.state +
                    " | " + contact.zip +
                    " | " + contact.phoneNumber +
                    " | " + contact.email);
        }
    }
}