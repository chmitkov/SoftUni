import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String[] input = br.readLine().split("");

        if (input.length % 2 != 0) {
            System.out.println("NO");
            return;
        }

        ArrayDeque<String> stringArrayDeque =
                new ArrayDeque<>(Arrays.asList(input));

        if(stringArrayDeque.size()==1){
            System.out.println("NO");
            return;
        }
        while (!stringArrayDeque.isEmpty()) {
            char first = stringArrayDeque.removeFirst().charAt(0);
            char last = stringArrayDeque.removeLast().charAt(0);

            if (first == 40) {
                if (last != 41) {
                    System.out.println("NO");
                    return;
                }
            } else {
                if (first + 2 != last) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}