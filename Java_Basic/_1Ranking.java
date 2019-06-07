import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class _1Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> passwordsMap = new HashMap<>();
        Map<String, LinkedHashMap<String, Integer>> coursesMap =
                new TreeMap<>();
        Map<String, Integer> scoreMap = new HashMap<>();

        String input = br.readLine();

        while (!input.equals("end of contests")) {
            String[] commands = input.split(":");
            String course = commands[0];
            String pass = commands[1];

            passwordsMap.put(course, pass);

            input = br.readLine();
        }

        String input2 = br.readLine();

        while (!input2.equals("end of submissions")) {
            String[] commands = input2.split("=>");
            String course = commands[0];
            String pass = commands[1];
            String name = commands[2];
            int score = Integer.parseInt(commands[3]);

            if (passwordsMap.containsKey(course) &&
                    passwordsMap.get(course).equals(pass)) {

                if (!coursesMap.containsKey(name)) {
                    coursesMap.put(name, new LinkedHashMap<>());
                    coursesMap.get(name).put(course, score);
                } else {
                    if (coursesMap.get(name).containsKey(course)) {
                        if (coursesMap.get(name).get(course) < score) {
                            coursesMap.get(name).put(course, score);
                        }
                    } else {
                        coursesMap.get(name).put(course, score);
                    }
                }

            }
            input2 = br.readLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : coursesMap.entrySet()) {
            int allPoints = 0;
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                allPoints += innerEntry.getValue();
            }
            scoreMap.put(entry.getKey(), allPoints);
        }

        scoreMap.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .limit(1)
                .forEach(x -> System.out.printf("Best candidate is %s with total %d points.%n",
                        x.getKey(), x.getValue()));

        System.out.println("Ranking:");
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : coursesMap.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue()
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(x -> {
                        System.out.printf("# %s -> %d%n", x.getKey(), x.getValue());
                    });
        }
    }
}
