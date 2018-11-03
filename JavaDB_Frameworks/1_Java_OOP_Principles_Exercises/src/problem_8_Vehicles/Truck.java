package problem_8_Vehicles;

public class Truck extends Vehicles {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 1.6);
    }

    @Override
    public void drive(double distance) {
        double neededLiters = this.getFuelConsumption() * distance;
        if (neededLiters > getFuelQuantity()) {
            System.out.println("Truck needs refueling");
        } else {
            this.setFuelQuantity(getFuelQuantity() - neededLiters);
            System.out.printf("Truck travelled %s km%n", getDf().format(distance));
        }
    }

    @Override
    public void refueled(double refueledLiters) {
        this.setFuelQuantity(getFuelQuantity()
                + refueledLiters * 0.95);
    }
}
