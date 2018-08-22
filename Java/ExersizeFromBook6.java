import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;

public class ExersizeFromBook6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[10];
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < input.length; i++) {
            int currNum = input[i];
            result[currNum]+=1;
        }
        int besSeq = Arrays.stream(result).sorted().toArray()[result.length - 1];
        int bestNum = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i]==besSeq)
            {
                bestNum = i;
                break;
            }
        }

        System.out.println(bestNum);
        System.out.println(besSeq);
    }

}
