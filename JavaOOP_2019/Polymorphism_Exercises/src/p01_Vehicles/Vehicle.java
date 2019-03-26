package p01_Vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public abstract void refuel(double liters);

    public abstract String drive(double distance);
}
