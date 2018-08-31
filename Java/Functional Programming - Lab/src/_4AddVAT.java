import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _4AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double[] numbers = Arrays.stream(br.readLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Consumer<double[]> addVatToPrice = arr -> {
            Arrays.stream(arr).forEach(x-> System.out.printf("%.2f%n",x*1.2));
        } ;
        System.out.println("Prices with VAT:");
        addVatToPrice.accept(numbers);

    }
}
