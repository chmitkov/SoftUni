import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class p06_BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brackets = br.readLine();

        Stack<Character> stack = new Stack<>();
        boolean isBalanced = true;

        for (int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);
            if (bracket == '{' || bracket == '[' || bracket == '(') {
                stack.push(bracket);
            } else {
                if (bracket == '}') {
                    bracket = '{';
                } else if (bracket == ')') {
                    bracket = '(';
                } else if (bracket == ']') {
                    bracket = '[';
                }

                if (stack.empty()) {
                    isBalanced = false;
                    break;
                }

                if (bracket == stack.peek()) {
                    stack.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
