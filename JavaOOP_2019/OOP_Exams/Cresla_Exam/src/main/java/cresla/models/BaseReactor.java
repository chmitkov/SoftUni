package cresla.models;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

public abstract class BaseReactor implements Reactor {

    private int id;
   private Container container;

    protected BaseReactor(int id, int capacity){
        this.id = id;
        this.container = new ModuleContainer(capacity);
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.container.getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.container.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
        return this.container.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d", this.getClass().getSimpleName(), this.getId())).append(System.lineSeparator());
        sb.append(String.format("Energy Output: %d",
                this.getTotalEnergyOutput() > this.getTotalHeatAbsorbing()
                        ? 0
                        : this.getTotalEnergyOutput()))
                .append(System.lineSeparator());
        sb.append(String.format("Heat Absorbing: %d", this.getTotalHeatAbsorbing())).append(System.lineSeparator());
        sb.append(String.format("Modules: %d", this.getModuleCount())).append(System.lineSeparator());


        return sb.toString().trim();
    }
}
