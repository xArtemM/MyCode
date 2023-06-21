import Event.*;

public class Main {

    public static Movie[] getMovies() {
        Movie movie1 = new Movie("Побег из Шоушенка", 1994, 16);
        Movie movie2 = new Movie("Начало", 2010, 14);
        Movie movie3 = new Movie("Бойцовский клуб", 1999, 18);
        return new Movie[]{movie1, movie2, movie3};
    }

    public static Theatre[] getTheatres() {
        Theatre Theatre1 = new Theatre("Чающие движения воды", 2022, 16);
        Theatre Theatre2 = new Theatre("Щелкунчик", 2019, 14);
        Theatre Theatre3 = new Theatre("Канарейка", 2010, 12);
        return new Theatre[]{Theatre1, Theatre2, Theatre3};
    }

    public static void validEvent(Event event) {
        if (event.getAge() == 0 || event.getTitle() == null || event.getReleaseYear() == 0) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        for (Event event : getMovies()) {
            validEvent(event);
        }
        for (Event event : getTheatres()) {
            validEvent(event);
        }
        System.out.println("Все события корректны");
    }
}