package part_3_Contacts_Database;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    // Global 2D array and contact tracker
    public static String[][] contacts = new String[100][3]; // {{ Index, Name, Number }, { }, { }}
    public static int contactCount = 0; // Keeps track of current available row position

    public static void main(String[] Args) {
        boolean running = true;

        while (running) {
            System.out.println("\n CONTACTS MENU ");
            System.out.println("1. Add contacts");
            System.out.println("2. Show contacts");
            System.out.println("3. Search in contacts");
            System.out.println("4. Edit contact");
            System.out.println("5. Delete contact");
            System.out.println("6. Delete All");
            System.out.println("7. Add sample contacts");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            String choiceInput = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 8.");
                continue;
            }

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    showContacts();
                    break;
                case 3:
                    searchContacts();
                    break;
                case 4:
                    editContact();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    deleteAll();
                    break;
                case 7:
                    addSampleContacts();
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    public static void addContact() {
        System.out.println("\n ADD CONTACTS MENU ");
        System.out.println("Enter details for each new contact.");
        System.out.println("To stop adding contacts and return to the main menu, leave the name empty or enter 'x'.");

        while (true) {
            if (contactCount >= contacts.length) {
                System.out.println("\nDatabase is full! Cannot add more contacts.");
                break;
            }

            String index = String.valueOf(contactCount + 1);

            System.out.println("\n Contact #" + index + " ");
            System.out.print("Enter Name (or empty/'x' to stop): ");
            String name = scanner.nextLine();

            if (name.isEmpty() || name.equalsIgnoreCase("x")) {
                System.out.println("Finished adding contacts.");
                break;
            }

            System.out.print("Enter Phone Number: ");
            String number = scanner.nextLine();

            contacts[contactCount][0] = index;  // Column 0: Index
            contacts[contactCount][1] = name;   // Column 1: Name
            contacts[contactCount][2] = number; // Column 2: Number

            contactCount++;

            System.out.println("Contact #" + index + " added successfully!");
        }
    }

    public static void showContacts() {
        System.out.println("\n CONTACTS LIST ");

        if (contactCount == 0) {
            System.out.println("No contacts stored yet.");
            return;
        }

        boolean activeFound = false;
        for (int i = 0; i < contactCount; i++) {
            String index = contacts[i][0];
            String name = contacts[i][1];
            String number = contacts[i][2];

            // Hide deleted contacts
            if (name.equalsIgnoreCase("DELETED") || name.equalsIgnoreCase("")) {
                continue;
            }

            System.out.println(index + ". " + name + " - " + number);
            activeFound = true;
        }

        if (!activeFound) {
            System.out.println("No active contacts to display.");
        }
    }

    public static void searchContacts() {
        System.out.println("\n CONTACT SEARCH MENU ");

        if (contactCount == 0) {
            System.out.println("No contacts stored yet.");
            return;
        }

        System.out.println("Search by (index / name / number)");
        String searchWay = scanner.nextLine().toLowerCase();

        System.out.print("Enter search phrase: ");
        String search = scanner.nextLine().toLowerCase();

        boolean matchFound = false;

        if (searchWay.contains("index")) {
            for (int i = 0; i < contactCount; i++) {
                String index = contacts[i][0];
                String name = contacts[i][1];
                String number = contacts[i][2];

                if (name.equalsIgnoreCase("DELETED") || name.equalsIgnoreCase("")) {
                    continue;
                }

                if (index.toLowerCase().contains(search)) {
                    System.out.println(index + ". " + name + " - " + number);
                    matchFound = true;
                }
            }
        } else if (searchWay.contains("name")) {
            for (int i = 0; i < contactCount; i++) {
                String index = contacts[i][0];
                String name = contacts[i][1];
                String number = contacts[i][2];

                if (name.equalsIgnoreCase("DELETED") || name.equalsIgnoreCase("")) {
                    continue;
                }

                if (name.toLowerCase().contains(search)) {
                    System.out.println(index + ". " + name + " - " + number);
                    matchFound = true;
                }
            }
        } else if (searchWay.contains("number")) {
            for (int i = 0; i < contactCount; i++) {
                String index = contacts[i][0];
                String name = contacts[i][1];
                String number = contacts[i][2];

                if (name.equalsIgnoreCase("DELETED") || name.equalsIgnoreCase("")) {
                    continue;
                }

                if (number.toLowerCase().contains(search)) {
                    System.out.println(index + ". " + name + " - " + number);
                    matchFound = true;
                }
            }
        } else {
            System.out.println("Invalid search type! Please enter index, name, or number.");
            return;
        }

        if (!matchFound) {
            System.out.println("No contacts found matching '" + search + "'.");
        }
    }

    public static void editContact() {
        System.out.println("\n CONTACT EDIT MENU ");

        if (contactCount == 0) {
            System.out.println("No contacts stored yet.");
            return;
        }

        System.out.print("\nEnter contact's index: ");
        String input = scanner.nextLine();

        int userIndex;
        try {
            userIndex = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            return;
        }

        int row = userIndex - 1;

        if (row < 0 || row >= contactCount || contacts[row][1].equalsIgnoreCase("DELETED") || contacts[row][1].equalsIgnoreCase("")) {
            System.out.println("Contact not found at index " + userIndex + ".");
            return;
        }

        System.out.println("\nSelected Contact: " + contacts[row][0] + ". " + contacts[row][1] + " - " + contacts[row][2]);

        System.out.print("Select changing part (index / name / number): ");
        String change = scanner.nextLine().toLowerCase();

        if (change.contains("index")) {
            System.out.print("Enter new index display: ");
            String newIndex = scanner.nextLine();
            contacts[row][0] = newIndex;
            System.out.println("Index updated successfully!");
        } else if (change.contains("name")) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            contacts[row][1] = newName;
            System.out.println("Name updated successfully!");
        } else if (change.contains("number")) {
            System.out.print("Enter new phone number: ");
            String newNumber = scanner.nextLine();
            contacts[row][2] = newNumber;
            System.out.println("Phone number updated successfully!");
        } else {
            System.out.println("Invalid selection! Operation canceled.");
        }
    }

    public static void deleteContact() {
        System.out.println("\n CONTACT DELETE MENU ");

        if (contactCount == 0) {
            System.out.println("No contacts stored yet.");
            return;
        }

        System.out.print("Enter contact's index: ");
        String input = scanner.nextLine();

        int userIndex;
        try {
            userIndex = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            return;
        }

        int row = userIndex - 1;

        if (row < 0 || row >= contactCount || contacts[row][1].equalsIgnoreCase("DELETED") || contacts[row][1].equalsIgnoreCase("")) {
            System.out.println("Contact not found at index " + userIndex + ".");
            return;
        }

        // Show details and ask confirmation (Y/N)
        System.out.println("Selected Contact: " + contacts[row][0] + ". " + contacts[row][1] + " - " + contacts[row][2]);
        System.out.print("Are you sure you want to DELETE this contact? (Y / N): ");
        String confirmation = scanner.nextLine();

        if (!confirmation.equalsIgnoreCase("yes") && !confirmation.equalsIgnoreCase("y")) {
            System.out.println("Operation canceled. Contact was not deleted.");
            return;
        }

        contacts[row][1] = "DELETED";
        contacts[row][2] = "DELETED";

        System.out.println("Contact #" + userIndex + " deleted successfully!");
    }

    public static void deleteAll() {
        System.out.println("\n ALL CONTACTS DELETE MENU ");

        if (contactCount == 0) {
            System.out.println("No contacts stored yet.");
            return;
        }

        System.out.print("Are you sure you want to DELETE all contacts? (Y / N): ");
        String confirmation = scanner.nextLine().trim();

        if (!confirmation.equalsIgnoreCase("yes") && !confirmation.equalsIgnoreCase("y")) {
            System.out.println("Operation canceled. No contacts were deleted.");
            return;
        }

        for (int i = 0; i < contactCount; i++) {
            contacts[i][0] = "";
            contacts[i][1] = "";
            contacts[i][2] = "";
        }

        contactCount = 0;

        System.out.println("All contacts have been successfully deleted!");
    }

    public static void addSampleContacts() {
        System.out.println("\n ADD SAMPLE CONTACTS ");

        String[][] samples = {
                {"Alice Smith",   "+380 67 123 4567"},
                {"Bob Jones",     "+380 50 987 6543"},
                {"Charlie Brown", "+380 63 456 7890"},
                {"Diana Prince",  "+380 97 321 6549"},
                {"Evan Wright",   "+380 93 654 9870"}
        };

        int addedCount = 0;

        for (String[] sample : samples) {
            if (contactCount >= contacts.length) {
                System.out.println("Database full! Some sample contacts could not be added.");
                break;
            }

            String index = String.valueOf(contactCount + 1);
            String name = sample[0];
            String number = sample[1];

            contacts[contactCount][0] = index;
            contacts[contactCount][1] = name;
            contacts[contactCount][2] = number;

            contactCount++;
            addedCount++;
        }

        System.out.println(addedCount + " sample contacts added successfully!");
    }
}