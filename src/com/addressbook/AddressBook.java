package com.addressbook;

public class AddressBook {
    ContactPerson contact;

    public void addContact(ContactPerson contact) {
        this.contact = contact;
        System.out.println("Contact Added: " + contact.firstName + " " + contact.lastName);
    }

    public void editContact(String firstName, String lastName,
                            String newAddress, String newCity, String newState,
                            String newZip, String newPhoneNumber, String newEmail) {
        if (contact.firstName.equalsIgnoreCase(firstName) &&
                contact.lastName.equalsIgnoreCase(lastName)) {
            contact.address = newAddress;
            contact.city = newCity;
            contact.state = newState;
            contact.zip = newZip;
            contact.phoneNumber = newPhoneNumber;
            contact.email = newEmail;
            System.out.println("Contact Updated: " + contact.firstName + " " + contact.lastName);
        } else {
            System.out.println("Contact Not Found: " + firstName + " " + lastName);
        }
    }

    public void deleteContact(String firstName, String lastName) {
        if (contact.firstName.equalsIgnoreCase(firstName) &&
                contact.lastName.equalsIgnoreCase(lastName)) {
            System.out.println("Contact Deleted: " + contact.firstName + " " + contact.lastName);
            contact = null;
        } else {
            System.out.println("Contact Not Found: " + firstName + " " + lastName);
        }
    }
}