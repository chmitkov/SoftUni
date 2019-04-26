package core;

import core.controllers.AirportManager;
import core.controllers.FlightManager;
import core.controllers.interfaces.AirportController;
import core.controllers.interfaces.FlightController;
import core.interfaces.Engine;
import core.io.ConsoleReader;
import core.io.ConsoleWriter;
import core.io.interfacese.Reader;
import core.io.interfacese.Writer;

import javax.naming.OperationNotSupportedException;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
@SuppressWarnings("All")

public class EngineController implements Engine {
    private Reader reader;
    private Writer writer;
    private AirportController airportController;
    private FlightController flightController;

    public EngineController(ConsoleReader reader, ConsoleWriter writer, AirportController airportController,
                            FlightController flightController) {
        this.reader = reader;
        this.writer = writer;
        this.airportController = airportController;
        this.flightController = flightController;
    }


    @Override
    public void run() throws IOException {
        while (true) {
            String input = this.reader.readLine();

            if (input.equals("END") && this.validateInput(input)) {
                break;
            }

            try {
                String result = this.processCommand(input);
                System.out.println(result);
            } catch (OperationNotSupportedException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
    }

    private boolean validateInput(String input){
        return input != null || !input.trim().isEmpty();
    }

    @Override
    public String processCommand(String input) throws OperationNotSupportedException {
        String[] tokens = input.split("\\s+");

        String command = tokens[0];
        String[] args = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case "RegisterPassenger": {
                String name = args[0];
                return this.airportController.registerPassenger(name);
            }
            case "RegisterTrip": {
                String source = args[0];
                String destination = args[1];
                String planeType = args[2];

                return this.airportController.registerTrip(source, destination, planeType);
            }
            case "RegisterBag": {
                String username = args[0];
                Iterable<String> bagItems = Arrays.stream(args).skip(1).collect(Collectors.toList());

                return this.airportController.registerBag(username, bagItems);
            }
            case "CheckIn": {
                String username = args[0];
                String tripId = args[1];
                Iterable<Integer> bagCheckInIndices = Arrays.stream(args)
                        .skip(2)
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());

                return this.airportController.checkIn(username, tripId, bagCheckInIndices);
            }
            case "TakeOff": {
                return this.flightController.TakeOff();
            }
            default:
                throw new OperationNotSupportedException("Invalid command!");
        }
    }
}
