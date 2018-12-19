package problem_6_GenericCountMethodDouble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double counter = Double.parseDouble(br.readLine());

        List<Double> containerList = new ArrayList<>();

        while (counter-- > 0) {
            containerList.add(Double.valueOf(br.readLine()));
        }

        double singleElement = Double.parseDouble(br.readLine());

        System.out.println(getCount(containerList, singleElement));

    }

    private static <T extends Comparable> int getCount(List<T> list, T element) {
        return (int) list.stream()
                .filter(el -> el.compareTo(element) > 0)
                .count();
    }
}
