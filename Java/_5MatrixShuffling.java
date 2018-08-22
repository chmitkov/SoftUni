import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _5MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] matrixSizes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] matrix = new int[matrixSizes[0]][matrixSizes[1]];
        for (int i = 0; i < matrix.length; i++) {
            int[] currRow = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = currRow;
        }
        String input = br.readLine();

        while (!"END".equals(input)){
            String [] commands = input.split(" ");

            if (isValidInput(commands,matrix)){
                changeItemPlace(commands,matrix);
                printMatrix(matrix);
            }else{
                System.out.println("Invalid input!");
            }

            input = br.readLine();
        }

    }

    private static void changeItemPlace(String[] commands,int [][]matrix ){
        int temp = matrix[Integer.valueOf(commands[1])][Integer.valueOf(commands[2])];

        matrix[Integer.valueOf(commands[1])][Integer.valueOf(commands[2])] =
                matrix[Integer.valueOf(commands[3])][Integer.valueOf(commands[4])];

        matrix[Integer.valueOf(commands[3])][Integer.valueOf(commands[4])] = temp;

        //return matrix;
    }
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isValidInput(String[] commands,int[][]matrix) {
        if (commands.length != 5 ||
                !"swap".equals(commands[0])) {
            return false;
        }

        if (Integer.valueOf(commands[1])>=matrix.length ||
                Integer.valueOf(commands[3])>=matrix.length ||
                    Integer.valueOf(commands[2])>= matrix[0].length||
                        Integer.valueOf(commands[4])>=matrix[0].length){
            return false;
        }

        return true;
    }
}
