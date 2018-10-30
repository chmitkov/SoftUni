package problem_6_BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<HavingBirthDate> set = new LinkedHashSet<>();
        String input = br.readLine();

        while (!input.equals("End")) {
            String[] commands = input.split(" ");
            String type = commands[0];
            String name = commands[1];
            if(type.equals("Citizen")){
                int age = Integer.parseInt(commands[2]);
                String id = commands[3];
                String birthdate = commands[4];

                set.add(new Citizen(name,age,id,birthdate));
            }else if (type.equals("Pet")){
                String birthdate = commands[2];

                set.add(new Pet(name,birthdate));
            }
            input = br.readLine();
        }
        String end = br.readLine();

        set.stream()
                .filter(x->x.getDate()
                .endsWith(end))
                .forEach(x-> System.out.println(x.getDate()));
    }
}
