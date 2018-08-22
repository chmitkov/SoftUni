import java.util.Scanner;

public class Exam2017July23_01DanceHall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double l = Double.parseDouble(scanner.nextLine());
        double w = Double.parseDouble(scanner.nextLine());
        double a = Double.parseDouble(scanner.nextLine());

        double hall = (l * 100) * (w * 100);
        double cube = (a * 100) * (a * 100);
        double dancer = 7040;
        double bench = hall / 10;

        System.out.printf("%.0f", Math.floor((hall - cube - bench) / dancer));
    }
}