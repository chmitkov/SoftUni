package panzer;

import panzer.contracts.*;
import panzer.core.ManagerImpl;
import panzer.core.PanzerBattleOperator;
import panzer.models.Vehicles.BaseVehicle;

import java.util.*;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;
    private Map<String, BaseVehicle> vehicleByNameMap;
    private BattleOperator battleOperator;
    private List<BaseVehicle> defeatedVehicle;


    public Engine(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.vehicleByNameMap = new LinkedHashMap<>();
        this.manager = new ManagerImpl(this.vehicleByNameMap);
        this.battleOperator = new PanzerBattleOperator();
        this.defeatedVehicle = new ArrayList<>();
    }

    @Override
    public void run() {

        String line;
        while (!"Terminate".equals(line = this.reader.readLine())) {

            String[] commands = line.split("\\s+");
            switch (commands[0]) {
                case "Vehicle":
                    this.writer.println(
                            this.manager.addVehicle(Arrays.asList(commands)));
                    break;
                case "Part":
                    this.writer.println(
                            this.manager.addPart(Arrays.asList(commands)));
                    break;
                case "Battle":
                    String winner = this.battleOperator.battle(
                            this.vehicleByNameMap.get(commands[1]),
                            this.vehicleByNameMap.get(commands[2])
                    );
                    String looser = winner.equals(commands[1]) ? commands[2] : commands[1];
                    this.defeatedVehicle.add(this.vehicleByNameMap.get(looser));
                    this.vehicleByNameMap.remove(looser);
                    this.writer.println(String.format("%s versus %s " +
                                    "-> %s Wins! Flawless Victory!",
                            commands[1], commands[2], winner));
                    break;
                case "Inspect":
                    this.writer.println(
                            this.manager.inspect(Arrays.asList(commands)));
                    break;
            }
        }
        this.writer.println(this.lastReport());
    }

    private String lastReport() {
        List<String> vehiclesName = this.vehicleByNameMap.values().stream()
                .map(BaseVehicle::getModel)
                .collect(Collectors.toList());

        List<String> defeated = this.defeatedVehicle.stream()
                .map(BaseVehicle::getModel)
                .collect(Collectors.toList());

        int allPartsCount = 0;
        for (BaseVehicle vehicle : this.vehicleByNameMap.values()) {
            for (Part part : vehicle.getParts()) {
                allPartsCount++;
            }
        }

        return String.format("Remaining Vehicles: %s\n" +
                        "Defeated Vehicles: %s\n" +
                        "Currently Used Parts: %d",
                vehiclesName.isEmpty()
                        ? "None" : String.join(", ", vehiclesName),
                defeated.isEmpty()
                        ? "None" : String.join(", ", defeated),
                allPartsCount
        );
    }
}
