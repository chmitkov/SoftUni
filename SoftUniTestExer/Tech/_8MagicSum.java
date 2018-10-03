import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class _8MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int givenNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length - 1; i++) {
           int firstNum = numbers[i];
            for (int j = i+1; j < numbers.length ; j++) {
                if (givenNum == (firstNum + numbers[j])) {
                    System.out.printf("%d %d%n", firstNum, numbers[j]);
                }
            }
        }
    }
}
