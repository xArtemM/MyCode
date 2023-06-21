import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void printStudentList(HashSet<Student> set) {
        System.out.println("Список студентов:");
        for (Student s : set) {
            System.out.println("  - " + s);
        }
    }

    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            if (set.isEmpty()) {
                System.out.println("Введите информацию о студенте: " +
                        "ФИО, номер группы, номер студенческого билета");
            } else {
                System.out.println("Введите информацию о студенте " +
                        "(для завершения работы программы введите end)");
            }
            String input = scanner.nextLine();
            if (input.equals("end")) {
                printStudentList(set);
                break;
            }
            String[] split = input.split(", ");
            if (!set.add(new Student(split[0], split[1], split[2]))) {
                System.out.println("Не добавленно. Студент с таким " +
                        "именем уже существует!");
            }
        }

    }
}