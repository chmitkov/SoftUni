
import java.util.Scanner;

public class Exam2017December17_3IvanovisHoliday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nightCount = Integer.parseInt(scanner.nextLine());
        String place = scanner.nextLine().toLowerCase(),
                transport = scanner.nextLine().toLowerCase();
        double total = 0.0,
                tran = 0.0;

        switch (place) {
            case "miami":
                if (nightCount <= 10) {
                    total = (2 * 24.99 + 3 * 14.99) * nightCount;
                    total = total + (total * 0.25);
                } else if (nightCount <= 15) {
                    total = (2 * 22.99 + 3 * 11.99) * nightCount;
                    total = total + (total * 0.25);
                } else {
                    total = (2 * 20.00 + 3 * 10.00) * nightCount;
                    total = total + (total * 0.25);
                }
                break;
            case "canary islands":
                if (nightCount <= 10) {
                    total = (2 * 32.50 + 3 * 28.50) * nightCount;
                    total = total + (total * 0.25);
                } else if (nightCount <= 15) {
                    total = (2 * 30.50 + 3 * 25.60) * nightCount;
                    total = total + (total * 0.25);
                } else {
                    total = (2 * 28.00 + 3 * 22.00) * nightCount;
                    total = total + (total * 0.25);
                }
                break;
            case "philippines":
                if (nightCount <= 10) {
                    total = (2 * 42.99 + 3 * 39.99) * nightCount;
                    total = total + (total * 0.25);
                } else if (nightCount <= 15) {
                    total = (2 * 41.99 + 3 * 36.99) * nightCount;
                    total = total + (total * 0.25);
                } else {
                    total = (2 * 38.50 + 3 * 32.40) * nightCount;
                    total = total + (total * 0.25);
                }
                break;
        }

        //total=+(total*0.25);// for Dog !

        switch (transport) {
            case "train":
                tran = 2 * 22.30 + 3 * 12.50;
                break;
            case "bus":
                tran = 2 * 45.00 + 3 * 37.00;
                break;
            case "airplane":
                tran = 2 * 90.00 + 3 * 68.50;
                break;
        }
        System.out.printf("%.3f", (total + tran));
    }
}