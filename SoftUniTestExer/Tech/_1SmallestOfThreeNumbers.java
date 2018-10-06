import java.util.Scanner;

public class _1SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(findSmallestNumber(firstNumber, secondNumber, thirdNumber));
    }

    private static int findSmallestNumber(int firstNumber, int secondNumber, int thirdNumber) {
        return Math.min(Math.min(firstNumber, secondNumber), thirdNumber);
    }
}
