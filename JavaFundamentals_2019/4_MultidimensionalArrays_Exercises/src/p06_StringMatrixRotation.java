import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p06_StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();

        int degrees = getDegrees(br.readLine()) % 360;

        String line;
        while (!"END".equalsIgnoreCase(line = br.readLine())) {
            list.add(line);
        }

        int longestWordLength = findLongestWord(list);

        String[][] matrix = new String[list.size()][longestWordLength];

        fullMatrix(matrix, list);
        if (degrees == 0) {
            printMatrix(matrix);
            return;
        }

        switch (degrees) {
            case 90:
                matrix = rotateMatrixTo90(matrix, list);
                break;
            case 180:
                matrix = rotateMatrixTo180(matrix, list);
                break;
            case 270:
                matrix = rotateMatrixTo270(matrix, list);
                break;
        }

        printMatrix(matrix);
    }

    private static String[][] rotateMatrixTo270(String[][] matrix, ArrayList<String> list) {
        String[][] rotatedMatrix = new String[matrix[0].length][matrix.length];
        for (int col = 0; col < rotatedMatrix[0].length; col++) {
            String[] currentRow = list.get(col).split("");
            int counter = 0;
            for (int row = rotatedMatrix.length - 1; row >= 0; row--) {
                if (counter >= currentRow.length) {
                    rotatedMatrix[row][col] = "";
                }else{
                    rotatedMatrix[row][col] = currentRow[counter];
                }
                counter++;
            }
        }

        return rotatedMatrix;
    }

    private static String[][] rotateMatrixTo180(String[][] matrix, ArrayList<String> list) {
        String[][] rotatedMatrix = new String[matrix.length][matrix[0].length];
        int counter = 0;
        for (int row = rotatedMatrix.length - 1; row >= 0; row--) {
            String[] currentRow = list.get(counter++).split("");
            int charCounter = 0;
            for (int col = rotatedMatrix[0].length - 1; col >= 0; col--) {
                if (charCounter >= currentRow.length) {
                    rotatedMatrix[row][col] = "";
                } else {
                    rotatedMatrix[row][col] = currentRow[charCounter];
                }
                charCounter++;
            }
        }

        return rotatedMatrix;
    }

    private static String[][] rotateMatrixTo90(String[][] matrix, ArrayList<String> list) {
        String[][] rotatedMatrix = new String[matrix[0].length][matrix.length];
        for (int col = rotatedMatrix[0].length - 1; col >= 0; col--) {
            String[] currentRow = list.get(rotatedMatrix[0].length - 1 - col).split("");
            for (int row = 0; row < rotatedMatrix.length; row++) {
                if (row >= currentRow.length) {
                    rotatedMatrix[row][col] = "";
                } else {
                    rotatedMatrix[row][col] = currentRow[row];
                }
            }
        }

        return rotatedMatrix;
    }

    private static int getDegrees(String readLine) {
        String degrees = "";
        for (char c : readLine.toCharArray()) {
            if (Character.isDigit(c)) {
                degrees += c;
            }
        }
        return Integer.valueOf(degrees);
    }

    private static void fullMatrix(String[][] matrix, ArrayList<String> list) {
        for (int i = 0; i < matrix.length; i++) {
            String[] currentRow = list.get(i).split("");
            for (int j = 0; j < matrix[0].length; j++) {
                if (j > currentRow.length - 1) {
                    matrix[i][j] = "";
                } else {
                    matrix[i][j] = currentRow[j];
                }
            }
        }
    }


    private static int findLongestWord(ArrayList<String> list) {
        int longest = 0;
        for (String s : list) {
            if (s.length() > longest) {
                longest = s.length();
            }
        }
        return longest;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
