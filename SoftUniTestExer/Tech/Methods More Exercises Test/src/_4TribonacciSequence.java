import java.util.Scanner;

public class _4TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        printTribonacciNumbers(number);
    }

    private static void printTribonacciNumbers(int number) {
        int firstNum = 1;
        int secondNum = 1;
        int thirdNum = 2;
        for (int i = 1; i <= number; i++) {
            if (i <= 3) {
                if (i == 1) {
                    System.out.print(firstNum + " ");
                } else if (i == 2) {
                    System.out.print(secondNum + " ");
                } else {
                    System.out.print(thirdNum + " ");
                }
            } else {
                int currentNum = firstNum + secondNum + thirdNum;
                firstNum = secondNum;
                secondNum = thirdNum;
                thirdNum = currentNum;
                System.out.print(currentNum + " ");
            }
        }
    }
}
