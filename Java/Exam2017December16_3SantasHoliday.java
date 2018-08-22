import java.util.Scanner;

public class Exam2017December16_3SantasHoliday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String room = scanner.nextLine().toLowerCase(),
                mark = scanner.nextLine().toLowerCase();
        double totalForNight = 0.0,
                total = 0.0;


        switch (room) {
            case "room for one person":
                totalForNight = 18.00;
                total = totalForNight * (days-1);
                break;
            case "apartment":
                if (days < 10) {
                    totalForNight = 25.00;
                    total = totalForNight * (days-1);
                    total = total - (total * 0.3);
                } else if (days < 15) {
                    totalForNight = 25.00;
                    total = totalForNight * (days-1);
                    total = total - (total * 0.35);
                } else {
                    totalForNight = 25.00;
                    total = totalForNight * (days-1);
                    total = total - (total * 0.5);
                }
                break;
            case "president apartment":
                if (days < 10) {
                    totalForNight = 35.00;
                    total = totalForNight * (days-1);
                    total = total - (total * 0.1);
                } else if (days < 15) {
                    totalForNight = 35.00;
                    total = totalForNight * (days-1);
                    total = total - (total * 0.15);
                } else {
                    totalForNight = 35.00;
                    total = totalForNight * (days-1);
                    total =total- (total * 0.20);
                }
                break;
        }

        if ("positive".equals(mark)) {
            total = total + (total * 0.25);
        } else {
            total = total - (total * 0.1);
        }

        System.out.printf("%.2f", total);
    }
}