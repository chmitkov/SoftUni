import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class _2Judge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, TreeMap<String, Integer>> coursesMap = new LinkedHashMap<>();
        Map<String, Integer> scoreMap = new TreeMap<>();
        String input = br.readLine();

        while (!input.equals("no more time")) {
            String[] commands = input.split(" -> ");
            String name = commands[0];
            String course = commands[1];
            int score = Integer.parseInt(commands[2]);

            if (!coursesMap.containsKey(course)) {
                coursesMap.put(course, new TreeMap<>());
                coursesMap.get(course).put(name, score);
            } else {
                if (!coursesMap.get(course).containsKey(name)) {
                    coursesMap.get(course).put(name, score);
                } else {
                    if (coursesMap.get(course).get(name) < score) {
                        coursesMap.get(course).put(name, score);
                    }
                }

            }

            input = br.readLine();
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : coursesMap.entrySet()) {
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                if (!scoreMap.containsKey(innerEntry.getKey())) {
                    scoreMap.put(innerEntry.getKey(), 0);
                }
                scoreMap.put(innerEntry.getKey(),
                        scoreMap.get(innerEntry.getKey()) + innerEntry.getValue());
            }
        }

        int[] counters = new int[]{1, 1};
        for (Map.Entry<String, TreeMap<String, Integer>> entry : coursesMap.entrySet()) {
            System.out.printf("%s: %d participants%n",
                    entry.getKey(), entry.getValue().entrySet().size());
            entry.getValue()
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(x -> System.out.printf("%d. %s <::> %d%n",
                            counters[0]++, x.getKey(), x.getValue()));


        }
        System.out.println("Individual standings:");
        scoreMap.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .forEach(x -> System.out.printf("%d. %s -> %d%n",
                        counters[1]++, x.getKey(), x.getValue()));
    }
}
