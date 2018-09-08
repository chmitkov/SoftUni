package staticIdandRate;

public class BankAccount1 {
    private static final double DEFAULT_INTEREST_RATE = 0.02;

    private static int bankAccountCount;
    private static double rate = DEFAULT_INTEREST_RATE;


    private int id;
    private double balance;

    public int getId() {
        return this.id;
    }


    public BankAccount1() {
        this.id = ++bankAccountCount;
    }

    public static void setInterest(double interest) {
        rate = interest;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterest(int years) {
        return this.balance * rate * years;
    }

    @Override
    public String toString() {
        return "ID"+this.id;
    }
}
