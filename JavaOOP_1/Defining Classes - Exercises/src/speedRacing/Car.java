package speedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = 0;
    }

    private double maxRange() {
        return fuelAmount / fuelCostPerKm;
    }

    private double fuelCostForTravel(int distanceTraveled) {
        return distanceTraveled * fuelCostPerKm;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        if (distanceTraveled > maxRange()) {
            throw new IllegalArgumentException("Insufficient fuel for the drive");
        }
        this.distanceTraveled += distanceTraveled;
        this.fuelAmount -= fuelCostForTravel(distanceTraveled);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }

}
