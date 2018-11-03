package problem_3_Ferrari;

public class Ferrari implements Car {

    private String model;
    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
        this.model = "488-Spider";
    }

    public String getDriver() {
        return this.driver;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String hitBrakes() {
        return "Brakes!";
    }

    @Override
    public String hitGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", getModel(), hitBrakes(), hitGas(), getDriver());
    }
}
