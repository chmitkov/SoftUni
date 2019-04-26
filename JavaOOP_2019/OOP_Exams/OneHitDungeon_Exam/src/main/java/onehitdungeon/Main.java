package onehitdungeon;

import onehitdungeon.interfaces.InputReader;
import onehitdungeon.interfaces.OutputWriter;
import onehitdungeon.io.InputReaderImpl;
import onehitdungeon.io.OutputWriterImpl;

public class Main {
    public static void main(String[] args) {
        InputReader inputReader = new InputReaderImpl();
        OutputWriter outputWriter = new OutputWriterImpl();

        Engine engine = new Engine(inputReader, outputWriter);
        engine.run();
    }
}
