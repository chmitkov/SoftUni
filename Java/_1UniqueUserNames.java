import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class _1UniqueUserNames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> names = new LinkedHashSet<>();
        int counter = Integer.parseInt(br.readLine());

        while (counter-->0){
            names.add(br.readLine());
        }
        names.forEach(System.out::println);
    }
}
