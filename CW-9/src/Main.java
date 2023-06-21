public class Main {

    public static long nextSmaller(long n) {
        String[] longPattern = String.valueOf(n).split("");
        int count = 0;
        for (long i = n - 1; i != -1; i--) {
            StringBuilder str = new StringBuilder(String.valueOf(i));
            for (int j = 0; j < longPattern.length; j++) {
                if (str.toString().matches("(.*)" + longPattern[j] + "(.*)")) {
                    count++;
                    str.deleteCharAt(str.indexOf(longPattern[j]));
                } else {
                    break;
                }
            }
            if (count == longPattern.length) {
                return i;
            } else {
                count = 0;
            }
            System.out.println(i);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("result: " + nextSmaller(907));
    }
}