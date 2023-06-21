package account;

public class SavingsAccount extends Account{


    public SavingsAccount(String name) {
        super(name);
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("Отказ. Платеж со сберегательного счета невозможен");
        return false;
    }

    @Override
    public boolean addMoney(int amount) {
        balance += amount;
        System.out.println("Успех. Счет " + this.name +
                " пополнен на " + amount + " руб.");
        printBalance();
        return true;
    }

    @Override
    public boolean transfer(Account account, int amount) {
        if (balance >= amount) {
            if (account.addMoney(amount)) {                 //Если целевой счет ответил о
                this.balance -= amount;                     //успешном пополнении
                System.out.println("Успех. Со счета " + this.name +
                        " списано " + amount + " руб.");
                printBalance();
                return true;
            }
            return false;
        } else {
            System.out.println("Отказ. Недостаточно средств для списания " +
                    "или отказ целевого счета");
            printBalance();
            return false;
        }
    }
}
