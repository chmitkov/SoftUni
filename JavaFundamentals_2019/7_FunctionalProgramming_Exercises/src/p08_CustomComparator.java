import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p08_CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.stream(numbers).filter(x -> x % 2 == 0).sorted().forEach(x -> System.out.printf("%s ", x));
        Arrays.stream(numbers).filter(x -> x % 2 != 0).sorted().forEach(x -> System.out.printf("%s ", x));
    }
}
