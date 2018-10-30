package problem_7_Mankind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            try {
                String[] commands = scanner.nextLine().split(" ");
                String firstName = commands[0];
                String lastName = commands[1];

                if (commands.length == 3) {
                    String facultyNumber = commands[2];

                    try {
                        Student student = new Student(firstName, lastName, facultyNumber);

                        System.out.println(student);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        return;
                    }
                } else {
                    double weekSalary = Double.parseDouble(commands[2]);
                    int workingHours = Integer.parseInt(commands[3]);

                    try {
                        Worker worker = new Worker(firstName, lastName, weekSalary, workingHours);
                        System.out.println(worker);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        return;
                    }

                }
            } catch (Exception e) {
                return;
            }
        }
    }
}
