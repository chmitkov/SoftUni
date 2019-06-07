import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class _05OddandEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int counter = 0;
        if (array.length % 2 != 0) {
            System.out.println("invalid length");
            return;
        }
        while (counter < array.length) {
            int num1 = array[counter];
            counter++;
            int num2 = array[counter];
            counter++;
            if (num1 % 2 == 0 && num2 % 2 == 0) {
                System.out.printf("%d, %d -> both are even\n",num1,num2);
            } else if (num1 % 2 != 0 && num2 % 2 != 0) {
                System.out.printf("%d, %d -> both are odd\n",num1,num2);
            } else {
                System.out.printf("%d, %d -> different\n",num1,num2);
            }
        }
    }
}
