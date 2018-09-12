package salaryIncrease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<PersonFromSalary> listFromPerson = new ArrayList<>();
        int numberOfEmployee = Integer.parseInt(br.readLine());

        while (numberOfEmployee-- > 0) {
            String[] commands = br.readLine().split("\\s+");

            listFromPerson.add(new PersonFromSalary((commands[0]),
                    commands[1], Integer.parseInt(commands[2])
                    , Double.parseDouble(commands[3])));
        }
        double bonus = Double.parseDouble(br.readLine());

        for (PersonFromSalary person : listFromPerson){
            person.increaseSalary(bonus);
        }

        listFromPerson.forEach(System.out::println);
    }

}
