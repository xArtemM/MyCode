public class Main {

    public static boolean validatePin(String pin) {
        if (pin.length() < 4 || pin.length() > 6 || pin.length() == 5) {
            return false;
        } else {
            for (int i = 0; i < pin.length(); i++) {
                if ((int) pin.charAt(i) < 48 || (int) pin.charAt(i) > 57) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String pin = "9179";
        System.out.println(validatePin(pin));

    }
}