import java.util.Scanner;

public class _2CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        GetPointNearPoint(x1, y1, x2, y2);
    }

    private static void GetPointNearPoint(int x1, int y1, int x2, int y2) {
        double firstDiagonal = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double secondDiagonal = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
        if (firstDiagonal <= secondDiagonal) {
            System.out.printf("(%d, %d)%n", x1, y1);
            ;
        } else {
            System.out.printf("(%d, %d)%n", x2, y2);
        }
    }
}
