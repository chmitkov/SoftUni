import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class p02_BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] commands = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numbersOfElementToPush = commands[0];
        int numbersOfElementToPop = commands[1];
        int searchedNumber = commands[2];

        for (int i = 0; i < numbersOfElementToPush; i++) {
            stack.push(numbers[i]);
        }

        while (numbersOfElementToPop-- > 0) {
            stack.pop();
        }

        if (stack.contains(searchedNumber)) {
            System.out.println(true);
        } else {
            System.out.println(giveMinNumber(stack));
        }

    }

    private static int giveMinNumber(ArrayDeque<Integer> stack) {
        int min = Integer.MAX_VALUE;
        for (Integer integer : stack) {
            if (integer < min) {
                min = integer;
            }
        }
        return stack.isEmpty() ? 0 : min;
    }
}
