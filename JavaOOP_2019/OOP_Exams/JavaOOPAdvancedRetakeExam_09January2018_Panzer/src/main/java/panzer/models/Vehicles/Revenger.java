package panzer.models.Vehicles;

import java.math.BigDecimal;

public class Revenger extends BaseVehicle {

    public Revenger(String model, Double weight, BigDecimal price,
                    Integer attack, Integer defense, Integer hitPoints) {
        super(model, weight,
                price.multiply(new BigDecimal("1.5")),
                (int) Math.round(attack * 2.5),
                (int) Math.round(defense * 0.5),
                (int) Math.round(hitPoints * 0.5));
    }
}
