package problem_5_GenericCountMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int counter = Integer.parseInt(br.readLine());

        List<Container<String>> containerList = new ArrayList<>();
        while (counter-- > 0) {
            containerList.add(new Container<>(br.readLine()));
        }

        Container<String> singleElement = new Container<>(br.readLine());
        System.out.println(getCountOfBiggerElements(containerList, singleElement));

    }

    private static <T extends Comparable> int getCountOfBiggerElements(
            List<Container<T>> list, Container<T> element) {

        return (int) list.stream()
                .filter(el -> el.compareTo(element) > 0)
                .count();

    }
}
