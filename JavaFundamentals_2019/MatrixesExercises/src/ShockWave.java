import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ShockWave {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] size = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = new int[size[0]][size[1]];
        String line;

        while (!"Here We Go".equals(line = br.readLine())) {
            int[] coordinate = Arrays.stream(line.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            fillMatrix(matrix, coordinate);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.printf("%s ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, int[] coordinate) {
        for (int row = coordinate[0]; row <= coordinate[2] ; row++) {
            for (int col = coordinate[1]; col <=coordinate[2] ; col++) {
                matrix[row][col]++;
            }
        }
    }
}
