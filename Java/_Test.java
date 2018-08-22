import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = new int[8][8];

        for (int i = 0; i < 8; i++) {
            int[] currRow = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < currRow.length; j++) {
                matrix[i][j] = currRow[j];
            }
        }
        for (int i = 1; i < matrix.length - 2; i++) {
            for (int j = 1; j < matrix[0].length - 2; j++) {
                if (i == 5 && matrix[i + 1][j] == 1) {
                    System.out.printf("Snake success! " +
                            "\nExit point is: Row:%d, Col:%d", i + 1, j);

                    return;
                } else if (j == 5 && matrix[i][j + 1] == 1) {
                    System.out.printf("Snake success! " +
                            "\nExit point is: Row:%d, Col:%d", i, j + 1);

                    return;
                } else {
                    if (matrix[i + 1][j] != 1 && matrix[i][j + 1] != 1) {
                        System.out.printf("Current position:\nRow:%d, Col:%d", i, j);
                        return;
                    } else if (matrix[i][j + 1] != 1) {
                        i++;
                        j--;
                    }
                }
            }
        }
    }
}
