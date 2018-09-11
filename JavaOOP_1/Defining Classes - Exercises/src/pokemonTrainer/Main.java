package pokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String line = br.readLine();

        while (!"Tournament".equals(line)){
            String[] commands= line.split("\\s+");

            String name = commands[0];
            String pokeName = commands[1];
            String element = commands[2];
            int health = Integer.parseInt(commands[3]);
            Trainer currTrainer = trainers.containsKey(name)?
                    trainers.get(name):new Trainer(name);

            Pokemon currPoke = new Pokemon(pokeName,element,health);

            currTrainer.getPokemonList().add(currPoke);

            trainers.put(name,currTrainer);

            line = br.readLine();
        }

        String nextCommand = br.readLine();

        while (!"End".equals(nextCommand)){
            for (Trainer trainer : trainers.values()) {
                trainer.checkForBadge(nextCommand);
            }

            nextCommand = br.readLine();
        }

         trainers.values().stream()
                .sorted((a,b)->Integer.compare(b.getBadges(),a.getBadges()))
                .collect(Collectors.toList())
                 .forEach(System.out::println);
    }

}
