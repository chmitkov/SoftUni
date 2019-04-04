package panzer.models.Vehicles;

import java.math.BigDecimal;

public class Vanguard extends BaseVehicle {

    public Vanguard(String model, Double weight, BigDecimal price,
                    Integer attack, Integer defense, Integer hitPoints) {
        super(model, weight * 2, price,
                (int) Math.round(attack * 0.75),
                (int) Math.round(defense * 1.5),
                (int) Math.round(hitPoints * 1.75));
    }
}
