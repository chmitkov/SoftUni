import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p04_MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.toCharArray().length; i++) {
            char currentChar = expression.charAt(i);
            if (currentChar == '(') {
                stack.push(i);
            } else if (currentChar == ')') {
                System.out.println(expression.substring(stack.pop(), i + 1));
            }
        }

    }
}
