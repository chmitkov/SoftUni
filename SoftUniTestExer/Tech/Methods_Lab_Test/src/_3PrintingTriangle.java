import java.util.Scanner;

public class _3PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printTriangle(Integer.parseInt(scanner.nextLine()));
    }
    private static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void printTriangle(int n) {
        for (int line = 1; line <= n; line++)
            printLine(1, line);

        for (int line = n - 1; line >= 1; line--)
            printLine(1, line);
    }


}
