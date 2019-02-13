import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p04_MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] matrixSize = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = new int[matrixSize[0]][matrixSize[1]];

        fullMatrix(br, matrix);

        printBigSumAndSubmatrix(matrix);
    }

    private static void printBigSumAndSubmatrix(int[][] matrix) {
        int bestSum = 0;
        int[] bestCenterIndex = new int[2];

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[0].length - 1; j++) {
                int currentPositionSum = 0;
                currentPositionSum = getCurrentPositionSum(matrix, i, j);

                if (currentPositionSum > bestSum) {
                    bestSum = currentPositionSum;
                    bestCenterIndex[0] = i;
                    bestCenterIndex[1] = j;
                }
            }
        }

        System.out.printf("Sum = %d%n", bestSum);

        printSubMatrixWithCordinates(bestCenterIndex, matrix);
    }

    private static void printSubMatrixWithCordinates(int[] bestCenterIndex, int[][] matrix) {
        int row = bestCenterIndex[0];
        int col = bestCenterIndex[1];

        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int getCurrentPositionSum(int[][] matrix, int row, int col) {
        int sum = 0;
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) {
                sum+=matrix[i][j];
            }
        }
        return sum;
    }

    private static void fullMatrix(BufferedReader br, int[][] matrix) throws IOException {
        for (int i = 0; i < matrix.length; i++) {
            int[] currentRow = Arrays.stream(br.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = currentRow[j];
            }
        }
    }


}
