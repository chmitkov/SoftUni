package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.annotation.Inject;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

public class Add implements Executable {

    @Inject
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    @Override
    public String execute() throws ClassNotFoundException, ExecutionControl.NotImplementedException {
        String unitType = this.data[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
