import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _07MaxSequenceofEqualElements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int best = 1;
        int counter = 1;
        int num = arr[0];

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]==arr[i+1]){
                counter++;
                if (counter>best){
                    best=counter;
                    num = arr[i];
                }
            }else {
                counter=1;
            }
        }
        for (int i = 0; i < best; i++) {
            System.out.printf("%d ",num);
        }


    }
}
