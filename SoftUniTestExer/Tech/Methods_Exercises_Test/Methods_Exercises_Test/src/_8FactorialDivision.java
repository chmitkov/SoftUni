import java.util.Scanner;

public class _8FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f", factorial(firstNumber)/secondNumber);

    }

    private static double factorial(int num) {
        double result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
