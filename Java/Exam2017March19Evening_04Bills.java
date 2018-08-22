import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017March19Evening_04Bills {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        int months = Integer.parseInt(b.readLine());
        double electrycity = 0.0,
                other = 0.0,
                water = 20 * months,
                internet = 15 * months;
        for (int i = 0; i < months; i++) {
            double elBill = Double.parseDouble(b.readLine());
            electrycity += elBill;
            other += ((elBill + 35) + (elBill + 35) * 0.2);
        }

        double average = (electrycity + water + internet + other) / months;

        System.out.printf("Electricity: %.2f lv\nWater: %.2f lv\nInternet: %.2f lv\nOther: %.2f lv\nAverage: %.2f lv", electrycity, water, internet, other, average);

    }
}