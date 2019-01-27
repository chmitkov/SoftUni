import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class p04_BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] commands = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numberOfElementsToAdd = commands[0];
        int numberOfElementsToPool = commands[1];
        int numberToCheckIsPresent = commands[2];

        for (int i = 0; i < numberOfElementsToAdd; i++) {
            queue.add(numbers[i]);
        }

        while (numberOfElementsToPool-->0){
            queue.poll();
        }

        System.out.println(
                queue.contains(numberToCheckIsPresent)
                        ? true : giveMinNumber(queue));

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
