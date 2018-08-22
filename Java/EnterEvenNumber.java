import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        while (true) {
            try {
                int n = Integer.parseInt(br.readLine());
                if (n % 2 == 0) {
                    System.out.printf("Even number entered: %d", n);
                    break;
                }
                System.out.println("The number is not even.");
            } catch (NumberFormatException numberException) {
                System.out.println("Invalid number!");
            }

        }
    }
}