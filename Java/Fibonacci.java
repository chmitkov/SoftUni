import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int num0 = 1, num1 = 1;
        int next = 0;
        if (n < 2) {
            System.out.println(num1);
        } else {

            for (int i = 0; i < n - 1; i++) {
                next = num0 + num1;
                num0 = num1;
                num1 = next;
            }
            System.out.println(next);
        }


    }
}