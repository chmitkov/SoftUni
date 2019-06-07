import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class _9ForceBook {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, TreeSet<String>> map = new TreeMap<>();
        String input = br.readLine();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String[] commands = input.split(" \\| ");
                String name = commands[1];
                String side = commands[0];

                if (!map.containsKey(side)) {
                    map.put(side, new TreeSet<>());
                }
                map.get(side).add(name);

            } else {
                String[] commands = input.split(" -> ");
                String name = commands[0];
                String side = commands[1];

                for (String key : map.keySet()) {
                    if (map.get(key).contains(name)) {
                        map.get(key).remove(name);
                    }
                }

                if (!map.containsKey(side)) {
                    map.put(side, new TreeSet<>());
                }
                map.get(side).add(name);
                System.out.printf("%s joins the %s side!%n",name,side);
            }

            input = br.readLine();
        }

        map.entrySet().stream().sorted((a, b) ->
                Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(entry -> {
                    if (entry.getValue().size() > 0) {
                        System.out.printf("Side: %s, Members: %d%n", entry.getKey(),
                                entry.getValue().size());
                        entry.getValue().forEach(x ->
                                System.out.printf("! %s%n", x));
                    }

                });
    }
}
