import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class p03_CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> func =
                arr -> {
                    int min = Integer.MAX_VALUE;
                    for (int num : arr) {
                        if (num < min) {
                            min = num;
                        }
                    }
                    return min;
                };

        System.out.println(func.apply(numbers));
    }
}
