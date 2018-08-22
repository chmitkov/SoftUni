import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine()),
                sum = 0,
                big = Integer.MIN_VALUE;
        for (int i = 0; i < numbers; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            sum += num;
            if (num > big) {
                big = num;
            }
        }
        if (big == (sum - big)) {
            System.out.printf("Yes\nSum = %d", big);
        } else {
            System.out.printf("No\nDiff = %d", Math.abs((sum - big) - big));
        }
    }
}
