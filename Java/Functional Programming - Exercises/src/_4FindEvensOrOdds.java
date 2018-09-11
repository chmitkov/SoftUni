import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class _4FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String condition = br.readLine();

        BiPredicate<String, Integer> predicate = (cond, num) -> {
            if ("odd".equals(cond)) {
                return num % 2 != 0;
            } else {
                return num % 2 == 0;
            }
        };

        for (int i = numbers[0]; i <= numbers[1]; i++) {
            if (predicate.test(condition,i))
                System.out.print(i+" ");
        }
    }

}
