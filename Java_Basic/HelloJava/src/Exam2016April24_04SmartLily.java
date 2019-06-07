import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2016April24_04SmartLily {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int age = Integer.parseInt(br.readLine());
        double washingMachine = Double.parseDouble(br.readLine());
        int toyPrice = Integer.parseInt(br.readLine());
        int total = 0;
        int toys = 0;

        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                total += i * 5;
                total--; //For Brother;
            } else {
                toys++;
            }

        }
        total += toys * toyPrice;
        if (total >= washingMachine) {
            System.out.printf("Yes! %.2f", total - washingMachine);
        } else {
            System.out.printf("No! %.2f", washingMachine - total);
        }
    }
}
