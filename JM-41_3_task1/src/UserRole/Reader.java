package UserRole;
import Book.Book;
public interface Reader {
    void takeBook (Administrator administrator, Book book);
    void returnBook(Administrator administrator, Book book);
}
