import java.util.Arrays;
import java.util.Scanner;

public class _7MaxSequenceofEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxCount = 1;
        int currentCount = 1;
        int lastIndex = 0;
        int bestIndex = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                currentCount++;
                lastIndex = i + 1;
            } else {
                currentCount = 1;
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                bestIndex = lastIndex;
            }
        }
        for (int i = bestIndex - maxCount + 1; i <= bestIndex; i++) {
            System.out.printf("%d ", numbers[i]);
        }
    }
}
