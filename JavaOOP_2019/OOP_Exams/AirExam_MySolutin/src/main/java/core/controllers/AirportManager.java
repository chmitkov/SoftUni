package core.controllers;

import core.controllers.interfaces.AirportController;
import entities.BagImpl;
import entities.PassengerImpl;
import entities.TripImpl;
import entities.factories.AirplaneWorkshop;
import entities.factories.ItemWorkshop;
import entities.factories.interfaces.AirplaneFactory;
import entities.factories.interfaces.ItemFactory;
import entities.interfaces.Airport;
import entities.interfaces.Bag;
import entities.interfaces.Passenger;
import entities.interfaces.Trip;
import entities.items.interfaces.Item;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirportManager implements AirportController {

    private Airport airport;
    private ItemFactory itemFactory;
    private AirplaneFactory airplaneFactory;

    public AirportManager(Airport airport) {

        this.airport = airport;
        this.itemFactory = new ItemWorkshop();
        this.airplaneFactory = new AirplaneWorkshop();
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
        List<Item> items = new ArrayList<>();
        for (String bagItem : bagItems) {
            try {
                items.add(this.itemFactory.createItem(bagItem));
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                    | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }

        Bag bag = new BagImpl(passenger, items);
        passenger.getBags().add(bag);

        return String.format("Registered bag with %s for %s",
                String.join(", ", bagItems), username);
    }

    @Override
    public String registerTrip(String source, String destination, String planeType) {

        Trip trip = null;

        try {
            trip = new TripImpl(source, destination,
                    this.airplaneFactory.createAirplane(planeType));
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        this.airport.addTrip(trip);

        return String.format("Registered trip %s", trip.getId());
    }

    @Override
    public String checkIn(String username, String tripId, Iterable<Integer> bagIndices) {

        Passenger passenger = this.airport.getPassenger(username);

        Trip trip = this.airport.getTrip(tripId);

        for (Trip currentTrip : this.airport.getTrips()) {
            if (currentTrip.getFlyingMachine()
                    .getPassengers().contains(passenger)) {
                throw new UnsupportedOperationException(
                        String.format("%s is already checked in!", username));
            }
        }

        int countOfBagsToCheckIn = 0;
        int countOfConfiscatedBags = 0;


        for (Integer bagIndex : bagIndices) {
            Bag bag = passenger.getBags().get(bagIndex);
            passenger.getBags().remove(bag);

            int sumOfItemsValue = bag.getItems().stream()
                    .mapToInt(Item::getValue)
                    .sum();

            if (sumOfItemsValue > 3000) {
                this.airport.addConfiscatedBag(bag);
                countOfConfiscatedBags++;
            } else {
                this.airport.addCheckedBag(bag);
                countOfBagsToCheckIn++;
            }
        }

        trip.getFlyingMachine().addPassenger(passenger);

        return String.format("Checked in %s with %d/%d checked in bags",
                username, countOfBagsToCheckIn,
                countOfBagsToCheckIn + countOfConfiscatedBags);
    }
}
