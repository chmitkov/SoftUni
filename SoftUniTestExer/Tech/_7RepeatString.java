import java.util.Scanner;

public class _7RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int timesToRepeat = Integer.parseInt(scanner.nextLine());

        repeatString(text,timesToRepeat);
    }

    private static void repeatString(String text, int timesToRepeat) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < timesToRepeat; i++) {
            sb.append(text);
        }
        System.out.print(sb);
    }
}
