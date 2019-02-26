import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class p04_AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        Function<int[], int[]> add = arr -> Arrays.stream(arr).map(e -> ++e).toArray();
        UnaryOperator<int[]> sub = arr -> Arrays.stream(arr).map(e -> --e).toArray();
        UnaryOperator<int[]> multiply = arr -> Arrays.stream(arr).map(e -> e *= 2).toArray();
        Consumer<int[]> print = arr -> Arrays.stream(arr).forEach(x-> System.out.println(x+" "));

                String line;

        while (!"end".equalsIgnoreCase(line = br.readLine())) {
            switch (line) {
                case "add":
                    nums = add.apply(nums);
                    break;
                case "multiply":
                    nums = multiply.apply(nums);
                    break;
                case "subtract":
                    nums = sub.apply(nums);
                    break;
                case "print":
                    print.accept(nums);
                    System.out.println();
                    break;
            }
        }
    }
}
