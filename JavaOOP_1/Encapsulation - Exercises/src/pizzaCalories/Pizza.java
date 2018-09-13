package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Toppings> toppings;

    public Pizza(String name, Integer numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);

    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setToppings(Integer numberOfToppings) {
        if (numberOfToppings < 1 || numberOfToppings > 10) {
           throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();
    }

    public void addToppings(List<Toppings>toppings) {
        this.toppings.addAll(toppings);
    }

    public void setName(String name) {
        if (name.length() < 1 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private double getAllToppingsCalories() {
        double result = 0;
        for (Toppings top : this.toppings) {
            result += top.getToppingCalories();
        }
        return result;
    }

    public double getPizzaCalories() {
        return this.dough.getDougCalories() + getAllToppingsCalories();
    }
}
