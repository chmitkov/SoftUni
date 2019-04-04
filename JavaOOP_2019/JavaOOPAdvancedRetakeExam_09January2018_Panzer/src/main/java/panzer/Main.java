package panzer;

import panzer.contracts.InputReader;
import panzer.contracts.OutputWriter;
import panzer.io.InputReaderImpl;
import panzer.io.OutputWriterImpl;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReaderImpl();
        OutputWriter writer = new OutputWriterImpl();

        Engine engine = new Engine(reader,writer);
        engine.run();
    }
}
