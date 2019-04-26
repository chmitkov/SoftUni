package p01_EventImplementation;

import p01_EventImplementation.Models.Dispatcher;
import p01_EventImplementation.Models.Handler;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        Handler handler = new Handler();

        dispatcher.addNameChangeListener(handler);

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!line.equals("End")) {
            dispatcher.setName(line);
            line = scanner.nextLine();
        }
    }
}
