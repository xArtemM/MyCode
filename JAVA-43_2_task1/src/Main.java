import java.util.Scanner;

public class Main {
    public static int calculateCustoms(int p, int w) {
        return p / 100 + w * 100;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Введите цену товара (в руб.):");
        int price = scanner.nextInt();
        System.out.print("Введите вес товара (в кг.):");
        int weight = scanner.nextInt();
        int customs = calculateCustoms(price, weight);
        System.out.println("Размер пошлины (в руб.) составит: " + customs);
    }
}