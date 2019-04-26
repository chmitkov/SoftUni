package hell.core;

import hell.interfaces.InputReader;
import hell.interfaces.Manager;
import hell.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;
    private Manager heroManager;

    public Engine(InputReader reader, OutputWriter writer, Manager heroManager) {
        this.reader = reader;
        this.writer = writer;
        this.heroManager = heroManager;
    }

    public void run() {
        boolean isRunning = true;

        while(isRunning) {
            String inputLine = this.reader.readLine();
            List<String> arguments = this.parseInput(inputLine);
            this.writer.writeLine(this.processInput(arguments));
            isRunning = !this.ShouldEnd(inputLine);
        }
    }

    private List<String> parseInput(String input) {
        return Arrays.asList(input.split(" "));
    }

    private String processInput(List<String> arguments) {
        String command = arguments.get(0);
        arguments = arguments.stream().skip(1).collect(Collectors.toList());
        String result = null;

        switch(command) {

            case "Hero":
                result = this.heroManager.addHero(arguments);
                break;
            case "Item":
                result = this.heroManager.addItem(arguments);
                break;
            case "Recipe":
                result = this.heroManager.addRecipe(arguments);
                break;
            case "Inspect":
                result = this.heroManager.inspect(arguments);
                break;
            case "Quit":
                result = this.heroManager.quit();
                break;
        }

        return result;
    }

    private boolean ShouldEnd(String inputLine) {
        return inputLine.equals("Quit");
    }
}
