package problem_03_CoffeeMachine;

public enum CoffeeSize {
    SMALL(50, 50), NORMAL(100, 75), DOUBLE(200, 100);

    private int ml;
    private int price;

    CoffeeSize(int ml, int price) {
        this.ml = ml;
        this.price = price;
    }

    public int getMl() {
        return ml;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
