import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017March19Evening_02Styrofoam {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        double budget = Double.parseDouble(b.readLine());
        double houseS = Double.parseDouble(b.readLine());
        int windows = Integer.parseInt(b.readLine());
        double styrInPack = Double.parseDouble(b.readLine());
        double packPrice = Double.parseDouble(b.readLine());

        houseS = houseS - windows * 2.4;
        houseS += houseS * 0.1;
        double packNeed = Math.ceil(houseS / styrInPack);
        double moneyNeed = packNeed * packPrice;

        if (budget >= moneyNeed) {
            System.out.printf("Spent: %.2f\nLeft: %.2f"
                    , moneyNeed, budget - moneyNeed);
        } else {
            System.out.printf("Need more: %.2f", moneyNeed - budget);
        }
    }
}