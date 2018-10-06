import java.util.Scanner;

public class _6MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        System.out.println(str.length() % 2 != 0
                ? str.charAt(str.length() / 2)
                : String.format("%c%c", str.charAt(str.length() / 2 - 1),
                str.charAt(str.length() / 2)));
    }
}
