import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class _09MostFrequentNumber {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int best = 0;
        int bestNum = 0;
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dict.containsKey(nums[i])){
                dict.put(nums[i],dict.get(nums[i])+1);
                if (dict.get(nums[i])+1>best)
                {
                    best = dict.get(nums[i])+1;
                    bestNum = nums[i];
                }
            }else {
                dict.put(nums[i],1);
            }
        }
        System.out.println(bestNum);
    }
}
