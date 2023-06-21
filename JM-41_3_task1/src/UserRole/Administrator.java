package UserRole;

import Book.Book;

public interface Administrator {
    void searchAndLendBook(Reader reader, Book book);
    void overdueNotification(Reader reader, Book book);
}
