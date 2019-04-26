package entities.interfaces;

import java.util.List;

public interface Airport {
    List<Bag> getCheckedInBags();

    List<Bag> getConfiscatedBags();

    List<Passenger> getPassengers();

    List<Trip> getTrips();

    void addPassenger(Passenger passenger);

    void addCheckedBag(Bag bag);

    void addConfiscatedBag(Bag bag);

    void addTrip(Trip trip);

    Passenger getPassenger(String username);

    Trip getTrip(String id);
}
