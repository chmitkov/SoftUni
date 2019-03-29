package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

public class Fight implements Executable {
    @Override
    public String execute() throws ClassNotFoundException, ExecutionControl.NotImplementedException {
        return "fight";
    }
}
