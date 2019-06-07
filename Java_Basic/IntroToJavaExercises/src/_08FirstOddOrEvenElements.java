import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _08FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String[] commands = scanner.nextLine().split(" ");
        int numbers = Integer.parseInt(commands[1]);
        String type = commands[2];
        ArrayList<Integer> current = new ArrayList<Integer>();
        if (type.equals("odd")) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 != 0) {
                    current.add(array[i]);
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 0) {
                    current.add(array[i]);
                }
            }
        }

        current.forEach(x->System.out.print(x+" "));
    }
}
