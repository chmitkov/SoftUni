package hell;

import hell.core.Engine;
import hell.core.HeroManager;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.ConsoleReader;
import hell.io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        HeroManager manager = new HeroManager();

        Runnable engine = new Engine(reader, writer, manager);
        engine.run();
    }
}