import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017December17_06MultiplyTable {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(b.readLine()),
                num1 = n % 10,
                num2 = (n / 10) % 10,
                num3 = n / 100;

        for (int i = 1; i <= num1; i++) {
            for (int j = 1; j <= num2; j++) {
                for (int k = 1; k <= num3; k++) {
                    System.out.printf("%d * %d * %d = %d;\n", i, j, k, (i * j * k));
                }
            }
        }
    }
}