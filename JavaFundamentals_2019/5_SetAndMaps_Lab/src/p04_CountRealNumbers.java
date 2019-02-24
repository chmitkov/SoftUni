import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class p04_CountRealNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Double, Integer> map = new LinkedHashMap<>();

        Arrays.stream(br.readLine().split("\\s+"))
                .forEach(x -> {
                    double number = Double.parseDouble(x);
                    if (map.containsKey(number)) {
                        map.put(number, map.get(number) + 1);
                    } else {
                        map.put(number, 1);
                    }
                });

        map.forEach((k,v) -> System.out.printf("%.1f -> %d%n", k, v));
    }
}
