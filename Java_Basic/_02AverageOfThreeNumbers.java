import java.util.Scanner;

public class _02AverageOfThreeNumbers {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        double first = scanner.nextDouble();
        double second = scanner.nextDouble();
        double third = scanner.nextDouble();

        System.out.printf("%.2f",(first+second+third)/3);
    }
}
