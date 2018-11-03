package problem_5_BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<HavingId> set = new LinkedHashSet<>();
        String input = br.readLine();

        while (!input.equals("End")) {
            String[] commands = input.split(" ");
            String name = commands[0];


            if (commands.length == 3) {
                int age = Integer.parseInt(commands[1]);
                String id = commands[2];

                set.add(new Citizen(name,age,id));
            } else {
                String id = commands[1];

                set.add(new Robot(name,id));
            }

            input = br.readLine();
        }
        String end = br.readLine();

        set.stream()
                .filter(x->x.getId()
                .endsWith(end))
                .forEach(x-> System.out.println(x.getId()));
    }
}
