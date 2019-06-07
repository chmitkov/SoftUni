import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class _7FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> dict = new LinkedHashMap<>();
        String input = br.readLine();

        while (!"stop".equals(input)) {
            String name = input;

            String mail = br.readLine();
            if (!mail.endsWith("us") &&
                    !mail.endsWith("uk") &&
                   !mail.endsWith("com")){
                dict.put(name,mail);
            }
                input = br.readLine();
        }
        dict.entrySet().forEach(x-> System.out.printf("%s -> %s%n",x.getKey(),x.getValue()));
    }
}
