import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;

public class _9MaximumElement {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int numOfCommands = Integer.parseInt(br.readLine());

        while (numOfCommands-- > 0) {
            int[] commands = Arrays.stream(br.readLine().split(" "))
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
                    int maxElement = Integer.MIN_VALUE;
                        for (int num : stack) {
                            if (num > maxElement) {
                                maxElement = num;
                            }
                        }

                    System.out.println(maxElement);
                    break;
            }
        }
    }
}
