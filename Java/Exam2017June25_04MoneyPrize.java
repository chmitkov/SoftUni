import java.util.Scanner;

public class Exam2017June25_04MoneyPrize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int parts = Integer.parseInt(scanner.nextLine());
        double moneyForPoint = Double.parseDouble(scanner.nextLine());

        double points = 0.0;

        for (int i = 1; i <= parts; i++) {
            int pointsForEachPart = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                points += pointsForEachPart * 2;
            } else {
                points += pointsForEachPart;
            }
        }
        System.out.printf("The project prize was %.2f lv.", points * moneyForPoint);

    }
}
