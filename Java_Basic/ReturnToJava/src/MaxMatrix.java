import java.io.IOException;
import java.util.Arrays;

public class MaxMatrix {
    public static void main(String[] args) throws IOException {
        int[][] matrix = new int[][]{
                {0, 2, 4, 0, 9, 5},
                {7, 1, 3, 3, 2, 1},
                {1, 3, 9, 8, 5, 6},
                {4, 6, 7, 9, 1, 0}
        };

        int bestSum = Integer.MIN_VALUE;
        int [][] bestMatrix = new int[2][2];
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestMatrix[0][0] = matrix[i][j];
                    bestMatrix[0][1] = matrix[i][j+1];
                    bestMatrix[1][0] = matrix[i+1][j];
                    bestMatrix[1][1] = matrix[i+1][j+1];
                }
            }
        }
        System.out.printf("Best Sum: %d\n", bestSum);
        System.out.print(Arrays.deepToString(bestMatrix));
    }
}
