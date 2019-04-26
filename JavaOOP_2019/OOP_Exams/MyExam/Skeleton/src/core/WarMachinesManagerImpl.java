package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.WarMachinesManager;

import entities.BaseMachine;
import entities.FighterImpl;
import entities.PilotImpl;
import entities.TankImpl;
import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.Map;

public class WarMachinesManagerImpl implements WarMachinesManager {

    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilotMap;
    private Map<String, Machine> machineMap;


    public WarMachinesManagerImpl(PilotFactory pilotFactory,
                                  MachineFactory machineFactory,
                                  Map<String, Pilot> pilots,
                                  Map<String, Machine> machines) {

        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilotMap = pilots;
        this.machineMap = machines;
    }


    @Override
    public String hirePilot(String name) {
        if (!this.pilotMap.containsKey(name)) {
            this.pilotMap.put(name, new PilotImpl(name));
            return String.format(OutputMessages.pilotHired, name);
        }
        return String.format(OutputMessages.pilotExists, name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        TankImpl tank = (TankImpl) this.machineFactory.createTank(name, attackPoints, defensePoints);

        if (this.machineMap.containsKey(name)) {
            return String.format(OutputMessages.machineExists, name);
        }

        this.machineMap.put(name, tank);
        return String.format(OutputMessages.tankManufactured, name,
                attackPoints, defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        FighterImpl fighter = (FighterImpl)
                this.machineFactory.createFighter(name, attackPoints, defensePoints);

        if (this.machineMap.containsKey(name)) {
            return String.format(OutputMessages.machineExists, name);
        }

        this.machineMap.putIfAbsent(name, fighter);

        return String.format(OutputMessages.fighterManufactured, name,
                attackPoints, defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        if (!this.pilotMap.containsKey(selectedPilotName)) {
            return
                    String.format(OutputMessages.pilotNotFound, selectedPilotName);
        }
        Pilot pilot = this.pilotMap.get(selectedPilotName);

        if (!this.machineMap.containsKey(selectedMachineName)) {
            throw new IllegalArgumentException(
                    String.format(OutputMessages.machineNotFound, selectedMachineName));

        }

        Machine machine = this.machineMap.get(selectedMachineName);

        if (machine.getPilot() != null) {
            return String.format(OutputMessages.machineHasPilotAlready, selectedMachineName);
        }

        pilot.addMachine(machine);

        machine.setPilot(pilot);

        return String.format(OutputMessages.machineEngaged,
                selectedPilotName, selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        if (!this.machineMap.containsKey(attackingMachineName)) {
           return (
                    String.format(
                            OutputMessages.machineNotFound,
                            attackingMachineName));

        }

        Machine attackMachine = this.machineMap.get(attackingMachineName);

        if (!this.machineMap.containsKey(defendingMachineName)) {
            return String.format(
                    OutputMessages.machineNotFound,
                    attackingMachineName);
        }

        Machine defenseMachine = this.machineMap.get(defendingMachineName);

        attackMachine.getTargets().add(defendingMachineName);

        if (attackMachine.getAttackPoints() > defenseMachine.getDefensePoints()) {
            defenseMachine.setHealthPoints(
                    defenseMachine.getHealthPoints() - attackMachine.getAttackPoints());

        }

        return String.format(OutputMessages.attackSuccessful,
                defendingMachineName, attackingMachineName,
                defenseMachine.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        if (!this.pilotMap.containsKey(pilotName)) {
            return
                    String.format(OutputMessages.pilotNotFound, pilotName);
        }

        Pilot pilot = this.pilotMap.get(pilotName);

        StringBuilder result = new StringBuilder();

        result.append(pilot.report());

        if (pilot.getMachines().isEmpty()) {
            return result.toString().trim();
        }

        for (Machine machine : pilot.getMachines()) {
            result.append(machineMap.get(machine.getName().toString()))
                    .append(System.lineSeparator());
        }

        return result.toString().trim();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if (!this.machineMap.containsKey(fighterName)) {
            return String.format(OutputMessages.machineNotFound, fighterName);
        }

        if (this.machineMap.get(fighterName).getClass().getSimpleName()
                .equals("TankImpl")) {
            return String.format(OutputMessages.notSupportedOperation, fighterName);
        }

        Fighter fighter = (Fighter) this.machineMap.get(fighterName);
        fighter.toggleAggressiveMode();
        return String.format(OutputMessages.fighterOperationSuccessful, fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if (!this.machineMap.containsKey(tankName)) {
            return String.format(OutputMessages.machineNotFound, tankName);
        }

        if (this.machineMap.get(tankName).getClass().getSimpleName().equals("FighterImpl")) {
            return String.format(OutputMessages.notSupportedOperation, tankName);
        }
        Tank tank = (Tank) this.machineMap.get(tankName);

        tank.toggleDefenseMode();
        return String.format(OutputMessages.tankOperationSuccessful, tankName);
    }
}
