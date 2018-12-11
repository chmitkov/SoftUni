package problem_2_GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayCreator arrayCreator = new ArrayCreator();

        String[] arr = arrayCreator.create(5, "str");

        Arrays.stream(arr).forEach(System.out::println);

    }
}
