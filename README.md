# Address Book System

## Introduction
A Java console-based Address Book System built as part of the BridgeLabz Fellowship program.
The system allows users to manage multiple address books, each containing multiple contacts.
Built using Core Java concepts including OOP, Collections, and Java Streams.

---

## Features
- Create contacts with full details (name, address, city, state, zip, phone, email)
- Add multiple contacts to an address book
- Edit existing contacts by name
- Delete contacts by name
- Maintain multiple address books using a unique name
- Prevent duplicate entries using equals() override and Java Streams
- Search contacts by City or State across multiple address books
- View contacts grouped by City or State
- Get count of contacts by City or State
- Sort contacts alphabetically by Name
- Sort contacts by City, State, or Zip

---

## Tech Stack
- Java 17
- IntelliJ IDEA
- Git & GitHub
- Git Flow

---

## Project Structure
```
Address-Book-System/
└── src/
    └── com/
        └── addressbook/
            ├── ContactPerson.java
            ├── AddressBook.java
            └── AddressBookMain.java
```

---

## UC Progress

| UC | Feature | Status |
|---|---|---|
| START | Welcome Message | ✅ Done |
| UC1 | Create Contact | ✅ Done |
| UC2 | Add Contact via Console | ✅ Done |
| UC3 | Edit Contact by Name | ✅ Done |
| UC4 | Delete Contact by Name | ✅ Done |
| UC5 | Add Multiple Contacts | ✅ Done |
| UC6 | Multiple Address Books | ✅ Done |
| UC7 | Duplicate Check | ✅ Done |
| UC8 | Search by City or State | ✅ Done |
| UC9 | View Grouped by City or State | ✅ Done |
| UC10 | Count by City or State | ✅ Done |
| UC11 | Sort by Name | ✅ Done |
| UC12 | Sort by City, State or Zip | ✅ Done |

---

## How to Run
1. Clone the repository
```
   git clone https://github.com/Aaditya-Ranjan/Address-Book-System.git
```
2. Open in IntelliJ IDEA
3. Mark `src` as Sources Root
4. Run `AddressBookMain.java`

---

## Git Flow Branch Structure

| Branch | Purpose |
|---|---|
| main | README only |
| develop | All source code |
| feature/UC1-ContactPerson | UC1 feature branch |
| feature/UC2-AddContact | UC2 feature branch |
| feature/UC3-EditContact | UC3 feature branch |
| feature/UC4-DeleteContact | UC4 feature branch |
| feature/UC5-MultipleContacts | UC5 feature branch |
| feature/UC6-MultipleAddressBooks | UC6 feature branch |
| feature/UC7-DuplicateCheck | UC7 feature branch |
| feature/UC8-SearchByCityOrState | UC8 feature branch |
| feature/UC9-ViewByCityOrState | UC9 feature branch |
| feature/UC10-CountByCityOrState | UC10 feature branch |
| feature/UC11-SortByName | UC11 feature branch |
| feature/UC12-SortByCityStateZip | UC12 feature branch |

---

## Author
**Aaditya Ranjan**
BridgeLabz Fellowship Program