import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017Match19Morning_06TwoNumbersSum {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        int start = Integer.parseInt(b.readLine()),
                end = Integer.parseInt(b.readLine()),
                special = Integer.parseInt(b.readLine()),
                count = 0;
        boolean yes = false;

        for (int i = start; i >= end; i--) {
            for (int j = start; j >= end; j--) {
                count++;
                if (i + j == special) {
                    yes = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)"
                            , count, i, j, special);
                    return;
                }
            }
        }
        if (!yes) {
            System.out.printf("%d combinations - neither equals %d", count, special);
        }
    }
}
