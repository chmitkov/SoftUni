package validationData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<PersonFromValidation> listFromPerson = new ArrayList<>();
        int numberOfEmployee = Integer.parseInt(br.readLine());

        while (numberOfEmployee-- > 0) {
            String[] commands = br.readLine().split("\\s+");

            try {
                listFromPerson.add(new PersonFromValidation(
                        commands[0], commands[1], Integer.parseInt(commands[2]),
                        Double.parseDouble(commands[3]))
                );
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            ;
        }
        double bonus = Double.parseDouble(br.readLine());

        for (PersonFromValidation person : listFromPerson) {
            person.increaseSalary(bonus);
        }

        listFromPerson.forEach(System.out::println);
    }

}
