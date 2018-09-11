package carSalesman;

public class EngineFromCarForSale {

    private String model;
    private int power;
    private int displacement;
    private String efficiency;


    public EngineFromCarForSale(String model, Integer power) {
        this.model = model;
        this.power = power;
    }

    public  EngineFromCarForSale(String model, Integer power, Integer displacement){
        this(model,power);
        this.displacement = displacement;
    }

    public  EngineFromCarForSale(String model, Integer power, String efficiency){
        this(model,power);
        this.efficiency = efficiency;
    }
    public EngineFromCarForSale(String model, Integer power, Integer displacement, String efficiency) {
        this(model, power,displacement);
        this.efficiency = efficiency;
    }

    public String getModel() {
        return this.model;
    }

    public int getPower() {
        return this.power;
    }

    public String getDisplacement() {
        if (this.displacement == 0){
            return "n/a";
        }
        return this.displacement+"";
    }

    public String getEfficiency() {
        if (this.efficiency==null){
            return "n/a";
        }
        return this.efficiency;
    }
}
