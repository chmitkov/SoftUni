package problem_8_Vehicles;

public class Car extends Vehicles {


    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 0.9);
    }

    @Override
    public void drive(double distance) {
        double neededLiters = this.getFuelConsumption() * distance;
        if (neededLiters > getFuelQuantity()) {
            System.out.println("Car needs refueling");
        } else {
            this.setFuelQuantity(getFuelQuantity() - neededLiters);
            System.out.printf("Car travelled %s km%n", getDf().format(distance));
        }
    }

    @Override
    public void refueled(double refueledLiters) {
        this.setFuelQuantity(getFuelQuantity() + refueledLiters);
    }

}
