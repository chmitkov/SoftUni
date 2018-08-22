import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1FillTheMatrix {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] commands =br.readLine().split(", ");
        int num = Integer.parseInt(commands[0]);
        String type = commands[1];
        int [][]  matrix = "A".equals(type)?
                makeMatrixTypeA(num):
                makeMatrixTypeB(num);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.println();
        }

    }
    private static int[][] makeMatrixTypeA(int num)
    {
        int [][] matrix = new int[num][num];
        int counter = 0;
        for (int col = 0; col < matrix.length; col++) {

            for (int row = 0; row < matrix.length; row++) {
                counter++;
                matrix[row][col]=counter;
            }
        }
        return matrix;
    }

    private static int[][] makeMatrixTypeB (int num){
        int [][] matrix = new int[num][num];

        int counter = 0;
        for (int col = 0; col < matrix.length; col++) {

            if (col%2==0){
                for (int row = 0; row < matrix.length; row++) {
                    counter++;
                    matrix[row][col]=counter;
                }
            }else
            {
                for (int row = matrix.length-1; row >= 0; row--) {
                    counter++;
                    matrix[row][col]=counter;
                }
            }

        }

        return matrix;
    }
}
