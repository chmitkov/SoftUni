package p02_VehicleExtension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String drive(double distanceInKilometers) {
        double requiredFuel = distanceInKilometers *
                (this.getFuelConsumption() + 1.6);
        if (requiredFuel <= this.getFuelQuantity()) {
            DecimalFormat df = new DecimalFormat("0.######");
            this.setFuelQuantity(this.getFuelQuantity() - requiredFuel);
            return String.format("Truck travelled %s km%n", df.format(distanceInKilometers));
        } else {
            return "Truck needs refueling";
        }
    }

    @Override
    public void refuel(double fuel) {
        this.setFuelQuantity(this.getFuelQuantity() + fuel * 0.95);
    }

    public String toString() {
        return String.format("Truck: %.2f", this.getFuelQuantity());
    }
}
