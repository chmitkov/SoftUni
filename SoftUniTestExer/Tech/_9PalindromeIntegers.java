import java.util.Arrays;
import java.util.Scanner;

public class _9PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String first = command;

            isPalindrome(first);

            command = scanner.nextLine();
        }

    }

    private static void isPalindrome(String first) {
        StringBuilder reverse = new StringBuilder(first).reverse();
        System.out.println(first.equals(reverse.toString()));
    }
}
