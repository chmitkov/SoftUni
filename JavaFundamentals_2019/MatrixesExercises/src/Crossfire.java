import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] matrixSize = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<List<Integer>> matrix = fillMatrix(matrixSize);
        String line;

        while (!"Nuke it from orbit".equals(line = br.readLine())) {
            int[] commands = Arrays.stream(line.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            boom(matrix, commands);

            matrixRemoveEmptyRows(matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                System.out.printf("%d ", matrix.get(row).get(col));
            }
            System.out.println();
        }
    }

    private static void matrixRemoveEmptyRows(List<List<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            if (matrix.get(row).isEmpty()) {
                matrix.remove(row);
                row--;
            }
        }
    }

    private static void boom(List<List<Integer>> matrix, int[] commands) {
        int startRow = commands[0];
        int startCol = commands[1];
        int power = commands[2];

        List<Integer> currentRow = null;
        if (startCol + power >= matrix.get(startRow).size()) {
            currentRow = matrix.get(startRow).subList(0, startCol - power);

        } else {
            int cellsForRemove = power * 2 + 1;
            int indexForRemove = startCol - power;
            while (cellsForRemove-- > 0) {
                currentRow = matrix.get(startRow);
                currentRow.remove(indexForRemove);
            }
        }
        matrix.set(startRow, currentRow);

        for (int row = startRow - power; row < matrix.size(); row++) {
            List<Integer> current = matrix.get(row);
            try {
                current.remove(startCol);
            } catch (Exception e) {

            }
            matrix.set(row, current);
        }
    }

    private static List<List<Integer>> fillMatrix(int[] matrixSize) {
        List<List<Integer>> matrix = new ArrayList<>();
        int counter = 1;
        for (int row = 0; row < matrixSize[0]; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < matrixSize[1]; col++) {
                matrix.get(row).add(counter);
                counter++;
            }
        }
        return matrix;
    }
}
