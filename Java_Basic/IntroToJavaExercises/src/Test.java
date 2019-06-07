import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String expressinon = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < expressinon.length(); i++) {
            char ch = expressinon.charAt(i);
            if (ch == '('){
                stack.push(i);
            }else if (ch==')'){
                int startIndex = stack.pop();
                String content = expressinon.substring(startIndex,i+1);
                System.out.println(content);
            }
        }

    }
}
