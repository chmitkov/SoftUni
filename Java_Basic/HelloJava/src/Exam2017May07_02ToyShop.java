import java.util.Scanner;

public class Exam2017May07_02ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tripPrice = Double.parseDouble(scanner.nextLine());
        int puzzels = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int bears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        double total = puzzels * 2.6 + dolls * 3 + bears * 4.1 + minions * 8.2
                + trucks * 2;
        if ((puzzels + dolls + bears + minions + trucks) >= 50) {
            total -= total * 0.25;
        }
        total -= total * 0.1;
        if (total >= tripPrice) {
            System.out.printf("Yes! %.2f lv left.", total - tripPrice);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", tripPrice - total);

        }
    }
}