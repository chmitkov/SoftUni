package rawData;

public class Engine {

    private int engineSpeed;
    private int enginePower;

    public Engine(Integer engineSpeed, Integer enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return this.enginePower;
    }
}
