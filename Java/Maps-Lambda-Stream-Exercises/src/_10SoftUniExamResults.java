import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class _10SoftUniExamResults {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> resultsMap = new TreeMap<>();
        Map<String, Integer> submissionMap = new TreeMap<>();

        String input = br.readLine();

        while (!input.equals("exam finished")) {
            String[] commands = input.split("-");
            String name = commands[0];

            if (commands.length == 3) {
                String course = commands[1];
                int score = Integer.parseInt(commands[2]);

                resultsMap.putIfAbsent(name, score);

                if (!submissionMap.containsKey(course)) {
                    submissionMap.put(course, 1);
                } else {
                    submissionMap.put(course, submissionMap.get(course) + 1);
                }

            } else {
                resultsMap.remove(name);
            }

            input = br.readLine();
        }

        System.out.println("Results:");
        resultsMap.entrySet().stream().sorted((a, b) ->
                Integer.compare(b.getValue(), a.getValue())
        ).forEach(entry -> {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        });
        System.out.println("Submissions:");
        submissionMap.entrySet().stream().sorted((a, b) ->
                Integer.compare(b.getValue(), a.getValue())
        ).forEach(x -> {
            System.out.printf("%s - %d%n", x.getKey(), x.getValue());
        });
    }
}
