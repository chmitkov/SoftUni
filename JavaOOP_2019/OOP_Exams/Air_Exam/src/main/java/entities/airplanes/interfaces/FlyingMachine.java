package entities.airplanes.interfaces;

import entities.interfaces.Bag;
import entities.interfaces.Passenger;

import java.util.List;

public interface FlyingMachine
	{
		int getBaggageCompartments();

		List<Bag> getBaggageCompartment();

		boolean isOverbooked();

		List<Passenger> getPassengers();

		int getSeats();

		void addPassenger(Passenger passenger);

		Passenger removePassenger(int seat);

		List<Bag> ejectPassengerBags(Passenger passenger);

		void loadBag(Bag bag);
	}
