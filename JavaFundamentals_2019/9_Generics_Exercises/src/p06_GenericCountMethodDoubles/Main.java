package p06_GenericCountMethodDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int counter = Integer.parseInt(br.readLine());
        List<Box<Double>> boxList = new ArrayList<Box<Double>>();
        while (counter-- > 0) {
            boxList.add(new Box<Double>(Double.parseDouble(br.readLine())));
        }
        Box<Double> compBox = new Box<Double>(Double.parseDouble(br.readLine()));
        System.out.println(
                Box.countOfBiggerElements(boxList,compBox));
    }
}
