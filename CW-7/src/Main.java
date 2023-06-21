import java.util.Arrays;

public class Main {

    public static String longToIP(long ip) {
        String binary = Long.toBinaryString(ip);
        binary = "0".repeat(32 - binary.length()) + binary;
        String[] binaryArr = {
                "" + Integer.parseInt(binary.substring(0, 8), 2),
                "" + Integer.parseInt(binary.substring(8, 16), 2),
                "" + Integer.parseInt(binary.substring(16, 24), 2),
                "" + Integer.parseInt(binary.substring(24, 32), 2)};
        return String.join(".", binaryArr);
    }

    public static void main(String[] args) {
        System.out.println(longToIP(25));
        System.out.println("128.114.17.104");
    }
}