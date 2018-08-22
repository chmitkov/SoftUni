import java.util.Scanner;

public class Exam2017July23_03FinalCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dancers = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine().toLowerCase(),
                place = scanner.nextLine().toLowerCase();
        double win = 0.0;

        if ("bulgaria".equals(place)) {
            win = dancers * points;
            if ("summer".equals(season)) {
                win -= (win * 0.05);
            } else {
                win -= (win * 0.08);
            }
        } else {
            win = dancers * points + ((dancers * points) * 0.5);
            if ("summer".equals(season)) {
                win -= (win * 0.1);
            } else {
                win -= (win * 0.15);
            }
        }
        double charity = win * 0.75;
        win -= charity;
        System.out.printf("Charity - %.2f\nMoney per dancer - %.2f",
                charity, win / dancers);
    }
}