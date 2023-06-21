package account;

public class CreditAccount extends Account {


    public CreditAccount(String name) {
        super(name);
    }

    @Override
    public boolean pay(int amount) {
        this.balance -= amount;
        System.out.println("Успех. Оплачено " + amount + " руб.");
        printBalance();
        return true;
    }

    @Override
    public boolean addMoney(int amount) {
        if ((balance + amount) > 0) {
            System.out.println("Отказ. Недопустимая сумма пополнения" +
                            " кредитного счета");
            printBalance();
            return false;
        }
        balance += amount;
        System.out.println("Успех. Счет " + this.name +
                " пополнен на " + amount + " руб.");
        printBalance();
        return true;
    }

    @Override
    public boolean transfer(Account account, int amount) {
        if (account.addMoney(amount)) {                             //Если целевой счет ответил о
            this.balance -= amount;                                 //успешном пополнении
            System.out.println("Успех. Со счета " + this.name +
                        " списано " + amount + " руб.");
            printBalance();
            return true;
        } else {
            System.out.println("Отказ. Отказ целевого счета");
            printBalance();
            return false;
        }
    }
}
