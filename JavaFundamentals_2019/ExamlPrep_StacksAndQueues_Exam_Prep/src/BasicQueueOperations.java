import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] commands = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numberToAddInQueue = commands[0];
        int numberToPollFromQueue = commands[1];
        int numberToCheckIsExist = commands[2];

        int[] numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numberToAddInQueue; i++) {
            queue.add(numbers[i]);
        }

        while (numberToPollFromQueue-- > 0) {
            queue.poll();
        }

        System.out.println(queue.contains(numberToCheckIsExist)
                ? "true"
                : smallNumberInQueue(queue)
        );
    }

    private static String smallNumberInQueue(ArrayDeque<Integer> queue) {
        return queue.isEmpty()
                ? String.valueOf(0)
                : String.valueOf(queue.stream()
                .min(Integer::compareTo)
                .get())
                ;
    }
}
