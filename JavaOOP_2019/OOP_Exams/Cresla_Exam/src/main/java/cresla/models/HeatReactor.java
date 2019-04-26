package cresla.models;

public class HeatReactor extends BaseReactor {
    private int heatReductionIndex;

    public HeatReactor(int id, int heatReductionIndex, int capacity) {
        super(id, capacity);
        this.heatReductionIndex  = heatReductionIndex ;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + heatReductionIndex;
    }
}
