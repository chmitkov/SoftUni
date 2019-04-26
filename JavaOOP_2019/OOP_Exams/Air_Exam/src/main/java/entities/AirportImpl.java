package entities;

import entities.interfaces.Airport;
import entities.interfaces.Bag;
import entities.interfaces.Passenger;
import entities.interfaces.Trip;

import java.util.ArrayList;
import java.util.List;

public class AirportImpl implements Airport {
    private List<Passenger> passengers;
    private List<Trip> trips;
    private List<Bag> checkedBags;
    private List<Bag> confiscatedBags;


    public AirportImpl() {
        this.passengers = new ArrayList<>();
        this.trips = new ArrayList<>();
        this.checkedBags = new ArrayList<>();
        this.confiscatedBags = new ArrayList<>();
    }

    @Override
    public List<Bag> getCheckedInBags() {
        return this.checkedBags;
    }

    @Override
    public List<Bag> getConfiscatedBags() {
        return this.confiscatedBags;
    }

    @Override
    public List<Passenger> getPassengers() {
        return this.passengers;
    }

    @Override
    public List<Trip> getTrips() {
        return this.trips;
    }

    @Override
    public void addPassenger(Passenger passenger) {
        //TODO OR NOT
//        if (this.passengers.contains(passenger)) {
//            throw new UnsupportedOperationException(
//                    String.format("Passenger %s already registered!",
//                            passenger.getUsername()));
//        }

        this.passengers.add(passenger);
    }

    @Override
    public void addCheckedBag(Bag bag) {
        this.checkedBags.add(bag);
    }

    @Override
    public void addConfiscatedBag(Bag bag) {
        this.confiscatedBags.add(bag);
    }

    @Override
    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }

    @Override
    public Passenger getPassenger(String username) {

        return this.passengers.stream()
                .filter(x -> x.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Trip getTrip(String id) {

        return this.trips.stream()
                .filter(x->x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
