import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class _2AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new LinkedHashMap<>();
        String input = br.readLine();

        while (!input.equals("stop")) {
            String name = input;
            int quantity = Integer.parseInt(br.readLine());

            if (!map.containsKey(name)) {
                map.put(name, quantity);
            }else{
                map.put(name, map.get(name) + quantity);
            }

            input = br.readLine();
        }

        map.entrySet().forEach(x -> System.out.printf("%s -> %d%n",
                x.getKey(), x.getValue()));
    }
}
