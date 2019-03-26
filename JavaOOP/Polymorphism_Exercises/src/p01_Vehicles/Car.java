package p01_Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    private static final DecimalFormat df = new DecimalFormat("#.########");

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void refuel(double liters) {
        super.setFuelQuantity(super.getFuelQuantity() + liters);
    }

    @Override
    public String drive(double distance) {
        double neededFuel = distance * (super.getFuelConsumption() + 0.9);
        if (neededFuel > super.getFuelQuantity()) {
            return "Car needs refueling";
        }

        super.setFuelQuantity(super.getFuelQuantity() - neededFuel);
        return String.format("Car travelled %s km", df.format(distance));
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", super.getFuelQuantity());
    }
}
