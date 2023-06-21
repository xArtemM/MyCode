public class Book {
    public String title;
    public String releaseYear;
    public Autor author;
    public int pages;
    public Book(String title, String releaseYear, Autor author, int pages) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
        this.pages = pages;
    }
    public boolean isBig() {
        if (pages > 500) {
            return true;
        } else {
            return false;
        }
    }
    public boolean matches(String word) {
        if (title.contains(word)) {
            return true;
        }
        if (author.name.contains(word)) {
            return true;
        }
        if (author.surname.contains(word)) {
            return true;
        } else {
            return false;
        }
    }
    public int estimatePrice() {
        int price = (pages * 3) * (int)Math.floor(Math.sqrt(author.rating));
        if (price <= 250) {
            return 250;
        } else {
            return price;
        }
    }
}
