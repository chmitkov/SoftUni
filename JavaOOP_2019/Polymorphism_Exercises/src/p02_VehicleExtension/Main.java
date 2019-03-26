package p02_VehicleExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfVehicle = 3;
        Car car = null;
        Truck truck = null;
        Bus bus = null;
        while (numberOfVehicle-- > 0) {
            String[] commands = br.readLine().split("\\s+");
            switch (commands[0]) {
                case "Car":
                    try {
                        car = new Car(Double.parseDouble(commands[1]),
                                Double.parseDouble(commands[2]), Double.parseDouble(commands[3]));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Truck":
                    try {
                        truck = new Truck(Double.parseDouble(commands[1]),
                                Double.parseDouble(commands[2]), Double.parseDouble(commands[3]));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    ;
                    break;
                case "Bus":
                    try {
                        bus = new Bus(Double.parseDouble(commands[1]),
                                Double.parseDouble(commands[2]), Double.parseDouble(commands[3]));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        int numberOfCommands = Integer.parseInt(br.readLine());

        while (numberOfCommands-- > 0) {
            String[] tokens = br.readLine().split("\\s+");
            switch (tokens[0]) {
                case "Refuel":
                    if(Double.parseDouble(tokens[2])<=0){
                        System.out.println("Fuel must be a positive number");
                        continue;
                    }
                    if (tokens[1].equals("Car")) {
                        try {
                            car.refuel(Double.parseDouble(tokens[2]));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (tokens[1].equals("Truck")) {
                        try {
                            truck.refuel(Double.parseDouble(tokens[2]));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        try {
                            bus.refuel(Double.parseDouble(tokens[2]));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Drive":
                    if (tokens[1].equals("Car")) {
                        System.out.println(car.drive(Double.parseDouble(tokens[2])));
                    } else if (tokens[1].equals("Truck")) {
                        System.out.println(truck.drive(Double.parseDouble(tokens[2])));
                    } else {
                        System.out.println(bus.drive(Double.parseDouble(tokens[2])));
                    }
                    break;
                case "DriveEmpty":
                    System.out.println(bus.driveEmpty(Double.parseDouble(tokens[2])));
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}