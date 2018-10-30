package problem_8_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String[] carDetails = br.readLine().split(" ");
        Car car = new Car(Double.parseDouble(carDetails[1]),
                Double.parseDouble(carDetails[2]));

        String[] truckDetails = br.readLine().split(" ");
        Truck truck = new Truck(Double.parseDouble(truckDetails[1]),
                Double.parseDouble(truckDetails[2]));

        int commandCount = Integer.parseInt(br.readLine());

        while (commandCount-- > 0) {
            String[] commands = br.readLine().split(" ");

            if (commands[1].equals("Car")) {
                if (commands[0].equals("Drive")) {
                    car.drive(Double.parseDouble(commands[2]));
                } else {
                    car.refueled(Double.parseDouble(commands[2]));
                }
            } else {
                if (commands[0].equals("Drive")) {
                    truck.drive(Double.parseDouble(commands[2]));
                } else {
                    truck.refueled(Double.parseDouble(commands[2]));
                }
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f", truck.getFuelQuantity());
    }
}
