import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Monopoly {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] matrixSize = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] field = new String[matrixSize[0]][matrixSize[1]];
        int[] playerMoney = new int[]{50};
        int[] hotelsNumber = new int[]{0};
        int[] turnsInJail = new int[]{0};
        int[] playerTurns = new int[]{0};

        for (int i = 0; i < field.length; i++) {
            field[i] = br.readLine().split("");
        }

        move(field, playerMoney, hotelsNumber, turnsInJail, playerTurns);

        System.out.println("Turns " + playerTurns[0]);
        System.out.println("Money " + playerMoney[0]);
    }

    private static void move(String[][] field, int[] playerMoney,
                             int[] hotelsNumber, int[] turnsInJail, int[] playerTurns) {
        for (int row = 0; row < field.length; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < field[row].length; col++) {

                    actionOnField(row, col, playerMoney,
                            hotelsNumber, turnsInJail, field, playerTurns);

                    if (hotelsNumber[0] > 0) {
                        playerMoney[0] += 10 * hotelsNumber[0];
                    }

                    playerTurns[0]++;
                }
            } else {
                for (int col = field[row].length - 1; col >= 0; col--) {
                    actionOnField(row, col, playerMoney,
                            hotelsNumber, turnsInJail, field, playerTurns);

                    if (hotelsNumber[0] > 0) {
                        playerMoney[0] += 10 * hotelsNumber[0];
                    }

                    playerTurns[0]++;
                }
            }
        }
    }

    private static void actionOnField(Integer row, Integer col, int[] playerMoney,
                                      int[] hotelsNumber,
                                      int[] turnsInJail, String[][] field, int[] playerTurns) {

        String currentCell = field[row][col];
        switch (currentCell) {
            case "H":
                int hotelPrice = playerMoney[0];
                playerMoney[0] = 0;
                hotelsNumber[0]++;
                System.out.printf("Bought a hotel for %d. Total hotels: %d.%n",
                        hotelPrice, hotelsNumber[0]);
                break;
            case "S":
                int shopPrice = (row + 1) * (col + 1);
                if (playerMoney[0] < shopPrice) {
                    shopPrice = playerMoney[0];
                }
                playerMoney[0] -= shopPrice;
                System.out.printf("Spent %d money at the shop.%n", shopPrice);
                break;

            case "J":
                turnsInJail[0] = 2;
                System.out.printf("Gone to jail at turn %d.%n", playerTurns[0]);
                playerTurns[0] += 2;
                while (turnsInJail[0]-- > 0) {
                    playerMoney[0] += hotelsNumber[0] * 10;
                }
                break;
        }
    }
}
