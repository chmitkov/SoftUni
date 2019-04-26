package cresla.models;

import cresla.interfaces.EnergyModule;

public abstract class BaseEnergyModule extends BaseModule implements EnergyModule{
    private int energyOutput;
    protected BaseEnergyModule(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        //Energy Output: 100
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append(String.format("Energy Output: %d", this.getEnergyOutput())).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
