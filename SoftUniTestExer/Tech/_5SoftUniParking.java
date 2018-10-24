import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class _5SoftUniParking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new LinkedHashMap<>();
        int counter = Integer.parseInt(br.readLine());

        while (counter-- > 0) {
            String[] commands = br.readLine().split(" ");
            String action = commands[0];
            String name = commands[1];


            if (action.equals("register")) {
                String plate = commands[2];
                if (map.containsKey(name)) {
                    System.out.printf("ERROR: already registered with plate number %s%n",
                            plate);
                } else {
                    map.put(name, plate);
                    System.out.printf("%s registered %s successfully%n",
                            name, plate);
                }
            } else {
                if (!map.containsKey(name)) {
                    System.out.printf("ERROR: user %s not found%n", name);
                } else {
                    map.remove(name);
                    System.out.printf("%s unregistered successfully%n", name);
                }
            }


        }
        map.entrySet().forEach(x -> System.out.printf("%s => %s%n",
                x.getKey(), x.getValue()));
    }
}
