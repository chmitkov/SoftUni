package problem_04_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split("\\s+|\\s*,\\s*"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(nums);


        System.out.println(lake.printMoves());
    }
}
