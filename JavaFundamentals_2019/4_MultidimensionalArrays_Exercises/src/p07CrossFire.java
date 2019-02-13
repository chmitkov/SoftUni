import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p_07CrossFire {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> matrix = new ArrayList<>();

        int[] matrixSize = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int counter = 1;
        for (int i = 0; i < matrixSize[0]; i++) {
            matrix.add(new ArrayList<Integer>());
            for (int j = 0; j < matrixSize[1]; j++) {
                matrix.get(i).add(counter++);
            }
        }


        String line;
        while (!"Nuke it from orbit".equals(line = br.readLine())) {
            int[] commands = Arrays.stream(line.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            bombHit(commands, matrix);
        }

        printMatrix(matrix);

    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> matrix1 : matrix) {
            matrix1.stream()
                    .filter(x -> x != 0)
                    .forEach(x -> System.out.printf("%d ", x));
            System.out.println();
        }
    }

    private static void bombHit(int[] commands, List<List<Integer>> matrix) {
        int row = commands[0];
        int col = commands[1];
        int power = commands[2];

        for (int r = row - power; r <= row + power; r++) {
            try {
                matrix.get(r).set(col, 0);
            } catch (Exception e) {
                //out of bounds
            }
        }

        ArrayList<Integer> tempList = new ArrayList<>();
        int startIndex = col - power;
        int endIndex = col + power;
        for (int i = 0; i < matrix.get(row).size(); i++) {
            if (i < startIndex || i > endIndex) {
                tempList.add(matrix.get(row).get(i));
            }
        }
        matrix.get(row).clear();
        matrix.get(row).addAll(tempList);
    }
}