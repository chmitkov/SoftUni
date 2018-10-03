import java.util.Arrays;
import java.util.Scanner;

public class _6EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rightSum = Arrays.stream(numbers).sum() - numbers[0];
        int leftSum = 0;
        int index = -1;
        if (numbers.length == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 1; i < numbers.length; i++) {
            rightSum -= numbers[i];
            leftSum += numbers[i - 1];
            if (leftSum == rightSum) {
                index = i;
            }
        }
        System.out.println(index == -1 ? "no" : index );
    }
}
