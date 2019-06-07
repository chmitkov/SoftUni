import java.util.ArrayList;
import java.util.Scanner;

public class _09Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNums = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[numberOfNums][8];
        ArrayList<String> binaryNums = new ArrayList<String>();

        for (int i = 0; i < numberOfNums; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            //String currBinary = Integer.toBinaryString(currentNum);
            String currBinary = String.format("%8s", Integer.toBinaryString(currentNum))
                    .replace(' ', '0');
            binaryNums.add(currBinary);
        }

        for (int i = 0; i < numberOfNums; i++) {
            for (int j = 0; j < 8; j++) {
                String numToInput = binaryNums.get(i);
                String neededChar = numToInput.charAt(j) + "";
                matrix[i][j] = Integer.parseInt(neededChar);
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("party over")) {
            String[] currRow = input.split(" ");
            String command = currRow[0];
            int indexOfCol = 7 - Integer.parseInt(currRow[1]);


            for (int i = 0; i < matrix.length; i++) {
                switch (command) {
                    case "-1":
                        if (matrix[i][indexOfCol] == 1) {
                            matrix[i][indexOfCol] = 0;
                        } else {
                            matrix[i][indexOfCol] = 1;
                        }
                        break;
                    case "0":
                        matrix[i][indexOfCol] = 0;
                        break;
                    case "1":
                        matrix[i][indexOfCol] = 1;
                        break;
                }
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < matrix.length; i++) {
            String currNumBinary = "";
            for (int j = 0; j < matrix[0].length; j++) {
                currNumBinary += matrix[i][j];
            }
            System.out.println(Integer.parseInt(currNumBinary, 2));
        }
    }
}
