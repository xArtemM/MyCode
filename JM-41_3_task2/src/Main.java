import account.*;

public class Main {
    public static void main(String[] args) {


        Account savingsAccount = new SavingsAccount("Сб#1");
        Account creditAccount = new CreditAccount("Кр#1");
        Account checkingAccount = new CheckingAccount("Рcч#1");



        checkingAccount.addMoney(600);

        System.out.println();

        checkingAccount.transfer(creditAccount,500);

        System.out.println();

        creditAccount.pay(400);

        System.out.println();

        checkingAccount.transfer(creditAccount,300);

        System.out.println();


    }
}