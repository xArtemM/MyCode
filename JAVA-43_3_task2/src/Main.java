import java.util.Scanner;

public class Main {

    public static int calcuDays(int year){
        if (year % 400 == 0) {
            return 366;
        } else if (year % 100 == 0) {
            return 365;
        } else if (year % 4 == 0) {
            return 366;
        } else {
            return 365;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int inYear;
        int inDays;
        int sum = 0;
        do {
            System.out.print("Введите год в формате yyyy: ");
            inYear = scanner.nextInt();
            System.out.print("Введите количество дней: ");
            inDays = scanner.nextInt();
            sum ++;
        } while ( calcuDays(inYear) == inDays );
        System.out.println("Неправильно! В этом году " + calcuDays ( inYear ) + " дней!");
        System.out.println("Набрано очков: " + (sum - 1));
    }
}