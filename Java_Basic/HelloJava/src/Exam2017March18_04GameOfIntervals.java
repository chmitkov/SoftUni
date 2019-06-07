import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017March18_04GameOfIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(b.readLine()),
                to9 = 0,
                to19 = 0,
                to29 = 0,
                to39 = 0,
                to50 = 0,
                invalid = 0;
        double result = 0;

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(b.readLine());
            if (m < 0 || m > 50) {
                result = (result * 1.0) / 2;
                invalid++;
            } else if (m < 10) {
                result += m * 0.2;
                to9++;
            } else if (m < 20) {
                result += m * 0.3;
                to19++;
            } else if (m < 30) {
                result += m * 0.4;
                to29++;
            } else if (m < 40) {
                result += 50;
                to39++;
            } else if (m <= 50) {
                result += 100;
                to50++;

            }
        }
        double to9percent = (to9 * 1.0 / n) * 100,
                to19percent = (to19 * 1.0 / n) * 100,
                to29percent = (to29 * 1.0 / n) * 100,
                to39percent = (to39 * 1.0 / n) * 100,
                to50percent = (to50 * 1.0 / n) * 100,
                invalidPercent = (invalid * 1.0 / n) * 100;
        System.out.printf("%.2f\nFrom 0 to 9: %.2f%%\nFrom 10 to 19: %.2f%%\nFrom 20 to 29: %.2f%%"
                        + "\nFrom 30 to 39: %.2f%%\nFrom 40 to 50: %.2f%%\nInvalid numbers: %.2f%%"
                , result, to9percent, to19percent, to29percent, to39percent, to50percent, invalidPercent);
    }
}