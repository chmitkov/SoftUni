import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class RoyalNonStop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] matrixSize = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] matrix = new String[matrixSize[0]][matrixSize[1]];

        int[] priceOfProducts = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lukankaPrice = priceOfProducts[0];
        int rakiaPrice = priceOfProducts[1];
        fillMatrix(matrix);
        BigInteger result = new BigInteger("0");
        int customersCounter = 0;
        String line;
        while (!"Royal Close".equals(line = br.readLine())) {
            int[] entryPoint = Arrays.stream(line.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            customersCounter++;

            result = result.add(entryPoint[0] < entryPoint[1]
                    ? firstUpThenLeft(matrix, entryPoint, priceOfProducts)
                    : firstLeftThanUp(matrix, entryPoint, priceOfProducts));
        }

        System.out.println(result);
        System.out.println(customersCounter);

    }

    private static BigInteger firstLeftThanUp(String[][] matrix, int[] entryPoint, int[] priceOfProducts) {
        BigInteger result = new BigInteger("0");
        for (int col = entryPoint[1]; col >= 0; col--) {
            try {
                result = result.add(
                        BigInteger.valueOf(matrix[entryPoint[0]][col].equals("L")
                                ? priceOfProducts[0] : priceOfProducts[1]));
            } catch (Exception e) {
            }
        }
        for (int row = entryPoint[0]; row >= 0; row--) {
            try {
                result = result.add(
                        BigInteger.valueOf(matrix[row][0].equals("L")
                                ? priceOfProducts[0] : priceOfProducts[1]));
            } catch (Exception e) {
            }
        }
        return result;
    }

    private static BigInteger firstUpThenLeft(String[][] matrix,
                                              int[] entryPoint, int[] priceOfProducts) {
        BigInteger result = new BigInteger("0");
        for (int row = entryPoint[0]; row >= 0; row--) {
            try {
                result = result.add(
                        BigInteger.valueOf(matrix[row][entryPoint[1]].equals("L")
                                ? priceOfProducts[0] : priceOfProducts[1]));
            } catch (Exception e) {
            }
        }

        for (int col = entryPoint[1]; col >= 0; col--) {
            try {
                result = result.add(
                        BigInteger.valueOf(matrix[0][col].equals("L")
                                ? priceOfProducts[0] : priceOfProducts[1]));
            } catch (Exception e) {
            }
        }
        return result;
    }

    private static void fillMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (row == 0 && col == 0) {
                    matrix[row][col] = "D";
                    continue;
                }
                matrix[row][col] = row % 2 == 0
                        ? "L" : "R";
            }
        }
    }
}
