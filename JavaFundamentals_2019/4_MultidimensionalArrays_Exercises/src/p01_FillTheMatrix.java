import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] commands = br.readLine().split(", ");

        int size = Integer.parseInt(commands[0]);

        String type = commands[1];

        System.out.println(type.endsWith("A")
                ? matrixTypeA(size) : matrixTypeB(size));
    }

    private static String matrixTypeB(int size) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix[0].length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = counter++;
                }
            } else {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][i] = counter++;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(String.format("%d ", matrix[i][j]));
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private static String matrixTypeA(int size) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = counter++;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(String.format("%d ", matrix[i][j]));
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
