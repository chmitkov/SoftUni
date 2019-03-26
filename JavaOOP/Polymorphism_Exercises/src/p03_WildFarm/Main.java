package p03_WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Animal> animals = new LinkedList<>();

        while (true){
            String commandLine = reader.readLine();
            if(commandLine.equals("End")) break;

            String[] animalString = commandLine.split(" ");

            switch (animalString[0]){
                case "Cat":
                    Animal cat = new Cat(animalString[1],animalString[0], Double.parseDouble(animalString[2]), animalString[3], animalString[4]);
                    animals.add(cat);
                    break;
                case "Tiger":
                    Animal tiger = new Tiger(animalString[1],animalString[0], Double.parseDouble(animalString[2]), animalString[3]);
                    animals.add(tiger);
                    break;
                case "Mouse":
                    Animal mouse = new Mouse(animalString[1],animalString[0], Double.parseDouble(animalString[2]), animalString[3]);
                    animals.add(mouse);
                    break;
                case "Zebra":
                    Animal zebra = new Zebra(animalString[1],animalString[0], Double.parseDouble(animalString[2]), animalString[3]);
                    animals.add(zebra);
                    break;
            }

            commandLine = reader.readLine();
            if(commandLine.equals("End")) break;

            String[] foodString = commandLine.split(" ");

            switch (foodString[0]){
                case "Vegetable":
                    Vegetable vegetable = new Vegetable(Integer.parseInt(foodString[1]));
                    try {
                        animals.get(animals.size() - 1).makeSound();
                        animals.get(animals.size() - 1).eat(vegetable);
                    } catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                    System.out.println(animals.get(animals.size() - 1).toString());
                    break;
                case "Meat":
                    Meat meat = new Meat(Integer.parseInt(foodString[1]));
                    try {
                        animals.get(animals.size() - 1).makeSound();
                    animals.get(animals.size()-1).eat(meat);
                    } catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                    System.out.println(animals.get(animals.size() - 1).toString());

                    break;
            }
        }

    }
}
