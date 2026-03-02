package com.addressbook;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {

    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, AddressBook> addressBookDictionary = new HashMap<>();

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

    public static AddressBook getOrCreateAddressBook(String name) {
        if (!addressBookDictionary.containsKey(name)) {
            addressBookDictionary.put(name, new AddressBook());
            System.out.println("New Address Book Created: " + name);
        } else {
            System.out.println("Using Existing Address Book: " + name);
        }
        return addressBookDictionary.get(name);
    }

    public static void displayAllAddressBooks() {
        if (addressBookDictionary.isEmpty()) {
            System.out.println("No Address Books Found!");
            return;
        }
        System.out.println("\n--- All Address Books ---");
        for (String name : addressBookDictionary.keySet()) {
            System.out.println("\nAddress Book: " + name);
            addressBookDictionary.get(name).displayAllContacts();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        String continueAdding = "yes";
        while (continueAdding.equalsIgnoreCase("yes")) {

            // Get Address Book Name
            System.out.print("\nEnter Address Book Name: ");
            String addressBookName = scanner.nextLine();
            AddressBook addressBook = getOrCreateAddressBook(addressBookName);

            // Add Contacts to this Address Book
            System.out.println("\n--- Add Contacts to " + addressBookName + " ---");
            String addMore = "yes";
            while (addMore.equalsIgnoreCase("yes")) {
                ContactPerson contact = getContactFromConsole();
                addressBook.addContact(contact);
                System.out.print("Add another contact? (yes/no): ");
                addMore = scanner.nextLine();
            }

            // Edit Contact in this Address Book
            System.out.println("\n--- Edit Contact in " + addressBookName + " ---");
            System.out.print("Enter First Name to Edit (or skip to press Enter): ");
            String editFirstName = scanner.nextLine();
            if (!editFirstName.isEmpty()) {
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
            }

            // Delete Contact in this Address Book
            System.out.println("\n--- Delete Contact in " + addressBookName + " ---");
            System.out.print("Enter First Name to Delete (or skip to press Enter): ");
            String deleteFirstName = scanner.nextLine();
            if (!deleteFirstName.isEmpty()) {
                System.out.print("Enter Last Name to Delete: ");
                String deleteLastName = scanner.nextLine();
                addressBook.deleteContact(deleteFirstName, deleteLastName);
            }

            System.out.print("\nAdd another Address Book? (yes/no): ");
            continueAdding = scanner.nextLine();
        }

        // Display All Address Books
        displayAllAddressBooks();

        scanner.close();
    }
}