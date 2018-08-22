import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017March18_03CarToGo {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        double budget = Double.parseDouble(b.readLine()),
                total = 0.0;
        String season = b.readLine().toLowerCase(),
                car = "",
                type = "";

        if (budget > 500) {
            car = "Jeep";
            type = "Luxury class";
            total = budget * 0.9;
        } else {
            switch (season) {
                case "summer":
                    car = "Cabrio";
                    if (budget <= 100) {
                        type = "Economy class";
                        total = budget * 0.35;
                    } else if (budget <= 500) {
                        type = "Compact class";
                        total = budget * 0.45;
                    }
                    break;
                case "winter":
                    car = "Jeep";
                    if (budget <= 100) {
                        type = "Economy class";
                        total = budget * 0.65;
                    } else if (budget <= 500) {
                        type = "Compact class";
                        total = budget * 0.80;
                    }
                    break;
            }
        }
        System.out.printf("%s\n%s - %.2f", type, car, total);
    }
}