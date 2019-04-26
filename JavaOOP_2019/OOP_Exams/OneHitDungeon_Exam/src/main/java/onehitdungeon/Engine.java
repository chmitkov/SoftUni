package onehitdungeon;

import onehitdungeon.core.DungeonManagerImpl;
import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.InputReader;
import onehitdungeon.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private DungeonManager dungeonManager;

    public Engine(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.dungeonManager = new DungeonManagerImpl();
    }

    @Override
    public void run() {

        String line;
        while (!"Quit".equals(line = this.inputReader.readLine())) {
            List<String> commands = Arrays.stream(line.split("\\s+"))
                    .collect(Collectors.toList());
            switch (commands.get(0)) {
                case "Hero":
                    this.outputWriter.println(this.dungeonManager.hero(commands));
                    break;
                case "Select":
                    this.outputWriter.println(this.dungeonManager.select(commands));
                    break;
                case "Fight":
                    this.outputWriter.println(this.dungeonManager.fight(commands));
                    break;
                case "Advance":
                    this.outputWriter.println(this.dungeonManager.advance(commands));
                    break;
                case "Train":
                    this.outputWriter.println(this.dungeonManager.train(commands));
                    break;
                case "Status":
                    this.outputWriter.println(this.dungeonManager.status(commands));
                    break;
            }
        }

        this.outputWriter.println(
                this.dungeonManager.quit(Arrays.asList(line.split("\\s+"))));
    }
}
