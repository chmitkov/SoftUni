import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JediGalaxy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] size = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = new int[size[0]][size[1]];
        fillMatrix(matrix);
        int sum = 0;

        int[] ivoStartPoint = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ivoStartPoint[1]++;
        ivoStartPoint[0]--;
        int[] evilStartPoint = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .map(x->x-=1)
                .toArray();

        while (evilStartPoint[0] >= 0) {
            evilRemoveDiagonals(matrix, evilStartPoint);
            sum += ivoSumDiagonals(matrix, ivoStartPoint);
            evilStartPoint[0]--;
            ivoStartPoint[0]--;
        }

        System.out.println(sum);

    }

    private static void fillMatrix(int[][] matrix) {
       int counter = 0;
         for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = counter++;
            }
        }
    }

    private static int ivoSumDiagonals(int[][] matrix, int[] ivoStartPoint) {
        int sum = 0;
        int col = ivoStartPoint[1];
        for (int row = ivoStartPoint[0]; row >= 0; row--) {
            int currentCell = matrix[row][col];
            sum += currentCell == -1 ? 0 : currentCell;
            col++;
        }
        return sum;
    }

    private static void evilRemoveDiagonals(int[][] matrix, int[] evilStartPoint) {
        int col = evilStartPoint[1];
        for (int row = evilStartPoint[0]; row >= 0; row--) {
            matrix[row][col] = -1;
            col--;
        }
    }
}
