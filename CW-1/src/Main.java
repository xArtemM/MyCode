import java.util.Arrays;

public class Main {

    public static String stringReverse(String inString) {
        char[] origArray = new char[inString.length()];
        String targetStr = "";
        inString.getChars(0, inString.length(), origArray, 0);
        for (char ch : origArray) {
            targetStr = ch + targetStr;
        }
        return targetStr;
    }

    public static String reverseWords(final String original) {
        String[] wordArr = original.split(" ", -1);
        String returnStr = "";
        for (String str : wordArr) {
            returnStr = returnStr + " " + stringReverse(str);
        }
        System.out.println(Arrays.toString(wordArr));
        return returnStr.replaceFirst(" ", "");
    }

    public static void main(String[] args) {

        String str1 = "   ";
        String str2 = reverseWords(str1);

        System.out.println(str1);
        System.out.println("   ");
        System.out.println(str2);


    }
}