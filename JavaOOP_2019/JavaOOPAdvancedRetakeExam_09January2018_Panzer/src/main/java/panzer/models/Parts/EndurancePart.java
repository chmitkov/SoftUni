package panzer.models.Parts;

import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;

public class EndurancePart extends BasePart implements HitPointsModifyingPart {

    private Integer hitPointsModifier;

    public EndurancePart(String model, Double weight,
                            BigDecimal price, Integer hitPointsModifier) {
        super(model, weight, price);
        this.hitPointsModifier = hitPointsModifier;
    }

    public int getHitPointsModifier() {
        return this.hitPointsModifier;
    }

    @Override
    public String toString() {
        return String.format("Endurance Part - %s\n" +
                        "+%d HitPointsModifier",
                this.getModel(), this.getHitPointsModifier());
    }
}
