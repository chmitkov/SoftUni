import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class p12_TheMatrix {
    private static ArrayDeque<int[]> positionsQueue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] matrixSize = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] matrix = new String[matrixSize[0]][matrixSize[1]];
        readMatrixFromConsole(br, matrix);

        String fillChar = br.readLine();

        int[] startRowAndCol = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        positionsQueue.add(startRowAndCol);

        String oldChar = matrix[startRowAndCol[0]][startRowAndCol[1]];

        changeMatrix(matrix, oldChar, fillChar);

        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void changeMatrix(String[][] matrix, String oldString, String fillChar) {
        while (!positionsQueue.isEmpty()) {
            int[] currentPosition = positionsQueue.poll();
            matrix[currentPosition[0]][currentPosition[1]] = fillChar;

            addNeighborsToQueue(currentPosition, matrix, oldString);
        }
    }

    private static void addNeighborsToQueue(int[] currentPosition, String[][] matrix, String oldString) {
        for (int row = currentPosition[0] - 1; row <= currentPosition[0] + 1; row++) {
            for (int col = currentPosition[1] - 1; col <= currentPosition[1] + 1; col++) {
                if (checkIfExist(new int[]{row, col}, matrix)
                        && !isDiagonals(row, col, currentPosition)) {
                    if (matrix[row][col].equals(oldString)) {
                        //  if (!(row == currentPosition[0] && col == currentPosition[1])) {
                        positionsQueue.add(new int[]{row, col});
                    }
                }
            }
        }
    }

    private static boolean isDiagonals(int row, int col, int[] currentPosition) {
        return (row == currentPosition[0] - 1 && col == currentPosition[1] - 1) ||
                (row == currentPosition[0] + 1 && col == currentPosition[1] - 1) ||
                (row == currentPosition[0] - 1 && col == currentPosition[1] + 1) ||
                (row == currentPosition[0] + 1 && col == currentPosition[1] + 1);

    }


    private static boolean checkIfExist(int[] cordinates, String[][] matrix) {
        return !(cordinates[0] < 0 || cordinates[0] >= matrix.length
                || cordinates[1] < 0 || cordinates[1] >= matrix[0].length);
    }

    private static void readMatrixFromConsole(BufferedReader br, String[][] matrix) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            String[] currentRow = br.readLine().split("\\s+");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = currentRow[col];
            }
        }
    }
}
