import java.util.Scanner;

public class Exam2017December17_2NewYearsParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guestNum = Integer.parseInt(scanner.nextLine()),
                budget = Integer.parseInt(scanner.nextLine());

        double couvert = guestNum * 20;
        double forFire = (budget - couvert) * 0.4;
        double moreFromI = couvert - budget;

        if (budget > couvert) {
            System.out.printf("Yes! %d lv are for fireworks and %d lv are for donation.", Math.round(forFire), Math.round(budget - couvert - forFire));
        } else {
            System.out.printf("They won't have enough money to pay the covert. They will need %d lv more.", Math.round(moreFromI));
        }
    }
}
