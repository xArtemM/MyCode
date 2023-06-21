import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Shedule shedule = new Shedule();

        while (true) {
            System.out.println("Выберите действие:\n" +
                    "1. Добавить задачу\n" +
                    "2. Вывести список задач\n" +
                    "3. Удалить задачу\n" +
                    "0. Выход");
            int sysWord = scanner.nextInt();
            if (sysWord == 0) {
                break;
            } else if (sysWord == 1) {
                shedule.addTask();
            } else if (sysWord == 2) {
                shedule.printTask();
            } else if (sysWord == 3) {
                shedule.delTask();
            } else {
                System.out.println("Некорректный ввод");
            }
            System.out.println();
        }
    }
}