package problem_03_CoffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String line;

        while (!"END".equals(line = br.readLine())) {
            String[] commands = line.split("\\s+");

            if (commands.length == 1) {
                coffeeMachine.insertCoins(commands[0]);
            } else {
                coffeeMachine.buyCoffee(commands[0], commands[1]);
            }
        }

        coffeeMachine.coffeeSold().forEach(System.out::println);
    }
}
