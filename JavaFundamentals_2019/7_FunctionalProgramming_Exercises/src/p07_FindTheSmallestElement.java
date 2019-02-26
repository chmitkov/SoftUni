import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class p07_FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Consumer<int[]> func =
                arr -> {
                    int minIndex = 0;
                    int minValue = Integer.MAX_VALUE;
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] <= minValue) {
                            minValue = arr[i];
                            minIndex = i;
                        }
                    }
                    System.out.println(minIndex);
                };

        func.accept(numbers);
    }
}
