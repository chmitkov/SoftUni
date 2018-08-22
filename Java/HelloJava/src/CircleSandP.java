import java.util.Scanner;

public class CircleSandP {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner (System.in);

        double r = Double.parseDouble(scanner.nextLine());
        double s = Math.PI * r * r;
        double p = 2 * Math.PI * r;

        System.out.printf("Area = %f"+"%n"+"Perimeter = %f", s, p);
    }
}
