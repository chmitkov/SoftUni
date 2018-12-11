package problem_6_GenericFlatMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};

        List<Double> doubles = new ArrayList<>() {{
            add(1.1);
            add(2.2);
            add(3.3);
        }};

        List<List<? extends Number>> jagged = new ArrayList<>();

        Collections.addAll(jagged, integers, doubles);

        List<Number> dest = new ArrayList<>();
        ListUtils.flatten(dest, jagged);

        dest.forEach(System.out::println);
    }
}
