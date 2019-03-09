package p03_GenericSwapMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int counter = Integer.parseInt(br.readLine());
        List<Box> list = new ArrayList<>();
        while (counter-- > 0) {
            list.add(new Box(br.readLine()));
        }
        int[] indices = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Box.swap(list, indices[0], indices[1]);

        list.forEach(System.out::println);
    }
}
