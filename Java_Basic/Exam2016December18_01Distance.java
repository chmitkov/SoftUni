import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2016December18_01Distance {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        int speed = Integer.parseInt(b.readLine()),
                time1 = Integer.parseInt(b.readLine()),
                time2 = Integer.parseInt(b.readLine()),
                time3 = Integer.parseInt(b.readLine());
        double time1H = time1 * 1.0 / 60,
                time2H = time2 * 1.0 / 60,
                time3H = time3 * 1.0 / 60,
                total = speed * time1H;
        total += (speed + speed * 0.1) * time2H;
        total += ((speed + speed * 0.1) - (speed + speed * 0.1) * 0.05) * time3H;
        System.out.printf("%.2f", total);
    }
}