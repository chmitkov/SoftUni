import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class _13BlurFilter {
    public static void main (String [] args){

        Scanner scanner = new Scanner(System.in);

        int numToIncreaseWith = Integer.parseInt(scanner.nextLine());

        int [] infoForMatrix = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int [] [] matrix = new int[infoForMatrix[0]][infoForMatrix[1]];

        for (int i = 0; i < matrix.length; i++) {
            int [] inputRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = inputRow[j];
            }
        }

        int[]targetCell = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        matrix[targetCell[0]][targetCell[1]] +=numToIncreaseWith;
        matrix[targetCell[0]-1][targetCell[1]-1] +=numToIncreaseWith;
        matrix[targetCell[0]-1][targetCell[1]] +=numToIncreaseWith;
        matrix[targetCell[0]-1][targetCell[1]+1] +=numToIncreaseWith;
        matrix[targetCell[0]][targetCell[1]-1] +=numToIncreaseWith;
        matrix[targetCell[0]][targetCell[1]+1] +=numToIncreaseWith;
        matrix[targetCell[0]+1][targetCell[1]-1] +=numToIncreaseWith;
        matrix[targetCell[0]+1][targetCell[1]] +=numToIncreaseWith;
        matrix[targetCell[0]+1][targetCell[1]+1] +=numToIncreaseWith;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
