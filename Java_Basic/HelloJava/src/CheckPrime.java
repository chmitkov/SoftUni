import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean IsPrime = true;
        if (n < 2) {
            System.out.println("Not Prime");
            return;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                IsPrime = false;
            }
        }
        if (IsPrime) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }
}