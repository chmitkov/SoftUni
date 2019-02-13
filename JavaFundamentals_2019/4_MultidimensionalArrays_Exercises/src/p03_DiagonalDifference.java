import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p03_DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {
            int[] currentRow = Arrays.stream(br.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = currentRow[j];
            }
        }

        System.out.println(sumDiagonals(matrix));
    }

    private static int sumDiagonals(int[][] matrix) {
        int firstDiagonal = 0;
        int secondDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            firstDiagonal += matrix[i][i];
        }

        for (int i = 0; i < matrix.length; i++) {
            secondDiagonal += matrix[i][matrix.length - 1 - i];
        }

        return Math.abs(firstDiagonal - secondDiagonal);
    }
}
