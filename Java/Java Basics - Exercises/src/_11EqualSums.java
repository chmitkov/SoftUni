import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11EqualSums {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int index = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            if (i != 0) {
                for (int j = 0; j < i; j++) {
                    leftSum += arr[j];
                }
            }
            if (i != arr.length - 1) {
                for (int j = i + 1; j < arr.length; j++) {
                    rightSum += arr[j];
                }
            }
            if (leftSum == rightSum) {
                index = i;
            }
        }
        if (index != Integer.MIN_VALUE) {
            System.out.println(index);
        }else {
            System.out.println("no");
        }
    }
}
