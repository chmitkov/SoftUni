package panzer.models.Parts;

import panzer.contracts.Part;

import java.math.BigDecimal;

public abstract class BasePart implements Part {
    private String model;
    private Double weight;
    private BigDecimal price;

    protected BasePart(String model, Double weight, BigDecimal price) {
        this.model = model;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public String getModel() {
        return this.model;
    }
}
