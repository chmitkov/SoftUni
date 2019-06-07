import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class _10BasicQueueOperations {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] commands = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.stream(nums).forEach(queue::add);
        int counter = commands[1];
        while (counter-- > 0) {
            queue.pop();
        }

        if (queue.contains(commands[2])) {
            System.out.println("true");
        }else{
            int minNum = Integer.MAX_VALUE;
            if (queue.isEmpty()){
                System.out.println("0");
                return;
            }
            for(int num : queue){
                if (num<minNum){
                    minNum=num;
                }
            }
            System.out.println(minNum);
        }
    }
}
