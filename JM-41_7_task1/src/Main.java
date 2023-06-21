import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();

        book.addGroupe("Работа");
        book.addGroupe("Друзья");
        book.addGroupe("Спортзал");
        System.out.println();

        book.addContact(new Contact("Vasya", "79589995246"),  new String[]{"Работа"});
        book.addContact(new Contact("Petya", "79589995555"),  new String[]{"Друзья"});
        book.addContact(new Contact("Kolya", "79589995534"),  new String[]{"Друзья"});
        book.addContact(new Contact("Anya", "79589995578"),  new String[]{"Друзья"});
        book.addContact(new Contact("Nastya", "79589995123"),  new String[]{"Спортзал"});
        book.addContact(new Contact("Tolya", "79589995789"),  new String[]{"Работа"});
        book.addContact(new Contact("Alexandr", "79589995258"),  new String[]{"Друзья"});
        book.addContact(new Contact("Maksim", "79589995852"),  new String[]{"Спортзал", "Работа"});
        book.addContact(new Contact("Vika", "79589995369"),  new String[]{"Неправильная группа"});
        book.addContact(new Contact("Olya", "79589995147"),  new String[]{"Спортзал", "Работа"});
        System.out.println();

        book.printAll();
        System.out.println();

        System.out.println(Arrays.toString(book.getContacts("Друзья")));
        System.out.println();


        System.out.println(book.getContactByPhone("79589995123"));
        System.out.println();

    }
}