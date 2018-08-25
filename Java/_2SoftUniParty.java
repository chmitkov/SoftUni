import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class _2SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> guests = new TreeSet<>();
        String input = br.readLine();

        while (!"PARTY".equals(input)) {
            guests.add(input);
            input = br.readLine();
        }

        String input2 = br.readLine();

        while (!"END".equals(input2)) {

            guests.remove(input2);
            input2 = br.readLine();
        }
        if(!guests.isEmpty()){
            System.out.println(guests.size());
            guests.forEach(System.out::println);
        }
    }
}
