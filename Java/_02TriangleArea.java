import java.util.Scanner;

public class _02TriangleArea {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        double sideA = scanner.nextDouble();
        double sideB = scanner.nextDouble();

        System.out.printf("%.2f",(sideA*sideB)/2);

    }
}
