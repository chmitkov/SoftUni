package p01_Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    private static final DecimalFormat df = new DecimalFormat("#.######");

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity,fuelConsumption);
    }

    @Override
    public void refuel(double liters) {
        super.setFuelQuantity(super.getFuelQuantity() + liters * 0.95);
    }

    @Override
    public String drive(double distance) {
        double neededFuel = distance * (super.getFuelConsumption()+1.6);
        if (neededFuel > super.getFuelQuantity()) {
            return "Truck needs refueling";
        }

        super.setFuelQuantity(super.getFuelQuantity() - neededFuel);
        return String.format("Truck travelled %s km", df.format(distance));
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }
}
