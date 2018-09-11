package carSalesman;

public class CarForSale {
    private String model;
    private EngineFromCarForSale engine;
    private int weight;
    private String color;

    public CarForSale(String model, EngineFromCarForSale engine) {
        this.model = model;
        this.engine = engine;
    }

    public CarForSale(String model, EngineFromCarForSale engine, Integer weight) {
        this(model,engine);
        this.weight = weight;
    }
    public CarForSale(String model, EngineFromCarForSale engine, String color) {
        this(model,engine);
        this.color = color;
    }

    public CarForSale(String model, EngineFromCarForSale engine, Integer weight, String color) {
        this(model,engine,weight);
        this.color = color;
    }

    public String getWeight() {
        if (this.weight == 0){
            return "n/a";
        }
        return this.weight+"";
    }

    public String getColor() {
        if (this.color == null){
            return "n/a";
        }
        return this.color;
    }

    @Override
    public String toString() {
        return String.format("%s:\n" +
                "%s:\n" +
                "Power: %d\n" +
                "Displacement: %s\n" +
                "Efficiency: %s\n" +
                "Weight: %s\n" +
                "Color: %s",
                this.model,this.engine.getModel(),this.engine.getPower(),
                this.engine.getDisplacement(),this.engine.getEfficiency(),
                getWeight(),getColor());
    }
}
