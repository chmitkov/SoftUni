import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class p03_MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int counter = Integer.parseInt(br.readLine());

        while (counter-- > 0) {
            int[] commands = Arrays.stream(br.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            switch (commands[0]) {
                case 1:
                    stack.push(commands[1]);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    printMaxElementInStack(stack);
                    break;
                default:
                    break;
            }
        }
    }

    private static void printMaxElementInStack(ArrayDeque<Integer> stack) {
        int max = Integer.MIN_VALUE;
        for (Integer integer : stack) {
            if (integer > max) {
                max = integer;
            }
        }
        System.out.println(max);
    }
}
