package problem_8_Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles {
    private double fuelQuantity;
    private double fuelConsumption;
    private double drivenKm;


    public Vehicles(double fuelQuantity, double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        setFuelQuantity(fuelQuantity);
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getDrivenKm() {
        return this.drivenKm;
    }

    public void drive(double distance) {
    }

    public void refueled(double refuelLiters) {
    }

    public DecimalFormat getDf() {
        return new DecimalFormat("#.##############");
    }
}
