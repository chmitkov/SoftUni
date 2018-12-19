package problem_2_GenericBoxOfInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int counter = Integer.parseInt(br.readLine());

        List<Box<Integer>> boxList = new ArrayList<>();

        while (counter-- > 0) {
            boxList.add(new Box<>(Integer.valueOf(br.readLine())));
        }

        boxList.forEach(System.out::println);
    }
}
