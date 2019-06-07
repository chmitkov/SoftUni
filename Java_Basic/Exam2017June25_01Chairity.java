import java.util.Scanner;

public class Exam2017June25_01Chairity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine()),
                bakers = Integer.parseInt(scanner.nextLine()),
                cakes = Integer.parseInt(scanner.nextLine()),
                waffles = Integer.parseInt(scanner.nextLine()),
                pancakes = Integer.parseInt(scanner.nextLine());

        double total = days * (bakers * (cakes * 45 + waffles * 5.80
                + pancakes * 3.2));
        total -= total * 0.125;
        System.out.printf("%.2f", total);
    }
}