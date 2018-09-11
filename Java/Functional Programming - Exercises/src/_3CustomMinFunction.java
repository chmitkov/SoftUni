import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

public class _3CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> findSmallerNum = x -> {
            int min = Integer.MAX_VALUE;
            for (Integer num : x) {
                min = num < min ? num : min;
            }
            return min;
        };

        System.out.println(findSmallerNum.apply(nums));
    }
}
