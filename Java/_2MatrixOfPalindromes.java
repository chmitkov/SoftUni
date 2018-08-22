import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2MatrixOfPalindromes {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] matrix = new int[nums[0]][nums[1]];
        for (int i = 0; i < matrix.length; i++) {
            char firstAndLast = (char)(i+97);
            for (int j= 0; j < matrix[0].length; j++) {
                char mid = (char)(j+i+97);
                System.out.printf("%s%s%s ",firstAndLast,mid,firstAndLast);

            }
            System.out.println();
        }
    }
}
