import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static String[] capitalize(String s) {
        int count = 0;
        String upperStr = "";
        String lowerStr = "";
        for (String string : s.split("")) {
            lowerStr = count % 2 == 0 ? lowerStr + string.toLowerCase() : lowerStr + string.toUpperCase();
            upperStr = count % 2 == 0 ? upperStr + string.toUpperCase() : upperStr + string.toLowerCase();
            count++;
        }
        return new String[]{upperStr, lowerStr};
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(capitalize("codewars")));

    }
}