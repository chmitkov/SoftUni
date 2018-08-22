import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        while (n > 0) {
            total += n % 10;
            n /= 10;
        }
        System.out.println(total);
    }
}
