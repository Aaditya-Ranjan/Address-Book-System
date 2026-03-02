package com.addressbook;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        ContactPerson contact = new ContactPerson(
                "John", "Doe",
                "123 Main St", "New York", "NY", "10001",
                "9876543210", "john.doe@email.com"
        );

        System.out.println("Contact Created: " + contact.firstName + " " + contact.lastName);
    }
}