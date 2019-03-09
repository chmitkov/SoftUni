package p10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstCommands = br.readLine().split("\\s+");
        String[] secondCommands = br.readLine().split("\\s+");
        String[] thirdCommands = br.readLine().split("\\s+");

        List<Tuple> list = new ArrayList<>();

        list.add(new Tuple<String, String>(
                firstCommands[0] +" "+ firstCommands[1], firstCommands[2]));

        list.add(new Tuple<String, Integer>(secondCommands[0],
                Integer.parseInt(secondCommands[1])));

        list.add(new Tuple<Integer, Double>(Integer.parseInt(thirdCommands[0]),
                Double.parseDouble(thirdCommands[1])));

        list.forEach(System.out::println);
    }
}
