import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class LargestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String line;
        int counter = 0;
        int[] bestSumAndCellAndSidesLength = new int[4];
        ArrayDeque<String[]> queue = new ArrayDeque<>();
        while (!"END".equalsIgnoreCase(line = br.readLine())) {
            queue.add(Arrays.stream(line.split(","))
                    .filter(x -> !x.trim().equals(""))
                    .toArray(String[]::new));
            counter++;
        }
        String[][] matrix = new String[counter][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = queue.poll();
        }

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                sizeOfInnerRectangle(matrix, row, col,
                        bestSumAndCellAndSidesLength);
            }
        }
        printMatrix(matrix, bestSumAndCellAndSidesLength);
    }

    private static void sizeOfInnerRectangle(String[][] matrix, int row, int col, int[] best) {
        String symbol = matrix[row][col];
        //Check upperSide
        int upperSideSize = 1;
        for (int c = col + 1; c < matrix[row].length; c++) {
            if (!symbol.equals(matrix[row][c])) {
                break;
            }
            upperSideSize++;
        }

        int leftSideSize = 1;
        for (int r = row + 1; r < matrix.length; r++) {
            if (!symbol.equals(matrix[r][col])) {
                break;
            }
            leftSideSize++;
        }

        int currentResult = leftSideSize * upperSideSize;
        if (best[0] < currentResult) {
            best[0] = currentResult;
            //Cell coordinate row*10+col
            best[1] = row * 10 + col;
            best[2] = upperSideSize;
            best[3] = leftSideSize;
        }
    }

    private static void printMatrix(String[][] matrix, int[] bestSumAndCellAndSidesLength) {
        int startRow = bestSumAndCellAndSidesLength[1] / 10;
        int startCol = bestSumAndCellAndSidesLength[1] % 10;
        int height = bestSumAndCellAndSidesLength[3];
        int width = bestSumAndCellAndSidesLength[2];

        for (int row = startRow; row < startRow + height - 1; row++) {
            matrix[row][startCol] = String.format("[%s]",
                    matrix[row][startCol]);
        }

        for (int row = startRow; row < startRow + height - 1; row++) {
            matrix[row][startCol + width - 1] = String.format("[%s]",
                    matrix[row][startCol + width - 1]);
        }

        for (int col = startCol; col < startCol + width - 1; col++) {
            matrix[col][startRow] = String.format("[%s]",
                    matrix[col][startRow]);
        }

        for (int col = startCol; col < startCol + width - 1; col++) {
            matrix[col][startRow + height - 1] = String.format("[%s]",
                    matrix[col][startRow + height - 1]);
        }

        for (String[] matrix1 : matrix) {
            for (String s : matrix1) {
                System.out.printf("     %s", s);
            }
            System.out.println();
        }
    }
}
