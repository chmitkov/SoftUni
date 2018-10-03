import java.util.Scanner;

public class _11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int secondNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(calculate(command, firstNumber, secondNumber));
    }

    private static double calculate(String command, int firstNumber, int secondNumber) {
        double result = 0;
        switch (command) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "/":
                result = firstNumber * 1.0 / secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
        }
        return result;
    }
}
