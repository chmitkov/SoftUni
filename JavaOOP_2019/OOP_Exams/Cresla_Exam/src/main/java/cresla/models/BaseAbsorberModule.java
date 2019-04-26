package cresla.models;

import cresla.interfaces.AbsorbingModule;

public abstract class BaseAbsorberModule extends BaseModule implements AbsorbingModule {

    private int heatAbsorbing;

    protected BaseAbsorberModule(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        //Heat Absorbing: 100
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append(String.format("Heat Absorbing: %d", this.getHeatAbsorbing())).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
