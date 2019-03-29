package pr0304Barracks.core;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.annotation.Inject;
import pr0304Barracks.contracts.*;
import pr0304Barracks.contracts.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private static final String COMMAND_PATH = "pr0304Barracks.core.commands.";

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpredCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException | NoSuchMethodException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpredCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String commandClassName = Character.toUpperCase(commandName.charAt(0))
                + commandName.substring(1);
        Class<?> commandClass = Class.forName(COMMAND_PATH + commandClassName);
        Constructor constructor = commandClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Executable command = (Executable) constructor.newInstance();

        this.injectDependencies(command);
        return command.execute();
    }

    private <T> void injectDependencies(T command) throws IllegalAccessException {
        Field[] commandFields = command.getClass().getDeclaredFields();
        Field[] engineFields = this.getClass().getDeclaredFields();

        for (Field commandField : commandFields) {
            commandField.setAccessible(true);
            if (commandField.isAnnotationPresent(Inject.class)) {
                for (Field engineField : engineFields) {
                    engineField.setAccessible(true);
                    if (commandField.getType().getSimpleName().equals(
                            engineField.getType().getSimpleName())
                            && commandField.getType().equals(engineField.getType())) {

                        commandField.set(command, engineField.get(this));
                    }

                }
            }
        }
    }
}
