import java.util.Scanner;

public class _5AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        System.out.println(subtractTwoNum(sumTwoNum(first, second), third));
    }

    private static int sumTwoNum(int first, int second) {
        return first + second;
    }

    private static int subtractTwoNum(int first, int second) {
        return first - second;
    }
}
