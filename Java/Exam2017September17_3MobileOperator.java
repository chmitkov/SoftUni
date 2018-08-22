import java.util.Scanner;

public class Exam2017September17_3MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String years = scanner.nextLine().toLowerCase(),
                type = scanner.nextLine().toLowerCase(),
                internet = scanner.nextLine().toLowerCase();
        int months = Integer.parseInt(scanner.nextLine());
        double total = 0.0;


        if ("one".equals(years)) {
            switch (type) {
                case "small":
                    total = 9.98;
                    break;
                case "middle":
                    total = 18.99;
                    break;
                case "large":
                    total = 25.98;
                    break;
                case "extralarge":
                    total = 35.99;
                    break;
            }
        } else {
            switch (type) {
                case "small":
                    total = 8.58;
                    break;
                case "middle":
                    total = 17.09;
                    break;
                case "large":
                    total = 23.59;
                    break;
                case "extralarge":
                    total = 31.79;
                    break;
            }
        }
        if ("yes".equals(internet)) {
            if (total <= 10.00) {
                total += 5.5;
            } else if (total <= 30.00) {
                total += 4.35;
            } else {
                total += 3.85;
            }
        }
        if ("two".equals(years)) {
            total = total - (total * 0.0375);
        }
        total = total * months;

        System.out.printf("%.2f lv.", total);
    }
}








