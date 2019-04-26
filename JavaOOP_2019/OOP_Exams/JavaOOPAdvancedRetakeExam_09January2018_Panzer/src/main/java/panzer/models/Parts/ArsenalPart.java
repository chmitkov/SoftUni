package panzer.models.Parts;

import panzer.contracts.AttackModifyingPart;

import java.math.BigDecimal;

public class ArsenalPart extends BasePart implements AttackModifyingPart {

    private Integer attackModifier;

    public ArsenalPart(String model, Double weight,
                       BigDecimal price, Integer attackModifier) {
        super(model, weight, price);
        this.attackModifier = attackModifier;
    }

    public int getAttackModifier() {
        return this.attackModifier;
    }

    @Override
    public String toString() {
        return String.format("Arsenal Part - %s\n" +
                        "+%d AttackModifier",
                this.getModel(), this.getAttackModifier());
    }
}
