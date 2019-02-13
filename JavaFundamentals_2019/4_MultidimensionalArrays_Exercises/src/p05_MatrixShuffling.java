import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p05_MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] matrixSize = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] matrix = new String[matrixSize[0]][matrixSize[1]];

        fullMatrix(br, matrix);

        String line;
        while (!"END".equals(line = br.readLine())) {

            String[] commands = line.split("\\s+");

            try {
                swapFieldsWith(commands, matrix);

                printMatrix(matrix);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void swapFieldsWith(String[] commands, String[][] matrix) {
        int row1 = Integer.valueOf(commands[1]);
        int col1 = Integer.valueOf(commands[2]);
        int row2 = Integer.valueOf(commands[3]);
        int col2 = Integer.valueOf(commands[4]);

        try {
            String temp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = temp;
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static void fullMatrix(BufferedReader br, String[][] matrix) throws IOException {
        for (int i = 0; i < matrix.length; i++) {
            String[] currentRow = br.readLine().split("\\s+");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = currentRow[j];
            }
        }
    }
}
