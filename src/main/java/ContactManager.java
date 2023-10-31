import java.util.*;

public class ContactManager {
    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add New Contact");
            System.out.println("2. Search by First Letter");
            System.out.println("3. Search by Full Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the contact's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the contact's phone number: ");
                    String phoneNumber = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber);
                    contactBook.addContact(newContact);
                    System.out.println("Contact added.");
                    break;
                case 2:
                    System.out.print("Enter the first letter: ");
                    char letter = scanner.nextLine().charAt(0);
                    List<Contact> contacts = contactBook.findContactsByStartingLetter(letter);
                    if (!contacts.isEmpty()) {
                        System.out.println("Contacts with names starting with '" + letter + "':");
                        for (Contact c : contacts) {
                            System.out.println(c.getName() + " - " + c.getPhoneNumber());
                        }
                    } else {
                        System.out.println("No contacts found with names starting with '" + letter + "'.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the full name: ");
                    String searchName = scanner.nextLine();
                    Contact contact = contactBook.findContactByName(searchName);
                    if (contact != null) {
                        System.out.println("Found contact: " + contact.getName() + " - " + contact.getPhoneNumber());
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the Contact Manager.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
