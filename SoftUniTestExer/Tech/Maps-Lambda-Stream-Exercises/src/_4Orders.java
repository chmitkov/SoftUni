import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedHashMap;
import java.util.Map;

public class _4Orders {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Double> priceMap = new LinkedHashMap<>();
        Map<String, Integer> quantityMap = new LinkedHashMap<>();

        String input = br.readLine();

        while (!input.equals("buy")) {
            String[] commands = input.split(" ");
            String name = commands[0];
            double price = Double.parseDouble(commands[1]);
            int quantity = Integer.parseInt(commands[2]);

            priceMap.put(name, price);

            if (!quantityMap.containsKey(name)) {
                quantityMap.put(name, quantity);
            } else {
                quantityMap.put(name, quantityMap.get(name) + quantity);
            }

            input = br.readLine();
        }

        priceMap.entrySet().forEach(x -> System.out.printf("%s -> %.2f%n",
                x.getKey(), x.getValue() * quantityMap.get(x.getKey())));
    }
}
