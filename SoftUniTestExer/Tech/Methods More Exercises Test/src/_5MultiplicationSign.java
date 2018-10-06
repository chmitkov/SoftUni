import java.util.Scanner;

public class _5MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        printMultiplicationSign(firstNum, secondNum, thirdNum);
    }

    private static void printMultiplicationSign(int firstNum, int secondNum, int thirdNum) {
        int countOfNegative = 0;
        boolean isThereZero = false;
        if (firstNum < 0) {
            countOfNegative++;
        }
        if (secondNum < 0) {
            countOfNegative++;
        }
        if (thirdNum < 0) {
            countOfNegative++;
        }
        if (firstNum == 0 || secondNum == 0 || thirdNum == 0) {
            isThereZero = true;
        }

        if (isThereZero) {
            System.out.println("zero");
        } else {
            System.out.println(countOfNegative % 2 == 0 ? "positive" : "negative");
        }

    }
}
