package p02_VehicleExtension;

public class Bus extends Vehicle {
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        if (distance * this.getFuelConsumption() <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - (distance *
                    (this.getFuelConsumption() + 1.4)));
            return String.format("Bus travelled %.0f km", distance);
        } else {
            return "Bus needs refueling";
        }
    }

    public String driveEmpty(double distance) {
        if (distance * this.getFuelConsumption() <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - (distance *
                    (this.getFuelConsumption())));
            return String.format("Bus travelled %.0f km", distance);
        } else {
            return "Bus needs refueling";
        }
    }

    @Override
    public void refuel(double quantity) {
        super.refuel(quantity);
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", this.getFuelQuantity());
    }
}
