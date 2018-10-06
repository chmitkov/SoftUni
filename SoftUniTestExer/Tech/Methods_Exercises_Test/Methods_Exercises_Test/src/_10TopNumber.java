import java.util.Scanner;

public class _10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        giveAllTopNumber(number);

    }

    private static void giveAllTopNumber(int number) {
        for (int i = 1; i <= number; i++) {
            isTopNumber(i);
        }
    }

    private static void isTopNumber(int num) {
        if(isSumOfDigit(num) && isOneDigitIsOdd(num)){
            System.out.println(num);
        }
    }

    private static boolean isSumOfDigit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum % 8 == 0;
    }

    private static boolean isOneDigitIsOdd(int num) {
        while (num > 0) {
            int currentNum = num % 10;
            if (currentNum % 2 != 0) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}
