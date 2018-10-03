import java.util.Arrays;
import java.util.Scanner;

public class _3ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        String [] secondArray = new String[length];
        String [] firstArray = new String[length];

        for (int i = 0; i < length; i++) {
            String [] currentNumbers = scanner.nextLine().split(" ");

            if (i % 2 == 0) {
                firstArray[i] = currentNumbers[0];
                secondArray[i] = currentNumbers[1];
            } else {
                firstArray[i] = currentNumbers[1];
                secondArray[i] = currentNumbers[0];
            }
        }

        System.out.println(String.join(" ",firstArray));
        System.out.println(String.join(" ",secondArray));



    }
}
