public class Main {
    public static void main(String[] args) {
        Autor autor1 = new Autor("Joanne", "Rowling", 5);
        Book book1 = new Book("Harry Potter", "2001", autor1, 100);
        System.out.println(book1.isBig());
        System.out.println(book1.matches("ling"));
        System.out.println(book1.estimatePrice());
    }
}