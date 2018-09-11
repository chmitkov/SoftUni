import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class _01ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] names = br.readLine().split("\\s+");
        Consumer<String[]> printArr =
                arr -> Arrays.stream(arr).forEach(System.out::println);
        printArr.accept(names);
    }
}
