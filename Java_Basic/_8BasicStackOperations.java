import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class _8BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] commands = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.stream(nums).forEach(stack::push);
        int howManuToRemove = commands[1];
        int searchedNum = commands[2];

        while (howManuToRemove-- > 0) {
            stack.pop();
        }

        if (stack.contains(searchedNum)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()){
                System.out.println(0);
                return;
            }
            int minNum = Integer.MAX_VALUE;
            for (int num:stack
                 ) {
                if (num<minNum){
                    minNum=num;
                }
            }
            System.out.println(minNum);
        }
    }
}
