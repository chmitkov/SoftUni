import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ParkingSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] matrixSize = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] parkingMatrix = new String[matrixSize[0]][matrixSize[1]];
        fillMatrix(parkingMatrix);
        String line;
        while (!"stop".equals(line = br.readLine())) {
            int[] commands = Arrays.stream(line.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            parkCarOnCoordinates(parkingMatrix, commands);
        }
    }

    private static void fillMatrix(String[][] parkingMatrix) {
        for (int row = 0; row < parkingMatrix.length; row++) {
            for (int col = 0; col < parkingMatrix[row].length; col++) {
                parkingMatrix[row][col] = "E";
            }
        }
    }

    private static void parkCarOnCoordinates(String[][] parkingMatrix, int[] commands) {
        int[] targetCell = findPlace(parkingMatrix, commands);
        if (targetCell[0] == -1) {
            return;
        }

        int neededMoves = Math.abs(commands[0] - commands[1]);

        for (int col = 0; col <= targetCell[1]; col++) {
            neededMoves++;
        }

        System.out.println(neededMoves);
    }

    private static int[] findPlace(String[][] parkingMatrix, int[] commands) {
        boolean find = false;
        int row = commands[1];
        int col = commands[2];
        int[] targetCell = new int[2];
        int counter = 0;

        while (!find) {
            counter++;

            if ("E".equals(parkingMatrix[row][col])) {
                find = true;
                parkingMatrix[row][col] = "X";
                targetCell[0] = row;
                targetCell[1] = col;
            }
            if (counter >= parkingMatrix[row].length) {
                System.out.printf("Row %d full", row);
                targetCell[0] = -1;
                return targetCell;
            }
            col = col - 1 <= 0
                    ? parkingMatrix[row].length - 1
                    : col - 1;
        }
        return targetCell;
    }
}
