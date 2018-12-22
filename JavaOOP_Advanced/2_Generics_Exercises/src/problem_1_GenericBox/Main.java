package problem_1_GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int counter = Integer.parseInt(br.readLine());

        List<Box<String>> boxList = new ArrayList<>();

        while (counter-- > 0) {
            boxList.add(new Box<>(br.readLine()));
        }

        boxList.forEach(System.out::println);
    }
}
