import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products = {"Молоко", "Хлеб", "Гречневая крупа"};
        int[] prices = {50, 14, 80};
        int[] productCount = new int[100];
        int finalSum = 0;
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " +
                    prices[i] + " руб/шт");
        }
        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] parts = input.split(" ");
            productCount[Integer.parseInt(parts[0]) - 1] += Integer.parseInt(parts[1]);
        }
        System.out.println("Ваша корзина:");
        for (int i = 0; i < products.length; i++) {
            if (productCount[i] > 0) {
                System.out.println(products[i] + " " + productCount[i] +
                        " шт " + prices[i] + " руб/шт " + productCount[i] *
                        prices[i] + " руб в сумме");
                finalSum += productCount[i] * prices[i];
            }
        }
        System.out.println("Итого: " + finalSum + " руб");
    }
}