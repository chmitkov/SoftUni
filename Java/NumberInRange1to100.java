import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberInRange1to100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Еnter a number in the range [1...100]:");
        //int n = Integer.parseInt(br.readLine());

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n > 100 || n < 1) {
                System.out.println("Invalid number!");
                continue;
            } else {
                System.out.printf("The number is: %d", n);
                break;
            }
        }

    }
}