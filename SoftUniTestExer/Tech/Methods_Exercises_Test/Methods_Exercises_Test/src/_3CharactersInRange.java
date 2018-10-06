import java.util.Scanner;

public class _3CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);

        giveMiddleChars(first, second);
    }

    private static void giveMiddleChars(char first, char second) {
        for (int i = Math.min(first, second) + 1; i < Math.max(first, second); i++) {
            System.out.printf("%c ", i);
        }
    }
}
