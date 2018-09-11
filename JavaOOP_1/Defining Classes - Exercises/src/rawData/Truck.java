package rawData;

import java.util.List;

public class Truck {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Truck(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return this.model;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Engine getEngine(){
        return  this.engine;
    }

    public boolean checkForTiresWithLowPressure(){
        boolean test = false;
        for (Tire tire : tires) {
            if (tire.getTirePressure()<1){
                test = true;
            }
        }
        return test;
    }
}
