package account;

public abstract class Account {

    protected String name;
    protected int balance;

    protected Account(String name) {
        this.name = name;
    }

    public void printBalance() {
        System.out.println("Баланс счета " + name + " " + balance + " руб.");
    }

    public abstract boolean transfer(Account account, int amount);
    public abstract boolean pay(int amount);
    public abstract boolean addMoney(int amount);

}
