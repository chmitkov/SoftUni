import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017March19Morning_03Vacantion {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(
                System.in));

        double budget = Double.parseDouble(b.readLine()),
                money = 0.0;
        String season = b.readLine().toLowerCase(),
                type = "",
                location = "";


        switch (season) {
            case "summer":
                if (budget <= 1000) {
                    type = "Camp";
                    location = "Alaska";
                    money = budget * 0.65;
                } else if (budget <= 3000) {
                    type = "Hut";
                    location = "Alaska";
                    money = budget * 0.80;
                } else {
                    type = "Hotel";
                    location = "Alaska";
                    money = budget * 0.90;
                }
                break;
            case "winter":
                if (budget <= 1000) {
                    type = "Camp";
                    location = "Morocco";
                    money = budget * 0.45;
                } else if (budget <= 3000) {
                    type = "Hut";
                    location = "Morocco";
                    money = budget * 0.60;
                } else {
                    type = "Hotel";
                    location = "Morocco";
                    money = budget * 0.90;
                }
                break;

        }
        System.out.printf("%s - %s - %.2f", location, type, money);
    }
}