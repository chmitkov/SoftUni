import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017March19Evening_06ControlNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        int m = Integer.parseInt(b.readLine());
        int control = Integer.parseInt(b.readLine());
        int sum = 0;
        int count = 0;
        boolean yes = false;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j > 0; j--) {
                sum += i * 2 + j * 3;
                count++;
                if (sum >= control) {
                    yes = true;
                    break;

                }
            }
        }
        if (yes) {
            System.out.printf("%d moves\nScore: %d >= %d", count, sum, control);
        } else {
            System.out.printf("%d moves", count);
        }
    }
}
