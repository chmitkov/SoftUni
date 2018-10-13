/*
    Дадена е квадратна матрица 8х8.
    На първите няколко реда, докато не получим командата "Game starts!", ще получаваме на всеки нов ред
    индексите на полетата, в които има мини.
    На следващите няколко реда, докато не получим командата "Stop", ще получаваме индексите на тези клетки,
    които играчът е избрал да отвори.
    Ако полето, което е избрал играчът е вече отворено (отворено поле - "_"), изписваме "Invalid index" .
    Ако полето е затворено (затворено поле "F") отваряме всички полета, които не са мина, стоящи надясно
    от текущото поле(включително него), на този ред.
    Ако полето, което е избрал е мина (поле с мина - "M") - броим отворена мина, след което променяме
    всички долепени до текущото поле (включително него) на отворени полета("_");

    Изход:
    След всяко отворено поле принтираме "Chance to hit mine: " и шансът да отворим мина(процентът на останалите мини от
    общият брой останали неотворени полета), закръглен до третият знак след десетичната запетая.

    Ако играчът отвори 3 мини, прекъсваме играта и изписваме "You lose", а на следващия ред игралното поле,
    но във въд, който би видял играчът(userView), т.е. принтираме само пълни ("F") и празни ("_") полета,
    за да не може нашият играч да види къде се крият другите мини. На мястото на мините също принтираме пълно поле - "F";

    Ако играчът успее да изпълни всички свои ходове, без да е отворил мина 3 пъти, принтираме "You did well",
    а на следващият ред отново игралното поле, но във вид, който би видял играча - userView(описано преди малко);


    Примерни входове и тестове :

    Пример номер 1
    0 7
    1 6
    2 5
    3 4
    4 3
    5 2
    6 1
    7 0
    Game starts!
    0 1
    2 2
    4 1
    3 6
    6 2
    Stop

    Очакван изход:

    Chance to hit mine 13.793%
    Chance to hit mine 15.094%
    Chance to hit mine 17.021%
    Chance to hit mine 17.778%
    Chance to hit mine 20.513%

    You did well
    F _ _ _ _ _ _ F
    F F F F F F F F
    F F _ _ _ F _ _
    F F F F F F _ _
    F _ _ F _ _ _ _
    F F F F F F F F
    F F _ _ _ _ _ _
    F F F F F F F F

    Пример номер 2:
    0 7
    1 6
    2 5
    3 4
    4 3
    5 2
    6 1
    7 0
    Game starts!
    0 7
    7 0
    4 3
    5 6
    4 1
    Stop

    Очакван изход:

    Chance to hit mine 10.000%
    Chance to hit mine 7.143%
    You lose
    F F F F F F _ _
    F F F F F F _ _
    F F F F F F F F
    F F _ _ _ F F F
    F F _ _ _ F F F
    F F _ _ _ F F F
    _ _ F F F F F F
    _ _ F F F F F F
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Mines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] field = new String[8][8];
        int hitMineCounter = 0;

        fillMatrix(field);

        String firstCommand = br.readLine();
        while (!firstCommand.equals("Game starts!")) {
            int[] indexOfMines = Arrays.stream(firstCommand.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            setMineOnIndex(indexOfMines, field);

            firstCommand = br.readLine();
        }

        String secondCommand = br.readLine();
        while (!secondCommand.equals("Stop")) {
            int[] playerMoves = Arrays.stream(secondCommand.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            String currentCell = field[playerMoves[0]][playerMoves[1]];

            if (currentCell.equals("M")) {
                hitMine(playerMoves, field);
                hitMineCounter++;

                if (hitMineCounter == 3) {
                    System.out.println("You lose");
                    printUserView(field);
                    return;
                }

            } else {
                openCell(playerMoves, field);
            }

            printChanceToHitMineNextTurn(field);

            secondCommand = br.readLine();
        }

        System.out.println("You did well");
        printUserView(field);
    }

    private static void printChanceToHitMineNextTurn(String[][] field) {
        int allMinesInField = 0;
        int allOpenCells = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j].equals("M")) {
                    allMinesInField++;
                } else if (field[i][j].equals("_")) {
                    allOpenCells++;
                }
            }
        }
        System.out.printf("Chance to hit mine %.3f%%%n",  ((allMinesInField*1.0/(64 - allOpenCells))*100));
    }

    private static void printUserView(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.printf(j == field[0].length - 1 ?
                                "%s%n" : "%s ",
                        field[i][j].equals("_") ? "_" : "F");
            }
        }
    }

    private static void openCell(int[] playerMoves, String[][] field) {
        String currentCell = field[playerMoves[0]][playerMoves[1]];
        if (currentCell.equals("_")) {
            System.out.println("Invalid index");
        } else {
            openFreeCells(playerMoves, field);
        }
    }

    private static void hitMine(int[] playerMoves, String[][] field) {
        int startRow = playerMoves[0] == 0 ? 0 : playerMoves[0] - 1;
        int endRow = playerMoves[0] == field.length - 1
                ? field.length - 1 : playerMoves[0] + 1;
        int startCol = playerMoves[1] == 0 ? 0 : playerMoves[1] - 1;
        int endCol = playerMoves[1] == field[0].length - 1
                ? field[0].length - 1 : playerMoves[1] + 1;

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                field[i][j] = "_";
            }
        }

    }

    private static void openFreeCells(int[] playerMoves, String[][] field) {
        int row = playerMoves[0];
        int col = playerMoves[1];
        for (int i = col; i < field[0].length; i++) {
            if (!field[row][i].equals("M")) {
                field[row][i] = "_";
            }
        }
    }

    private static void setMineOnIndex(int[] indexOfMines, String[][] matrix) {
        matrix[indexOfMines[0]][indexOfMines[1]] = "M";
    }

    private static void fillMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = "F";
            }
        }
    }
}
