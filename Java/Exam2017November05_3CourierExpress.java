import java.util.Scanner;

public class Exam2017November05_3CourierExpress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double weight = Double.parseDouble(scanner.nextLine());
        String type = scanner.nextLine().toLowerCase();
        int distance = Integer.parseInt(scanner.nextLine());
        double total = 0.0,
                morePerKm = 0.0;

        if ("standard".equals(type)) {
            if (weight < 1) {
                total = distance * 0.03;
            } else if (weight <= 10) {
                total = distance * 0.05;
            } else if (weight <= 40) {
                total = distance * 0.1;
            } else if (weight <= 90) {
                total = distance * 0.15;
            } else {
                total = distance * 0.2;
            }
        } else {
            if (weight < 1) {
                morePerKm = (distance * 0.03) * 0.8;
                total = (distance * 0.03) + (weight * morePerKm);
            } else if (weight <= 10) {
                morePerKm = (distance * 0.05) * 0.4;
                total = (distance * 0.05) + (weight * morePerKm);
            } else if (weight <= 40) {
                morePerKm = (distance * 0.1) * 0.05;
                total = (distance * 0.1) + (weight * morePerKm);
            } else if (weight <= 90) {
                morePerKm = (distance * 0.15) * 0.02;
                total = (distance * 0.15) + (weight * morePerKm);
            } else {
                morePerKm = (distance * 0.2) * 0.01;
                total = (distance * 0.2) + (weight * morePerKm);
            }
        }
        //total=total*1.0/1000;
        System.out.printf("The delivery of your shipment with weight of %.3f kg. would cost %.2f lv.", weight, total);
    }
}