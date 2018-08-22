import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class _10XBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[8][8];
        ArrayList<String> binaryNums = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < 8; i++) {
            int currNum = Integer.parseInt(scanner.nextLine());
            String currBinary = String.format("%8s", Integer.toBinaryString(currNum))
                    .replace(' ', '0');
            binaryNums.add(currBinary);
        }
        for (int i = 0; i < matrix.length; i++) {
            String currBinaryNum = binaryNums.get(i);
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.parseInt(
                        Character.toString(currBinaryNum.charAt(j)));
            }
        }
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[0].length - 2; j++) {
                if ((matrix[i][j] + "" + matrix[i][j + 1] + matrix[i][j + 2]).equals("101")
                        && (matrix[i + 1][j] + "" + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]).equals("010")
                        && (matrix[i + 2][j] + "" + matrix[i + 2][j + 1] + matrix[i + 2][j + 2]).equals("101")) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
