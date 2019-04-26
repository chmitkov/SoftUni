package panzer.core;

import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.Parts.ArsenalPart;
import panzer.models.Parts.EndurancePart;
import panzer.models.Parts.ShellPart;
import panzer.models.Vehicles.BaseVehicle;
import panzer.models.Vehicles.Revenger;
import panzer.models.Vehicles.Vanguard;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private Map<String, BaseVehicle> vehicleByNameMap;


    public ManagerImpl(Map<String, BaseVehicle> vehicleByNameMap) {
        this.vehicleByNameMap = vehicleByNameMap;

    }

    @Override
    public String addVehicle(List<String> arguments) {
        if (arguments.get(1).equals("Vanguard")) {
            Vanguard vanguard = new Vanguard(
                    arguments.get(2),
                    Double.valueOf(arguments.get(3)),
                    new BigDecimal(arguments.get(4)),
                    Integer.parseInt(arguments.get(5)),
                    Integer.parseInt(arguments.get(6)),
                    Integer.parseInt(arguments.get(7))
            );
            this.vehicleByNameMap.put(vanguard.getModel(), vanguard);
        } else {
            Revenger revenger = new Revenger(
                    arguments.get(2),
                    Double.valueOf(arguments.get(3)),
                    new BigDecimal(arguments.get(4)),
                    Integer.parseInt(arguments.get(5)),
                    Integer.parseInt(arguments.get(6)),
                    Integer.parseInt(arguments.get(7)));
            this.vehicleByNameMap.put(revenger.getModel(), revenger);
        }
        return String.format("Created %s Vehicle - %s",
                arguments.get(1), arguments.get(2));
    }

    @Override
    public String addPart(List<String> arguments) {
        Vehicle vehicle = this.vehicleByNameMap.get(arguments.get(1));
        switch (arguments.get(2)) {
            case "Arsenal":
                ArsenalPart arsenalPart = new ArsenalPart(arguments.get(3),
                        Double.valueOf(arguments.get(4)),
                        BigDecimal.valueOf(Long.parseLong(arguments.get(5))),
                        Integer.parseInt(arguments.get(6)));

                vehicle.addArsenalPart(arsenalPart);
                break;

            case "Shell":
                ShellPart shellPart = new ShellPart(arguments.get(3),
                        Double.valueOf(arguments.get(4)),
                        BigDecimal.valueOf(Long.parseLong(arguments.get(5))),
                        Integer.parseInt(arguments.get(6)));
                vehicle.addShellPart(shellPart);
                break;

            case "Endurance":
                EndurancePart endurancePart = new EndurancePart(arguments.get(3),
                        Double.valueOf(arguments.get(4)),
                        BigDecimal.valueOf(Long.parseLong(arguments.get(5))),
                        Integer.parseInt(arguments.get(6)));

                vehicle.addEndurancePart(endurancePart);
                break;
        }
        return String.format("Added %s - %s to Vehicle - %s",
                arguments.get(2), arguments.get(3), arguments.get(1));
    }

    @Override
    public String inspect(List<String> arguments) {

        String result = "";

        if (this.vehicleByNameMap.containsKey(arguments.get(1))) {
            Vehicle vehicle = this.vehicleByNameMap.get(arguments.get(1));
            result = vehicle.getClass().getSimpleName() + vehicle.toString();
        } else {
            Part part = null;
            for (Vehicle vehicle : this.vehicleByNameMap.values()) {
                for (Part vehiclePart : vehicle.getParts()) {
                    if (vehiclePart.getModel().equals(arguments.get(1))) {
                        part = vehiclePart;
                        result = part.toString();
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String battle(List<String> arguments) {
        return "";
    }

    @Override
    public String terminate(List<String> arguments) {
        return "";
    }
}
