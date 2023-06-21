import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static List<String> number(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, i+1 + ": " + lines.get(i));
        }
        return lines;
    }

    public static void main(String[] args) {

        List<String> listInput = Arrays.asList("a", "b", "c");
        List<String> listOut = number(listInput);

        System.out.println(listInput);
        System.out.println(listOut);
    }
}