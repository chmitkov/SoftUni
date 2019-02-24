import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class p06_ProductShop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        String line;

        while (!"Revision".equalsIgnoreCase(line = br.readLine())) {
            String[] commands = line.split(", +");
            String shopName = commands[0];
            String product = commands[1];
            Double price = Double.valueOf(commands[2]);

            if (shops.containsKey(shopName)) {
                shops.get(shopName).put(product, price);

            } else {
                shops.put(shopName, new LinkedHashMap<String, Double>());
                shops.get(shopName).put(product, price);
            }
        }

        shops.forEach((k, v) -> {
            System.out.printf("%s->%n", k);
            v.forEach((k1, v2) -> System.out.printf("Product: %s, Price: %.1f%n", k1, v2));
        });
    }
}
