package core.controllers.interfaces;

import javax.naming.OperationNotSupportedException;

public interface AirportController
	{
		String registerPassenger(String username) throws OperationNotSupportedException;

		String registerBag(String username, Iterable<String> bagItems);

		String registerTrip(String source, String destination, String planeType);

		String checkIn(String username, String tripId, Iterable<Integer> bagIndices);
	}
