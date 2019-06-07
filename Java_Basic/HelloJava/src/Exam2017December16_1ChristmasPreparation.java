import java.util.Scanner;

public class Exam2017December16_1ChristmasPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int paperRolls = Integer.parseInt(scanner.nextLine());
        int fabricRolls = Integer.parseInt(scanner.nextLine());
        double glue = Double.parseDouble(scanner.nextLine());
        int cutPercent = Integer.parseInt(scanner.nextLine());

        double total = (paperRolls * 5.8 + fabricRolls * 7.2 + glue * 1.2),
                cut = total * (0.01 * cutPercent);
        System.out.printf("%.3f", (total - cut));

    }

}