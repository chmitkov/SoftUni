package core.controllers;

import core.controllers.interfaces.FlightController;
import entities.airplanes.interfaces.FlyingMachine;
import entities.interfaces.Airport;
import entities.interfaces.Bag;
import entities.interfaces.Passenger;
import entities.interfaces.Trip;
import entities.items.interfaces.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlightManager implements FlightController {
    private final int EJECTION_SEED = 1337;

    private Airport airport;

    private Random randomGenerator;

    public FlightManager(Airport airport) {
        this.airport = airport;
        this.randomGenerator = new Random(EJECTION_SEED);
    }

    public String TakeOff() {
        StringBuilder sb = new StringBuilder();

        for (Trip trip : this.airport.getTrips()) {
            if (trip.isCompleted()) {
                continue;
            }

            sb.append(trip.getId()).append(":").append(System.lineSeparator());

            loadCarryOnBaggage(trip);

            if (trip.getFlyingMachine().isOverbooked()) {
                List<Passenger> ejectedPassengers = ejectOverbookedPassengers(trip);

                List<String> usernames = new ArrayList<>();
                for (Passenger ejectedPassenger : ejectedPassengers) {
                    usernames.add(ejectedPassenger.getUsername());
                }

                sb.append(String.format("Overbooked! Ejected %s", String.join(", ", usernames))).append(System.lineSeparator());

                List<Bag> ejectedBags = new ArrayList<>();

                for (Passenger ejectedPassenger : ejectedPassengers) {
                    ejectedBags.addAll(trip.getFlyingMachine().ejectPassengerBags(ejectedPassenger));
                }

                int bagsTotalValue = 0;

                for (Bag ejectedBag : ejectedBags) {
                    this.airport.addConfiscatedBag(ejectedBag);
                    bagsTotalValue += ejectedBag.getItems().stream().mapToInt(Item::getValue).sum();
                }


                sb.append(String.format("Confiscated %d bags ($%d)", ejectedBags.size(), bagsTotalValue)).append(System.lineSeparator());
            }

            trip.complete();

            int size = trip.getFlyingMachine().getPassengers().size();

            String tripResult = String.format("Successfully transported %d passengers from %s to %s.",
                    size,
                    trip.getSource(),
                    trip.getDestination());

            sb.append(tripResult);
            sb.append(System.lineSeparator());
        }


        List<Bag> confiscatedBags = this.airport.getConfiscatedBags();


        List<Item> confiscatedItems = new ArrayList<>();

        for (Bag confiscatedItem : confiscatedBags) {
            confiscatedItems.addAll(confiscatedItem.getItems());
        }

        sb.append(String.format("Confiscated bags: %d (%d items) => $%d",
                confiscatedBags.size(),
                confiscatedItems.size(),
                confiscatedItems.stream().mapToInt(Item::getValue).sum()
        ));

        return sb.toString();
    }

    private static void loadCarryOnBaggage(Trip trip) {
        FlyingMachine plane = trip.getFlyingMachine();
        for (Passenger passenger : plane.getPassengers()) {
            List<Bag> luggage = passenger.getBags();

            while (!luggage.isEmpty()) {
                Bag luggageBag = luggage.get(0);
                passenger.getBags().remove(0);
                plane.loadBag(luggageBag);
            }
        }
    }

    private List<Passenger> ejectOverbookedPassengers(Trip trip) {
        FlyingMachine plane = trip.getFlyingMachine();

        List<Passenger> ejectedPassengers = new ArrayList<>();

        while (plane.isOverbooked()) {
            int seat = this.randomGenerator.nextInt(plane.getSeats());
            Passenger passenger = plane.removePassenger(seat);

            ejectedPassengers.add(passenger);
        }

        return ejectedPassengers;
    }
}
