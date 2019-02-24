import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p05_AverageStudentsGrades {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Double>> map = new TreeMap<>();
        int counter = Integer.parseInt(br.readLine());

        while (counter-- > 0) {
            String[] commands = br.readLine().split("\\s+");

            String name = commands[0];
            double grade = Double.parseDouble(commands[1]);
            if (map.containsKey(name)) {
                map.get(name).add(grade);
            } else {
                map.put(name, new ArrayList<>() {{
                    add(grade);
                }});
            }
        }

        for (String s : map.keySet()) {
            System.out.printf("%s -> ", s);
            map.get(s).forEach(x -> System.out.printf("%.2f ", x));
            double average = map.get(s)
                    .stream()
                    .mapToDouble(x -> x)
                    .average()
                    .getAsDouble();
            System.out.printf("(avg: %.2f)%n", average);
        }
    }
}
