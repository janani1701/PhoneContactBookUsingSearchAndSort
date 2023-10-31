import java.util.*;

public class ContactBook {
    private List<Contact> contacts;
    private Map<String, Contact> contactMap;

    public ContactBook() {
        contacts = new ArrayList<>();
        contactMap = new HashMap<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        Collections.sort(contacts);
        contactMap.put(contact.getName(), contact);
    }

    public Contact findContactByName(String name) {
        Contact contact = contactMap.get(name);
        if (contact != null) {
            return contact;
        }
        return binarySearch(name);
    }

    public List<Contact> findContactsByStartingLetter(char letter) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().charAt(0) == letter) {
                result.add(contact);
            }
        }
        return result;
    }

    private Contact binarySearch(String name) {
        int left = 0;
        int right = contacts.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = contacts.get(mid).getName().compareTo(name);

            if (comparison == 0) {
                return contacts.get(mid); // Name found
            } else if (comparison < 0) {
                left = mid + 1; // Name is in the right half
            } else {
                right = mid - 1; // Name is in the left half
            }
        }

        return null; // Name not found
    }
}
