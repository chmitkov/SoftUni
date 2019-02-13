import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] matrixSize = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] matrix = new String[matrixSize[0]][matrixSize[1]];
        int[] playerPosition = new int[2];
        boolean isDied = false;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = br.readLine().split("");
            if (Arrays.asList(matrix[i]).contains("P")) {
                playerPosition[0] = i;
                for (int j = 0; j < matrix[i].length; j++) {
                    if ("P".equalsIgnoreCase(matrix[i][j])) {
                        playerPosition[1] = j;
                        break;
                    }
                }
            }
        }
        matrix[playerPosition[0]][playerPosition[1]] = ".";
        String[] commands = br.readLine().split("");
        for (String command : commands) {

            if(playerMove(matrix, playerPosition, command)){
                return;
            }
        }

        printMatrix(matrix);
        System.out.printf("won: %d %d", playerPosition[0], playerPosition[1]);

    }

    private static void printMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            Arrays.stream(rows).forEach(System.out::print);
            System.out.println();
        }
    }

    private static boolean playerMove(String[][] matrix,
                                      int[] playerPosition, String command) {
        boolean isDied = false;
        switch (command) {
            case "U":
                playerPosition[0] = playerPosition[0] - 1 < 0
                        ? 0 : playerPosition[0] - 1;
                break;
            case "D":
                playerPosition[0] = playerPosition[0] + 1 >= matrix.length
                        ? matrix.length - 1
                        : playerPosition[0] + 1;
                break;
            case "L":
                playerPosition[1] = playerPosition[1] - 1 < 0
                        ? 0
                        : playerPosition[1] - 1;

                break;
            case "R":
                playerPosition[1] = playerPosition[1] + 1 >= matrix[0].length
                        ? matrix[0].length - 1
                        : playerPosition[1] + 1;

                break;
        }
        try {
            if("R".equals(
                    matrix[playerPosition[1]][playerPosition[2]])) {
                isDied = true;
                printMatrix(matrix);
                System.out.printf("dead: %d %d%n", playerPosition[1],
                        playerPosition[1]);
            }
        } catch (Exception e) {

        }
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String currentCell = matrix[row][col];
                if ("B".equals(currentCell)) {
                    stack.push(row + "" + col);
                }
            }
        }

        while (!stack.isEmpty()) {
            String str = stack.pop();
            int row = Integer.parseInt(str.charAt(0) + "");
            int col = Integer.parseInt(str.charAt(1) + "");
            setRabbitToNearCell(matrix, row - 1, col);
            setRabbitToNearCell(matrix, row, col - 1);
            setRabbitToNearCell(matrix, row, col + 1);
            setRabbitToNearCell(matrix, row + 1, col);
        }

        try {
            if ("B".equals(matrix[playerPosition[0]][playerPosition[1]])) {
                isDied = true;
                printMatrix(matrix);
                System.out.printf("dead: %d %d", playerPosition[0], playerPosition[1]);
            }
        } catch (Exception e) {
        }
        ;
        return isDied;
    }

    private static void setRabbitToNearCell(String[][] matrix, int row, int col) {
        try {
            matrix[row][col] = "B";
        } catch (Exception e) {
        }
    }

}
