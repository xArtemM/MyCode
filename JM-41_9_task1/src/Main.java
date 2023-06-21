import java.util.*;

public class Main {
    
    public static void printQueue(Queue<Integer> queue) {
        int floor = 0;
        int previousFloor = -1;
        int totalSeconds = 0;
        int waitDoorsInSeconds = 10;
        int waitMoveInSeconds = 5;
        System.out.println("Лифт проследовал по следующим этажам: ");
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                floor = queue.poll();
                System.out.printf("этаж %d -> ", floor);
            } else {
                floor = queue.poll();
                System.out.printf("этаж %d", floor);
            }
            if (previousFloor != -1) {
                totalSeconds += Math.abs(floor - previousFloor) * waitMoveInSeconds;
                totalSeconds += waitDoorsInSeconds;
            }
            previousFloor = floor;
        }
        System.out.printf("\nВремя затраченное лифтом на маршрут = %d с.", totalSeconds);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        while (true) {
            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            int input = scanner.nextInt();
            if (input == 0) {
                printQueue(queue);
                break;
            } else if (input < 0 || input > 25) {
                System.out.println("Такого этажа нет в доме!");
            } else {
                System.out.println(queue.offer(input) ? "Этаж добавлен в очередь!"
                        : "Ошибка добавления!");
            }
            System.out.println();

        }
    }
}