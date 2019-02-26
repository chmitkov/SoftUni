import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

public class p06_PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());

        String[] names = br.readLine().split("\\s+");

        BiPredicate<Integer, String> func =
                (num, name) ->
                        num >= name.length();

        for (String name : names) {
            if (func.test(length, name)) {
                System.out.println(name);
            }
        }

    }
}
