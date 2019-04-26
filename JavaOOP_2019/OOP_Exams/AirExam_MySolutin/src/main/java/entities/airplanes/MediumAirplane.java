package entities.airplanes;

import entities.interfaces.Bag;

public class MediumAirplane extends Airplane {
    public MediumAirplane() {
        super(10, 14);
    }
    @Override
    public void loadBag(Bag bag) {
        if (super.getBaggageCompartments() == super.getBaggageCompartment().size()) {
            throw new UnsupportedOperationException("No more bag room in MediumAirplane!");
        }
        super.loadBag(bag);
    }
}
