package problem_7_GenericAddAll;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>(){{
            add(1);
            add(2);
            add(null);
            add(2);
            add(null);
        }};

        List<Double> doubles = new ArrayList<>(){{
            add(1.2);
            add(3.2);
            add(5.5);
        }};

        List<Number> destination = new ArrayList<>();

        ListUtils.addAll(destination, integers);
        ListUtils.addAll(destination, doubles);

        destination.forEach(System.out::println);
    }
}
