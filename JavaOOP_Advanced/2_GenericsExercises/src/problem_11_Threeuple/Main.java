package problem_11_Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Threeuple> list = new ArrayList<>();
        String[] firstRow = br.readLine().split("\\s+");
        list.add(new Threeuple<>(String.format("%s %s", firstRow[0], firstRow[1]),
                firstRow[2], firstRow[3]));

        String[] secondRow = br.readLine().split("\\s+");
        list.add(new Threeuple<>(secondRow[0], Integer.parseInt(secondRow[1]),
                !"not".equals(secondRow[2])));

        String[] thirdRow = br.readLine().split("\\s+");
        list.add(new Threeuple<>(thirdRow[0], Double.parseDouble(thirdRow[1]), thirdRow[2]));

        list.forEach(System.out::println);
    }
}
