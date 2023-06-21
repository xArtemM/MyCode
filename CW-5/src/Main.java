import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Main {

    public static String[] towerBuilder(int nFloors) {
        return IntStream.range(0, nFloors * 2)
                .filter(n -> n % 2 != 0)
                .mapToObj(n -> String.format("%s%s%s", "_".repeat((nFloors * 2 - n - 1) / 2), "*".repeat(n), "_".repeat((nFloors * 2 - n - 1) / 2)))
                .toArray(String[]::new);
    }


    public static void main(String[] args) {

        System.out.println(String.join(",", towerBuilder(6)));
        System.out.println(String.join(",", "  *  ", " *** ", "*****"));
    }
}