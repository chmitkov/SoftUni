import java.util.Scanner;

public class TriangleS {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double side = Double.parseDouble(scanner.nextLine()),
                h = Double.parseDouble(scanner.nextLine()),
                s = (side * h)/2;

        System.out.printf("Triangle area = %.2f",s);
    }
}
