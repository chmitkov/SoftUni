package problem_5_NullFinder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>() {{
            add(1);
            add(2);
            add(null);
            add(2);
            add(null);
        }};

        List<String> strings = new ArrayList<>(){{
            add("a");
            add(null);
            add("c");
        }};

        ListUtils.getNullIndices(integers).forEach(System.out::println);
        ListUtils.getNullIndices(strings).forEach(System.out::println);
    }
}
