import java.util.Scanner;

public class Exam2018January07_3Aquapark {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine().toLowerCase();
        double hours = Double.parseDouble(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());
        String d = scanner.nextLine().toLowerCase();
        double total = 0.0,
                pricePerPerson = 0.0;

        if ("march".equals(month) || "april".equals(month) || "may".equals(month)) {
            if ("day".equals(d)) {
                pricePerPerson = hours * 10.5;
                if (hours >= 5) {
                    pricePerPerson = pricePerPerson * 1.0 / 2.0;
                }
                if (people >= 4) {
                    pricePerPerson = pricePerPerson - (pricePerPerson * 0.1);
                }
            } else {
                pricePerPerson = hours * 8.4;
                if (hours >= 5) {
                    pricePerPerson = pricePerPerson * 1.0 / 2.0;
                }
                if (people >= 4) {
                    pricePerPerson = pricePerPerson - (pricePerPerson * 0.1);
                }
            }
            total = pricePerPerson * people;
        } else if ("june".equals(month) || "july".equals(month) || "august".equals(month)) {
            if ("day".equals(d)) {
                pricePerPerson = hours * 12.6;
                if (hours >= 5) {
                    pricePerPerson = pricePerPerson * 1.0 / 2.0;
                }if (people >= 4) {
                    pricePerPerson = pricePerPerson - (pricePerPerson * 0.1);
                }
            } else {
                pricePerPerson = hours * 10.2;
                if (hours >= 5) {
                    pricePerPerson = pricePerPerson * 1.0 / 2.0;
                }
                if (people >= 4) {
                    pricePerPerson = pricePerPerson - (pricePerPerson * 0.1);
                }
            }
            total = pricePerPerson * people;
        }
        System.out.printf("Price per person for one hour: %.2f\n" +
                "Total cost of the visit: %.2f", pricePerPerson / hours, total);
    }
}

