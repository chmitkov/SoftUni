package cresla;


import cresla.core.CommandManager;
import cresla.interfaces.Manager;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Manager manager = new CommandManager();


        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("Exit")){

            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            String result = null;
            switch (command){
                case "Reactor":
                    result = manager.reactorCommand(Arrays.asList(Arrays.stream(tokens).skip(1).toArray(String[]::new)));
                    break;
                case "Module":
                    result = manager.moduleCommand(Arrays.asList(Arrays.stream(tokens).skip(1).toArray(String[]::new)));
                    break;
                case "Report":
                    result = manager.reportCommand(Arrays.asList(Arrays.stream(tokens).skip(1).toArray(String[]::new)));
                    break;
            }

            if(result != null && !result.isEmpty()){
                System.out.println(result);
            }
            input = scanner.nextLine();
        }

        System.out.println(manager.exitCommand(Arrays.asList(input.split("\\s+"))));
    }
}
