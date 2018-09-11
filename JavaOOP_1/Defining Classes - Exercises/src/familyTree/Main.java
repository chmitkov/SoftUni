package familyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, PersonFromFamily> mapByNames = new HashMap<>();
        Map<String, PersonFromFamily> mapByBirthday = new HashMap<>();

        Function<String, PersonFromFamily> checkMapsForMatchPerson =
                line -> {
                    String[] commands = line.split("\\s+");
                    if (commands.length == 1) {
                        if (Character.isDigit(commands[0].charAt(0))) {
                            if (mapByBirthday.containsKey(commands[0])) {
                                return mapByBirthday.get(commands[0]);
                            } else {
                                return new PersonFromFamily();
                            }
                        } else {
                            if (mapByNames.containsKey(commands[0])) {
                                return mapByNames.get(commands[0]);
                            } else {
                                return new PersonFromFamily();
                            }
                        }
                    } else {
                        boolean inMapByName = mapByNames.keySet()
                                .contains(String.format("%s %s", commands[0], commands[1]));
                        boolean inMapByBirthday = mapByBirthday.keySet()
                                .contains(commands[2]);
                        if (inMapByName) {
                            return mapByNames.get(String.format("%s %s", commands[0], commands[1]));
                        } else if (inMapByBirthday) {
                            return mapByBirthday.get(commands[2]);
                        } else {
                            return new PersonFromFamily();
                        }
                    }
                };
        Consumer<PersonFromFamily> checkAndSetParentsAndChildren = person -> {
            String personBirthday = person.getBirthday();
            if (mapByBirthday.containsKey(personBirthday)) {
                person.getParents().addAll(mapByBirthday.get(personBirthday).getParents());
                person.getChildren().addAll(mapByBirthday.get(personBirthday).getChildren());
            }
        };
        String mainPerson = br.readLine();
        PersonFromFamily searchedPerson = new PersonFromFamily();
        if (!Character.isDigit(mainPerson.charAt(0))) {
            String firstName = mainPerson.split(" ")[0];
            String lastName = mainPerson.split(" ")[1];

            searchedPerson.setFirstName(firstName);
            searchedPerson.setLastName(lastName);

            mapByNames.put(mainPerson, searchedPerson);
        } else {

            searchedPerson.setBirthday(mainPerson);
            mapByBirthday.put(mainPerson, searchedPerson);
        }

        String line = br.readLine();

        while (!"End".equals(line)) {


            if (line.contains("-")) {
                String[] commands = line.split("-");

                PersonFromFamily firstPerson = checkMapsForMatchPerson.apply(commands[0].trim());
                PersonFromFamily secondPerson = checkMapsForMatchPerson.apply(commands[1].trim());

                firstPerson.getChildren().add(secondPerson);
                secondPerson.getParents().add(firstPerson);

                boolean firstStartsWithDigit = Character.isDigit(commands[0].trim().charAt(0));
                boolean secondStartsWithDigit = Character.isDigit(commands[1].trim().charAt(0));

                if (firstStartsWithDigit) {
                    if (secondStartsWithDigit) {
                        mapByBirthday.put(commands[0].trim(), firstPerson);
                        mapByBirthday.put(commands[1].trim(), secondPerson);
                    } else {
                        mapByBirthday.put(commands[0].trim(), firstPerson);
                        mapByNames.put(commands[1].trim(), secondPerson);
                    }
                } else {
                    if (secondStartsWithDigit) {
                        mapByNames.put(commands[0].trim(), firstPerson);
                        mapByBirthday.put(commands[1].trim(), secondPerson);
                    } else {
                        mapByNames.put(commands[0].trim(), firstPerson);
                        mapByNames.put(commands[1].trim(), secondPerson);
                    }
                }


            } else {

                String[] commands = line.split("\\s+");
                PersonFromFamily currPerson = checkMapsForMatchPerson.apply(line);
                currPerson.setFirstName(commands[0]);
                currPerson.setLastName(commands[1]);
                currPerson.setBirthday(commands[2]);

                checkAndSetParentsAndChildren.accept(currPerson);

                mapByNames.put(String.format("%s %s", commands[0], commands[1]), currPerson);
                mapByBirthday.put(commands[2], currPerson);

            }

            line = br.readLine();
        }

        System.out.print(searchedPerson.toString());
        System.out.println("Parents:");
        searchedPerson.getParents().forEach(System.out::print);
        System.out.println("Children:");
        searchedPerson.getChildren().forEach(System.out::print);

    }

}
