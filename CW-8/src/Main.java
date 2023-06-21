import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static String rot13(String message) {
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            int ASCIIch = message.charAt(i);
            if (ASCIIch >= 65 && ASCIIch <= 90) {
                if (ASCIIch <= 77) {
                    result = result + ((char) (ASCIIch + 13));
                } else {
                    result = result + ((char) (ASCIIch - 13));
                }
            } else if (ASCIIch >= 97 && ASCIIch <= 122) {
                if (ASCIIch <= 109) {
                    result = result + ((char) (ASCIIch + 13));
                } else {
                    result = result + ((char) (ASCIIch - 13));
                }
            } else {
                result = result + ((char) (ASCIIch));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("uryyb");
        System.out.println(rot13("hello"));
    }
}