package UserRole;

import Book.Book;

public class Librarianimpl extends User implements Librarian {

    public Librarianimpl(String name) {
        super(name);
    }

    @Override
    public void orderBook(Supplier supplier, Book book) {
        System.out.println(this.toString() + " заказывает книгу " +
                book.toString() + " у " + supplier.toString());
    }
}
