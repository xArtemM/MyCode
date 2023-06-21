package UserRole;

import Book.Book;

public class Administratorimpl extends User implements Administrator {


    public Administratorimpl(String name) {
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
}
