package entities.airplanes;

import entities.interfaces.Bag;

public class LightAirplane extends Airplane {
    public LightAirplane() {
        super(5, 8);
    }

    @Override
    public void loadBag(Bag bag) {
        if (super.getBaggageCompartments() == super.getBaggageCompartment().size()) {
            throw new UnsupportedOperationException("No more bag room in LightAirplane!");
        }
        super.loadBag(bag);
    }
}
