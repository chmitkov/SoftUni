package p02_VehicleExtension;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (fuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    private void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void refuel(double quantity) {
        if(quantity<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.setFuelQuantity(this.fuelQuantity + quantity);
    }

    public String drive(double distance) {
        if (distance * this.fuelConsumption <= this.fuelQuantity) {
            this.fuelQuantity -= (distance * this.fuelConsumption);
            return String.format("Vehicle travelled %s km", distance);
        } else {
            return "Can't drive this distance!";
        }
    }
}
