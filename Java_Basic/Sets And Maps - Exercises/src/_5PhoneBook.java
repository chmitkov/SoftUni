import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _5PhoneBook {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> dict = new HashMap<>();
        String input = br.readLine();

        while (!"search".equals(input)) {
            String[] commands = input.split("-");
                dict.put(commands[0],commands[1]);
            input = br.readLine();
        }
        String input2 = br.readLine();

        while (!"stop".equals(input2)){
            if (dict.containsKey(input2)){
                System.out.printf("%s -> %s%n",input2,dict.get(input2));
            }else {
                System.out.printf("Contact %s does not exist.%n",input2);
            }
            input2 = br.readLine();
        }
    }
}
