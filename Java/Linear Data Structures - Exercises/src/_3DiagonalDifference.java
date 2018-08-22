import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class _3DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[][] matrix = new int[num][num];
        for (int i = 0; i < num; i++) {
            int[] currRow = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < currRow.length; j++) {
                matrix[i][j] = currRow[j];
            }
        }

        int firstDiag = 0;
        int secondDiag = 0;
        for (int i = 0; i <matrix.length; i++) {
            firstDiag += matrix[i][i];
            secondDiag+= matrix[matrix.length-1-i][i];
        }

        System.out.println(Math.abs(firstDiag-secondDiag));
    }
}
