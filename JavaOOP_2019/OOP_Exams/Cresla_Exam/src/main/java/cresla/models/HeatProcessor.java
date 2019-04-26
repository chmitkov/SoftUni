package cresla.models;

import cresla.interfaces.AbsorbingModule;

public class HeatProcessor extends BaseAbsorberModule {
    private int heatAbsorbing;

    public HeatProcessor(int id, int heatAbsorbing) {
        super(id, heatAbsorbing);
    }
}
