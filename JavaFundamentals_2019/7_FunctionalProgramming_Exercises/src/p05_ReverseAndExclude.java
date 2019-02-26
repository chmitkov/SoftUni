import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class p05_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int number = Integer.parseInt(br.readLine());

        BiConsumer<int[], Integer> func =
                (numbers, num) -> {
                    for (int i = numbers.length - 1; i >= 0; i--) {
                        if (numbers[i] % num != 0) {
                            System.out.print(numbers[i] + " ");
                        }
                    }
                };

        func.accept(nums, number);
    }
}
