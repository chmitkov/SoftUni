package panzer.models.miscellaneous;

import panzer.contracts.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VehicleAssembler implements Assembler {
    private List<AttackModifyingPart> arsenalParts;

    private List<DefenseModifyingPart> shellParts;

    private List<HitPointsModifyingPart> enduranceParts;

    public VehicleAssembler() {
        this.arsenalParts = new ArrayList<AttackModifyingPart>();
        this.shellParts = new ArrayList<DefenseModifyingPart>();
        this.enduranceParts = new ArrayList<HitPointsModifyingPart>();
    }

    @Override
    public double getTotalWeight() {
        return this.arsenalParts.stream().mapToDouble((x) -> x.getWeight()).sum()
                - this.shellParts.stream().mapToDouble((x) -> x.getWeight()).sum()
                + this.enduranceParts.stream().mapToDouble((x) -> x.getWeight()).sum();
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal result = BigDecimal.ZERO;

        for (AttackModifyingPart arsenalPart : this.arsenalParts) {
            result = result.add(arsenalPart.getPrice());
        }

        for (DefenseModifyingPart shellPart : this.shellParts) {
            result = result.add(shellPart.getPrice());
        }

        for (HitPointsModifyingPart endurancePart : this.enduranceParts) {
            result = result.add(endurancePart.getPrice());
        }

        return result;
    }

    @Override
    public long getTotalAttackModification() {
        return this.arsenalParts.stream().mapToInt((x) -> x.getAttackModifier()).sum();
    }

    @Override
    public long getTotalDefenseModification() {
        return this.shellParts.stream().mapToInt((x) -> x.getDefenseModifier()).sum();
    }

    @Override
    public long getTotalHitPointModification() {
        return this.enduranceParts.stream().mapToInt((x) -> x.getHitPointsModifier()).sum();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.arsenalParts.add((AttackModifyingPart)arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.shellParts.add((DefenseModifyingPart)shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.enduranceParts.add((HitPointsModifyingPart)endurancePart);
    }
}