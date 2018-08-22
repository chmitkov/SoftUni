import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _4MaximalSum {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] matrixSize = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] matrix = new int[matrixSize[0]][matrixSize[1]];

        for (int i = 0; i < matrix.length; i++) {
            int[] currentRow = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = currentRow[j];
            }
        }
        int best = Integer.MIN_VALUE;
        int[] bestVector = new int[2];
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[0].length - 2; j++) {
                int[] index = new int[]{i, j};
                if (sumSquareMatrix(index, matrix) > best) {
                    best = sumSquareMatrix(index, matrix);
                    bestVector = index;
                }
            }
        }
        System.out.printf("Sum = %s%n",best);
        printThisMatrix(bestVector,matrix);
    }

    private static int sumSquareMatrix(int[] index, int[][] matrix) {
        int sum = 0;
        for (int i = index[0]; i < index[0] + 3; i++) {
            for (int j = index[1]; j < index[1] + 3; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static void printThisMatrix(int[] vector, int[][] matrix) {
        for (int i = vector[0]; i < vector[0] + 3; i++) {
            for (int j = vector[1]; j < vector[1] + 3; j++) {
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.println();
        }
    }
}
