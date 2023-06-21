import java.util.Scanner;
public class Main {
    public static int taxEarnings(int earnings) {                                        // налог 6% от доходов
        int tax = earnings * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {           // налог 15% от разницы доходов и расходов
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;                                               // доходы
        int spendings = 0;                                              // расходы
        while (true) {
            System.out.println("Выберите операцию и введите её номер:\n" + "1. Добавить новый доход\n" +
                    "2. Добавить новый расход\n" + "3. Выбрать ситему налогооблажения");
            String inputConsole = scanner.nextLine();                // забираем в String значение с консоли
            if ("end".equals(inputConsole)) {                        // проверяем на наличие условия выхода
                break;
            } else if (Integer.parseInt(inputConsole) > 0 && Integer.parseInt(inputConsole) < 4) {
                switch (Integer.parseInt(inputConsole)) {
                    case 1:
                        System.out.println("Введите сумму дохода:");
                        earnings += Integer.parseInt(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Введите сумму расхода:");
                        spendings += Integer.parseInt(scanner.nextLine());
                        break;
                    case 3:
                        int resultTaxEarnings = taxEarnings(earnings);
                        int resultTaxEarningsMinusSpendings = taxEarningsMinusSpendings(earnings, spendings);
                        if (resultTaxEarnings < resultTaxEarningsMinusSpendings) {
                            System.out.println("Мы советуем вам УСН доходы\n" + "Ваш налог составит: " + resultTaxEarnings +
                                    " рублей\n" + "Налог на другой системе: " + resultTaxEarningsMinusSpendings + " рублей\n" +
                                    "Экономия: " + (resultTaxEarningsMinusSpendings - resultTaxEarnings) + " рублей\n");

                        } else if (resultTaxEarnings > resultTaxEarningsMinusSpendings){
                            System.out.println("Мы советуем вам УСН доходы минус расходы\n" + "Ваш налог составит: " + resultTaxEarningsMinusSpendings +
                                    " рублей\n" + "Налог на другой системе: " + resultTaxEarnings + " рублей\n" +
                                    "Экономия: " + (resultTaxEarnings - resultTaxEarningsMinusSpendings) + " рублей\n");
                        } else {
                            System.out.println("Можете выбрать любую систему налогооблажения\n");
                        }
                        break;
                }
            } else {
                System.out.println("Такой операции нет\n");
            }
        }
    }
}