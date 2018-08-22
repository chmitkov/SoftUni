import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2016July17_04BackToThePast {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

        double money = Double.parseDouble(b.readLine());
        int years = Integer.parseInt(b.readLine());

        for (int i = 0; i <= years-1800; i++) {
            if (i % 2 == 0) {
                money -= 12000;
            } else {
                money -= (12000 + 50 * (18+i));
            }
        }
        if (money < 0) {
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(money));
        } else {
            System.out.printf("Yes! He will live a carefree life" +
                    " and will have %.2f dollars left.", money);
        }

    }
}