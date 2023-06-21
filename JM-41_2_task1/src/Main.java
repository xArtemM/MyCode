import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int slot = 0;
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        while (true) {
            System.out.format("У игрока %d слотов с оружием,"
                        + " введите номер, чтобы выстрелить,"
                        + " -1 чтобы выйти%n", player.getSlotsCount());
            slot = scanner.nextInt();
            if (slot == -1) {
                break;
            }
            player.shotWithWeapon(slot - 1);
        }
        System.out.println("Game over!");
    }
}