import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017March19Morning_02Cups {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(
                System.in));

        int cupsNeed = Integer.parseInt(b.readLine()),
                workers = Integer.parseInt(b.readLine()),
                days = Integer.parseInt(b.readLine());

        double cups = Math.floor(((workers * days * 8) * 1.0) / 5.0);
        // money = cup*4.2;
        if (cups >= cupsNeed) {
            System.out.printf("%.2f extra money",
                    (cups - cupsNeed) * 4.2);
        } else {
            System.out.printf("Losses: %.2f",
                    (cupsNeed - cups) * 4.2);
        }
    }
}
