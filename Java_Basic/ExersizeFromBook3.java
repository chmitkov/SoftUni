import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ExersizeFromBook3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int bestCounter = Integer.MIN_VALUE;
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                counter++;
                if (counter > bestCounter) {
                    bestCounter = counter;
                }
            } else {
                counter = 1;
            }
        }
        System.out.println(bestCounter);
    }
}
