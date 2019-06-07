import java.util.Scanner;

public class Exam2017May07_04FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        int fens = Integer.parseInt(scanner.nextLine());

        double a = 0.0, b = 0.0, v = 0.0, g = 0.0;

        for (int i = 0; i < fens; i++) {
            String sector = scanner.nextLine().toLowerCase();
            if ("a".equals(sector)) {
                a += 1;
            } else if ("b".equals(sector)) {
                b += 1;
            } else if ("v".equals(sector)) {
                v += 1;
            } else {
                g += 1;
            }
        }

        System.out.printf("%.2f%%\n", a / fens * 1.0 * 100);
        System.out.printf("%.2f%%\n", b / fens * 1.0 * 100);
        System.out.printf("%.2f%%\n", v / fens * 1.0 * 100);
        System.out.printf("%.2f%%\n", g / fens * 1.0 * 100);
        System.out.printf("%.2f%%\n", (a + b + v + g) / capacity * 100);
    }
}