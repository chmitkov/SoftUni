package callofduty;

import callofduty.core.Engine;
import callofduty.core.MissionControlImpl;
import callofduty.core.MissionManagerImpl;
import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;
import callofduty.io.InputReaderImpl;
import callofduty.io.OutputWriterImpl;

import java.io.Writer;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReaderImpl();
        OutputWriter writer = new OutputWriterImpl();
        MissionManager manager = new MissionManagerImpl();
        MissionControl control = new MissionControlImpl();

        Engine engine = new Engine(reader, writer, manager, control);

        engine.run();
    }
}




