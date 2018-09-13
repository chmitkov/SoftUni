package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Toppings {
    private String typeOfToppings;
    private int toppingsWeight;

    private static List<String> possibleToppings = new ArrayList<>() {{
        add("Meat");
        add("Veggies");
        add("Cheese");
        add("Sauce");
    }};

    public Toppings(String typeOfToppings,Integer toppingsWeight){
        setTypeOfToppings(typeOfToppings);
        setToppingsWeight(toppingsWeight);
    }

    public void setToppingsWeight(int toppingsWeight) {
        if (toppingsWeight < 1 || toppingsWeight > 50) {
            throw new IllegalArgumentException(String.format(
                    "%s weight should be in the range [1..50].",this.typeOfToppings));
        }
        this.toppingsWeight = toppingsWeight;
    }

    public void setTypeOfToppings(String typeOfToppings) {
        if (!possibleToppings.contains(typeOfToppings)) {
            throw new IllegalArgumentException(String.format(
                    "Cannot place %s on top of your pizza.", typeOfToppings));
        }
        this.typeOfToppings = typeOfToppings;
    }
    private double getThisTypeModifier(){
        double result = 0;
        switch (this.typeOfToppings){
            case "Meat":
                result = 1.2;
                break;
            case "Veggies":
                result = 0.8;
                break;
            case "Cheese":
                result = 1.1;
                break;
            case "Sauce":
                result = 0.9;
                break;
        }
        return result;
    }
    public double getToppingCalories() {
        return this.toppingsWeight * 2 * getThisTypeModifier();
    }
}
