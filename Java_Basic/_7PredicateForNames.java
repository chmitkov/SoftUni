import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class _7PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BiPredicate<Integer, Integer> predicate = (num, element) -> element <= num;

        int number = Integer.parseInt(br.readLine());

        String [] names = br.readLine().split(" ");

        Arrays.stream(names).forEach(x-> {
            if (predicate.test(number,x.length()))
                System.out.println(x);
        });
    }
}
