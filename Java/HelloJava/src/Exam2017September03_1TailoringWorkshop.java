import java.util.Scanner;

public class Exam2017September03_1TailoringWorkshop {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        int tables = Integer.parseInt(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine()),
                width = Double.parseDouble(scanner.nextLine());

        double rectangle = 0.0,
                diamond = 0.0,
                total = 0.0;

        rectangle = tables * ((length + 0.6) * (width + 0.6));
        diamond = tables * ((length * 1.0 / 2.0) * (length * 1.0 / 2.0));
        rectangle = rectangle * 7;
        diamond = diamond * 9;
        total = rectangle + diamond;


        System.out.printf("%.2f USD\n%.2f BGN", total, (total * 1.85));
    }
}