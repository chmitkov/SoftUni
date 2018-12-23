package problem_05_ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int equalPeople = 0;

        List<Person> persons = new ArrayList<>();
        String line;

        while (!"END".equals(line = br.readLine())) {
            String[] commands = line.split("\\s+");

            Person currentPerson = new Person(commands[0],
                    Integer.parseInt(commands[1]), commands[2]);

            persons.add(currentPerson);
        }

        int numberOfPerson = Integer.parseInt(br.readLine());

        Person neededPerson = persons.get(numberOfPerson - 1);

        for (Person person : persons) {
            if (neededPerson.compareTo(person)==0) {
                equalPeople++;
            }
        }

        System.out.println(equalPeople == 1
                ? "No matches"
                : String.format("%d %d %d", equalPeople,
                persons.size() - equalPeople, persons.size()));
    }
}
