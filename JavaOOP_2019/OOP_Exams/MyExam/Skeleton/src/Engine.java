import core.interfaces.WarMachinesManager;
import entities.interfaces.Reader;
import entities.interfaces.Writer;

public class Engine implements Runnable {

    private Writer writer;
    private Reader reader;
    private WarMachinesManager warMachinesManager;


    public Engine(Writer writer, Reader reader,
                  WarMachinesManager warMachinesManager) {

        this.writer = writer;
        this.reader = reader;
        this.warMachinesManager = warMachinesManager;
    }

    @Override
    public void run() {

        String line;
        while (!"Over".equals(line = this.reader.readLine())) {

            String[] commands = line.split("\\s+");

            switch (commands[0]) {
                case "Hire":
                    this.writer.printLine(this.warMachinesManager.hirePilot(commands[1]));
                    break;
                case "Report":
                    this.writer.printLine(this.warMachinesManager.pilotReport(commands[1]));
                    break;
                case "ManufactureTank":
                    this.writer.printLine(
                            this.warMachinesManager
                                    .manufactureTank(commands[1],
                                            Double.valueOf(commands[2]),
                                            Double.valueOf(commands[3])));
                    break;
                case "ManufactureFighter":
                    this.writer.printLine(
                            this.warMachinesManager
                                    .manufactureFighter(commands[1],
                                            Double.valueOf(commands[2]),
                                            Double.valueOf(commands[3]))
                    );
                    break;
                case "Engage":
                    this.writer.printLine(
                            this.warMachinesManager
                                    .engageMachine(commands[1], commands[2]));
                    break;
                case "Attack":
                    this.writer.printLine(
                            this.warMachinesManager.attackMachines(
                                    commands[1], commands[2]
                            )
                    );
                    break;
                case "DefenseMode":
                    this.writer.printLine(
                            this.warMachinesManager
                                    .toggleTankDefenseMode(commands[1])
                    );
                    break;
                case "AggressiveMode":
                    this.writer.printLine(
                            this.warMachinesManager
                                    .toggleFighterAggressiveMode(commands[1])
                    );
                    break;
            }
        }
    }
}
