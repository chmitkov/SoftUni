import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExersizeFromBook1 {
    public static void main(String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i*5;
            System.out.println(nums[i]);
        }
    }
}
