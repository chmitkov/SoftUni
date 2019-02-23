import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] commands = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numberOfElementsInStack = commands[0];
        int numberOfElementsToPop = commands[1];
        int numberToCheckIsExists = commands[2];

        int[] numbersToPushInStack = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numberOfElementsInStack; i++) {
            stack.push(numbersToPushInStack[i]);
        }

        while (numberOfElementsToPop-- > 0) {
            stack.pop();
        }

        System.out.println(stack.contains(numberToCheckIsExists)
                ? "true" : smallElementInStack(stack));
    }

    private static String smallElementInStack(ArrayDeque<Integer> stack) {
        return stack.isEmpty()
                ? String.valueOf(0)
                : String.valueOf(stack.stream()
                        .min(Integer::compareTo).get());
    }
}
