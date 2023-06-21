package UserRole;

import Book.Book;

public class Superviser extends User implements Administrator, Librarian {

    public Superviser(String name) {
        super(name);
    }

    @Override
    public void searchAndLendBook(Reader reader, Book book) {
        System.out.println(this.toString() + " находит и выдает книгу " +
                book.toString() + " " + reader.toString());
    }

    @Override
    public void overdueNotification(Reader reader, Book book) {
        System.out.println(this.toString() +
                " уведомляет о необходимости возврата книги " +
                book.toString() + " " + reader.toString());
    }

    @Override
    public void orderBook(Supplier supplier, Book book) {
        System.out.println(this.toString() + " заказывает книгу " +
                book.toString() + " у " + supplier.toString());
    }
}
