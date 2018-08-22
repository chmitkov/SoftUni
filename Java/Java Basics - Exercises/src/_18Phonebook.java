import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _18Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> dict = new HashMap<>();
        String input = br.readLine();

        while (!input.equals("END")) {
            String[] commands = input.split(" ");

            String action = commands[0];
            String name = commands[1];
            switch (action) {
                case "A":
                    String phone = commands[2];
                    dict.put(name, phone);
                    break;
                case "S":
                    if (dict.containsKey(name)) {
                        System.out.printf("%s -> %s%n",name,dict.get(name));
                    } else {
                        System.out.printf("Contact %s does not exist.%n",name);
                    }
                    break;
            }
            input = br.readLine();
        }
    }
}
