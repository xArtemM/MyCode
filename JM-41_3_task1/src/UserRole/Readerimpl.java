package UserRole;

import Book.Book;

public class Readerimpl extends User implements Reader {

    public Readerimpl(String name) {
        super(name);
    }

    @Override
    public void takeBook(Administrator administrator, Book book) {
        System.out.println(this.toString() + " берет книгу " +
                book.toString() + " у " + administrator.toString());
    }

    @Override
    public void returnBook(Administrator administrator, Book book) {
        System.out.println(this.toString() + " Возвращает книгу " +
                book.toString() + " " + administrator.toString());
    }
}
