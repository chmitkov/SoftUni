package problem_3_GenericSwapMethodStrings;

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

        List<Container<String>> containerList = new ArrayList<>();
        while (counter-- > 0) {
            containerList.add(new Container<>(br.readLine()));
        }

        int[] swapIndices = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        swapElements(containerList, swapIndices[0],swapIndices[1]);

        containerList.forEach(System.out::println);
    }

    private static <T> void swapElements(List<Container<T>> list,
                                         int firstIndex, int secondIndex) {

        Container<T> tempElement = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, tempElement);
    }
}
