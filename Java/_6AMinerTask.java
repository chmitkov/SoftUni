import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class _6AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> dict = new LinkedHashMap<>();
        String input = br.readLine();
        while (!"stop".equals(input)) {
            String resource = input;
            long quantity = Long.parseLong(br.readLine());
            if (!dict.containsKey(resource)) {
                dict.put(resource, quantity);
            } else {
                dict.put(resource, dict.get(resource) + quantity);
            }
            input = br.readLine();
        }

        dict.entrySet()
                .forEach(kvp->
                        System.out.printf("%s -> %d%n",kvp.getKey(),kvp.getValue()));
    }
}
