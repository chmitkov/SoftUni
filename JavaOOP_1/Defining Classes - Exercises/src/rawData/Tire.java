package rawData;

public class Tire {

    private double tirePressure;
    private int tireAge;

    public Tire(Double tirePressure, Integer tireAge){
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public double getTirePressure() {
        return this.tirePressure;
    }
}
