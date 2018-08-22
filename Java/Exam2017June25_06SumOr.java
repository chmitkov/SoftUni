import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017June25_06SumOr {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(b.readLine());
        int count = 0;

        for (int i = 1; i <= 30; i++) {
            for (int j = 1; j <= 30; j++) {
                for (int k = 1; k <= 30; k++) {
                    if (i + j + k == n && i < j && j < k) {
                        System.out.printf("%d + %d + %d = %d\n", i, j, k, n);
                        count++;
                    }
                    if (i * j * k == n && i > j && j > k) {
                        System.out.printf("%d * %d * %d = %d\n", i, j, k, n);
                        count++;
                    }
                }
            }
        }
        if (count == 0) {
            System.out.print("No!");
        }

    }
}
