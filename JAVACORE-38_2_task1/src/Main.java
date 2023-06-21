import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4));     // Почему если убрать "new ArrayList<>"
                                                                                                                //.remove(ln. 14) выбрасывает эксепшн?
        System.out.println(intList);

        Iterator<Integer> iterator = intList.iterator();
        while (iterator.hasNext()) {                                           //Фильтрация
            Integer i = iterator.next();
            if (i <= 0 || i % 2 != 0) {
                iterator.remove();
            }
        }

        intList.sort(Comparator.naturalOrder());                               //Сортировка

        System.out.println(intList);

    }
}