import java.util.Scanner;

public class ExamMarch2017_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine()),
                p1 = 0,
                p2 = 0,
                p3 = 0;

        for (int i = 0; i < numbers; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (num % 3 == 0) {
                p2 += 1;
            }
            if (num % 4 == 0) {
                p3 += 1;
            }
            if (num % 2 == 0) {
                p1 += 1;
            }
        }
        double p1percent = (p1 * 1.0 / numbers) * 100;
        double p2percent = (p2 * 1.0 / numbers) * 100;
        double p3percent = (p3 * 1.0 / numbers) * 100;

        System.out.printf("%.2f%%\n%.2f%%\n%.2f%%", p1percent, p2percent, p3percent);
    }
}