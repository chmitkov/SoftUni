package problem_03_CoffeeMachine;

public class Coffee {

    private CoffeeSize coffeeSize;
    private CoffeeType coffeeType;

    public Coffee(String size, String type) {
        this.coffeeSize = Enum.valueOf(CoffeeSize.class, size.toUpperCase());
        this.coffeeType = Enum.valueOf(CoffeeType.class, type.toUpperCase());
    }

    public CoffeeSize getCoffeeSize() {
        return coffeeSize;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.coffeeSize.toString(),
                this.coffeeType.toString());
    }
}
