import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class p01_ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Consumer<String> func = str -> {
            Arrays.stream(input.split("\\s+"))
                    .forEach(System.out::println);
        };

        func.accept(input);
    }
}
