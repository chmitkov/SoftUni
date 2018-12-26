package problem_03_CoffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private int coins;
    private List<Coffee> coffees;

    public CoffeeMachine(){
        this.coffees = new ArrayList<>();
    }

    void buyCoffee(String size, String type) {
        Coffee currCoffee = new Coffee(size, type);
        if (this.coins >= currCoffee.getCoffeeSize().getPrice()) {
            coffees.add(currCoffee);
            this.coins = 0;
        }
    }

    void insertCoins(String coin) {
        this.coins += Enum.valueOf(Coin.class, coin.toUpperCase()).getValue();
    }

    Iterable<Coffee> coffeeSold() {
        return this.coffees;
    }
}
