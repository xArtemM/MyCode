import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PhoneBook {

    HashMap<String, ArrayList<Contact>> map = new HashMap<>();

    public void addGroupe(String group) {
        map.put(group, new ArrayList());
    }

    public void addContact(Contact contact, String[] groups) {
        for (int i = 0; i < groups.length; i++) {
            ArrayList<Contact> getGroupe = map.get(groups[i]);
            if (getGroupe != null) {
                getGroupe.add(contact);
            }
        }
    }

    public void printGroupeList() {
        System.out.println("Найдены группы:");
        int count = 0;
        for (String key : map.keySet()) {
            count++;
            System.out.printf("   %d) %s\n", count, key);
        }
    }

    public Contact[] getContacts(String group) {       //поиск контактов по группе
        ArrayList<Contact> getGroupe = map.get(group);
        if (getGroupe == null) {
            System.out.println("Такой группы нет!\n");
            return null;
        } else {
            Contact[] arr = new Contact[getGroupe.size()];
            return getGroupe.toArray(arr);
        }
    }

    public Contact getContactByPhone (String phone) {       //поиск контакта по номеру
        for (String key : map.keySet()) {
            for (Contact contact : map.get(key)) {
                if (contact.getPhoneNumber().equals(phone)) {
                    return contact;
                }
            }
        }
        return null;
    }

    public void printAll() {
        int countGroupe = 0;
        for (String key : map.keySet()) {
            countGroupe++;
            System.out.printf("%d) Группа %s:\n", countGroupe, key);
            int countContact = 0;
            for (Contact contact : map.get(key)) {
                countContact++;
                System.out.printf("   %d) %s %s\n", countContact, contact.getName(), contact.getPhoneNumber());
            }
            System.out.println();
        }
    }
}

