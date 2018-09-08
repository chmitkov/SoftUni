package defineBankAccountClass;

public class BankAccount {

    private int id;
    private double balance;

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }

    public void print() {
        System.out.println(String.format("Account ID%d, balance %.2f",
                this.id, this.balance));
    }
}
