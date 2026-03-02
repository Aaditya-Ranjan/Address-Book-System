package com.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public static void searchPersonByCity(String city) {
        System.out.println("\n--- Search Results for City: " + city + " ---");
        List<ContactPerson> results = new ArrayList<>();

        addressBookDictionary.forEach((bookName, addressBook) -> {
            List<ContactPerson> found = addressBook.searchByCity(city);
            if (!found.isEmpty()) {
                System.out.println("Address Book: " + bookName);
                found.forEach(c -> System.out.println(
                        c.firstName + " " + c.lastName +
                                " | " + c.city +
                                " | " + c.state));
                results.addAll(found);
            }
        });

        if (results.isEmpty()) {
            System.out.println("No Contacts Found in City: " + city);
        }
    }

    public static void searchPersonByState(String state) {
        System.out.println("\n--- Search Results for State: " + state + " ---");
        List<ContactPerson> results = new ArrayList<>();

        addressBookDictionary.forEach((bookName, addressBook) -> {
            List<ContactPerson> found = addressBook.searchByState(state);
            if (!found.isEmpty()) {
                System.out.println("Address Book: " + bookName);
                found.forEach(c -> System.out.println(
                        c.firstName + " " + c.lastName +
                                " | " + c.city +
                                " | " + c.state));
                results.addAll(found);
            }
        });

        if (results.isEmpty()) {
            System.out.println("No Contacts Found in State: " + state);
        }
    }

    public static void viewPersonsByCity() {
        System.out.println("\n--- Contacts Grouped by City ---");

        addressBookDictionary.forEach((bookName, addressBook) -> {
            Map<String, List<ContactPerson>> cityMap = addressBook.getContactsGroupedByCity();
            if (!cityMap.isEmpty()) {
                System.out.println("\nAddress Book: " + bookName);
                cityMap.forEach((city, contacts) -> {
                    System.out.println("  City: " + city);
                    contacts.forEach(c -> System.out.println(
                            "    " + c.firstName + " " + c.lastName));
                });
            }
        });
    }

    public static void viewPersonsByState() {
        System.out.println("\n--- Contacts Grouped by State ---");

        addressBookDictionary.forEach((bookName, addressBook) -> {
            Map<String, List<ContactPerson>> stateMap = addressBook.getContactsGroupedByState();
            if (!stateMap.isEmpty()) {
                System.out.println("\nAddress Book: " + bookName);
                stateMap.forEach((state, contacts) -> {
                    System.out.println("  State: " + state);
                    contacts.forEach(c -> System.out.println(
                            "    " + c.firstName + " " + c.lastName));
                });
            }
        });
    }

    public static void countByCity() {
        System.out.println("\n--- Count of Contacts by City ---");

        addressBookDictionary.forEach((bookName, addressBook) -> {
            Map<String, Long> cityCount = addressBook.getCountByCity();
            if (!cityCount.isEmpty()) {
                System.out.println("\nAddress Book: " + bookName);
                cityCount.forEach((city, count) ->
                        System.out.println("  City: " + city + " | Count: " + count));
            }
        });
    }

    public static void countByState() {
        System.out.println("\n--- Count of Contacts by State ---");

        addressBookDictionary.forEach((bookName, addressBook) -> {
            Map<String, Long> stateCount = addressBook.getCountByState();
            if (!stateCount.isEmpty()) {
                System.out.println("\nAddress Book: " + bookName);
                stateCount.forEach((state, count) ->
                        System.out.println("  State: " + state + " | Count: " + count));
            }
        });
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

            System.out.print("\nEnter Address Book Name: ");
            String addressBookName = scanner.nextLine();
            AddressBook addressBook = getOrCreateAddressBook(addressBookName);

            System.out.println("\n--- Add Contacts to " + addressBookName + " ---");
            String addMore = "yes";
            while (addMore.equalsIgnoreCase("yes")) {
                ContactPerson contact = getContactFromConsole();
                addressBook.addContact(contact);
                System.out.print("Add another contact? (yes/no): ");
                addMore = scanner.nextLine();
            }

            System.out.print("\nAdd another Address Book? (yes/no): ");
            continueAdding = scanner.nextLine();
        }

        // Display All Address Books
        displayAllAddressBooks();

        // Search by City
        System.out.print("\nEnter City to Search: ");
        String city = scanner.nextLine();
        searchPersonByCity(city);

        // Search by State
        System.out.print("\nEnter State to Search: ");
        String state = scanner.nextLine();
        searchPersonByState(state);

        // View Grouped by City
        viewPersonsByCity();

        // View Grouped by State
        viewPersonsByState();

        // Count by City
        countByCity();

        // Count by State
        countByState();

        scanner.close();
    }
}