import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _5TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];
            if (i == numbers.length - 1) {
                if (currentNum > 0) {
                    System.out.printf("%d",numbers[i]);
                    break;
                }
            }
            boolean isBigger = true;
            for (int j = i + 1; j <numbers.length; j++) {
                if (currentNum <= numbers[j]){
                    isBigger = false;
                }
            }
            if (isBigger){
                System.out.printf("%d ",numbers[i]);
            }
        }
    }
}
