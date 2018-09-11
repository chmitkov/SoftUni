package rawData;

public class Cargo {

    private int cargoWeight;
    private String cargoType;

    public Cargo(Integer cargoWeight,String cargoType){
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return this.cargoType;
    }
}
