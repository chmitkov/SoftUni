import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class p09_ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int borderNumber = Integer.parseInt(br.readLine());

        int[] numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        BiPredicate<Integer, int[]> func = (num, arr) -> {
            for (int i : arr) {
                if (num % i != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= borderNumber; i++) {
            if (func.test(i, numbers)) {
                System.out.printf("%s ", i);
            }
        }
    }
}
