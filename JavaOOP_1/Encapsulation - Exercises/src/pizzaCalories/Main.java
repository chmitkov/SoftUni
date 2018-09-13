package pizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Toppings> toppingsList = new ArrayList<>();
        String [] pizzaInfo = br.readLine().split("\\s+");
        String pizzaName = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);
        Pizza currPizza  = null;
        try{
           currPizza  = new Pizza(pizzaName,numberOfToppings);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return;
        }

        String [] doughInfo = br.readLine().split("\\s+");
        String doughType = doughInfo[1];
        String bakingType = doughInfo[2];
        int doughWeight = Integer.parseInt(doughInfo[3]);

        try{
            Dough currDough = new Dough(doughType,bakingType,doughWeight);
            currPizza.setDough(currDough);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return;
        }

        while (numberOfToppings-->0){
            String [] topInfo = br.readLine().split("\\s+");
            try{
                toppingsList.add(new Toppings(topInfo[1],Integer.parseInt(topInfo[2])));
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                return;
            }
        }

        try {
            currPizza.addToppings(toppingsList);
            System.out.printf("%s - %.2f",
                    pizzaName,currPizza.getPizzaCalories());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
