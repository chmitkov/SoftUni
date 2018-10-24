import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class _7StudentAcademy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, ArrayList<Double>> map = new LinkedHashMap<>();

        int pairs = Integer.parseInt(br.readLine());

        while (pairs-- > 0) {
            String name = br.readLine();
            double grade = Double.parseDouble(br.readLine());

            if (map.containsKey(name)) {
                map.get(name).add(grade);
            } else {
                map.put(name, new ArrayList<>());
                map.get(name).add(grade);
            }
        }

        map.entrySet().stream()
                .sorted((a, b) -> {
                    double num1 = a.getValue().stream()
                            .mapToDouble(x -> x).average().getAsDouble();
                    double num2 = b.getValue().stream()
                            .mapToDouble(x -> x).average().getAsDouble();
                    return Double.compare(num2, num1);
                }).forEach(entry -> {
            if (entry.getValue().stream().mapToDouble(a -> a)
                    .average().getAsDouble() >= 4.5) {
                System.out.printf("%s -> %.2f%n", entry.getKey(),
                        entry.getValue().stream()
                                .mapToDouble(x -> x).average().getAsDouble());
            }
        });
    }
}
