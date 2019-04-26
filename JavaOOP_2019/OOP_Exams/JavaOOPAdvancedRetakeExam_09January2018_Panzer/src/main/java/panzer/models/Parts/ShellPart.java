package panzer.models.Parts;

import panzer.contracts.DefenseModifyingPart;

import java.math.BigDecimal;

public class ShellPart extends BasePart implements DefenseModifyingPart {

    private Integer defenseModifier ;

    public ShellPart(String model, Double weight,
                        BigDecimal price, Integer defenseModifier) {
        super(model, weight, price);
        this.defenseModifier = defenseModifier;
    }

    public int getDefenseModifier() {
        return this.defenseModifier;
    }

    @Override
    public String toString() {
        return String.format("Shell Part - %s\n" +
                        "+%d DefenseModifier",
                this.getModel(), this.getDefenseModifier());
    }
}
