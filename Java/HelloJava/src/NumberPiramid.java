import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberPiramid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int num = 1;
        while (num <= n) {
            for (int i = 0; i < count; i++) {
                System.out.printf("%d ", num);
                num++;
                if (num > n) {
                    return;
                }
            }

            count++;
            System.out.println();
        }
    }
}
