package core.controllers;

import core.controllers.interfaces.AirportController;
import entities.PassengerImpl;
import entities.interfaces.Airport;
import entities.interfaces.Bag;
import entities.interfaces.Passenger;

import javax.naming.OperationNotSupportedException;

public class AirportManager implements AirportController {

    private Airport airport;

    public AirportManager(Airport airport) {
        this.airport = airport;
    }

    @Override
    public String registerPassenger(String username) throws OperationNotSupportedException {
        if (this.airport.getPassenger(username) != null) {
            throw new UnsupportedOperationException(
                    String.format("Passenger %s already registered!",
                            username));
        }

        this.airport.addPassenger(new PassengerImpl(username));

        return String.format("Registered %s", username);
    }

    @Override
    public String registerBag(String username, Iterable<String> bagItems) {
        Passenger passenger = this.airport.getPassenger(username);

    }

    @Override
    public String registerTrip(String source, String destination, String planeType) {
        return null;
    }

    @Override
    public String checkIn(String username, String tripId, Iterable<Integer> bagIndices) {
        return null;
    }
}
