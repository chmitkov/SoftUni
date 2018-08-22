import java.util.Scanner;

public class Exam2017September17_4GrandpaStavri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double liter = 0.0,
                deg = 0.0;

        for (int i = 0; i < days; i++) {
            double rakia = Double.parseDouble(scanner.nextLine()),
                    degreese = Double.parseDouble(scanner.nextLine());

            liter += rakia;
            deg += degreese * rakia;

        }
        deg = deg * 1.0 / liter;
        System.out.printf("Liter: %.2f\nDegrees: %.2f\n", liter, deg);

        if (deg < 38) {
            System.out.println("Not good, you should baking!");
        } else if (deg < 42) {
            System.out.println("Super!");
        } else {
            System.out.println("Dilution with distilled water!");
        }
    }
}