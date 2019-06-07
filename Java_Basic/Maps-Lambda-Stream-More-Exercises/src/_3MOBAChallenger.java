import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class _3MOBAChallenger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, TreeMap<String, Integer>> map = new TreeMap<>();
        Map<String, Integer> scoreMap = new HashMap<>();
        String input = br.readLine();

        while (!input.equals("Season end")) {
            if (!input.contains("vs")) {
                String[] commands = input.split(" -> ");
                String name = commands[0];
                String position = commands[1];
                int skill = Integer.parseInt(commands[2]);

                if (map.containsKey(name)) {

                    if (map.get(name).containsKey(position)) {
                        if (map.get(name).get(position) > skill) {
                            map.get(name).put(position, skill);
                        }

                    } else {
                        map.get(name).put(position, skill);
                    }
                } else {

                    map.put(name, new TreeMap<>());
                    map.get(name).put(position, skill);

                }

            } else {
                String[] commands = input.split(" vs ");
                String player1 = commands[0];
                String player2 = commands[1];

                if (map.containsKey(player1) && map.containsKey(player2)) {
                    if (haveSamePosition(player1, player2, map)) {
                        fight(player1, player2, map);
                    }
                }
            }

            input = br.readLine();
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : map.entrySet()) {
            int allSkills = 0;
            if (!scoreMap.containsKey(entry.getKey())) {
                scoreMap.put(entry.getKey(), 0);
            }
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                allSkills += innerEntry.getValue();
            }
            scoreMap.put(entry.getKey(), allSkills);
        }

        scoreMap = scoreMap.entrySet().stream().sorted((a,b)->Integer.compare(b.getValue(),a.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
            System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue());
            map.get(entry.getKey())
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(x -> System.out.printf("- %s <::> %d%n", x.getKey(), x.getValue()));
        }
    }

    private static void fight(String player1, String player2, Map<String, TreeMap<String, Integer>> map) {
        for (Map.Entry<String, Integer> entry : map.get(player1).entrySet()) {
            if (map.get(player2).keySet().contains(entry.getKey())) {
                if (map.get(player1).get(entry.getKey()) > map.get(player2).get(entry.getKey())) {
                    map.remove(player2);
                } else if (map.get(player2).get(entry.getKey()) > map.get(player1).get(entry.getKey())) {
                    map.remove(player1);
                }
            }
        }
    }

    private static boolean haveSamePosition(String player1, String player2, Map<String, TreeMap<String, Integer>> map) {
        for (Map.Entry<String, Integer> entry : map.get(player1).entrySet()) {
            if (map.get(player2).keySet().contains(entry.getKey())) {
                return true;
            }
        }
        return false;
    }

}
