import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _08MaxSequenceOfIncreasingElements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int best = 1;
        int counter = 1;
        int startIndex = 0;

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]<arr[i+1]){
                counter++;
                if (counter>best){
                    best=counter;
                    startIndex = i;
                }
            }else {
                counter=1;
            }
        }
        int start = startIndex-(best-2);
        for (int i = start; i < start+best; i++) {
            System.out.printf("%d ",arr[i]);
        }
    }
}

