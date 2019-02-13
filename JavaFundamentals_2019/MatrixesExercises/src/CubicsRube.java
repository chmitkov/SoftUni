import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CubicsRube {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cubeSize = Integer.parseInt(br.readLine());
        int counter = 0;
        int sumOfChangedCells = 0;

        int[][][] cube = new int[cubeSize][cubeSize][cubeSize];

        String line;
        while (!"Analyze".equals(line = br.readLine())) {
            int[] commands = Arrays.stream(line.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (isValidCoordinates(cube, commands)) {
                cube[commands[0]][commands[1]][commands[2]] = commands[3];
                counter++;
                sumOfChangedCells+=commands[3];
            }
        }
        System.out.println(sumOfChangedCells);
        System.out.println(cubeSize * cubeSize * cubeSize - counter);
    }

    private static boolean isValidCoordinates(int[][][] cube, int[] commands) {
        if (!(commands[0] >= 0 && commands[0] < cube.length) ||
                !(commands[1] >= 0 && commands[1] < cube[0].length) ||
                !(commands[2] >= 0 && commands[2] < cube[0][0].length)) {
            return false;
        }
        return true;
    }
}
