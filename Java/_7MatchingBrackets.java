import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class _7MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        String express = br.readLine();

        for (int i = 0; i < express.length(); i++) {
            if (express.charAt(i) == '(') {
                  stack.push(i);
            } else if (express.charAt(i)==')'){
                int startIndex = stack.pop();

                String str = express.substring(startIndex, i+1);

                System.out.println(str);
            }
        }
    }
}
