import java.util.Scanner;

public class _3SumMatrixElements {
    public static  void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] matrixInfo = scanner.nextLine().split(", ");
        int totalSum =0;
        int [][] matrix = new int[Integer.parseInt(matrixInfo[0])]
                [Integer.parseInt(matrixInfo[1])];

        for (int i = 0; i < matrix.length; i++) {
            String[] currRow = scanner.nextLine().split(", ");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.parseInt(currRow[j]);
                totalSum+=matrix[i][j];
            }
        }
        System.out.println(matrixInfo[0]);
        System.out.println(matrixInfo[1]);
        System.out.println(totalSum);

    }
}
