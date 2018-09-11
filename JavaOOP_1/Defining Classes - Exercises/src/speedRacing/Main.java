package speedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Car> carMap = new LinkedHashMap<>();
        int numberOfCars = Integer.parseInt(br.readLine());

        while (numberOfCars-- > 0) {
            String[] carDetails = br.readLine().split(" ");
            String model = carDetails[0];
            double fuelAmount = Double.parseDouble(carDetails[1]);
            double fuelCostFor1km = Double.parseDouble(carDetails[2]);

            Car currCar = new Car(model, fuelAmount, fuelCostFor1km);

            carMap.put(model, currCar);
        }

        String line = br.readLine();

        while (!"End".equals(line)) {
            String[] commands = line.split("\\s+");
            String model = commands[1];
            int distance = Integer.parseInt(commands[2]);

            try {
                carMap.get(model).setDistanceTraveled(distance);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

            line = br.readLine();
        }

        carMap.values().forEach(System.out::println);
    }
}
