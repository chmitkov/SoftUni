package entities;

import entities.airplanes.interfaces.FlyingMachine;
import entities.interfaces.Trip;

public class TripImpl implements Trip {

    private static int counter = 0;

    private String id;
    private String source;
    private String destination;
    private boolean isCompleted;
    private FlyingMachine airplane;

    public TripImpl(String source, String destination, FlyingMachine flyingMachine) {
        counter++;
        this.id = source + destination + counter;
        this.source = source;
        this.destination = destination;
        this.isCompleted = false;
        this.airplane = flyingMachine;
    }

    @Override

    public String getId() {
        return this.id;
    }

    @Override
    public String getSource() {
        return this.source;
    }

    @Override
    public String getDestination() {
        return this.destination;
    }

    @Override
    public boolean isCompleted() {
        return this.isCompleted;
    }

    @Override
    public FlyingMachine getFlyingMachine() {
        return this.airplane;
    }

    @Override
    public void complete() {
        this.isCompleted = true;
    }
}
