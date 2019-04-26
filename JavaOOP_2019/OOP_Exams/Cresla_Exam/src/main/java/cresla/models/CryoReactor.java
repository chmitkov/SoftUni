package cresla.models;

public class CryoReactor extends BaseReactor {

    private int cryoProductionIndex;

    public CryoReactor(int id, int cryoProductionIndex, int capacity) {
        super(id, capacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        return super.getTotalEnergyOutput() * cryoProductionIndex;
    }
}
