package cresla.core;

import cresla.interfaces.*;
import cresla.interfaces.Module;
import cresla.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager implements Manager {

    private static int id = 1;

    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;

    public CommandManager() {
        this.reactors = new HashMap<>();
        this.modules = new HashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {

        String type = arguments.get(0);
        int additionalParam = Integer.parseInt(arguments.get(1));
        int moduleCapacity = Integer.parseInt(arguments.get(2));

        Reactor reactor = null;
        if (type.equalsIgnoreCase("Cryo")) {
            reactor = new CryoReactor(id, additionalParam, moduleCapacity);
        } else {
            reactor = new HeatReactor(id, additionalParam, moduleCapacity);
        }

        this.reactors.putIfAbsent(id, reactor);

        return String.format("Created %s Reactor - %d", type, id++);
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParam = Integer.parseInt(arguments.get(2));

        Module module = null;

        switch (type) {
            case "CryogenRod":
                module = new CryogenRod(id, additionalParam);
                break;
            case "HeatProcessor":
                module = new HeatProcessor(id, additionalParam);
                break;
            case "CooldownSystem":
                module = new CooldownSystem(id, additionalParam);
                break;
        }

        this.modules.putIfAbsent(id, module);

        if (this.reactors.containsKey(reactorId)) {
            try {
                if (type.equalsIgnoreCase("CooldownSystem") || type.equalsIgnoreCase("HeatProcessor")) {
                    this.reactors.get(reactorId).addAbsorbingModule((AbsorbingModule) module);
                } else {

                    this.reactors.get(reactorId).addEnergyModule((EnergyModule) module);
                }
            }catch (IllegalArgumentException ex){
                return "";
            }

        }

        return String.format("Added %s - %d to Reactor - %d", type, id++, reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {

        int objectId = Integer.parseInt(arguments.get(0));

        String output = "";

        if(this.reactors.containsKey(objectId)){
            output = this.reactors.get(objectId).toString();
        }else if(this.modules.containsKey(objectId)){
            output = this.modules.get(objectId).toString();
        }

        return output;
    }

    @Override
    public String exitCommand(List<String> arguments) {
        StringBuilder sb = new StringBuilder();

        int cryoReactorsCount = 0;
        int heatReactorsCount = 0;
        int energyModulesCount = 0;
        int absorbingModulesCount = 0;
        long totalEnergyOutput = 0;
        long totalHeatAbsorbing = 0;

        for (Reactor reactor : reactors.values()) {
            String reactorClassName = reactor.getClass().getSimpleName();

            if (reactorClassName.startsWith("Cryo")) {
                cryoReactorsCount++;
            }
            if (reactorClassName.startsWith("Heat")) {
                heatReactorsCount++;
            }

            totalEnergyOutput += reactor.getTotalEnergyOutput() > reactor.getTotalHeatAbsorbing()
                    ? 0
                    : reactor.getTotalEnergyOutput();
            totalHeatAbsorbing += reactor.getTotalHeatAbsorbing();
        }

        for (Module module : modules.values()) {
            String moduleClassName = module.getClass().getSuperclass().getSimpleName();

            if (moduleClassName.endsWith("EnergyModule")) {
                energyModulesCount++;
            }
            if (moduleClassName.endsWith("AbsorberModule")) {
                absorbingModulesCount++;
            }
        }

        // Cryo Reactors: 1
        // Heat Reactors: 1
        // Energy Modules: 6
        // Absorbing Modules: 2
        // Total Energy Output: 10249
        // Total Heat Absorbing: 20250

        sb.append(String.format("Cryo Reactors: %d", cryoReactorsCount)).append(System.lineSeparator());
        sb.append(String.format("Heat Reactors: %d", heatReactorsCount)).append(System.lineSeparator());
        sb.append(String.format("Energy Modules: %d", energyModulesCount)).append(System.lineSeparator());
        sb.append(String.format("Absorbing Modules: %d", absorbingModulesCount)).append(System.lineSeparator());
        sb.append(String.format("Total Energy Output: %d", totalEnergyOutput)).append(System.lineSeparator());
        sb.append(String.format("Total Heat Absorbing: %d", totalHeatAbsorbing)).append(System.lineSeparator());

        return sb.toString().trim();
    }
}
