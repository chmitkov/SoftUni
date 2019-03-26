package p01_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] carDetails = br.readLine().split("\\s+");
        Car car = new Car(Double.valueOf(carDetails[1]),
                Double.valueOf(carDetails[2]));

        String[] truckDetails = br.readLine().split("\\s+");
        Truck truck = new Truck(Double.valueOf(truckDetails[1]),
                Double.valueOf(truckDetails[2]));

        int counter = Integer.parseInt(br.readLine());

        while (counter-- > 0) {
            String[] commands = br.readLine().split("\\s+");
            switch (commands[0]) {
                case "Drive":
                    if (commands[1].equalsIgnoreCase("Car")) {
                        System.out.println(car.drive(Double.valueOf(commands[2])));
                    } else {
                        System.out.println(truck.drive(Double.valueOf(commands[2])));
                    }
                    break;
                case "Refuel":
                    if (commands[1].equalsIgnoreCase("Car")) {
                        car.refuel(Double.valueOf(commands[2]));
                    } else {
                        truck.refuel(Double.valueOf(commands[2]));
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}

