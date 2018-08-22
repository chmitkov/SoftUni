import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class _6StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strDeg = br.readLine().replaceAll("[^\\d.]", "");
        int degrease = Integer.valueOf(strDeg) >= 360 ?
                convertDegrease(Integer.valueOf(strDeg)) :
                Integer.valueOf(strDeg);
        String input = br.readLine();
        ArrayList<String> words = new ArrayList<>();
        while (!"END".equals(input)) {
            words.add(input);
            input = br.readLine();
        }
        int longestWord = 0;
        for (String word : words) {
            if (word.length() > longestWord) {
                longestWord = word.length();
            }
        }
        String[][] matrix = new String[words.size()][longestWord];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = j <= words.get(i).length() - 1 ?
                        words.get(i).charAt(j) + "" :
                        "";
            }
        }
        switch (degrease) {

            case 90:
                matrix = rotateMatrixTo90(matrix);
                printMatrix(matrix);
                break;
            case 180:
                matrix = rotateMatrixTo180(matrix);
                printMatrix(matrix);
                break;
            case 270:
                matrix = rotateMatrixTo270(matrix);
                printMatrix(matrix);
                break;
            case 0:
                printMatrix(matrix);
                break;
        }
    }
    private static String[][] rotateMatrixTo270(String[][] matrix) {
        String[][] rotatedMatrix = new String[matrix[0].length][matrix.length];


        for (int col = 0; col < rotatedMatrix[0].length; col++) {
            String currentWord = "";
            for (String s : matrix[col]
             ) {
                currentWord += s;
            };
            int counter = 0;
            for (int row = rotatedMatrix.length-1; row >=0 ; row--) {
                rotatedMatrix[row][col] = counter<currentWord.length()?
                        currentWord.charAt(counter)+"":
                        "";
                counter++;
            }
        }
        return  rotatedMatrix;
    }
    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                String output = matrix[i][j].equals("")?
                        " ":
                        matrix[i][j];
                System.out.printf("%s",output);
            }
            System.out.println();
        }
    }

    private static int convertDegrease(int degrease) {
        while (degrease >= 360) {
            degrease -= 360;
        }
        return degrease;
    }

    private static String[][] rotateMatrixTo90(String[][] matrix) {
        String[][] rotatedMatrix = new String[matrix[0].length][matrix.length];

        for (int i = rotatedMatrix[0].length - 1; i >= 0; i--) {
            String currentWord = "";
            for (String s : matrix[matrix.length - 1 - i]
            ) {
                currentWord += s;
            }
            for (int j = 0; j < rotatedMatrix.length; j++) {
                rotatedMatrix[j][i] = j < currentWord.length() ?
                        currentWord.charAt(j) + "" :
                        "";
            }
        }
        return rotatedMatrix;
    }

    private static String[][] rotateMatrixTo180(String[][] matrix) {
        String[][] rotatedMatrix = new String[matrix.length][matrix[0].length];

        for (int i = matrix.length - 1; i >= 0; i--) {
            String currentWord = "";
            for (String s : matrix[matrix.length - 1 - i]
            ) {
                currentWord += s;
            }
            int counter = 0;
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                rotatedMatrix[i][j] = counter < currentWord.length() ?
                        currentWord.charAt(counter) + "" :
                        "";
                counter++;
            }
        }
        return rotatedMatrix;
    }
}
