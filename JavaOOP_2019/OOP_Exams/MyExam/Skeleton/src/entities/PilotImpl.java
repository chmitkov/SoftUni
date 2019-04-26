package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PilotImpl implements Pilot {

    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addMachine(Machine machine) {
        this.machines.add(machine);
    }

    public List<Machine> getMachines() {
        return this.machines;
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s – %s machines\n"
                , this.name, this.machines.size()));

        return sb.toString();
    }

    public void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Pilot name cannot be null or empty string.");
        }
        this.name = name;
    }
}