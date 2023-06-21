import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Shedule {
    List<String> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addTask() {
        System.out.println("Введите задачу для планирования:");
        this.list.add(scanner.nextLine());
        System.out.printf("Добавленно. Число задач %d -> %s\n", list.size() - 1, list.size());
    }

    public void delTask() {
        System.out.println("Выберите задачу для удаления:");
        printTask();
        this.list.remove(Integer.parseInt(scanner.nextLine()) - 1);
        System.out.printf("Удалено. Число задач %d -> %s\n", list.size() + 1, list.size());
    }

    public void printTask() {
        if (list.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Список задач:");
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d) %s\n", i + 1, list.get(i));
            }
        }
    }

}