import java.util.Scanner;

public class _4MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] matrixInfo = scanner.nextLine().split(", ");
        int[][] matrix = new int[Integer.parseInt(matrixInfo[0])]
                [Integer.parseInt(matrixInfo[1])];

        for (int i = 0; i < matrix.length; i++) {
            String[] currRow = scanner.nextLine().split(", ");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.parseInt(currRow[j]);
            }
        }

        int bestSum = 0;
        int bestRowIndex = 0;
        int bestCollIndex = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                int currSum = matrix[i][j] + matrix[i][j + 1]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if(currSum>bestSum){
                    bestSum=currSum;
                    bestRowIndex=i;
                    bestCollIndex=j;
                }
            }
        }
        System.out.printf("%d %d%n", matrix[bestRowIndex][bestCollIndex], matrix[bestRowIndex][bestCollIndex+1]);
        System.out.printf("%d %d%n", matrix[bestRowIndex+1][bestCollIndex], matrix[bestRowIndex+1][bestCollIndex+1]);
        System.out.println(bestSum);
    }
}
