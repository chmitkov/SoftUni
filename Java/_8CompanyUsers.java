import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class _8CompanyUsers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, LinkedHashSet<String>> map = new TreeMap<>();

        String input = br.readLine();

        while (!input.equals("End")) {
            String [] commands = input.split(" -> ");
            String company = commands[0];
            String employeeId = commands[1];

            if (!map.containsKey(company)){
                map.put(company,new LinkedHashSet<>());
            }

            map.get(company).add(employeeId);

            input = br.readLine();
        }

        map.entrySet().stream().forEach(entry->{
            System.out.printf("%s%n",entry.getKey());
            entry.getValue().forEach(x->{
                System.out.printf("-- %s%n", x);
            });
        });
    }
}
