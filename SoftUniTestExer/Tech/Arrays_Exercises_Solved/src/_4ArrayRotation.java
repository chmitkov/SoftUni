import java.util.Scanner;

public class _4ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");

        int numberOfRotations = Integer.parseInt(scanner.nextLine());

        while (numberOfRotations-- > 0) {
            rotateArray(numbers);
        }

        System.out.println(String.join(" ", numbers));
    }

    private static void rotateArray(String[] array) {
        String firstElement = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = firstElement;
    }
}
