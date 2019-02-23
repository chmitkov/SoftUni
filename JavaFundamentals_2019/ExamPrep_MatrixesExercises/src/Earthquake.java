import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] gardenSize = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] garden = new int[gardenSize[0]][gardenSize[1]];

        String line;

        while (!"Bloom Bloom Plow".equals(line = br.readLine())) {
            int[] flowerCoordinate = Arrays.stream(line.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            
            fillMatrix(garden, flowerCoordinate);
        }

        printMatrix(garden);

    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.printf("%s ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] garden, int[] flowerCoordinate) {
        for (int row = 0; row < garden.length ; row++) {
            garden[row][flowerCoordinate[1]]++;
        }

        for (int col = 0; col < garden[0].length; col++) {
            garden[flowerCoordinate[0]][col]++;
        }

        garden[flowerCoordinate[0]][flowerCoordinate[1]]--;
    }
}
