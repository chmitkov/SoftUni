package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.annotation.Inject;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class Report implements Executable {

    @Inject
    private Repository repository;

    @Override
    public String execute() throws ClassNotFoundException, ExecutionControl.NotImplementedException {
        return this.repository.getStatistics();
    }
}
