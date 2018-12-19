package problem_10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Tuple> list = new ArrayList<>();

        String[] firstRow = br.readLine().split("\\s+");
        list.add(new Tuple<>(String.format("%s %s", firstRow[0], firstRow[1]), firstRow[2]));

        String[] secondRow = br.readLine().split("\\s+");
        list.add(new Tuple<>(secondRow[0], Integer.parseInt(secondRow[1])));

        String[] thirdRow = br.readLine().split("\\s+");
        list.add(new Tuple<>(Integer.parseInt(thirdRow[0]), Double.parseDouble(thirdRow[1])));

        list.forEach(System.out::println);

    }
}
