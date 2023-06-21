package UserRole;

import Book.Book;

public class Supplierimpl extends User implements Supplier {

    public Supplierimpl(String name) {
        super(name);
    }

    @Override
    public void deliverBook(Librarian librarian, Book book) {
        System.out.println(this.toString() + " доставляет книгу " +
                book.toString() + " " + librarian.toString());
    }
}
