import core.EngineController;
import core.controllers.AirportManager;
import core.controllers.FlightManager;
import core.controllers.interfaces.AirportController;
import core.controllers.interfaces.FlightController;
import core.interfaces.Engine;
import core.io.ConsoleReader;
import core.io.ConsoleWriter;
import entities.AirportImpl;
import entities.interfaces.Airport;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        //Better inside in Engine
        Airport airport = new AirportImpl();
        AirportController airportController = new AirportManager(airport);
        FlightController flightController = new FlightManager(airport);


        Engine engine = new EngineController(reader, writer,
                airportController, flightController);

        engine.run();
    }
}
