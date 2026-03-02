package com.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    static Scanner scanner = new Scanner(System.in);

    public static ContactPerson getContactFromConsole() {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.print("Enter State: ");
        String state = scanner.nextLine();

        System.out.print("Enter Zip: ");
        String zip = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        return new ContactPerson(firstName, lastName, address,
                city, state, zip, phoneNumber, email);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        AddressBook addressBook = new AddressBook();

        // Add Multiple Contacts
        System.out.println("\n--- Add Contacts ---");
        String addMore = "yes";
        while (addMore.equalsIgnoreCase("yes")) {
            ContactPerson contact = getContactFromConsole();
            addressBook.addContact(contact);
            System.out.print("Add another contact? (yes/no): ");
            addMore = scanner.nextLine();
        }

        // Display All Contacts
        addressBook.displayAllContacts();

        // Edit Contact
        System.out.println("\n--- Edit Contact ---");
        System.out.print("Enter First Name to Edit: ");
        String editFirstName = scanner.nextLine();
        System.out.print("Enter Last Name to Edit: ");
        String editLastName = scanner.nextLine();
        System.out.print("Enter New Address: ");
        String newAddress = scanner.nextLine();
        System.out.print("Enter New City: ");
        String newCity = scanner.nextLine();
        System.out.print("Enter New State: ");
        String newState = scanner.nextLine();
        System.out.print("Enter New Zip: ");
        String newZip = scanner.nextLine();
        System.out.print("Enter New Phone Number: ");
        String newPhoneNumber = scanner.nextLine();
        System.out.print("Enter New Email: ");
        String newEmail = scanner.nextLine();

        addressBook.editContact(editFirstName, editLastName,
                newAddress, newCity, newState,
                newZip, newPhoneNumber, newEmail);

        // Delete Contact
        System.out.println("\n--- Delete Contact ---");
        System.out.print("Enter First Name to Delete: ");
        String deleteFirstName = scanner.nextLine();
        System.out.print("Enter Last Name to Delete: ");
        String deleteLastName = scanner.nextLine();

        addressBook.deleteContact(deleteFirstName, deleteLastName);

        // Display All Contacts After Changes
        addressBook.displayAllContacts();

        scanner.close();
    }
}