package p04_ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 3, 4, 5);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");

        String minStr = ListUtils.getMin(strings);
        System.out.println(minStr);
        int maxInt = ListUtils.getMax(integers);
        System.out.println(maxInt);
    }
}
