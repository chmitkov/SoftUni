import java.io.InputStreamReader;
import java.util.Scanner;

public class _01RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        System.out.printf("%.2f",a*b);
    }
}
