import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class _2KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] names = br.readLine().split("\\s+");
        Consumer<String[]> printArr =
                arr -> Arrays.stream(arr).forEach(
                        x-> System.out.printf("Sir %s%n",x));
        printArr.accept(names);
    }
}
