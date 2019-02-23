import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ChessKnight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] field = new String[8][8];

        int invalidMoves = 0;
        int boardOutMoves = 0;
        List<String> pieceTake = new ArrayList<>();

        for (int row = 0; row < field.length; row++) {
            field[row] = br.readLine().split("\\|");
        }

        String startPositionString = br.readLine();
        int[] startingPosition = new int[]{
                Integer.parseInt(startPositionString.charAt(0) + ""),
                Integer.parseInt(startPositionString.charAt(1) + "")
        };

        String line;

        while (!"END".equalsIgnoreCase(line = br.readLine())) {
            String[] tokens = line.split(" -> ");
            String oldPositionString = tokens[0];
            int[] oldPosition = new int[]{
                    Integer.parseInt(oldPositionString.charAt(0) + ""),
                    Integer.parseInt(oldPositionString.charAt(1) + "")
            };
            String currentPositionString = tokens[1];
            int[] currentPosition = new int[]{
                    Integer.parseInt(currentPositionString.charAt(0) + ""),
                    Integer.parseInt(currentPositionString.charAt(1) + "")
            };

            if (!isInvalidMove(oldPosition, currentPositionString)) {
                invalidMoves++;
                continue;
            }

            if (!isInField(field, currentPosition)) {
                boardOutMoves++;
                continue;
            }

            if (!field[currentPosition[0]][currentPosition[1]].trim().equals("")) {
                pieceTake.add(field[currentPosition[0]][currentPosition[1]]);
            }

        }

        System.out.println("Pieces take: " +
                String.join(", ", pieceTake));
        System.out.printf("Invalid moves: %d%n", invalidMoves);
        System.out.printf("Board out moves: %d%n", boardOutMoves);
    }

    private static boolean isInField(String[][] field, int[] currentPosition) {
        try {
            String cell = field[currentPosition[0]][currentPosition[1]];
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean isInvalidMove(int[] startingPosition, String currentPosition) {
        HashSet<String> possibleMoves = new HashSet<>() {{
            add((startingPosition[0] - 1) + " " + (startingPosition[1] - 2));
            add((startingPosition[0] - 2) + " " + (startingPosition[1] - 1));
            add((startingPosition[0] + 1) + " " + (startingPosition[1] - 2));
            add((startingPosition[0] + 2) + " " + (startingPosition[1] - 1));
            add((startingPosition[0] - 2) + " " + (startingPosition[1] + 1));
            add((startingPosition[0] - 1) + " " + (startingPosition[1] + 2));
            add((startingPosition[0] + 1) + " " + (startingPosition[1] + 2));
            add((startingPosition[0] + 2) + " " + (startingPosition[1] + 1));
        }};


        return !possibleMoves.contains(currentPosition);
    }
}
