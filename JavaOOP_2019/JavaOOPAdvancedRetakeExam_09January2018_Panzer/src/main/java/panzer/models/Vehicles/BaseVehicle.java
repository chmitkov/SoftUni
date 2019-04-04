package panzer.models.Vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseVehicle implements Vehicle {

    private String model;
    private Double weight;
    private BigDecimal price;
    private Integer attack;
    private Integer defense;
    private Integer hitPoints;
    private Assembler assembler;

    protected BaseVehicle(String model, Double weight, BigDecimal price,
                          Integer attack, Integer defense, Integer hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.assembler = new VehicleAssembler();
    }

    @Override
    public double getTotalWeight() {
        return this.weight + this.assembler.getTotalWeight();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.price.add(this.assembler.getTotalPrice());
    }

    @Override
    public long getTotalAttack() {
        return this.attack + this.assembler.getTotalAttackModification();
    }

    @Override
    public long getTotalDefense() {
        return this.defense + this.assembler.getTotalDefenseModification();
    }

    @Override
    public long getTotalHitPoints() {
        return this.hitPoints + this.assembler.getTotalHitPointModification();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        List<Part> result = null;
        try {
            Field field = this.assembler.getClass().getDeclaredField("allParts");
            field.setAccessible(true);
            result = (List<Part>) field.get(this.assembler);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        List<String> allPartsNames = new ArrayList<>();
        this.getParts().forEach(x -> allPartsNames.add(x.getModel()));
        DecimalFormat df = new DecimalFormat("###############.000");

        return String.format(" - %s\n" +
                        "Total Weight: %.3f\n" +
                        "Total Price: %s\n" +
                        "Attack: %d\n" +
                        "Defense: %d\n" +
                        "HitPoints: %d\n" +
                        "Parts: %s",
                this.getModel(), this.getTotalWeight(),
                df.format(this.getTotalPrice()), this.getTotalAttack(),
                this.getTotalDefense(), this.getTotalHitPoints(),
                allPartsNames.isEmpty()
                        ? "None"
                        : String.join(", ", allPartsNames));
    }
}
