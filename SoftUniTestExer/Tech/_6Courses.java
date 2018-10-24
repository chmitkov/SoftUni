import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class _6Courses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, TreeSet<String>> map = new LinkedHashMap<>();

        String input = br.readLine();

        while (!input.equals("end")) {
            String[] commands = input.split(" : ");
            String course = commands[0];
            String name = commands[1];

            if (map.containsKey(course)) {
                map.get(course).add(name);
            } else {
                map.put(course, new TreeSet<>());
                map.get(course).add(name);
            }

            input = br.readLine();
        }

        map.entrySet().stream()
                .sorted((a, b) ->
                        Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d%n",
                            entry.getKey(), entry.getValue().size());
                    entry.getValue().forEach(x ->
                            System.out.printf("-- %s%n", x));
                });
    }
}
