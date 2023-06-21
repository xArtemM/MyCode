import java.util.*;

public class Main {

    public static boolean scramble(String str1, String str2) {
        StringBuilder inputWord = new StringBuilder(str1);
        StringBuilder keyWord = new StringBuilder(str2);
        for (int i = 0; i < keyWord.length(); i++) {
            int index = inputWord.indexOf("" + keyWord.charAt(i));
            if (index > -1) {
                inputWord.delete(index, index + 1);
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "abcdefghijklmnopqrstuvwxyz".repeat(10_000);
        String s2 = "zyxcba".repeat(9_000);
        System.out.println(scramble(s1, s2));
    }
}