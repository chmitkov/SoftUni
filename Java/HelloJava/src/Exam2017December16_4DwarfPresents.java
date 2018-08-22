import java.util.Scanner;

public class Exam2017December16_4DwarfPresents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dwarf = Integer.parseInt(scanner.nextLine()),
                money = Integer.parseInt(scanner.nextLine());
        double total = 0.0;

        for (int i = 0; i < dwarf; i++) {
            String present = scanner.nextLine().toLowerCase();

            switch (present) {
                case "sand clock":
                    total += 2.20;
                    break;
                case "magnet":
                    total += 1.50;
                    break;
                case "cup":
                    total += 5.00;
                    break;
                case "t-shirt":
                    total += 10.00;
            }
        }
        if (money >= total) {
            System.out.printf("Santa Claus has %.2f more leva left!", (money - total));
        } else {
            System.out.printf("Santa Claus will need %.2f more leva.", (total - money));
        }
    }
}