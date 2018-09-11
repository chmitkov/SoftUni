package carSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, EngineFromCarForSale> engines = new HashMap<>();
        List<CarForSale> cars = new ArrayList<>();

        int numberOfEngines = Integer.parseInt(br.readLine());

        while (numberOfEngines-- > 0) {
            String[] commands = br.readLine().split("\\s+");

            String name = commands[0];
            int power = Integer.parseInt(commands[1]);
            EngineFromCarForSale currEngine = null;
            if (commands.length == 3) {
                try {
                    currEngine = new EngineFromCarForSale(name, power, Integer.parseInt(commands[2]));
                } catch (Exception ex) {
                    currEngine = new EngineFromCarForSale(name, power, commands[2]);
                }
            } else if (commands.length == 4) {
                int displacements = Integer.parseInt(commands[2]);
                String efficiency = commands[3];

                currEngine = new EngineFromCarForSale(name, power, displacements, efficiency);
            } else {
                currEngine = new EngineFromCarForSale(name, power);
            }

            engines.put(name, currEngine);
        }

        int numberOfCars = Integer.parseInt(br.readLine());

        while (numberOfCars-- > 0) {
            String[] commands = br.readLine().split("\\s+");

            String name = commands[0];
            String engineName = commands[1];
            EngineFromCarForSale currEngine = engines.get(engineName);
            CarForSale currCar = null;
            if (commands.length == 2) {
                currCar = new CarForSale(name, currEngine);
            } else if (commands.length == 3) {
                try {
                    currCar = new CarForSale(name, currEngine, Integer.parseInt(commands[2]));
                } catch (Exception ex) {
                    currCar = new CarForSale(name, currEngine, commands[2]);
                }
            } else {
                currCar = new CarForSale(name, currEngine,
                        Integer.parseInt(commands[2]), commands[3]);
            }

            cars.add(currCar);
        }

        cars.forEach(System.out::println);
    }
}
