import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class p02_SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new TreeSet<>();

        String line;

        while (!"PARTY".equals(line = br.readLine())) {
            set.add(line);
        }

        String command;

        while (!"END".equals(command = br.readLine())){
            set.remove(command);
        }

        System.out.println(set.size());
        set.forEach(System.out::println);
    }
}
