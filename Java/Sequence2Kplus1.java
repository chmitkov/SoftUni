import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sequence2Kplus1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int num = 0;
        for (int i = 0; i < n; i++) {
            num = num * 2 + 1;
            if (num > n) {
                break;
            }
            System.out.println(num);

        }

    }
}