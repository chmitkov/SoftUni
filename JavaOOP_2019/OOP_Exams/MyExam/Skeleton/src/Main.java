import core.MachineFactoryImpl;
import core.PilotFactoryImpl;
import core.WarMachinesManagerImpl;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.WarMachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Reader;
import entities.interfaces.Writer;
import io.ReaderImpl;
import io.WriterImpl;


import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();
        WarMachinesManager warMachinesManager = new WarMachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);
        Writer writer = new WriterImpl();
        Reader reader = new ReaderImpl();

        Engine engine = new Engine(writer, reader, warMachinesManager);

        engine.run();
    }
}
