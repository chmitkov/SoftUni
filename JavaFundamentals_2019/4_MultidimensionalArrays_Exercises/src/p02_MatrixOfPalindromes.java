import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p02_MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] commands = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] matrix = new String[commands[0]][commands[1]];

        fullMatrixFields(matrix);

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String col : row) {
                System.out.printf("%s ", col);
            }
            System.out.println();
        }
    }

    private static void fullMatrixFields(String[][] matrix) {
        char currentFirstAndLast = 97;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = String.format("%c%c%c",
                        currentFirstAndLast, currentFirstAndLast + j, currentFirstAndLast);
            }
            currentFirstAndLast++;
        }
    }
}
