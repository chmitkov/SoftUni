import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _12BalancedParentheses {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        String str = br.readLine();
        if (str.length() % 2 != 0) {
            System.out.println("No");
        } else {
            for (int i = 0; i < str.length(); i++) {
                  if (i<str.length()/2){
                      stack.push(str.charAt(i));
                  }else {
                      queue.add(str.charAt(i));
                  }
            }

            while (!stack.isEmpty()){
                if (stack.pop().compareTo(queue.remove())!=0){
                    System.out.println("No");
                    return;
                }
            }
            System.out.println("Yes");
        }
    }
}
