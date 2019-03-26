package p02_VehicleExtension;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {

        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String drive(double distanceInKilometers) {
        double requiredFuel = distanceInKilometers *
                (this.getFuelConsumption() + 0.9);
        if (requiredFuel <= this.getFuelQuantity()) {
            DecimalFormat df = new DecimalFormat("0.######");
            this.setFuelQuantity(this.getFuelQuantity() - requiredFuel);
            return  String.format("Car travelled %s km%n", df.format(distanceInKilometers));
        } else {
            return "Car needs refueling";
        }
    }

    @Override
    public void refuel(double fuel) {
        this.setFuelQuantity(this.getFuelQuantity() + fuel);
    }

    public String toString() {
        return String.format("Car: %.2f", this.getFuelQuantity());
    }
}
