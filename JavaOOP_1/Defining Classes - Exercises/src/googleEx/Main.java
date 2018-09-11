package googleEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> map = new HashMap<>();
        String line = br.readLine();

        while (!"End".equals(line)) {
            String[] commands = line.split("\\s+");
            String name = commands[0];

            Person currPerson = map.keySet().contains(name)?
                    map.get(name):
                    new Person();

            currPerson.setName(name);

            switch (commands[1]) {
                case "company":
                    currPerson.setCompany(new Company(commands[2],commands[3],Double.parseDouble(commands[4])));
                    break;
                case "car":
                    currPerson.setCar(new CarOwned(commands[2],Integer.parseInt(commands[3])));
                    break;
                case "pokemon":
                    currPerson.getPokemonOwnedList().add(new PokemonOwned(commands[2],commands[3]));
                    break;
                case "parents":
                    currPerson.getParentsList().add(new Parents(commands[2],commands[3]));
                    break;
                case "children":
                    currPerson.getChildrenList().add(new Children(commands[2],commands[3]));
                    break;
            }

            map.put(name, currPerson);
            line = br.readLine();
        }

        String neededName = br.readLine();

        if (map.keySet().contains(neededName)){
            System.out.println(map.get(neededName).toString());
        }

    }
}
