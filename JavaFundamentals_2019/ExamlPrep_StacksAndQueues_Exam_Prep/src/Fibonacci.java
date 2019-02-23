import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Fibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.println(fib(num));
    }

    private static int fib(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>() {{
            push(1);
            push(1);
        }};
        while (num-- > 1) {
            int beforeNum = stack.pop();
            int beforeBeforeNum = stack.pop();

            int result = beforeNum + beforeBeforeNum;
            stack.push(beforeBeforeNum);
            stack.push(beforeNum);
            stack.push(result);
        }
        return stack.pop();
    }
}
