package googleEx;

public class CarOwned {
    private String model;
    private int carSpeed;

    public CarOwned(String model, int carSpeed) {
        this.model = model;
        this.carSpeed = carSpeed;
    }

    public String getModel() {
        return this.model;
    }

    public int getCarSpeed() {
        return this.carSpeed;
    }
    @Override
    public String toString() {
        return String.format("%s %d%n", getModel(),getCarSpeed());
    }
}
