package problem_7_CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> myList = new CustomList<>();

        String command;

        while (!(command = br.readLine()).equals("END")) {
            String[] tokens = command.split(" ");

            String currentCommand = tokens[0];
            String element = tokens.length > 1 ? tokens[1] : null;
            switch (currentCommand) {
                case "Add":
                    myList.add(element);
                    break;
                case "Remove":
                    System.out.println(myList.remove(Integer.parseInt(element)));
                    break;
                case "Contains":
                    System.out.println(myList.contains(element));
                    break;
                case "Swap":
                    myList.swap(Integer.parseInt(element), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(myList.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(myList.getMax());
                    break;
                case "Min":
                    System.out.println(myList.getMin());
                    break;
                case "Print":
                    System.out.println(myList);
                    break;
            }
        }
    }
}
