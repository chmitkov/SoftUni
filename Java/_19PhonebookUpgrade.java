import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _19PhonebookUpgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, String> dict = new TreeMap<>();
        String input = br.readLine();

        while (!input.equals("END")) {
            String[] commands = input.split(" ");

            String action = commands[0];

            switch (action) {
                case "A":
                    String phone = commands[2];
                    String name = commands[1];
                    dict.put(name, phone);
                    break;
                case "S":
                    String name1 = commands[1];
                    if (dict.containsKey(name1)) {
                        System.out.printf("%s -> %s%n", name1, dict.get(name1));
                    } else {
                        System.out.printf("Contact %s does not exist.%n", name1);
                    }
                    break;
                case "ListAll":
                    dict.forEach((k,v)-> System.out.printf("%s -> %s%n",k,v));
                break;

            }
            input = br.readLine();
        }
    }
}


