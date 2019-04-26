package core.controllers;

import core.controllers.interfaces.FlightController;
import entities.AirportImpl;
import entities.interfaces.Airport;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class FlightManagerTest {

    private FlightController flightManager;
    private Airport airport;
    private FlyingMachine flyingMachine;
    private Passenger passenger;
    private Bag bag;
    private Item item;

    @Before
    public void before() {
        this.flightManager = new FlightManager(airport);
        this.airport = Mockito.mock(AirportImpl.class);
        this.flyingMachine = Mokito.mock(LightAirPlane.class);
        this.passenger = Mockito.mock(PassengerImpl.class);
        this.bag = Mockito.mock(BagImpl.class);
        this.item = Mockito.mock(Laptop.class);

        flightManager

    }

    @Test
    public void testLoadCarryOnBaggage() {

    }
}