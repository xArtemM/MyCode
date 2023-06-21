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
        System.out.print("Введите год в формате yyyy: ");
        int inYear = scanner.nextInt();
        System.out.println("Количество дней : " + calcuDays(inYear));
    }
}