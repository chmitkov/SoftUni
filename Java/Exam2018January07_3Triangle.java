import java.text.DecimalFormat;
import java.util.Scanner;

public class Exam2018January07_3Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine()),
                b = Double.parseDouble(scanner.nextLine()),
                c = Double.parseDouble(scanner.nextLine());
        DecimalFormat decimalFormat = new DecimalFormat("#.#");

        if ((a < b + c) && (b < a + c) && (c < a + b)) {
            if (a != b && a != c) {
                System.out.printf("Triangle with sides %s, %s and %s is scalene.", decimalFormat.format(a), decimalFormat.format(b), decimalFormat.format(c));
            } else if (a == b && a == c) {
                System.out.printf("Triangle with sides %s, %s and %s is equilateral.", decimalFormat.format(a), decimalFormat.format(b), decimalFormat.format(c));
            } else if (a == b ^ a == c ^ b == c) {
                System.out.printf("Triangle with sides %s, %s and %s is isosceles.", decimalFormat.format(a), decimalFormat.format(b), decimalFormat.format(c));
            } else {
                System.out.printf("There is no triangle with sides %s, %s and %s.", decimalFormat.format(a), decimalFormat.format(b), decimalFormat.format(c));
            }
        } else {
            System.out.printf("There is no triangle with sides %s, %s and %s.", decimalFormat.format(a), decimalFormat.format(b), decimalFormat.format(c));
        }
    }
}
