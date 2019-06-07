import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017November05_06LuckyNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(b.readLine());
        if (n < 10) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    for (int k = 1; k < n; k++) {
                        for (int m = 1; m < n; m++) {
                            if ((i + j == k + m) && ((i + j) % n == 0)) {
                                System.out.printf("%d%d%d%d ", i, j, k, m);
                            }
                        }
                    }
                }
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    for (int k = 1; k <= 9; k++) {
                        for (int m = 1; m <= 9; m++) {
                            if ((i + j == k + m) && (n % (i + j) == 0)) {
                                System.out.printf("%d%d%d%d ", i, j, k, m);
                            }
                        }
                    }
                }
            }
        }
    }
}