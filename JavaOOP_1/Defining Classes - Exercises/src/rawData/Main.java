package rawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Truck> truckList = new ArrayList<>();
        int countOfTrucks = Integer.parseInt(br.readLine());

        while (countOfTrucks-- > 0) {
            String[] truckData = br.readLine().split("\\s+");

            String model = truckData[0];

            int engineSpeed = Integer.parseInt(truckData[1]);
            int enginePower = Integer.parseInt(truckData[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(truckData[3]);
            String cargoType = truckData[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>() {{
                add(new Tire(Double.parseDouble(truckData[5]), Integer.parseInt(truckData[6])));
                add(new Tire(Double.parseDouble(truckData[7]), Integer.parseInt(truckData[8])));
                add(new Tire(Double.parseDouble(truckData[9]), Integer.parseInt(truckData[10])));
                add(new Tire(Double.parseDouble(truckData[11]), Integer.parseInt(truckData[12])));
            }};

            truckList.add(new Truck(model, engine, cargo, tires));
        }

        String command = br.readLine();

        if ("fragile".equals(command)) {
            truckList.forEach(truck -> {
                if ("fragile".equals(truck.getCargo().getCargoType()) &&
                    truck.checkForTiresWithLowPressure()
                ){
                    System.out.println(truck.getModel());
                }
            });
        } else {
            truckList.forEach(truck ->{
                if (truck.getEngine().getEnginePower()>250){
                    System.out.println(truck.getModel());
                }
            });
        }
    }
}
