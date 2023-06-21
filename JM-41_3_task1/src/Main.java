import Book.Book;
import UserRole.*;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Война и мир");
        Book book2 = new Book("Обломов");
        Book book3 = new Book("Мастер и Маргарита");


        Readerimpl reader1 = new Readerimpl("Tolya");
        Administratorimpl admin1 = new Administratorimpl("Vasya");
        Librarianimpl librarian1 = new Librarianimpl("Katya");
        Supplierimpl supplierimpl1 = new Supplierimpl("Masha");
        Superviser super1 = new Superviser("Alexander");

        reader1.takeBook(admin1, book1);
        librarian1.orderBook(supplierimpl1,book2);
        admin1.overdueNotification(reader1,book3);

        supplierimpl1.deliverBook(librarian1,book2);
        supplierimpl1.deliverBook(super1,book1);


    }
}