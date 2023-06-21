import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int SIZE = 8;   //размерность

    public static void printMatrix (int[][] colors) {   //вывод матрицы в консоль
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%6d", colors[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] colors = new int [SIZE][SIZE];
        int[][] rotatedColors = new int[SIZE][SIZE];
        int[][] rotatedColorsOld = new int[SIZE][SIZE];
        int angle = 0;
        int rotateCount = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < SIZE; i++) {    //заполнение матрицы
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }

        System.out.println("Исходная матрица:");
        printMatrix(colors);

        System.out.println("Введите угол поворота кратный 90:");
        while (true) {
            angle = scanner.nextInt();
            if (angle % 90 != 0) {
                System.out.println("Некорректный ввод, ведите угол кратный 90:");
            } else {
                rotateCount = angle / 90; //вычисляем сколько раз повернуть
                break;
            }

        }

        rotatedColorsOld = colors.clone();

        for (int k = 0; k < rotateCount; k++) {   //поворот матрицы rotateCount раз
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    rotatedColors[i][j] = rotatedColorsOld[(SIZE - 1) - j][i];
                }
            }
            rotatedColorsOld = rotatedColors.clone();
        }

        System.out.println("Итоговая матрица:");
        printMatrix(rotatedColors);

    }
}