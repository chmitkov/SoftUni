import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorialOfN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int one = 1;
        for (int i = 1; i <= n; i++) {
            one *= i;
        }
        System.out.println(one);
    }
}